package helpers;

import com.badlogic.gdx.graphics.Color;

/**
 * Holds all colors we need for various objects, such as particle effects.
 * 
 * @author Fabulous Fellini
 *
 */
public class ColorHelper {
	
	private static int noTransparancy = 0;
	
	private static int minimumColorValue = 0;
	
	private static int maximumColorValue = 255;
	
	/**
	 * Available colors.
	 */
	public static final Color RED    = new Color(maximumColorValue, minimumColorValue, minimumColorValue, noTransparancy);
	public static final Color YELLOW = new Color(maximumColorValue, maximumColorValue, minimumColorValue, noTransparancy);
	public static final Color ORANGE = new Color(maximumColorValue, 128, minimumColorValue, noTransparancy);
	public static final Color WHITE  = new Color(maximumColorValue, maximumColorValue, maximumColorValue, noTransparancy);
	public static final Color BLUE   = new Color(minimumColorValue, minimumColorValue, maximumColorValue, noTransparancy);
}
