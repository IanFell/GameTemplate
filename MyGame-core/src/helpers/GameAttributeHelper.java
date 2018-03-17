package helpers;

import com.badlogic.gdx.Gdx;

/**
 * Holds game attributes such as screen size, game state, etc.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameAttributeHelper {
	
	/**
	 * Width of screen.
	 */
	public final static int SCREEN_WIDTH  = Gdx.graphics.getWidth();
	
	/**
	 * Height of screen.
	 */
	public final static int SCREEN_HEIGHT = Gdx.graphics.getHeight();
	
	/**
	 * Holds current state of game, 
	 * based on the constants located in the Screens class.
	 */
	public static int gameState;
}
