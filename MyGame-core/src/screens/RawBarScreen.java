package screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class RawBarScreen extends Screens {

	/**
	 * 
	 * @param MyGame myGame
	 */
	public RawBarScreen(MyGame myGame) {
		super(myGame);
		GameAttributeHelper.gameState = Screens.RAW_BAR_SCREEN;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	public void render(SpriteBatch batch, ImageLoader imageLoader) {
		clearScreenAndSetScreenColor(GameAttributeHelper.gameState, null);
		updateCamera();
		myGame.renderer.batch.begin();
		myGame.renderer.batch.end();
	}
}
