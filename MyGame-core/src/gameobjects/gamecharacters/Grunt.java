package gameobjects.gamecharacters;

/**
 * A grunt is a secondary enemy.
 * 
 * @author Fabulous Fellini
 *
 */
public class Grunt extends Enemy {

	public static int MAX_ENEMIES_ALLOWED_TO_BE_ALIVE_AT_ONCE = 3;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 * @param float width
	 * @param float height
	 * @param int   direction
	 */
	public Grunt(float x, float y, float width, float height, int direction) {
		super(x, y, width, height, direction);
	}
}
