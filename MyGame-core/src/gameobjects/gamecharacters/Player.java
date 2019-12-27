package gameobjects.gamecharacters;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import handlers.AnimationHandler;
import helpers.GameAttributeHelper;
import inventory.Inventory;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import maps.MapHandler;
import particles.DustParticleEmitter;
import towns.Town;

/**
 * Player object.
 * 
 * Although there are three starting players, all info is held within Player One.
 * For example, when player one dies, he is reset, and redrawn to look like player two.
 * If player one dies, player three will cease to be rendered and player two will now
 * be rendered as player three.  This will make it easier when it comes to health, not 
 * having to transfer inventory, etc.
 * 
 * @author Fabulous Fellini
 *
 */
public class Player extends GameCharacter { 

	public static final String JOLLY_ROGER = "JOLLY ROGER";
	public static final String BLACK_BEARD = "BLACK BEARD";
	public static final String PEG_LEG     = "PEG LEG";

	private String name;

	protected String playerRenderingPrefix = "artwork/gamecharacters/player/";

	public final static float PLAYER_SPEED = 0.3f;

	public static boolean isInWater = false;

	public static boolean playerIsPerformingAttack;
	public static int attackTimer;

	/**
	 * If player jumps, isJumping will be true until jumpCount surpases jumpCountMax.
	 * When it does, jumpCount is reset to 0 and ready for another jump.
	 */
	public static boolean isJumping         = false;
	private static int jumpCount            = 0;
	private static final int JUMP_COUNT_MAX = GameAttributeHelper.FRAMES_PER_SECOND;

	public static int jumpingAction;
	protected float jumpSpeed;
	private float jumpingSpeedValue = 0.1f;

	public static final int ON_GROUND       = 0;
	public static final int ASCENDING_JUMP  = 1;
	public static final int DESCENDING_JUMP = 2;

	public static final int LIFE_STATE_ONE   = 1;
	public static final int LIFE_STATE_TWO   = 2;
	public static final int LIFE_STATE_THREE = 3;

	public static int lifeState;

	/**
	 * Used to determine whether footsteps sound effect should play.
	 */
	public static boolean playerIsMoving = false;

	/**
	 * Distance player two and player three follow player one,
	 * as well as the direction value.
	 */
	protected int playerOneFollowAndDirectionValueOffset;

	protected float playerSize = 1f;

	protected int playerLoot;

	protected int health;

	private final int STARTING_HEALTH = 10;

	public static boolean hasTorch;

	private DustParticleEmitter dustEmitter;

	private int playerNumber;

	/**
	 * Constructor.
	 * 
	 * @param String name
	 * @param MyGame myGame
	 * @param int    playerNumber
	 */
	public Player(String name, MyGame myGame, int playerNumber) {
		setPlayerStartingPosition(Town.STUMP_HOLE);
		this.playerNumber        = playerNumber;
		this.width               = playerSize;
		this.height              = playerSize;
		rectangle.width          = playerSize;
		rectangle.height         = playerSize * 2;
		lifeState                = LIFE_STATE_ONE;

		switch (playerNumber) {
		case Player.PLAYER_ONE:
			walkDownTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerDownRed.atlas"));
			walkUpTexture            = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerUpRed.atlas"));
			walkRightTexture         = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerRightRed.atlas"));
			walkLeftTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerLeftRed.atlas")); 
			break;
		case Player.PLAYER_TWO:
			walkDownTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwo.atlas"));
			walkUpTexture            = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwoUp.atlas"));
			walkRightTexture         = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwoRight.atlas"));
			walkLeftTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwoLeft.atlas")); 
			break;
		case Player.PLAYER_THREE:
			walkDownTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeDown.atlas"));
			walkUpTexture            = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeUp.atlas"));
			walkRightTexture         = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeRight.atlas"));
			walkLeftTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeLeft.atlas")); 
			break;
		}

		walkDownAnimation        = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_PLAYER, walkDownTexture.getRegions());
		walkUpAnimation          = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_PLAYER, walkUpTexture.getRegions());
		walkRightAnimation       = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_PLAYER, walkRightTexture.getRegions());
		walkLeftAnimation        = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_PLAYER, walkLeftTexture.getRegions());
		health            	     = STARTING_HEALTH;
		this.name                = name;
		hasTorch                 = false;
		inventory                = new Inventory(myGame);
		playerIsPerformingAttack = false;
		dustEmitter              = new DustParticleEmitter();
	}

	/**
	 * 
	 * @param int town
	 */
	private void setPlayerStartingPosition(int town) {
		switch (town) {
		case Town.MEXICO_BEACH:
			this.x = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 43;
			this.y = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 10;
			break;
		case Town.PORT_ST_JOE:
			this.x = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 1;
			this.y = GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 6;
			break;
		case Town.THE_POINT:
			this.x = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 10; 
			this.y = GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START - 100;
			break;
		case Town.WEWA:
			this.x = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60;
			this.y = 3;
			break;
		case Town.APALACHICOLA:
			this.x = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 35;
			this.y = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 43;
			break;
		case Town.ST_GEORGE:
			this.x = GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 5;
			this.y = GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START + 3;
			break;
		case Town.CAPE_SAN_BLAS:
			this.x = GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 30; 
			this.y = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START - 40;
			break;
		case Town.STUMP_HOLE:
			this.x = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 12; 
			this.y = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 45;
			break;
		}
	}

	/**
	 * 
	 * @return int
	 */
	@Override
	public int getPlayerLoot() {
		return playerLoot;
	}

	/**
	 * 
	 * @param MyGame myGame
	 * @param Player player
	 */
	public void init(MyGame myGame, Player player) {
		setDirection(DIRECTION_LEFT);
		player.setX(myGame.gameObjectLoader.playerOne.getX());
		player.setY(myGame.gameObjectLoader.playerOne.getY());
	}

	/**
	 * 
	 * @param MyGame myGame
	 * @param int    playerNumber
	 */
	protected void setLifeState(MyGame myGame, int playerNumber) {
		if (lifeState == LIFE_STATE_ONE) {
			setUpLifeState(myGame, playerNumber);
		}
		else if (lifeState == LIFE_STATE_TWO) {
			setUpLifeState(myGame, playerNumber);
		}
	}

	/**
	 * Handles life state of player if it needs to change due to death.
	 * 
	 * @param MyGame myGame
	 * @param int    playerNumber
	 */
	protected void setUpLifeState(MyGame myGame, int playerNumber) {
		switch (lifeState) {
		case LIFE_STATE_ONE:
			if (playerNumber == PLAYER_ONE) {
				walkDownTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwo.atlas"));
				walkUpTexture            = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwoUp.atlas"));
				walkRightTexture         = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwoRight.atlas"));
				walkLeftTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwoLeft.atlas")); 
			}
			if (playerNumber == PLAYER_TWO) {
				walkDownTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeDown.atlas"));
				walkUpTexture            = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "PlayerThreeUp.atlas"));
				walkRightTexture         = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeRight.atlas"));
				walkLeftTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeLeft.atlas"));
				lifeState                = LIFE_STATE_TWO;
				myGame.getGameObject(Player.PLAYER_ONE).setHealth(STARTING_HEALTH);
			}
			break;
		case LIFE_STATE_TWO:
			if (playerNumber == PLAYER_ONE) {
				walkDownTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeDown.atlas"));
				walkUpTexture            = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "PlayerThreeUp.atlas"));
				walkRightTexture         = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeRight.atlas"));
				walkLeftTexture          = new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeLeft.atlas")); 
			}
			if (playerNumber == PLAYER_TWO) {
				lifeState = LIFE_STATE_THREE;
				myGame.getGameObject(Player.PLAYER_ONE).setHealth(STARTING_HEALTH);
			}
			break;
		}
		walkDownAnimation  = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_PLAYER, walkDownTexture.getRegions());
		walkUpAnimation    = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_PLAYER, walkUpTexture.getRegions());
		walkRightAnimation = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_PLAYER, walkRightTexture.getRegions());
		walkLeftAnimation  = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_PLAYER, walkLeftTexture.getRegions());
	}

	/**
	 * Collisions with tiles are located in the MapRenderer class.
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		x += dx;
		y += dy;
		rectangle.x = x;
		rectangle.y = y - height * 2;

		// Timer for water animation.
		timer++;
		if (timer > 20) {
			timer = GameAttributeHelper.TIMER_START_VALUE;
		}

		// Cannot perform attack too fast.
		if (playerIsPerformingAttack) {
			attackTimer++;
			if (attackTimer > 5) {
				attackTimer              = GameAttributeHelper.TIMER_START_VALUE;
				playerIsPerformingAttack = false;
			}
		}
		dustEmitter.updateParticles(myGame);

		if (isInWater) {
			jumpingAction = ON_GROUND;
		}
	}

	/**
	 * 
	 * @return int
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * 
	 * @param int health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	protected void handleJumping(MyGame myGame) {
		if (isJumping) {
			jumpCount++;
			if (jumpCount >= JUMP_COUNT_MAX) {
				// Reset jump variables and get ready to jump again.
				isJumping = !isJumping;
				jumpCount = 0;
			}
			// If player is still jumping up.
			if (playerIsBelowPeakJump()) {
				jumpingAction = ASCENDING_JUMP;
			} else {
				// If player has reached jumping peak and is falling back to the ground.
				jumpingAction = DESCENDING_JUMP;
			}

			switch (jumpingAction) {
			case ASCENDING_JUMP:
				jumpSpeed = -jumpingSpeedValue;
				break;
			case DESCENDING_JUMP:
				jumpSpeed = jumpingSpeedValue;
				break;
			}
			myGame.getGameObject(
					GameObject.PLAYER_ONE).setY(myGame.getGameObject(GameObject.PLAYER_ONE).getY() + jumpSpeed
							);
			myGame.getGameObject(
					GameObject.PLAYER_TWO).setY(myGame.getGameObject(GameObject.PLAYER_TWO).getY() + jumpSpeed
							);
			myGame.getGameObject(
					GameObject.PLAYER_THREE).setY(myGame.getGameObject(GameObject.PLAYER_THREE).getY() + jumpSpeed
							);
		} else {
			jumpingAction = ON_GROUND;
		}
	}

	/**
	 * Checks if player is ascending during jump.
	 * 
	 * @return boolean
	 */
	private boolean playerIsBelowPeakJump() {
		if (jumpCount < JUMP_COUNT_MAX / 2) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	protected void handleWalking(MyGame myGame) {}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		updateElapsedTime();
		dustEmitter.renderObject(batch, imageLoader);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	protected void renderHitBox(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(imageLoader.whiteSquare, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
	}

	/**
	 * 
	 * @param float distance
	 */
	@Override
	public void translateX(float distance) {
		if (isInWater) {
			distance = distance / 2;
		}
		x += distance;
	}

	/**
	 * 
	 * @param float distance
	 */
	@Override
	public void translateY(float distance) {
		if (isInWater) {
			distance = distance / 2;
		}
		y += distance;
	}

	/**
	 * 
	 * @param float speed
	 */
	@Override
	public void moveRight(float speed) {
		translateX(speed);
		setDirection(Player.DIRECTION_RIGHT);
		playerIsMoving = true;
	}

	/**
	 * 
	 * @param float speed
	 */
	@Override
	public void moveLeft(float speed) {
		translateX(-speed);
		setDirection(Player.DIRECTION_LEFT);
		playerIsMoving = true;
	}

	/**
	 * 
	 * @param float speed
	 */
	@Override
	public void moveUp(float speed) {
		translateY(-speed);
		setDirection(Player.DIRECTION_UP);
		playerIsMoving = true;
	}

	/**
	 * 
	 * @param float speed
	 */
	@Override
	public void moveDown(float speed) {
		translateY(speed);
		setDirection(Player.DIRECTION_DOWN);
		playerIsMoving = true;
	}

	/**
	 * 
	 * @return float
	 */
	public float getJumpingSpeedValue() {
		return jumpingSpeedValue;
	}

	/**
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param GameObject player
	 */
	protected void simulateDeath(MyGame myGame, GameObject player) {
		if (!GameObjectLoader.gameObjectList.contains(player)) {
			health--;
		}
	}

	/**
	 * 
	 * @param float              x
	 * @param float              y
	 * @param ArrayList<Float>   xPositions
	 * @param ArrayList<Float>   yPositions
	 * @param ArrayList<Integer> directions
	 */
	protected void savePlayerCurrentPositionAndDirection(
			float x, 
			float y, 
			ArrayList<Float> xPositions, 
			ArrayList<Float> yPositions, 
			ArrayList<Integer> directions
			) {
		if (playerIsMoving) {
			xPositions.add(x);
			yPositions.add(y);
			directions.add(direction);
		}
	}

	/**
	 * 
	 * @param boolean isBouncingBack
	 */
	public void setBouncingBack(boolean isBouncingBack) {}

	/**
	 * 
	 * @param int loot
	 */
	public void updatePlayerLoot(int loot) {}
}
