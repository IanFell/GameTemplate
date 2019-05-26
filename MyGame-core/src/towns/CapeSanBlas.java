package towns;

import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class CapeSanBlas extends Town {

	/**
	 * Constructor.
	 */
	public CapeSanBlas() {
		super();
		townBorder.x      = GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 39;
		townBorder.y      = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START - 55;
		townBorder.width  = 15;
		townBorder.height = 40;
	}
}
