package helpers;

import com.badlogic.gdx.Gdx;

import maps.MapInformationHolder;

/**
 * Holds game attributes such as screen size, game state, etc.
 * 
 * @author Fabulous Fellini
 *
 */
public final class GameAttributeHelper {

	public final static int SCREEN_WIDTH  = Gdx.graphics.getWidth();
	public final static int SCREEN_HEIGHT = Gdx.graphics.getHeight();
	
	public final static int FRAMES_PER_SECOND = 30;
	
	public final static int TIMER_START_VALUE = 0;
	
	/**
	 * Game world has 68 chunks, a grid of 8 x 8.
	 */
	private static int CHUNK_WIDTH                       = MapInformationHolder.CHUNK_WIDTH;
	public static final int CHUNK_ONE_X_POSITION_START   = 0;
	public static final int CHUNK_TWO_X_POSITION_START   = CHUNK_ONE_X_POSITION_START + CHUNK_WIDTH;
	public static final int CHUNK_THREE_X_POSITION_START = CHUNK_TWO_X_POSITION_START + CHUNK_WIDTH;
	public static final int CHUNK_FOUR_X_POSITION_START  = CHUNK_THREE_X_POSITION_START + CHUNK_WIDTH;
	public static final int CHUNK_FIVE_X_POSITION_START  = CHUNK_FOUR_X_POSITION_START + CHUNK_WIDTH;
	public static final int CHUNK_SIX_X_POSITION_START   = CHUNK_FIVE_X_POSITION_START + CHUNK_WIDTH;
	public static final int CHUNK_SEVEN_X_POSITION_START = CHUNK_SIX_X_POSITION_START + CHUNK_WIDTH;
	public static final int CHUNK_EIGHT_X_POSITION_START = CHUNK_SEVEN_X_POSITION_START + CHUNK_WIDTH;
	
	private static final int CHUNK_HEIGHT                = MapInformationHolder.CHUNK_HEIGHT;
	public static final int CHUNK_ONE_Y_POSITION_START   = 1;
	public static final int CHUNK_TWO_Y_POSITION_START   = CHUNK_ONE_Y_POSITION_START + CHUNK_HEIGHT;
	public static final int CHUNK_THREE_Y_POSITION_START = CHUNK_TWO_Y_POSITION_START + CHUNK_HEIGHT;
	public static final int CHUNK_FOUR_Y_POSITION_START  = CHUNK_THREE_Y_POSITION_START + CHUNK_HEIGHT;
	public static final int CHUNK_FIVE_Y_POSITION_START  = CHUNK_FOUR_Y_POSITION_START + CHUNK_HEIGHT;
	public static final int CHUNK_SIX_Y_POSITION_START   = CHUNK_FIVE_Y_POSITION_START + CHUNK_HEIGHT;
	public static final int CHUNK_SEVEN_Y_POSITION_START = CHUNK_SIX_Y_POSITION_START + CHUNK_HEIGHT;
	public static final int CHUNK_EIGHT_Y_POSITION_START = CHUNK_SEVEN_Y_POSITION_START + CHUNK_HEIGHT;

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
