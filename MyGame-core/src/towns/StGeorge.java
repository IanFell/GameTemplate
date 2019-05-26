package towns;

import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class StGeorge extends Town {

	/**
	 * Constructor.
	 */
	public StGeorge() {
		super();
		townBorder.x      = GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START;
		townBorder.y      = GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START - 7;
		townBorder.width  = 20;
		townBorder.height = 10;
	}
}
