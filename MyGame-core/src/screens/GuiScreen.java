package screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

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
		int height = 1;
		myGame.renderer.batch.begin();
		batch.draw(
				imageLoader.playerScore, 
				camera.position.x - getViewportWidth() / denominatorOffset, 
				camera.position.y - verticalHeight / denominatorOffset + height, 
				3, 
				-height
				);
		myGame.renderer.batch.end();
	}
}