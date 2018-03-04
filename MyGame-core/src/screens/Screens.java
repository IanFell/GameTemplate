package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.mygame.MyGame;

/**
 * Handles different 'screens' of the game.
 * These can include splash screen, menu screen, game screen, pause screen.
 * 
 * @author Fabulous Fellni
 *
 */
public class Screens implements Screen {
	
	/**
	 * Scrolling speed for closest tier to screen.
	 */
	public final static float SCREEN_SCROLL_SPEED_TIER_ONE = 5f;
	 
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
		// Update camera matrices.
		camera.update();
		// Tell the SpriteBatch to render in the coordinate system specified by the camera.
		myGame.renderer.batch.setProjectionMatrix(camera.combined);
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
}
