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
public class LootUi {

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
				imageLoader.whiteSquare,
				player.getX() - 12.5f,
				player.getY() - 5.5f,
				size, 
				-size
				);
	}
}
