package gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.CollisionHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class LegendSword extends GameObject {

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public LegendSword(int x, int y) {
		this.x                = x;
		this.y                = y;
		this.width            = 1;
		this.height           = 2;
		this.rectangle.width  = width;
		this.rectangle.height = height;
		hasBeenCollected      = false;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.sword, x, y, width, -height);
	}

	/**
	 * 
	 * @param MyGame     myGamet
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		this.rectangle.x = x;
		this.rectangle.y = y - height;
		if (!hasBeenCollected) {
			CollisionHandler.checkIfPlayerHasCollidedWithLegendSword(
					PlayerController.getCurrentPlayer(myGame),
					this
					);
		} 
	}
}
