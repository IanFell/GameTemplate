package screens;

import com.badlogic.gdx.Gdx;
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
	}
	
	/**
	 * Render splash screen.
	 * 
	 * @param float delta
	 */
	@Override
	public void render(float delta) {
		clearScreenAndSetScreenColor();
		updateCamera();
		myGame.renderer.batch.begin();
		ImageHelper.drawImageInMiddleOfScreen(
				myGame.renderer.batch, 
				myGame.imageLoader.fabulousFelliniLogo, 
				GameAttributeHelper.SCREEN_WIDTH, 
				GameAttributeHelper.SCREEN_HEIGHT
		);
		myGame.renderer.batch.end();
	}
}
