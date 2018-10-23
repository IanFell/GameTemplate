package gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import interfaces.GameObjectInterface;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * Class to hold and handle common elements for all game objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameObject extends Sprite implements GameObjectInterface, Comparable<GameObject> {
	
	/**
	 * Used to ensure the correct player is returned in getGameObject() method.
	 */
	public static final int PLAYER_ONE   = 1;
	public static final int PLAYER_TWO   = 2;
	public static final int PLAYER_THREE = 3;
	public static final int TREE         = 4;

	protected float x;
	protected float y;
	protected float width;
	protected float height;

	/**
	 * Rectangle to deal with collisions.
	 */
	public Rectangle rectangle = new Rectangle();

	/**
	 * Direction game objects can travel in.
	 * If left arrow is pressed, we can think of this as 'direction = player.MovingLeftConstant'.
	 */
	public int direction;

	/**
	 * Game object x-axis speed value.
	 */
	public float dx;

	/**
	 * Game object y-axis speed value.
	 */
	public float dy;

	/**
	 * Constructor.
	 */
	public GameObject() {}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void init(MyGame myGame) {}

	/**
	 * Move object along the X axis.
	 * 
	 * @param float distance
	 */
	public void translateX(float distance) {}

	/**
	 * Move object along the Y axis.
	 * 
	 * @param float distance
	 */
	public void translateY(float distance) {}

	/**
	 * 
	 * @return int
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * 
	 * @param int direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateObject(MyGame myGame, MapHandler mapHandler) {}

	/**
	 * Stops object from moving on screen, mostly from collisions with hard game objects.
	 * 
	 * @param int direction
	 */
	public void stopScrolling(int direction) {}

	public void stopPlayer() {}

	/**
	 * 
	 * @return float
	 */
	public float getX() {
		return x;
	}

	/**
	 * 
	 * @param float x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * 
	 * @return float
	 */
	public float getY() {
		return y;
	}

	/**
	 * 
	 * @param float y
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * 
	 * @return float
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * 
	 * @param float width
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * 
	 * @return float
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * 
	 * @param float height
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * 
	 * @return float
	 */
	public float getDx() {
		return dx;
	}

	/**
	 * 
	 * @param float dx
	 */
	public void setDx(float dx) {
		this.dx = dx;
	}

	/**
	 * 
	 * @return float
	 */
	public float getDy() {
		return dy;
	}

	/**
	 * 
	 * @param float dy
	 */
	public void setDy(float dy) {
		this.dy = dy;
	}

	/**
	 *
	 * @param GameObject gameObject
	 */
	@Override
	public int compareTo(GameObject gameObject) {
		return Float.compare(getY(), gameObject.getY());
	}
}
