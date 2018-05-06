package helpers;

import gameobjects.GameObject;

/**
 * Contains methods to help with game play, such as setting a player's
 * position in the middle of the screen upon initialization, or making 
 * the screen scroll.  I might want to break this up later.
 * 
 * Currently this class is unused but I don't want to get rid of it just yet, just in case.
 * 
 * @author Fabulous Fellini
 *
 */
public class GamePlayHelper {
	
	/**
	 * 
	 * @param GameObject gameObject
	 * @return int
	 */
	public static float setObjectXPositionInMiddleOfScreen(GameObject gameObject) {
		return (GameAttributeHelper.SCREEN_WIDTH / 2) - (gameObject.getWidth() / 2);
	}
	
	/**
	 * 
	 * @param GameObject gameObject
	 * @return int
	 */
	public static float setObjectYPositionInMiddleOfScreen(GameObject gameObject) {
		return (GameAttributeHelper.SCREEN_HEIGHT / 2) - (gameObject.getHeight() / 2);	
	}
}
