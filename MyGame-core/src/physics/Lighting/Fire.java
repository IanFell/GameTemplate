package physics.Lighting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import handlers.AnimationHandler;
import inventory.Inventory;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Fire extends GameObject {

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
		textureAtlas                     = new TextureAtlas(Gdx.files.internal("artwork/effects/fire/fire.atlas"));
		animation                        = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_FIRE, textureAtlas.getRegions());
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
		updateElapsedTime();
		AnimationHandler.renderAnimation(
				batch, 
				elapsedTime, 
				animation, 
				x, 
				y, 
				width, 
				height,
				imageLoader, 
				AnimationHandler.OBJECT_TYPE_FIRE
				);
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
