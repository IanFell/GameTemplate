package ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import cutscenes.CutScene;
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
	private SelectedInventoryUi selectedInventoryUi;
	private RumUi rumUi;

	/**
	 * Constructor.
	 */
	public UserInterface() {
		healthUi            = new HealthUi();
		lootUi              = new LootUi();
		playerNameUi        = new PlayerNameUi();
		selectedInventoryUi = new SelectedInventoryUi();
		rumUi               = new RumUi();
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	public void renderUserInterface(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		// Dont render this if a cutscene is in progress.
		if (!CutScene.anyCutSceneIsInProgress) {
			healthUi.renderHealthUi(batch, imageLoader, myGame);
			GameObject player = PlayerController.getCurrentPlayer(myGame);
			lootUi.renderUi(batch, imageLoader, myGame, player.convertPlayerLootToString(), player, 11.0f, -6.0f);
			rumUi.renderUi(batch, imageLoader, myGame, player.convertPlayerRumToString(), player, 11.0f, -2.0f);
			playerNameUi.renderUi(batch, imageLoader, myGame, player, 10.5f, 6.0f);
			selectedInventoryUi.renderSelectedInventoryUi(batch, imageLoader, myGame, player);
		}
	}
}
