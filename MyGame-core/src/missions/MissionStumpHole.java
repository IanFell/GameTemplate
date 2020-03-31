package missions;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import gameobjects.Bird;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.nature.Feather;
import gameobjects.nature.Stump;
import handlers.CollisionHandler;
import helpers.GameAttributeHelper;
import loaders.ImageLoader;
import maps.MapHandler;
import screens.GameScreen;
import ui.LocationMarker;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionStumpHole extends Mission {

	// When this is true, bird weapon will appear on screen.
	public static boolean stumpHoleMissionComplete;

	private Feather featherOne;
	private Feather featherTwo;
	private Feather featherThree;

	// Value each feather is worth when collected.
	public static final float FEATHER_VALUE = 8.0f;

	private final float FEATHER_VALUE_METER_MAX = 8.0f;

	/**
	 * This variable will not increase by 1 every time a feather is collected.
	 * It will increase anywhere from 1-10 (based on time that player actually intersects with feather).
	 * This makes it seem more random, since this mission is based on something like a health meter that
	 * slowely rises, this seems like an okay thing to do so the mission is not the same every time.
	 */
	public static float playerFeatherScore;

	public static boolean missionIsActive = false;

	private Bird bird;
	private Bird attackBird;
	private float attackBirdOriginX;
	private float attackBirdOriginY;
	private float attackBirdAngle               = 0;
	private float attackBirdDx                  = 0.7f;
	// Break in between attacks.
	private float attackBirdBreakTimer          = 0;
	private final float ATTACK_BREAK_VALUE      = 25;
	private boolean birdIsSpinning              = false;
	private boolean birdHasBeganSpinning        = false;
	// How long bird will go in a circle.
	private final int CIRCULAR_ATTACK_MAX_VALUE = 58;
	private int circularAttackTimer             = 0;

	public static ArrayList <GameObject> stumps = new ArrayList <GameObject>();
	private final int AMOUNT_OF_STUMPS          = 13;

	public static Rectangle player;
	public static float playerDx;
	public static float playerDy;
	// Make player smaller so he can fall between the stumps.  In the open world player is 1 x 1.
	private float playerSize = 0.8f;
	public static int playerDirection;

	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;

	/**
	 * Gravity and jumping variables.
	 */
	private double gravity                    = 0.6d;
	private double dt                         = 0.4d; 
	public static boolean playerIsJumping     = false;
	private int jumpTimer                     = 0;
	private final float VERTICAL_ACCELERATION = 0.8f;
	private final float PEAK_JUMP_VALUE       = 3.0f;
	// Use a different jumping variable than regular player so camera doesn't move everytime player jumps.
	public static boolean jumpSoundShouldPlay = false;

	// Player cannot fall past this barrier. 
	private float gravityHaltBarrier;

	private float waterTileHeight                    = 2.3f;
	private int animatedWaterTimer                   = 0;
	private final int MAX_ANIMATED_WATER_TIMER_VALUE = 10;

	// Represents number of big attacks (each containing three waves) that repeat.
	private final int ATTACK_ONE = 1;
	private final int ATTACK_TWO = 2;

	// Waves represent three different little attacks within one bigger attack. 
	private final int WAVE_ONE   = 1;
	private final int WAVE_TWO   = 2;
	private final int WAVE_THREE = 3;
	private int wave             = WAVE_ONE;

	private boolean firstAttackComplete  = false;
	private boolean secondAttackComplete = false;

	private boolean reset = true;

	private int breakTimer            = 0;
	private final int MAX_BREAK_VALUE = 30;

	/**
	 * Constructor.
	 */
	public MissionStumpHole() {
		stumpHoleMissionComplete = false;
		loadStumps();
		gravityHaltBarrier = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 43;
		// Place this bird on last stump of row one of stumps.
		bird            = new Bird(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 5f, 
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 32.5f
				);

		// This bird moves around.
		attackBird      = new Bird(
				stumps.get(5).getX(), 
				stumps.get(5).getY() - 3
				);
		attackBird.rectangle.width  = attackBird.getWidth();
		attackBird.rectangle.height = attackBird.getHeight();
		attackBirdOriginX           = attackBird.getX();
		attackBirdOriginY           = attackBird.getY();

		player          = new Rectangle(stumps.get(0).getX(), stumps.get(0).getY() - 60, playerSize, playerSize);
		playerDx        = 0.2f;
		playerDy        = 0;
		playerDirection = DIRECTION_RIGHT;

		playerFeatherScore = 0;

		locationMarker = new LocationMarker(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 12, 
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 40
				);
	}

	private void loadStumps() {
		float startX = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 24.5f;
		int startY   = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 45;
		for (int i = 0; i < AMOUNT_OF_STUMPS; i++) {
			if (i % 2 == 0) {
				stumps.add(new Stump((int) startX, startY, Stump.START_MOVING_DOWN));
			} else {
				stumps.add(new Stump((int) startX, startY, Stump.START_MOVING_UP));
			}
			startX += 2;
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	@Override
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		if (missionIsActive) {
			// Render background.
			batch.draw(
					imageLoader.sky, 
					GameScreen.camera.position.x - GameScreen.camera.viewportWidth / 2, 
					GameScreen.camera.position.y + GameScreen.camera.viewportHeight / 2,
					GameScreen.camera.viewportWidth, 
					-GameScreen.camera.viewportHeight
					);

			// Make attack bird fly in between stumps if he is not spinning.
			for (int i = 0; i < stumps.size(); i++) {
				if (i % 2 == 0) {
					stumps.get(i).renderObject(batch, imageLoader);
				}
			}
			if (!birdIsSpinning) {
				attackBird.renderObject(batch, imageLoader);
			}
			for (int i = 0; i < stumps.size(); i++) {
				if (i % 2 != 0) {
					stumps.get(i).renderObject(batch, imageLoader);
				}
			}

			// Render player.
			Texture playerTexture = imageLoader.playerRight;
			if (playerDirection == DIRECTION_LEFT) {
				playerTexture = imageLoader.playerLeft;
			}
			batch.draw(playerTexture, player.x, player.y + player.height, player.width, -player.height);
			renderWater(batch, imageLoader);
			// Feathers only render when needed.
			renderFeathers(batch, imageLoader);
			renderFeatherValueMeter(batch, imageLoader);

			// Render bird in front of water if he is spinning.
			if (birdIsSpinning) {
				attackBird.renderObject(batch, imageLoader);
			}
		} else {
			bird.renderObject(batch, imageLoader);
			// Flash location icon so player knows where to go.
			if (locationMarker.timerValuesAreCorrectToFlash() && !stumpHoleMissionComplete) {
				locationMarker.renderObject(batch, imageLoader);
			}
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	private void renderFeatherValueMeter(SpriteBatch batch, ImageLoader imageLoader) {
		float height = 2.0f;
		batch.draw(
				imageLoader.blackSquare, 
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 7.5f, 
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 37.0f,
				FEATHER_VALUE_METER_MAX, 
				-height
				);
		batch.draw(
				imageLoader.whiteSquare, 
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 7.5f, 
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 37.0f,
				playerFeatherScore, 
				-height
				);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	private void renderFeathers(SpriteBatch batch, ImageLoader imageLoader) {
		if (featherOne != null) {
			if (!featherOne.hasBeenCollected) {
				featherOne.renderObject(batch, imageLoader);
			}
		}
		if (featherTwo != null) {
			if (!featherTwo.hasBeenCollected) {
				featherTwo.renderObject(batch, imageLoader);
			}
		}
		if (featherThree != null) {
			if (!featherThree.hasBeenCollected) {
				featherThree.renderObject(batch, imageLoader);
			}
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	private void renderWater(SpriteBatch batch, ImageLoader imageLoader) {
		float originalX                    = GameScreen.camera.position.x - GameScreen.camera.viewportWidth / 2;
		float originalY                    = GameScreen.camera.position.y + GameScreen.camera.viewportHeight / 2;
		float startX                       = originalX;
		float startY                       = originalY;
		int rowLength                      = 29;
		int numberOfRows                   = 2;
		boolean secondRowOfWaterHasBeenSet = false;

		for (int i = 0; i < rowLength * numberOfRows; i++) {
			animateWaterTiles(batch, imageLoader, startX, startY);
			startX++;
			// Start new row.
			if (i >= rowLength && !secondRowOfWaterHasBeenSet) {
				startX = originalX;
				startY = originalY - waterTileHeight;
				secondRowOfWaterHasBeenSet = true;
			}
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param float       startX
	 * @param float       startY
	 */
	private void animateWaterTiles(SpriteBatch batch, ImageLoader imageLoader, float startX, float startY) {
		animatedWaterTimer++;
		if (animatedWaterTimer > MAX_ANIMATED_WATER_TIMER_VALUE) {
			animatedWaterTimer = 0;
		}
		Texture texture = imageLoader.waterTileOne;
		if (animatedWaterTimer < MAX_ANIMATED_WATER_TIMER_VALUE / 2) {
			texture = imageLoader.waterTileTwo;
		}
		batch.draw(
				texture, 
				startX, 
				startY,
				1, 
				-waterTileHeight
				);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateMission(MyGame myGame, MapHandler mapHandler) {
		if (!missionIsActive) {
			locationMarker.updateObject();
			if (CollisionHandler.playerHasCollidedWithLocationMarker(myGame.getGameObject(Player.PLAYER_ONE), locationMarker)) {
				missionIsActive = true;
			}
		}

		applyPlayerPhysics();

		attackBirdBreakTimer++;
		attackBird.rectangle.x = attackBird.getX();
		attackBird.rectangle.y = attackBird.getY();

		if (playerIsJumping) {
			// Player goes up.
			playerDy = playerDy - VERTICAL_ACCELERATION;
			jumpTimer++;
			// Player comes down.
			if (jumpTimer > PEAK_JUMP_VALUE) {
				playerIsJumping = false;
				jumpTimer       = 0;
			}
		}

		for (int i = 0; i < stumps.size(); i++) {
			stumps.get(i).updateObject(myGame, mapHandler);
		}

		// If we have not completed the mission yet:
		if (!secondAttackComplete) {
			// Execute first attack if it's not done.
			if (!firstAttackComplete) {
				executeBirdAttack(ATTACK_ONE);
			} else {
				// If the first attack is done, take a little break.
				breakTimer++;
				if (breakTimer < MAX_BREAK_VALUE) {
					breakBetweenAttacks();
				} else {
					// If the break is done, reset values and execute second attack.
					if (reset) {
						resetAttackVariables(stumps.get(0).getX() - 5, stumps.get(0).getY() - 6, false);
						reset = false;
					}
					executeBirdAttack(ATTACK_TWO);
				}
			}
		} else {
			// Reset values and set them back to attack one.
			resetAttackVariables(stumps.get(5).getX(), stumps.get(5).getY() - 3, true);
		}

		updateFeathers(myGame, mapHandler);

		// Player wins if he gets enough feathers.
		if (playerFeatherScore >= FEATHER_VALUE_METER_MAX) {
			missionIsActive          = false;
			stumpHoleMissionComplete = true;
		}

		// Player loses health if he gets hit by attack bird.
		CollisionHandler.checkIfPlayerHasCollidedWithAttackBird(
				myGame.getGameObject(Player.PLAYER_ONE),
				attackBird.rectangle
				);
	}

	/**
	 * This method ensures bird attacks loop over and over.
	 * 
	 * @param float   x
	 * @param float   y
	 * @param boolean resetAttacks
	 */
	private void resetAttackVariables(float x, float y, boolean resetAttacks) {
		attackBird.setX(x);
		attackBird.setY(y);
		attackBirdBreakTimer = 0;
		circularAttackTimer  = 0;
		wave                 = WAVE_ONE;
		birdHasBeganSpinning = false;
		reset                = true;
		if (resetAttacks) {
			secondAttackComplete = false;
			firstAttackComplete  = false;
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	private void updateFeathers(MyGame myGame, MapHandler mapHandler) {
		if (featherOne != null) {
			featherOne.updateObject(myGame, mapHandler);
		}
		if (featherTwo != null) {
			featherTwo.updateObject(myGame, mapHandler);
		}
		if (featherThree != null) {
			featherThree.updateObject(myGame, mapHandler);
		}
		//System.out.println(featherValue);
	}

	private void breakBetweenAttacks() {
		// TODO will put count down graphics during this part or something.
	}

	/**
	 * 
	 * @param int attack
	 */
	private void executeBirdAttack(int attack) {
		if (wave == WAVE_ONE) {
			if (attackBirdBreakTimer > ATTACK_BREAK_VALUE) {
				if (attack == ATTACK_ONE) {
					moveAttackBirdLeft(ATTACK_ONE);
				} else {
					moveAttackBirdRight(ATTACK_TWO);
				}
			}
		} else if (wave == WAVE_TWO) {
			if (attackBirdBreakTimer > ATTACK_BREAK_VALUE) {
				if (attack == ATTACK_ONE) {
					moveAttackBirdRight(ATTACK_ONE);
				} else {
					moveAttackBirdLeft(ATTACK_TWO);
				}
			}
		} else if (wave == WAVE_THREE) {
			if (attackBirdBreakTimer > ATTACK_BREAK_VALUE) {
				if (attack == ATTACK_ONE) {
					moveAttackBirdInCircularPath(DIRECTION_LEFT);
				} else {
					moveAttackBirdInCircularPath(DIRECTION_RIGHT);
				}
			}
		}
	}

	/**
	 * 
	 * @param int attackNumber
	 */
	private void moveAttackBirdRight(int attackNumber) {
		attackBird.setDirection(DIRECTION_RIGHT);
		attackBird.setX(attackBird.getX() + attackBirdDx);
		if (attackNumber == ATTACK_ONE) {
			if (attackBirdHasReachedRightBoundary()) {
				wave                 = WAVE_THREE;
				attackBirdBreakTimer = 0;
			}
		} else {
			if (attackBirdHasReachedRightBoundary()) {
				wave                 = WAVE_TWO;
				attackBirdBreakTimer = 0;
			}
		}
	}

	/**
	 * 
	 * @param int attackNumber
	 */
	private void moveAttackBirdLeft(int attackNumber) {
		attackBird.setDirection(DIRECTION_LEFT);
		attackBird.setX(attackBird.getX() - attackBirdDx);
		if (attackNumber == ATTACK_ONE) {
			if (attackBirdHasReachedLeftBoundary()) {
				wave                 = WAVE_TWO;
				attackBirdBreakTimer = 0;
			}
		} else {
			if (attackBirdHasReachedLeftBoundary()) {
				wave                 = WAVE_THREE;
				attackBirdBreakTimer = 0;
			}
		}
	}

	/**
	 * 
	 * @return boolean
	 */
	private boolean attackBirdHasReachedRightBoundary() {
		return attackBird.getX() > stumps.get(AMOUNT_OF_STUMPS - 1).getX() + 5;
	}

	/**
	 * 
	 * @return boolean
	 */
	private boolean attackBirdHasReachedLeftBoundary() {
		return attackBird.getX() < stumps.get(0).getX() - 5;
	}

	private void makeBirdMoveInCircle() {
		float attackBirdCircularPathRadius = 3;
		attackBird.setX((float) (attackBirdOriginX - Math.cos(attackBirdAngle) * attackBirdCircularPathRadius)); 
		attackBird.setY((float) (attackBirdOriginY + Math.sin(attackBirdAngle) * attackBirdCircularPathRadius));
	}

	/**
	 * This differs from makeBirdMoveInCircle() because this method takes into consideration
	 * entering and leaving the viewport, as well as the spin.
	 * 
	 * @param int direction
	 */
	private void moveAttackBirdInCircularPath(int direction) {
		// Bird is going in a circle.
		if (birdIsSpinning) {
			float angleValue = 0.3f;
			if (direction == DIRECTION_LEFT) {
				attackBirdAngle += angleValue;
			} else {
				attackBirdAngle -= angleValue;
			}
			makeBirdMoveInCircle();

			// Make bird go in a circle for a specified amount of time.
			circularAttackTimer++;
			if (circularAttackTimer > CIRCULAR_ATTACK_MAX_VALUE) {
				birdIsSpinning = false;
				int x          = (int) attackBird.getX();
				int y          = (int) attackBird.getY();
				featherOne     = new Feather(x, y);
				featherTwo     = new Feather(x, y);
				featherThree   = new Feather(x, y);
			}
		} else {
			/**
			 * Bird will go in a different direction depending on which way it comes from,
			 * as well as whether or not it is entering or leaving the viewport.
			 */
			if (direction == DIRECTION_LEFT) {
				moveAttackBirdLeft(ATTACK_ONE);
			} else {
				moveAttackBirdRight(ATTACK_ONE);
			}
		}

		// Prepare bird to spin.  If it's position is smaller than "origin of spinning point", begin spinning. 
		if (direction == DIRECTION_LEFT) {
			if (attackBird.getX() < attackBirdOriginX && !birdHasBeganSpinning) {
				prepareBirdToMoveInACircularPath();
			}
			// If bird makes it to this position, first attack is completed.
			if (attackBirdHasReachedLeftBoundary()) {
				firstAttackComplete = true;
			}
		} else {
			// Prepare bird to spin.  If it's position is greater than "origin of spinning point", begin spinning.
			if (attackBird.getX() > attackBirdOriginX && !birdHasBeganSpinning) {
				prepareBirdToMoveInACircularPath();
			} 
			// If bird makes it to this position, second attack is completed.
			if (attackBirdHasReachedRightBoundary()) {
				secondAttackComplete = true;
			}
		}
	}

	private void prepareBirdToMoveInACircularPath() {
		birdIsSpinning       = true;
		birdHasBeganSpinning = true;
	}

	private void applyPlayerPhysics() {
		// Apply gravity unless player has hit the barrier (water) for him to stop.
		if (player.y <= gravityHaltBarrier) {
			// Change in velocity.
			playerDy += gravity * dt; 
			// Position formula.
			player.y += playerDy * dt + .00005f * gravity * dt * dt; 
		} else {
			// Make sure this is false so player can still move on top of stumps.
			playerIsJumping = false;
		}
	}
}
