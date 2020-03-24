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
import handlers.RumHandler;
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

	private float animationSpeed;

	private final float BOUNCE_BACK_STARTING_VALUE = 0.7f;
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
		playerLoot = 0;
		torch      = new Torch(0, 0);
	}

	/**
	 * 
	 * @param int loot
	 */
	@Override
	public void updatePlayerLoot(int loot) {
		playerLoot += loot;
	}

	/**
	 * Convert the current amount of player loot into a string to display on screen.
	 * 
	 * @retrun String
	 */
	@Override
	public String convertPlayerLootToString() {
		return Integer.toString(playerLoot);
	}

	/**
	 * Convert the current amount of player rum into a string to display on screen.
	 * 
	 * @retrun String
	 */
	@Override
	public String convertPlayerRumToString() {
		return Integer.toString(RumHandler.rumCount);
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
		setPlayerAnimations();
	}

	/**
	 * Handles player animations, depending on the life state.
	 * Each life state will draw a different player.
	 */
	private void setPlayerAnimations() {
		if (lifeState == LIFE_STATE_TWO) {
			setAnimations(
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwoRight.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwoLeft.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwoUp.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerTwo.atlas"))	
					);
		} 
		if (lifeState == LIFE_STATE_THREE) {
			setAnimations(
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeRight.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeLeft.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeUp.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerThreeDown.atlas"))	
					);
		} 
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
		} else {
			bounceBackIncrement = BOUNCE_BACK_STARTING_VALUE;
			isBouncingBack = false;
		}

		if (jumpingAction == ON_GROUND) {
			isBouncingBack = false;
		}
	}

	/**
	 * 
	 * @param boolean isBouncingBack
	 */
	public void setBouncingBack(boolean isBouncingBack) {
		this.isBouncingBack = isBouncingBack;
	}

	private void handleTextures() {
		if (Inventory.inventoryIsEquipped) {
			// Make player spin if jumping.
			if (jumpingAction == Player.DESCENDING_JUMP) {
				animationSpeed = AnimationHandler.ANIMATION_SPEED_PLAYER_DESCEND_JUMP;
				setAnimations(
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpRight.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpLeft.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpUp.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpDown.atlas"))
						);
			} else {
				animationSpeed = AnimationHandler.ANIMATION_SPEED_PLAYER;
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
				animationSpeed = AnimationHandler.ANIMATION_SPEED_PLAYER_DESCEND_JUMP;
				setAnimations(
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpRight.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpLeft.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpUp.atlas")),
						new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerJumpDown.atlas"))
						);
			} else {
				animationSpeed = AnimationHandler.ANIMATION_SPEED_PLAYER;
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
		if (!Player.isInvincible) {
			AnimationHandler.renderAnimation(
					batch, 
					elapsedTime, 
					getCurrentAnimation(), 
					x, 
					y, 
					width,
					height,
					imageLoader, 
					AnimationHandler.OBJECT_TYPE_PLAYER
					);
		} else {
			if (Player.invincibilityTimer % 2 == 0) {
				AnimationHandler.renderAnimation(
						batch, 
						elapsedTime, 
						getCurrentAnimation(), 
						x, 
						y, 
						width,
						height,
						imageLoader, 
						AnimationHandler.OBJECT_TYPE_PLAYER
						);
			}
		}


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
			case DIRECTION_LEFT:
				dx = -0.3f;
				dy = 0.01f;
				break;
			case DIRECTION_RIGHT:
				dx = 0.3f;
				dy = 0.01f;
				break;
			case DIRECTION_UP:
				dx = 0;
				dy = -0.3f;
				break;
			case DIRECTION_DOWN:
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
