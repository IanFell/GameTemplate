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
public class TeePeeScreen extends Screens {

	/**
	 * 
	 * @param MyGame myGame
	 */
	public TeePeeScreen(MyGame myGame) {
		super(myGame);
		GameAttributeHelper.gameState = Screens.TEE_PEE_SCREEN;
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
