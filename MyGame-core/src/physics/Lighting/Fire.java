package physics.Lighting;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import inventory.Inventory;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Fire extends GameObject {

	private int timer = 0;

	private String location;

	private boolean hasLogs;

	public static boolean playSound = false;

	private Rectangle boundingAudibleRectangle = new Rectangle();

	/**
	 * Constructor.
	 * 
	 * @param float   x
	 * @param float   y
	 * @param float   width
	 * @param float   height
	 * @param String  location
	 * @param boolean hasLogs
	 */
	public Fire(float x, float y, float width, float height, String location, boolean hasLogs) {
		this.x                           = x;
		this.y                           = y;
		this.width                       = width;
		this.height                      = height;
		this.location                    = location;
		this.hasLogs                     = hasLogs;
		this.rectangle.x                 = x;
		this.rectangle.y                 = y;
		this.rectangle.width             = width;
		this.rectangle.height            = height;
		int boundingAudibleXYOffset      = 5;
		boundingAudibleRectangle.x       = x - boundingAudibleXYOffset;
		boundingAudibleRectangle.y       = y - boundingAudibleXYOffset;
		int boundingAudibleRectangleSize = 10;
		boundingAudibleRectangle.width   = boundingAudibleRectangleSize;
		boundingAudibleRectangle.height  = boundingAudibleRectangleSize;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		timer++;
		if (timer > 20) {
			timer = 1;
		}
		/*
		CollisionHandler.checkIfPlayerHasCollidedWithFire(
				myGame.getGameObject(GameObject.PLAYER_ONE),
				this
				);*/
		/*
		 * Play sound if all inventory is being rendered.  
		 * If not, just play it when player overlaps with bounding rectangle.
		 */
		if (!Inventory.allInventoryShouldBeRendered) {
			if (boundingAudibleRectangle.overlaps(PlayerController.getCurrentPlayer(myGame).rectangle)) {
				playSound = true;
			} 
		} else {
			playSound = true;
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		if (timer > 0) {
			batch.draw(imageLoader.fireOne, x, y, width, -height);
		}
		if (timer > 2) {
			batch.draw(imageLoader.fireTwo, x, y, width, -height);
		}
		if (timer > 4) {
			batch.draw(imageLoader.fireThree, x, y, width, -height);
		}
		if (timer > 6) {
			batch.draw(imageLoader.fireFour, x, y, width, -height);
		}
		if (timer > 8) {
			batch.draw(imageLoader.fireFive, x, y, width, -height);
		}
		if (timer > 10) {
			batch.draw(imageLoader.fireSix, x, y, width, -height);
		}
		if (timer > 12) {
			batch.draw(imageLoader.fireSeven, x, y, width, -height);
		}
		if (timer > 14) {
			batch.draw(imageLoader.fireEight, x, y, width, -height);
		}
		if (timer > 16) {
			batch.draw(imageLoader.fireNine, x, y, width, -height);
		}
		if (timer > 18) {
			batch.draw(imageLoader.fireTen, x, y, width, -height);
		}
		if (hasLogs) {
			batch.draw(imageLoader.logs, x, y, width, -height / 2);
		}

		// Draw bounding audio square.  If player is within this square, he will hear fire audio.
		/*
		batch.draw(
				imageLoader.whiteSquare, 
				boundingAudibleRectangle.x, 
				boundingAudibleRectangle.y, 
				boundingAudibleRectangle.width, 
				boundingAudibleRectangle.height
				); */
	}
}
