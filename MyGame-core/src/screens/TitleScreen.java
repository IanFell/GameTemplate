package screens;

import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;
import helpers.ImageHelper;

/**
 * Title screen.
 * 
 * @author Fabulous Fellini
 *
 */
public class TitleScreen extends Screens {

	/**
	 * 
	 * @param MyGame myGame
	 */
	public TitleScreen(MyGame myGame) {
		super(myGame);
		GameAttributeHelper.gameState = Screens.TITLE_SCREEN;
	}
	
	/**
	 * 
	 * @param float delta
	 */
	@Override
	public void render(float delta) {
		clearScreenAndSetScreenColor(GameAttributeHelper.gameState, null);
		updateCamera();
		myGame.renderer.batch.begin();
		ImageHelper.drawImageInMiddleOfScreen(
				myGame.renderer.batch, 
				myGame.imageLoader.titleScreenLogo, 
				GameAttributeHelper.SCREEN_WIDTH, 
				GameAttributeHelper.SCREEN_HEIGHT
				);
		myGame.renderer.batch.end();
	}
}
