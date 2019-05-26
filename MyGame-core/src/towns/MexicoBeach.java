package towns;

import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MexicoBeach extends Town {

	/**
	 * Constructor.
	 */
	public MexicoBeach() {
		super();
		townBorder.x = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 30;
		townBorder.y = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START - 1;
	}
}
