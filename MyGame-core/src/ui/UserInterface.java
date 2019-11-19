package ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
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
	private SelectedInventoryUi selectedInventoryUi;

	/**
	 * Constructor.
	 */
	public UserInterface() {
		healthUi            = new HealthUi();
		lootUi              = new LootUi();
		playerNameUi        = new PlayerNameUi();
		selectedInventoryUi = new SelectedInventoryUi();
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
		playerNameUi.renderUi(batch, imageLoader, myGame, getCurrentPlayerNameToDisplayOnUi(), player, 10.5f, 5.0f);
		selectedInventoryUi.renderSelectedInventoryUi(batch, imageLoader, myGame, player);
	}
	
	private String getCurrentPlayerNameToDisplayOnUi() {
		if (Player.lifeState == Player.LIFE_STATE_ONE) {
			return Player.JOLLY_ROGER;
		}
		if (Player.lifeState == Player.LIFE_STATE_TWO) {
			return Player.BLACK_BEARD;
		}
		return Player.PEG_LEG;
	}
}
