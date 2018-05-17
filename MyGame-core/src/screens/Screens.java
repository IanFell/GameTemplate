package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;
import physics.Weather.WeatherHandler;

/**
 * Handles different 'screens' of the game.
 * These can include splash screen, menu screen, game screen, pause screen.
 * 
 * @author Fabulous Fellni
 *
 */
public class Screens implements Screen {
	
	public final static int SPLASH_SCREEN    = 0;
	public final static int MENU_SCREEN      = 1;
	public final static int GAME_SCREEN      = 2;
	public final static int PAUSE_SCREEN     = 3;
	public final static int INVENTORY_SCREEN = 4;
	public final static int GAME_OVER_SCREEN = 5;
	
	/**
	 * Scrolling speed for closest tier to screen.
	 */
	public final static float SCREEN_SCROLL_SPEED_TIER_ONE = 0.1f;
	
	protected final MyGame myGame;
	
	public static OrthographicCamera camera;

	protected ExtendViewport viewport;
	 
	/**
	 * Saves camera X position before screen shake.
	 */
	public static float cameraX;

	/**
	 * Saves camera Y position before screen shake.
	 */
	public static float cameraY;
	
	public static ScreenShake screenShake = new ScreenShake();

	/**
	 * 
	 * @param MyGame myGame
	 */
	public Screens(final MyGame myGame) {
		this.myGame = myGame;
		createCamera();
	}
	
	/**
	 * Creates camera object and sets position for basic camera with a straight on view.
	 */
	public void createCamera() {
		int width          = GameAttributeHelper.SCREEN_WIDTH;
		int height         = GameAttributeHelper.SCREEN_HEIGHT;
		camera             = new OrthographicCamera(width, height);
		viewport           = new ExtendViewport(width, height, camera);
		int cameraPosition = 0;
		camera.position.set(cameraPosition, cameraPosition, cameraPosition);
	}
	
	/**
	 * Clear / set screen and set screen color of screen.
	 * Background can change depending on game weather.
	 * 
	 * @param int            gameState
	 * @param WeatherHandler weatherHandler
	 */
	protected void clearScreenAndSetScreenColor(int gameState, WeatherHandler weatherHandler) {
		int minValue = 0;
		int maxValue = 1;
		switch (gameState) {
		case SPLASH_SCREEN:
			Gdx.gl.glClearColor(minValue, minValue, minValue, maxValue);
			break;
		case GAME_SCREEN:
			Gdx.gl.glClearColor(minValue, minValue, weatherHandler.nightAndDayCycle.dayNightCycleValue, maxValue);
			break;
		}
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	protected void updateCamera() {
		// Tell the SpriteBatch to render in the coordinate system specified by the camera.
		myGame.renderer.batch.setProjectionMatrix(camera.combined);
		// Update camera matrices.
		camera.update();
	}
	
	public static void saveCameraCoordinatesBeforeScreenShake() {
		cameraX = camera.position.x;
		cameraY = camera.position.y;
	}

	@Override
	public void show() {}

	@Override
	public void render(float delta) {}

	/**
	 * This guarantees our screen objects are always rendered in
	 * the correct location, even if the screen is resized.
	 * 
	 * @param int width
	 * @param int height
	 */
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	    myGame.renderer.batch.setProjectionMatrix(camera.combined);
	    camera.update();
	}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {}
}
