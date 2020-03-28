package gameobjects.nature;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import handlers.CollisionHandler;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class QuickSand extends NatureObject {

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public QuickSand(int x, int y) {
		super(x, y);
		int size         = 3;
		this.width       = size;
		this.height      = size;
		rectangle.width  = width;
		rectangle.height = height;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		renderNatureObject(batch, imageLoader.quickSand);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		rectangle.x = x;
		rectangle.y = y - height;
		CollisionHandler.checkIfPlayerCollidedWithQuickSand(PlayerController.getCurrentPlayer(myGame), this);
	}
}
