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

	/**
	 * Minimum color value (from 0 - 255).
	 */
	private static int minimumColorValue = 0;

	/**
	 * Maximum color value (from 0 - 255).
	 */
	private static int maximumColorValue = 255;

	/**
	 * Available solid colors.
	 */
	public static final Color RED    = new Color(maximumColorValue, minimumColorValue, minimumColorValue, noTransparancy);
	public static final Color YELLOW = new Color(maximumColorValue, maximumColorValue, minimumColorValue, noTransparancy);
	public static final Color ORANGE = new Color(maximumColorValue, 128, minimumColorValue, noTransparancy);
	public static final Color WHITE  = new Color(maximumColorValue, maximumColorValue, maximumColorValue, noTransparancy);
	public static final Color BLUE   = new Color(minimumColorValue, minimumColorValue, maximumColorValue, noTransparancy);
	public static final Color BLACK  = new Color(minimumColorValue, minimumColorValue, minimumColorValue, noTransparancy);

	public static final Color RED_ORANGE = new Color(255, 74, 14, noTransparancy);
	
	public static final Color CLOUD_COLOR = new Color(maximumColorValue, maximumColorValue, maximumColorValue, .05f);
}
