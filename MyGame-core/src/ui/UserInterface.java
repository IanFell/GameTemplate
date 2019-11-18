package ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class UserInterface {

	private HealthUi healthUi;
	private LootUi lootUi;

	/**
	 * Constructor.
	 */
	public UserInterface() {
		healthUi = new HealthUi();
		lootUi   = new LootUi();
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	public void renderUserInterface(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		healthUi.renderHealthUi(batch, imageLoader, myGame);
		lootUi.renderLootUi(batch, imageLoader, myGame);
	}
}
