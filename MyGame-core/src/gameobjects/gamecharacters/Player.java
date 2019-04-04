package gameobjects.gamecharacters;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.Torch;
import handlers.AnimationHandler;
import helpers.GameAttributeHelper;
import inventory.Inventory;
import loaders.GameObjectLoader;
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
	 * Used for water animation.
	 */
	private int timer;

	/**
	 * Available directions player can travel.  
	 */
	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_UP    = 2;
	public static final int DIRECTION_DOWN  = 3;

	public final static float PLAYER_SPEED = 0.10f;

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

	protected int playerScore;

	protected int playerHealth;

	private Torch torch;
	public static boolean hasTorch;

	protected Inventory inventory;

	/**
	 * Constructor.
	 * 
	 *  String name
	 */
	public Player(String name) {
		this.x                   = 0;
		this.y                   = 5;
		this.width               = characterSize;
		this.height              = characterSize;
		rectangle.width          = characterSize;
		rectangle.height         = characterSize;
		walkDownTexture          = new TextureAtlas(Gdx.files.internal("PlayerSpriteDown.atlas"));
		walkUpTexture            = new TextureAtlas(Gdx.files.internal("PlayerSpriteUp.atlas"));
		walkRightTexture         = new TextureAtlas(Gdx.files.internal("PlayerSpriteRight.atlas"));
		walkLeftTexture          = new TextureAtlas(Gdx.files.internal("PlayerSpriteLeft.atlas"));
		float animationSpeed     = 7/15f;
		walkDownAnimation        = new Animation <TextureRegion> (animationSpeed, walkDownTexture.getRegions());
		walkUpAnimation          = new Animation <TextureRegion> (animationSpeed, walkUpTexture.getRegions());
		walkRightAnimation       = new Animation <TextureRegion> (animationSpeed, walkRightTexture.getRegions());
		walkLeftAnimation        = new Animation <TextureRegion> (animationSpeed, walkLeftTexture.getRegions());
		playerHealth     	     = 100;
		this.name                = name;
		torch                    = new Torch(0, 0);
		hasTorch                 = false;
		inventory                = new Inventory();
		playerIsPerformingAttack = false;
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
		System.out.println("Player Inventory includes: " + inventory);
		x += dx;
		y += dy;
		rectangle.x = x;
		rectangle.y = y;

		// Timer for water animation.
		timer++;
		if (timer > 20) {
			timer = 0;
		}

		if (hasTorch) {	
			torch.updateObject(myGame, mapHandler);
		}

		if (playerIsPerformingAttack) {
			attackTimer++;
			if (attackTimer > 5) {
				attackTimer              = 0;
				playerIsPerformingAttack = false;
			}
		}
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	protected void handleJumping(MyGame myGame) {
		if (isJumping) {
			System.out.println("Player is jumping");
			jumpCount++;
			if (jumpCount >= JUMP_COUNT_MAX) {
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
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		elapsedTime += Gdx.graphics.getDeltaTime();
		if (isInWater) {
			float offset = 1.0f;
			if (timer < 10) {
				offset = 1.1f;
			}
			int resizedValue = 2;
			switch (direction) {
			case DIRECTION_LEFT:
				batch.draw(imageLoader.playerHeadLeft, x, y + offset, characterSize, -characterSize * resizedValue);
				break;
			case DIRECTION_RIGHT:
				batch.draw(imageLoader.playerHeadRight, x, y + offset, characterSize, -characterSize * resizedValue);
				break;
			case DIRECTION_UP:
				batch.draw(imageLoader.playerHeadUp, x, y + offset, characterSize, -characterSize * resizedValue);
				break;
			case DIRECTION_DOWN:
				batch.draw(imageLoader.playerHeadDown, x, y + offset, characterSize, -characterSize * resizedValue);
				break;
			}
		} else {
			AnimationHandler.renderAnimation(batch, elapsedTime, getCurrentAnimation(), x, y, characterSize);
		}

		if (hasTorch) {	
			torch.renderObject(batch, shapeRenderer, imageLoader);
		}
	}

	/**
	 * 
	 * @return Inventory
	 */
	public Inventory getInventory() {
		return inventory;
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
	 * @param int score
	 */
	public void updatePlayerScore(int score) {}

	/**
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return int
	 */
	@Override
	public int getPlayerHealth() {
		return playerHealth;
	}

	/**
	 * 
	 * @param MyGame myGame
	 * @return boolean
	 */
	protected boolean playerOneIsMovingAndNotDead(MyGame myGame) {
		return Player.playerIsMoving && myGame.getGameObject(GameObject.PLAYER_ONE).getPlayerHealth() > 0;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param GameObject player
	 */
	protected void simulateDeath(MyGame myGame, GameObject player) {
		if (!GameObjectLoader.gameObjectList.contains(player)) {
			playerHealth--;
		}
	}

	/**
	 * 
	 * @param GameObject previousPlayer
	 * @param GameObject currentPlayer
	 */
	protected void removeCurrentPlayerIfDead(GameObject previousPlayer, GameObject currentPlayer) {
		if (playerHealth <= 0 && !GameObjectLoader.gameObjectList.contains(previousPlayer)) {
			GameObjectLoader.gameObjectList.remove(currentPlayer);
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
}
