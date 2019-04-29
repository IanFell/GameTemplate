package gameobjects.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
import inventory.Inventory;
import loaders.ImageLoader;
import loaders.bulletloader.BulletLoader;
import maps.MapHandler;
import physics.CollisionHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Gun extends Weapon {

	//public static boolean playerIsEquippedWithGun = false;
	public static boolean hasBeenCollected;

	private boolean playerHasBeenGivenGunToStartGameWith;

	private int timer;
	
	public static boolean shouldNotRender = true;

	/**
	 * 
	 * @param float x
	 * @param float y
	 */
	public Gun(float x, float y) {
		super(x, y);
		this.width            = 2.0f;
		this.height           = 1.0f;
		this.rectangle.width  = width;
		this.rectangle.height = height;
		hasBeenCollected = false;
		playerHasBeenGivenGunToStartGameWith = false;
		timer = 0;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {

		super.updateObject(myGame, mapHandler);
		/*
		if (playerIsEquippedWithGun) {
			float leftRightOffset = 0.5f;
			switch (Player.direction) {
			case Player.DIRECTION_LEFT:
				x = PlayerController.getCurrentPlayer(myGame).getX() - leftRightOffset;
				y = PlayerController.getCurrentPlayer(myGame).getY() - leftRightOffset;
				break;
			case Player.DIRECTION_RIGHT:
				x = PlayerController.getCurrentPlayer(myGame).getX() + leftRightOffset;
				y = PlayerController.getCurrentPlayer(myGame).getY() - leftRightOffset;
				break;
			case Player.DIRECTION_UP:
				x = PlayerController.getCurrentPlayer(myGame).getX();
				y = PlayerController.getCurrentPlayer(myGame).getY() - 1.5f;
				break;
			case Player.DIRECTION_DOWN:
				x = PlayerController.getCurrentPlayer(myGame).getX();
				y = PlayerController.getCurrentPlayer(myGame).getY();
				break;
			}
			this.rectangle.x = x;
			this.rectangle.y = y;
			BulletLoader.updateBullets(myGame, mapHandler);
		} else { */
		// Figure out where to place gun and put it here.
		/*
			x                = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 43;
			y                = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 7;
			this.rectangle.x = x;
			this.rectangle.y = y;
			CollisionHandler.checkIfPlayerHasCollidedWithGun(
					PlayerController.getCurrentPlayer(myGame),
					this
					);*/
		//}

		if (hasBeenCollected && !Inventory.allInventoryShouldBeRendered) { 
			float leftRightOffset = 0.5f;
			switch (Player.direction) {
			case Player.DIRECTION_LEFT:
				x = PlayerController.getCurrentPlayer(myGame).getX() - 2;
				y = PlayerController.getCurrentPlayer(myGame).getY();
				this.width            = 2.0f;
				this.height           = 1.0f;
				break;
			case Player.DIRECTION_RIGHT:
				x = PlayerController.getCurrentPlayer(myGame).getX() + leftRightOffset;
				y = PlayerController.getCurrentPlayer(myGame).getY();
				this.width            = 2.0f;
				this.height           = 1.0f;
				break;
			case Player.DIRECTION_UP:
				x = PlayerController.getCurrentPlayer(myGame).getX();
				y = PlayerController.getCurrentPlayer(myGame).getY() - 1.0f;
				this.width            = 1.0f;
				this.height           = 2.0f;
				break;
			case Player.DIRECTION_DOWN:
				x = PlayerController.getCurrentPlayer(myGame).getX() - 0.5f;
				y = PlayerController.getCurrentPlayer(myGame).getY() + 2;
				this.width            = 1.0f;
				this.height           = 2.0f;
				break;
			}
			this.rectangle.x = x;
			this.rectangle.y = y;
			BulletLoader.updateBullets(myGame, mapHandler);
		} else {
			x                = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 43;
			y                = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 7;
			this.rectangle.x = x;
			this.rectangle.y = y;
			CollisionHandler.checkIfPlayerHasCollidedWithGun(
					PlayerController.getCurrentPlayer(myGame),
					this
					);
		}
		/*
		if (timer < 10) {
			timer++;
		} else {
			// Let player start with gun.  
			if (!playerHasBeenGivenGunToStartGameWith) {
				x = PlayerController.getCurrentPlayer(myGame).getX();
				y = PlayerController.getCurrentPlayer(myGame).getY();
				playerHasBeenGivenGunToStartGameWith = true;
				hasBeenCollected = true;
				CollisionHandler.checkIfPlayerHasCollidedWithGun(
						PlayerController.getCurrentPlayer(myGame),
						this
						);
				//PlayerController.getCurrentPlayer(myGame).getInventory().addObjectToInventory(this);
			} else {
				//PlayerController.getCurrentPlayer(myGame).getInventory().addObjectToInventory(this);
			}
		}*/
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (hasBeenCollected && Inventory.inventoryIsEquipped) {
			Texture texture = null;
			switch (Player.direction) {
			case Player.DIRECTION_LEFT:
				texture = imageLoader.gunLeft;
				break;
			case Player.DIRECTION_RIGHT:
				texture = imageLoader.gunRight;
				break;
			case Player.DIRECTION_UP:
				texture = imageLoader.gunUp;
				break;
			case Player.DIRECTION_DOWN:
				texture = imageLoader.gunDown;
				break;
			}
			batch.draw(
					texture,
					x, 
					y,
					width,
					-height
					);
			BulletLoader.renderBullets(batch, shapeRenderer, imageLoader);
		} else if (Inventory.allInventoryShouldBeRendered) {
			batch.draw(
					imageLoader.gunUp,
					x, 
					y,
					width,
					-height
					);
		}
		else if (!hasBeenCollected) {
			batch.draw(
					imageLoader.gunRight,
					x, 
					y,
					width,
					-height
					);
		}
	}
}
