package gameobjects.gamecharacters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import handlers.AnimationHandler;
import helpers.GameAttributeHelper;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * Player object.
 * 
 * @author Fabulous Fellini
 *
 */
public class Player extends GameObject { 

	private String name;

	/**
	 * Available directions player can travel.  
	 */
	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_UP    = 2;
	public static final int DIRECTION_DOWN  = 3;

	public final static float PLAYER_SPEED = 0.10f;

	/**
	 * If player jumps, isJumping will be true until jumpCount surpases jumpCountMax.
	 * When it does, jumpCount is reset to 0 and ready for another jump.
	 */
	public static boolean isJumping       = false;
	private static int jumpCount          = 0;
	private static final int jumpCountMax = GameAttributeHelper.FRAMES_PER_SECOND;

	public static int jumpingAction;
	private float jumpSpeed;
	private float jumpingSpeedValue = 0.05f;

	private static final int ON_GROUND      = 0;
	public static final int ASCENDING_JUMP  = 1;
	public static final int DESCENDING_JUMP = 2;

	/**
	 * Used to determine whether footsteps sound effect should play.
	 */
	public static boolean playerIsMoving = false;

	/**
	 * Distance player two and player three follow player one,
	 * as well as the direction value.
	 */
	protected int playerOneFollowAndDirectionValueOffset;

	/**
	 * Textures to go with animations.
	 */
	private TextureAtlas walkDownTexture;
	private TextureAtlas walkUpTexture;
	private TextureAtlas walkRightTexture;
	private TextureAtlas walkLeftTexture;

	/**
	 * Available animations for player object.
	 */
	private Animation <TextureRegion> walkDownAnimation;
	private Animation <TextureRegion> walkUpAnimation;
	private Animation <TextureRegion> walkRightAnimation;
	private Animation <TextureRegion> walkLeftAnimation;

	/**
	 * Current animation being used in game.
	 */
	private Animation <TextureRegion> currentAnimation;

	/**
	 * Used for animation speed.
	 */
	private float elapsedTime = 0;

	/**
	 * Character size is the same size as a tile.
	 */
	private float characterSize = 0.5f;

	private int playerScore;

	/**
	 * Constructor.
	 * 
	 *  String name
	 */
	public Player(String name) {
		this.x               = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 35;
		this.y               = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START;
		this.width           = characterSize;
		this.height          = characterSize;
		rectangle.width      = characterSize;
		rectangle.height     = characterSize;
		walkDownTexture      = new TextureAtlas(Gdx.files.internal("PlayerSpriteDown.atlas"));
		walkUpTexture        = new TextureAtlas(Gdx.files.internal("PlayerSpriteUp.atlas"));
		walkRightTexture     = new TextureAtlas(Gdx.files.internal("PlayerSpriteRight.atlas"));
		walkLeftTexture      = new TextureAtlas(Gdx.files.internal("PlayerSpriteLeft.atlas"));
		float animationSpeed = 7/15f;
		walkDownAnimation    = new Animation <TextureRegion> (animationSpeed, walkDownTexture.getRegions());
		walkUpAnimation      = new Animation <TextureRegion> (animationSpeed, walkUpTexture.getRegions());
		walkRightAnimation   = new Animation <TextureRegion> (animationSpeed, walkRightTexture.getRegions());
		walkLeftAnimation    = new Animation <TextureRegion> (animationSpeed, walkLeftTexture.getRegions());
		playerScore          = 0;
		this.name            = name;
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
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		x += dx;
		y += dy;
		rectangle.x = x;
		rectangle.y = y;
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	protected void handleJumping(MyGame myGame) {
		if (isJumping) {
			System.out.println("Player is jumping");
			jumpCount++;
			if (jumpCount >= jumpCountMax) {
				// Reset jump variables and get ready to jump again.
				isJumping = !isJumping;
				jumpCount = 0;
			}
			// If player is still jumping up.
			if (playerIsBelowPeakJump()) {
				jumpingAction = ASCENDING_JUMP;
				System.out.println("Player is ascending during jumping");
			} else {
				// If player has reached jumping peak and is falling back to the ground.
				jumpingAction = DESCENDING_JUMP;
				System.out.println("Player is descending during jumping");
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
		if (jumpCount < jumpCountMax / 2) {
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
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		elapsedTime += Gdx.graphics.getDeltaTime();
		AnimationHandler.renderAnimation(batch, elapsedTime, getCurrentAnimation(), x, y, characterSize);
	}

	/**
	 * Returns current animation depending on which direction player is facing.
	 * 
	 * @return Animation <TextureRegion>
	 */
	private Animation <TextureRegion> getCurrentAnimation() {
		switch (direction) {
		case Player.DIRECTION_LEFT:
			currentAnimation = walkLeftAnimation;
			break;
		case Player.DIRECTION_RIGHT:
			currentAnimation = walkRightAnimation;
			break;
		case Player.DIRECTION_UP:
			currentAnimation = walkUpAnimation;
			break;
		case Player.DIRECTION_DOWN:
			currentAnimation = walkDownAnimation;
			break;
		}
		return currentAnimation;
	}

	/**
	 * 
	 * @param float distance
	 */
	@Override
	public void translateX(float distance) {
		x += distance;
	}

	/**
	 * 
	 * @param float distance
	 */
	@Override
	public void translateY(float distance) {
		y += distance;
	}

	public void stopPlayer() {
		dx = 0;
		dy = 0;
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
	 * @return int
	 */
	public int getPlayerScore() {
		return playerScore;
	}

	/**
	 * 
	 * @param int playerScore
	 */
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	/**
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}
}
