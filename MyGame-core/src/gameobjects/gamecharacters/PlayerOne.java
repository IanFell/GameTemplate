package gameobjects.gamecharacters;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.Torch;
import handlers.AnimationHandler;
import inventory.Inventory;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.Lighting.Fire;

/**
 * Jolly Roger.
 * 
 * @author Fabulous Fellini
 *
 */
public class PlayerOne extends Player {

	private final float BOUNCE_BACK_STARTING_VALUE = 0.06f;
	private float bounceBackIncrement              = BOUNCE_BACK_STARTING_VALUE;
	private boolean isBouncingBack                 = false;

	private Torch torch;

	int timer = 0;

	/**
	 * Keeps a list of player one's coordinates and direction.  
	 * This is used to determine the paths of player two and player three.
	 */
	public static ArrayList<Float> playerOneXPositions = new ArrayList<Float>();
	public static ArrayList<Float> playerOneYPositions = new ArrayList<Float>();
	public static ArrayList<Integer> playerDirections  = new ArrayList<Integer>();

	/**
	 * Constructor.
	 * 
	 * @param String name
	 * @param MyGame myGame
	 * @param int    playerNumber
	 */
	public PlayerOne(String name, MyGame myGame, int playerNumber) {
		super(name, myGame, playerNumber);
		playerScore = 0;
		torch       = new Torch(0, 0);
	}

	/**
	 * 
	 * @param int score
	 */
	public void updatePlayerScore(int score) {
		playerScore += score;
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
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		handleWalking(myGame);
		handleJumping(myGame);
		handleBounceBack();

		if (getHealth() <= 0) {
			setLifeState(myGame, PLAYER_ONE);
		}

		if (hasTorch) {	
			torch.updateObject(myGame, mapHandler);
			Fire.playSound = true;
		}

		//simulateDeath(myGame, this);

		if (Inventory.inventoryHasStartedCollection) {
			inventory.updateInventory(x, y, mapHandler);
		}

		handleTextures();
	}

	/**
	 * This handles bouncing back of player after he collides and attacks and enemy.
	 * 
	 * If player bounces back offscreen he will never stop because he never hits the ground.
	 */
	private void handleBounceBack() {
		if (isBouncingBack) {
			switch (direction) {
			case DIRECTION_LEFT:
				x += bounceBackIncrement;
				break;
			case DIRECTION_RIGHT:
				x -= bounceBackIncrement;
				break;
			case DIRECTION_UP:
				y += bounceBackIncrement;
				break;
			case DIRECTION_DOWN:
				y -= bounceBackIncrement;
				break;
			}
			bounceBackIncrement *= 1.7f;
		} else {
			bounceBackIncrement = BOUNCE_BACK_STARTING_VALUE;
			isBouncingBack = false;
		}

		if (jumpingAction == ON_GROUND) {
			isBouncingBack = false;
		}
	}

	public void setBouncingBack(boolean isBouncingBack) {
		this.isBouncingBack = isBouncingBack;
	}

	private void handleTextures() {
		if (Inventory.inventoryIsEquipped) {
			// Make player spin if jumping.
			if (jumpingAction == Player.DESCENDING_JUMP) {
				animationSpeed = 1/15f;
				setAnimations(
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpRight.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpLeft.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpUp.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpDown.atlas"))
						);
			} else {
				animationSpeed = 7/15f;
				setAnimations(
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerRightGun.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerLeftGun.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerUpGun.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerDownGun.atlas"))
						);
			}
		} else {
			// Make player spin if jumping.
			if (jumpingAction == Player.DESCENDING_JUMP) {
				animationSpeed = 1/15f;
				setAnimations(
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpRight.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpLeft.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpUp.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpDown.atlas"))
						);
			} else {
				animationSpeed = 7/15f;
				setAnimations(
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerRightRed.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerLeftRed.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerUpRed.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerDownRed.atlas"))
						);
			}
		}
	}

	/**
	 * 
	 * @param TextureAtlas walkRight
	 * @param TextureAtlas walkLeft
	 * @param TextureAtlas walkUp
	 * @param TextureAtlas walkDown
	 */
	private void setAnimations(TextureAtlas walkRight, TextureAtlas walkLeft, TextureAtlas walkUp, TextureAtlas walkDown) {
		walkRightTexture   = walkRight;
		walkLeftTexture    = walkLeft;
		walkDownTexture    = walkDown;
		walkUpTexture      = walkUp;
		walkRightAnimation = new Animation <TextureRegion> (animationSpeed, walkRightTexture.getRegions());
		walkLeftAnimation  = new Animation <TextureRegion> (animationSpeed, walkLeftTexture.getRegions());
		walkDownAnimation  = new Animation <TextureRegion> (animationSpeed, walkDownTexture.getRegions());
		walkUpAnimation    = new Animation <TextureRegion> (animationSpeed, walkUpTexture.getRegions());
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		super.renderObject(batch, imageLoader);
		AnimationHandler.renderAnimation(
				batch, 
				elapsedTime, 
				getCurrentAnimation(), 
				x, 
				y, 
				playerSize, 
				imageLoader, 
				AnimationHandler.OBJECT_TYPE_PLAYER
				);

		if (hasTorch) {	
			torch.renderObject(batch, imageLoader);
		}
		//renderHitBox(batch, imageLoader);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param GameObject player
	 */
	@Override
	protected void simulateDeath(MyGame myGame, GameObject player) {
		health--;
	}

	/**
	 * Only save player coordiantes if player is moving.  
	 * This is so player two and three stop and move with player one.
	 * 
	 * @param MyGame myGame
	 */
	@Override
	protected void handleWalking(MyGame myGame) {
		savePlayerCurrentPositionAndDirection(x, y, playerOneXPositions, playerOneYPositions, playerDirections);
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	@Override
	protected void handleJumping(MyGame myGame) {
		super.handleJumping(myGame);
		if (jumpingAction == Player.DESCENDING_JUMP) {
			switch (direction) {
			case Player.DIRECTION_LEFT:
				dx = -0.3f;
				dy = 0.01f;
				break;
			case Player.DIRECTION_RIGHT:
				dx = 0.3f;
				dy = 0.01f;
				break;
			case Player.DIRECTION_UP:
				dx = 0;
				dy = -0.3f;
				break;
			case Player.DIRECTION_DOWN:
				dx = 0;
				dy = 0.3f;
				break;
			}
			x += dx;
			y += dy;
		} else {
			dx = 0;
			dy = 0;
		}
	}
}
