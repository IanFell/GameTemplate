package gameobjects.stationarygameobjects;


import gameobjects.GameObject;
import helpers.RandomNumberGenerator;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class NatureObject extends GameObject {

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public NatureObject(int x, int y) {
		this.x              = x;
		this.y              = y;
		this.width          = 1;
		double randomHeight = RandomNumberGenerator.generateRandomDouble(2.0f, 4.0f);
		this.height         = (float) randomHeight;
	}
}
