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
import maps.MapLocationFinder;
import physics.Lighting.Fire;

/**
 * Jolly Roger.
 * 
 * @author Fabulous Fellini
 *
 */
public class PlayerOne extends Player {

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
		torch                    = new Torch(0, 0);
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
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		handleWalking(myGame);
		handleJumping(myGame);

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

		if (Inventory.inventoryIsEquipped) {
			setAnimations(
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerRightGun.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerLeftGun.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerUpGun.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerDownGun.atlas"))
					);
		} else {
			setAnimations(
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerRightRed.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerLeftRed.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerUpRed.atlas")),
					new TextureAtlas(Gdx.files.internal(playerRenderingPrefix + "playerDownRed.atlas"))
					);
		}
		
		//System.out.println(MapLocationFinder.getPlayerLocationOnMap(this));
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
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
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
}
