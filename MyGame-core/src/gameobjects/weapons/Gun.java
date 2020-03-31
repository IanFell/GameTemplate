package gameobjects.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.gamecharacters.Player;
import gameobjects.gamecharacters.PlayerOne;
import gameobjects.stationarygameobjects.buildings.TradingPost;
import handlers.CollisionHandler;
import helpers.GamePlayHelper;
import inventory.Inventory;
import loaders.ImageLoader;
import loaders.bulletloader.BulletLoader;
import maps.MapHandler;
import ui.MapUi;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Gun extends Weapon {

	public static final int LOOT_NEEDED_TO_BUY_GUN = 5;

	public static boolean hasBeenCollected;

	public static boolean shouldNotRender = true;

	private int rotationAngle;

	private TextureRegion textureRegion;

	public static boolean playCollectionSound = false;

	/**
	 * Constructor.
	 * 
	 * @param float       x
	 * @param float       y
	 * @param ImageLoader imgageLoader 
	 */
	public Gun(float x, float y, ImageLoader imageLoader) {
		super(x, y);
		this.width            = 1.0f;
		this.height           = 1.0f;
		rectangle.width       = width;
		rectangle.height      = height;
		hasBeenCollected      = false;
		this.rotationAngle    = 0;
		textureRegion         = new TextureRegion(imageLoader.gunLeft);
	}

	/**
	 * 
	 * @param int rotationAngle
	 */
	public void setRotationAngle(int rotationAngle) {
		this.rotationAngle = rotationAngle;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		if (!hasBeenCollected) {
			CollisionHandler.checkIfPlayerHasCollidedWithGun(
					PlayerController.getCurrentPlayer(myGame),
					this
					);
		} else {
			setRotationAngleDependingOnPlayerDirection(myGame.imageLoader);
		}

		rectangle.x = x;
		rectangle.y = y;

		if (Player.playerIsPerformingAttack && myGame.getGameObject(Player.PLAYER_ONE).getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) instanceof Gun) {
			BulletLoader.createBullet(myGame);
		}

		if (Inventory.allInventoryShouldBeRendered) {
			rotationAngle = 0;
		}
	}

	/**
	 * 
	 * @param ImageLoader imageLoader
	 */
	private void setRotationAngleDependingOnPlayerDirection(ImageLoader imageLoader) {
		int rotationAngle0Degrees  = 0;
		switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
		case DIRECTION_RIGHT:
			setRotationAngle(rotationAngle0Degrees);
			textureRegion = new TextureRegion(imageLoader.gunRight);
			break;
		case DIRECTION_LEFT:
			setRotationAngle(rotationAngle0Degrees);
			textureRegion = new TextureRegion(imageLoader.gunLeft);
			break;
		case DIRECTION_DOWN:
			setRotationAngle(rotationAngle0Degrees);
			textureRegion = new TextureRegion(imageLoader.gunDown);
			break;
		case DIRECTION_UP:
			setRotationAngle(rotationAngle0Degrees);
			textureRegion = new TextureRegion(imageLoader.gunUp);
			break;
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		int value = 1;
		if (GamePlayHelper.gameObjectIsWithinScreenBounds(this)) {
			// Only render gun if we have enough loot and have entered trading post to buy gun.
			if (TradingPost.hasBeenEntered) {
				if (!hasBeenCollected) {	
					if (!MapUi.mapShouldBeRendered && !Inventory.allInventoryShouldBeRendered) {
						batch.draw(
								textureRegion, 
								x, 
								y, 
								width, 
								height, 
								width, 
								-height, 
								value, 
								value, 
								rotationAngle
								);
					}
				} else if (myGame.getGameObject(Player.PLAYER_ONE).getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) == this && Inventory.inventoryIsEquipped && !Inventory.allInventoryShouldBeRendered) {
					batch.draw(
							textureRegion, 
							x, 
							y, 
							width, 
							height, 
							width, 
							-height, 
							value, 
							value, 
							rotationAngle
							);
				} else if (Inventory.allInventoryShouldBeRendered) {
					textureRegion = new TextureRegion(imageLoader.gunRight);
					batch.draw(
							textureRegion, 
							x, 
							y, 
							width, 
							height, 
							width, 
							-height, 
							value, 
							value, 
							0
							);
				}
			}
		}
	}
}
