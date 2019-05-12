package particles;

import gameobjects.GameObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Particle extends GameObject {

	/**
	 * Represents how long particle will live.  This is randomly set upon instantiation.
	 */
	protected float lifeSpan;

	protected boolean isAlive;

	/**
	 * Represents how much time has passed in particle's life.
	 */
	protected float life;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 * @param float width
	 * @param float height
	 * @param float lifeSpan
	 */
	public Particle(float x, float y, float width, float height, float lifeSpan) {
		this.x        = x;
		this.y        = y;
		this.width    = width;
		this.height   = height;
		this.lifeSpan = lifeSpan;
		this.isAlive  = true;
		life          = 0;
	}
}
