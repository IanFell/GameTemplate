package ui;

import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
public class LootUi {

	private BitmapFont font;

	/**
	 * Constructor.
	 */
	public LootUi() {
		// The true paramater signifies font is flipped.
		font = new BitmapFont(true);
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		float scale = 0.1f;
		font.getData().setScale(scale, scale);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	public void renderLootUi(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		GameObject player = PlayerController.getCurrentPlayer(myGame);
		int size          = 1;
		batch.draw(
				imageLoader.loot,
				player.getX() - 12.5f,
				player.getY() - 5.0f,
				size, 
				-size
				);

		font.draw(
				batch, 
				myGame.getGameObject(Player.PLAYER_ONE).convertPlayerLootToString(), 
				player.getX() - 11.0f, 
				player.getY() - 6.0f
				);
	}
}
