package towns;

import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Apalachicola extends Town {

	/**
	 * Constructor.
	 */
	public Apalachicola() {
		super();
		townBorder.x = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 19;
		townBorder.y = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 8;
	}
}
