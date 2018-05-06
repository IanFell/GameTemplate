package helpers;

import com.badlogic.gdx.Gdx;

/**
 * Holds game attributes such as screen size, game state, etc.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameAttributeHelper {
	
	public final static int SCREEN_WIDTH  = Gdx.graphics.getWidth();
	public final static int SCREEN_HEIGHT = Gdx.graphics.getHeight();
	
	/**
	 * Holds current state of game, 
	 * based on the constants located in the Screens class.
	 * This will include any and all screens:
	 * 	- Game Screen
	 *  - Menu Screen
	 *  - Splash Screen
	 *  - Etc.
	 */
	public static int gameState;
}
