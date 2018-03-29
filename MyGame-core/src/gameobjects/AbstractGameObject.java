package gameobjects;

/**
 * Holds variables and methods all game objects will have.
 * 
 * @author Fabulous Fellini
 *
 */
public abstract class AbstractGameObject {
	
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
}
