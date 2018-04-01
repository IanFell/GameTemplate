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
public class GameObject extends AbstractGameObject implements GameObjectInterface {
	
	/**
	 * Direction game objects can travel in.
	 */
	public int direction;
	
	/**
	 * Circle for our collision detection.
	 */
	protected Circle circle;
	
	/**
	 * Image for our game object.
	 */
	protected Texture texture;

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
	public void draw(SpriteBatch batch) {}
	
	/**
	 * Abstract update method.  
	 * Most gameObject children will override this.
	 */
	public void updateGameObject() {}
	
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
	 * @return Circle
	 */
	public Circle getCircle() {
		return circle;
	}

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
}
