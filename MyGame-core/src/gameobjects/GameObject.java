package gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

import interfaces.GameObjectInterface;
import loaders.ImageLoader;

/**
 * Class to hold and handle common elements for all game objects.
 * 
 * @author Fabulous Fellini
 *
 */
abstract public class GameObject implements GameObjectInterface {
	
	/**
	 * Object X position.
	 */
	protected float x;
	
	/**
	 * Object Y position.
	 */
	protected float y;
	
	/**
	 * Object width.
	 */
	protected float width;
	
	/**
	 * Object height.
	 */
	protected float height;
	
	/**
	 * Image for our game object.
	 */
	protected Texture texture;
	
	/**
	 * Circle for our collision detection.
	 */
	protected Circle circle;

	/**
	 * Constructor.
	 */
	public GameObject() {}
	
	/**
	 * Initialize object image.
	 * 
	 * @param ImgageLoader imageLoader
	 */
	public void init(ImageLoader imageLoader) {
		this.texture = imageLoader.testImage;
	}
	
	/**
	 * Draw game object.
	 * 
	 * @param SpriteBatch batch
	 */
	public void draw(SpriteBatch batch) {
		batch.draw(texture, x, y);
	}

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
	 * @return Circle
	 */
	public Circle getCircle() {
		return circle;
	}
	
	/**
	 * Abstract update method.  
	 * Most gameObject children will override this.
	 */
	abstract public void updateGameObject();
	
	/**
	 * Moves object to the left or right.
	 * 
	 * @param float distance
	 */
	public void translateX(float distance) {}
	
	/**
	 * Moves object up or down.
	 * 
	 * @param float distance
	 */
	public void translateY(float distance) {}
}
