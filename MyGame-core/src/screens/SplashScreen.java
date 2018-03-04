package screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;
import helpers.ImageHelper;

/**
 * Fabulous Fellini logo screen.
 * 
 * @author Fabulous Fellini
 *
 */
public class SplashScreen extends Screens {
	
	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public SplashScreen(final MyGame myGame) {
		super(myGame);
		GameAttributeHelper.gameState = Screens.SPLASH_SCREEN;
		int width   = GameAttributeHelper.WIDTH;
		int height  = GameAttributeHelper.HEIGHT;
		camera      = new OrthographicCamera(width, height);
		viewport    = new ExtendViewport(width, height, camera);
		camera.setToOrtho(false, width, height);
	}
	
	/**
	 * Render splash screen.
	 * 
	 * @param float delta
	 */
	@Override
	public void render(float delta) {
		this.clearScreenAndSetScreenColor();
		this.updateCamera();
		myGame.renderer.batch.begin();
		ImageHelper.drawImageInMiddleOfScreen(
				myGame.renderer.batch, 
				myGame.imageLoader.fabulousFelliniLogo, 
				GameAttributeHelper.WIDTH, 
				GameAttributeHelper.HEIGHT
		);
		myGame.renderer.batch.end();
	}
}
