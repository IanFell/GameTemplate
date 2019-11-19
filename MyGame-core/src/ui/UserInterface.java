package ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class UserInterface {

	private HealthUi healthUi;
	private LootUi lootUi;
	private PlayerNameUi playerNameUi;

	/**
	 * Constructor.
	 */
	public UserInterface() {
		healthUi     = new HealthUi();
		lootUi       = new LootUi();
		playerNameUi = new PlayerNameUi();
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	public void renderUserInterface(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		healthUi.renderHealthUi(batch, imageLoader, myGame);
		GameObject player = PlayerController.getCurrentPlayer(myGame);
		lootUi.renderUi(batch, imageLoader, myGame, player.convertPlayerLootToString(), player, 11.0f, -6.0f);
		playerNameUi.renderUi(batch, imageLoader, myGame, "JOLLY ROGER", player, 11.0f, 5.0f);
	}
}
