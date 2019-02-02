package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * GamePlayObjects represent objects that will interact with the player,
 * such as a chest or a key.
 * 
 * @author Fabulous Fellini
 *
 */
public class GamePlayObject extends GameObject {
	
	/**
	 * Signifies whether chest is closed or not.
	 * This will be moved as we create more game objects that affect player.
	 */
	private boolean isClosed;
	
	/**
	 * Constructor.
	 */
	public GamePlayObject() {
		this.x           = 3;
		this.y           = 3;
		int objectSize   = 1;
		this.width       = objectSize;
		this.height      = objectSize;
		rectangle.x      = x;
		rectangle.y      = y;
		rectangle.width  = objectSize;
		rectangle.height = objectSize;
		isClosed         = true;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.chest, x, y, width, -height);
	}
	
	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		rectangle.x = x;
		rectangle.y = y;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isClosed() {
		return isClosed;
	}

	/**
	 * 
	 * @param boolean isClosed
	 */
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
}
