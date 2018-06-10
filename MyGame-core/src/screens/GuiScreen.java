package screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;
import loaders.ImageLoader;

/**
 * Screen for graphical user interface.
 * 
 * @author Fabulous Fellini
 *
 */
public class GuiScreen extends Screens {

	/**
	 * 
	 * @param MyGame myGame
	 */
	public GuiScreen(MyGame myGame) {
		super(myGame);
	}
	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	public void render(SpriteBatch batch, ImageLoader imageLoader) {
		float aspectRatio   = (float)GameAttributeHelper.SCREEN_HEIGHT / (float)GameAttributeHelper.SCREEN_WIDTH;
		float viewportWidth = verticalHeight / aspectRatio;
		myGame.renderer.batch.begin();
		int denominator = 2;
		int height      = 1;
		batch.draw(
				imageLoader.playerScore, 
				camera.position.x - viewportWidth / denominator, 
				camera.position.y - verticalHeight / denominator + height, 
				3, 
				-height
				);
		myGame.renderer.batch.end();
	}
}
