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

	private int timer;

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
		this.width            = 2.0f;
		this.height           = 1.0f;
		this.rectangle.width  = width;
		this.rectangle.height = height;
		hasBeenCollected      = false;
		timer                 = 0;
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
			setRotationAngleDependingOnPlayerDirection();
		}
		this.rectangle.x = x;
		this.rectangle.y = y;

		if (Player.playerIsPerformingAttack && myGame.getGameObject(Player.PLAYER_ONE).getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) instanceof Gun) {
			BulletLoader.createBullet(myGame);
		}
	}

	private void setRotationAngleDependingOnPlayerDirection() {
		switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
		case Player.DIRECTION_RIGHT:
			setRotationAngle(-90);
			break;
		case Player.DIRECTION_LEFT:
			setRotationAngle(90);
			break;
		case Player.DIRECTION_DOWN:
			setRotationAngle(0);
			break;
		case Player.DIRECTION_UP:
			setRotationAngle(180);
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
		} else if (myGame.getGameObject(Player.PLAYER_ONE).getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) == this &&
				Inventory.inventoryIsEquipped) {
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
