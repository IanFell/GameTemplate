package towns;

import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PortStJoe extends Town {

	/**
	 * Constructor.
	 */
	public PortStJoe() {
		super();
		townBorder.x = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		townBorder.y = GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 35;
	}
}
