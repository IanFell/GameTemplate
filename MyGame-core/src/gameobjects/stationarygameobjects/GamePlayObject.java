package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.GameAttributeHelper;
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

	private int objectSize = 1;

	private boolean playSound;

	/**
	 * Signifies whether chest is closed or not.
	 * This will be moved as we create more game objects that affect player.
	 */
	private boolean isClosed;

	/**
	 * Constructor.
	 */
	public GamePlayObject() {
		this.x             = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 38;
		this.y             = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 2;
		this.width         = objectSize;
		this.height        = objectSize;
		rectangle.x        = x;
		rectangle.y        = y;
		rectangle.width    = objectSize;
		rectangle.height   = objectSize;
		isClosed           = true;
		playSound          = false;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (isClosed) {
			batch.draw(imageLoader.chestClosed, x, y, width, -height);
		} else {
			batch.draw(imageLoader.chestOpen, x, y, width, -height);
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		rectangle.x = x;
		// Compensate for having to flip the texture on the y-axis.
		rectangle.y = y - objectSize;
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

	/**
	 * 
	 * @return boolean
	 */
	@Override
	public boolean getPlaySound() {
		return playSound;
	}

	/**
	 * 
	 * @param boolean playSoud
	 */
	@Override
	public void setPlaySound(boolean playSound) {
		this.playSound = playSound;
	}
}
