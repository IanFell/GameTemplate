package gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.gamecharacters.Player;
import loaders.ImageLoader;
import loaders.chestloader.ChestLoader;
import maps.MapHandler;
import physics.CollisionHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class LegendSword extends GameObject {

	// This variable is basically so it's easier to see which color sword is being created. 
	private int color;

	private int rotationAngle;
	public static boolean playSound;
	private TextureRegion textureRegion;

	/**
	 * Constructor.
	 * 
	 * @param int           x
	 * @param int           y
	 * @param TextureRegion textureRegion
	 */
	public LegendSword(int x, int y, int color, TextureRegion textureRegion) {
		this.x                = x;
		this.y                = y;
		this.width            = 1;
		this.height           = 2;
		this.rectangle.width  = width;
		this.rectangle.height = height;
		hasBeenCollected      = false;
		this.color            = color;
		this.rotationAngle    = 0;
		playSound             = false;
		this.textureRegion = textureRegion;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(
				textureRegion, 
				x, 
				y, 
				width / 2, 
				height / 2, 
				width, 
				-height, 
				1, 
				1, 
				rotationAngle
				); 
		//renderHitBox(batch, imageLoader);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	private void renderHitBox(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.whiteSquare, 
				rectangle.x, 
				rectangle.y, 
				rectangle.width, 
				rectangle.height
				);
	}

	/**
	 * 
	 * @param MyGame     myGamet
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);

		if (!hasBeenCollected) {
			this.rectangle.x = x;
			this.rectangle.y = y - height;
			CollisionHandler.checkIfPlayerHasCollidedWithLegendSword(
					PlayerController.getCurrentPlayer(myGame),
					this
					);
		} else {
			updateHitBox();
			// This will be changed to all enemies eventually.  For now, just check chests.
			for (int i = 0; i < ChestLoader.chests.length; i++) {
				CollisionHandler.checkIfSwordHasCollidedWithObject(
						ChestLoader.chests[i],
						this
						);
			}
			setRotationAngleDependingOnPlayerDirection();
		}
	}

	private void setRotationAngleDependingOnPlayerDirection() {
		switch (Player.direction) {
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
	 * Change hit box x, y, width, and height depending to match rotation of object.
	 */
	private void updateHitBox() {
		float offsetValue = 0.5f;
		switch (Player.direction) {
		case Player.DIRECTION_RIGHT:
			this.rectangle.x      = x - height - offsetValue;
			this.rectangle.y      = y + offsetValue;
			this.rectangle.width  = height;
			this.rectangle.height = width;
			break;
		case Player.DIRECTION_LEFT:
			this.rectangle.x      = x + height - offsetValue;
			this.rectangle.y      = y + offsetValue;
			this.rectangle.width  = height;
			this.rectangle.height = width;
			break;
		case Player.DIRECTION_DOWN:
			this.rectangle.x      = x;
			this.rectangle.y      = y - height;
			this.rectangle.width  = width;
			this.rectangle.height = height;
			break;
		case Player.DIRECTION_UP:
			this.rectangle.x      = x;
			this.rectangle.y      = y + height;
			this.rectangle.width  = width;
			this.rectangle.height = height;
			break;
		}
	}

	/**
	 * 
	 * @param int rotationAngle
	 */
	public void setRotationAngle(int rotationAngle) {
		this.rotationAngle = rotationAngle;
	}
}
