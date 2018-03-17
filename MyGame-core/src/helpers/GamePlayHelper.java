package helpers;

import gameobjects.GameObject;

/**
 * Contains methods to help with game play, such as setting a player's
 * position in the middle of the screen upon initialization, or making 
 * the screen scroll.  I might want to break this up later.
 * 
 * @author Fabulous Fellini
 *
 */
public class GamePlayHelper {
	
	/**
	 * Sets given object to be in the middle of the screen on the x-axis.
	 * 
	 * @param GameObject gameObject
	 * @return int
	 */
	public static float setObjectXPositionInMiddleOfScreen(GameObject gameObject) {
		return (GameAttributeHelper.SCREEN_WIDTH / 2) - (gameObject.getWidth() / 2);
	}
	
	/**
	 * Sets given object to be in the middle of the screen on the y-axis.
	 * 
	 * @param GameObject gameObject
	 * @return int
	 */
	public static float setObjectYPositionInMiddleOfScreen(GameObject gameObject) {
		return (GameAttributeHelper.SCREEN_HEIGHT / 2) - (gameObject.getHeight() / 2);	
	}
}
