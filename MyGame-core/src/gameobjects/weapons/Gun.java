package gameobjects.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.gamecharacters.Player;
import gameobjects.gamecharacters.PlayerOne;
import handlers.CollisionHandler;
import inventory.Inventory;
import loaders.ImageLoader;
import loaders.bulletloader.BulletLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Gun extends Weapon {

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
		this.rectangle.width  = width;
		this.rectangle.height = height;
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
		this.rectangle.x = x;
		this.rectangle.y = y;

		if (Player.playerIsPerformingAttack && myGame.getGameObject(Player.PLAYER_ONE).getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) instanceof Gun) {
			BulletLoader.createBullet(myGame);
		}
	}

	/**
	 * 
	 * @param ImageLoader imageLoader
	 */
	private void setRotationAngleDependingOnPlayerDirection(ImageLoader imageLoader) {
		int rotationAngle90Degrees = 90;
		int rotationAngle0Degrees  = 0;
		switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
		case Player.DIRECTION_RIGHT:
			setRotationAngle(rotationAngle0Degrees);
			textureRegion = new TextureRegion(imageLoader.gunRight);
			break;
		case Player.DIRECTION_LEFT:
			setRotationAngle(rotationAngle0Degrees);
			textureRegion = new TextureRegion(imageLoader.gunLeft);
			break;
		case Player.DIRECTION_DOWN:
			setRotationAngle(rotationAngle90Degrees);
			textureRegion = new TextureRegion(imageLoader.gunRight);
			break;
		case Player.DIRECTION_UP:
			setRotationAngle(-rotationAngle90Degrees);
			textureRegion = new TextureRegion(imageLoader.gunRight);
			break;
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader, MyGame myGame) {
		int value = 1;
		if (!hasBeenCollected || Inventory.allInventoryShouldBeRendered) {
			if (Inventory.allInventoryShouldBeRendered) {
				rotationAngle = 0;
			}
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
		} else if (myGame.getGameObject(Player.PLAYER_ONE).getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) == this && Inventory.inventoryIsEquipped) {
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
	}
}
