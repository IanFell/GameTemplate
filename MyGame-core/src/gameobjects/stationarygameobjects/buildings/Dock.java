package gameobjects.stationarygameobjects.buildings;

import com.badlogic.gdx.graphics.Texture;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Dock extends Building {

	/**
	 * Constructor.
	 * 
	 * @param int     x
	 * @param int     y
	 * @param int     width
	 * @param int     height
	 * @param Texture texture
	 */
	public Dock(int x, int y, int width, int height, Texture texture) {
		super(x, y, width, height, texture);
		rectangle.x      = x;
		rectangle.y      = y - 0.5f;
		rectangle.width  = width;
		rectangle.height = height / 2;
	}
}
