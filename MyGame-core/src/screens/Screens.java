package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;

/**
 * Handles different 'screens' of the game.
 * These can include splash screen, menu screen, game screen, pause screen.
 * 
 * @author Fabulous Fellni
 *
 */
public class Screens implements Screen {
	
	/**
	 * Screen does not scroll if this is set.
	 */
	public final static float SCREEN_SCROLL_SPEED_NONE = 0;
	
	/**
	 * Scrolling speed for closest tier to screen.
	 */
	public final static float SCREEN_SCROLL_SPEED_TIER_ONE = 0.3f;
	 
	/**
	 * Available game states.
	 */
	public final static int SPLASH_SCREEN = 0;
	public final static int MENU_SCREEN   = 1;
	public final static int GAME_SCREEN   = 2;
	public final static int PAUSE_SCREEN  = 3;
	
	/**
	 * Game instance.
	 */
	protected final MyGame myGame;
	
	/**
	 * Camera object.
	 */
	public static OrthographicCamera camera;
	
	/**
	 * Viewport object.
	 */
	protected ExtendViewport viewport;
	
	/**
	 * Constructor.
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
		int width  = GameAttributeHelper.SCREEN_WIDTH;
		int height = GameAttributeHelper.SCREEN_HEIGHT;
		camera     = new OrthographicCamera(width, height);
		viewport   = new ExtendViewport(width, height, camera);
		camera.position.set(0, 0, 0);
	}
	
	/**
	 * Clear screen and set screen color.
	 */
	protected void clearScreenAndSetScreenColor() {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	/**
	 * Update camera matrices and tell SpriteBatch to render 
	 * in the coordinate system specified by the camera.
	 */
	protected void updateCamera() {
		// Tell the SpriteBatch to render in the coordinate system specified by the camera.
		myGame.renderer.batch.setProjectionMatrix(camera.combined);
		// Update camera matrices.
		camera.update();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This guarantees our screen objects are always rendered in
	 * the correct location, even if the screen is resized.
	 */
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	    myGame.renderer.batch.setProjectionMatrix(camera.combined);
	    camera.update();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Scroll screen whichever way neccessary.
	 * 
	 * @param float x
	 * @param float y
	 */
	public static void scrollScreen(float x, float y) {
		camera.translate(x, y);
	}

	/**
	 * Moves camera back 1 on the x, y axis, then stops it.
	 * This is used when a player interacts with a solid tile.
	 */
	public static void stopScrolling() {
		camera.position.x = camera.position.x - 1;
		camera.position.y = camera.position.y - 1;
		camera.translate(SCREEN_SCROLL_SPEED_NONE, SCREEN_SCROLL_SPEED_NONE);
	}
}
