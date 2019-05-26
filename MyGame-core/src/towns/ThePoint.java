package towns;

import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class ThePoint extends Town {

	/**
	 * Constructor.
	 */
	public ThePoint() {
		super();
		townBorder.x      = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 3;
		townBorder.y      = GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START - 113;
		townBorder.width  = 10;
		townBorder.height = 30;
	}
}
