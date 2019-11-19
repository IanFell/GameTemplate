package ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class SelectedInventoryUi {

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 * @param GameObject  player
	 */
	public void renderSelectedInventoryUi(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame, GameObject player) {
		int size = 1;
		batch.draw(
				imageLoader.whiteSquare,
				player.getX() - 12.0f,
				player.getY() + 6.0f,
				size, 
				-size
				);
	}
}
