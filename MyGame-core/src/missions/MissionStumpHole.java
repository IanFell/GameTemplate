package missions;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import gameobjects.Bird;
import gameobjects.GameObject;
import gameobjects.nature.Stump;
import helpers.GameAttributeHelper;
import loaders.ImageLoader;
import maps.MapHandler;
import screens.GameScreen;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionStumpHole extends Mission {

	private Bird bird;
	private Bird attackBird;

	public static boolean missionIsActive = false;

	public static ArrayList <GameObject> stumps = new ArrayList <GameObject>();

	private final int AMOUNT_OF_STUMPS = 13;

	public static Rectangle player;

	public static float playerDx;
	public static float playerDy;

	private float playerSize = 0.8f;

	public static int playerDirection;

	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;

	/**
	 * Gravity variables.
	 */
	private double gravity = 0.6d;
	private double dt      = 0.4d; 

	public static boolean playerIsJumping = false;

	private int jumpTimer = 0;

	private final float VERTICAL_ACCELERATION = 0.8f;
	private final float PEAK_JUMP_VALUE       = 3.0f;

	private float waterTileHeight = 2.3f;

	private int animatedWaterTimer = 0;

	private final int MAX_ANIMATED_WATER_TIMER_VALUE = 10;

	private float attackBirdOriginX;
	private float attackBirdOriginY;
	private float attackBirdAngle      = 0;
	private float attackBirdDx         = 0.3f;
	// Break in between attacks.
	private float attackBirdBreakTimer     = 0;
	private final float ATTACK_BREAK_VALUE = 50;

	private final int WAVE_ONE                     = 1;
	private final int WAVE_TWO                     = 2;
	private final int WAVE_THREE                   = 3;
	private int wave                               = WAVE_ONE;
	private boolean birdIsSpinning                 = false;
	private boolean birdHasBeganSpinning           = false;
	// How long bird will go in a circle.
	private final int CIRCULAR_ATTACK_MAX_VALUE    = 58;
	private int circularAttackTimer                = 0;


	/**
	 * Constructor.
	 */
	public MissionStumpHole() {
		loadStumps();
		// Place bird on last stump of row one of stumps.
		bird            = new Bird(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 5f, 
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 32.5f
				);
		attackBird      = new Bird(
				stumps.get(5).getX(), 
				stumps.get(5).getY() - 3
				);
		player          = new Rectangle(stumps.get(0).getX(), stumps.get(0).getY() - 60, playerSize, playerSize);
		playerDx        = 0.2f;
		playerDy        = 0;
		playerDirection = DIRECTION_RIGHT;

		attackBirdOriginX = attackBird.getX();
		attackBirdOriginY = attackBird.getY();
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
			// Draw background.
			batch.draw(
					imageLoader.sky, 
					GameScreen.camera.position.x - GameScreen.camera.viewportWidth / 2, 
					GameScreen.camera.position.y + GameScreen.camera.viewportHeight / 2,
					GameScreen.camera.viewportWidth, 
					-GameScreen.camera.viewportHeight
					);

			for (int i = 0; i < stumps.size(); i++) {
				stumps.get(i).renderObject(batch, imageLoader);
			}

			// Draw player.
			Texture playerTexture = imageLoader.playerRight;
			if (playerDirection == DIRECTION_LEFT) {
				playerTexture = imageLoader.playerLeft;
			}
			batch.draw(playerTexture, player.x, player.y + player.height, player.width, -player.height);

			// Render water.
			float originalX                    = GameScreen.camera.position.x - GameScreen.camera.viewportWidth / 2;
			float originalY                    = GameScreen.camera.position.y + GameScreen.camera.viewportHeight / 2;
			float startX                       = originalX;
			float startY                       = originalY;
			int rowLength                      = 28;
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
			attackBird.renderObject(batch, imageLoader);
		} else {
			bird.renderObject(batch, imageLoader);
		}
	}

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
		if (playerIsJumping) {
			playerDy = playerDy - VERTICAL_ACCELERATION;
			jumpTimer++;
			if (jumpTimer > PEAK_JUMP_VALUE) {
				playerIsJumping = false;
				jumpTimer       = 0;
			}
		}
		for (int i = 0; i < stumps.size(); i++) {
			stumps.get(i).updateObject(myGame, mapHandler);
		}
		applyGravityToPlayer();

		attackBirdBreakTimer++;
		executeBirdAttackOne();
	}

	private void executeBirdAttackOne() {
		if (wave == WAVE_ONE) {
			if (attackBirdBreakTimer > ATTACK_BREAK_VALUE) {
				moveAttackBirdLeft();
			}
		} else if (wave == WAVE_TWO) {
			if (attackBirdBreakTimer > ATTACK_BREAK_VALUE) {
				moveAttackBirdRight();
			}
		} else if (wave == WAVE_THREE) {
			if (attackBirdBreakTimer > ATTACK_BREAK_VALUE) {
				moveAttackBirdInCircularPath();
			}
		}
	}

	private void moveAttackBirdRight() {
		attackBird.setX(attackBird.getX() + attackBirdDx);

		if (attackBird.getX() > stumps.get(AMOUNT_OF_STUMPS - 1).getX() + 5) {
			wave                 = WAVE_THREE;
			attackBirdBreakTimer = 0;
		}
	}

	private void moveAttackBirdLeft() {
		attackBird.setX(attackBird.getX() - attackBirdDx);

		if (attackBird.getX() < stumps.get(0).getX() - 5) {
			wave                 = WAVE_TWO;
			attackBirdBreakTimer = 0;
		}
	}

	private void moveAttackBirdInCircularPath() {
		if (birdIsSpinning) {
			attackBirdAngle += 0.3f;
			float attackBirdCircularPathRadius = 3;
			attackBird.setX((float) (attackBirdOriginX - Math.cos(attackBirdAngle) * attackBirdCircularPathRadius)); 
			attackBird.setY((float) (attackBirdOriginY + Math.sin(attackBirdAngle) * attackBirdCircularPathRadius)); 

			// Make bird go in a circle for a specified amount of time.
			circularAttackTimer++;
			if (circularAttackTimer > CIRCULAR_ATTACK_MAX_VALUE) {
				birdIsSpinning = false;
			}
		} else {
			moveAttackBirdLeft();
		}

		if (attackBird.getX() < attackBirdOriginX && !birdHasBeganSpinning) {
			birdIsSpinning       = true;
			birdHasBeganSpinning = true;
		} 
	}

	private void applyGravityToPlayer() {
		// Change in velocity.
		playerDy += gravity * dt; 
		// Position formula.
		player.y += playerDy * dt + .00005f * gravity * dt * dt; 
	}
}
