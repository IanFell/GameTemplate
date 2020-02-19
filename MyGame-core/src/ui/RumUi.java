package ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import handlers.RumHandler;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class RumUi {

	/**
	 * This method is overloaded.
	 * We are using it to draw an image, not a string.
	 * 
	 * For now just draw all rum we get on the screen horizontally.
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 * @param GameOjbect  player
	 * @param float       xOffset
	 * @param float       yOffset
	 */
	public void renderUi(
			SpriteBatch batch, 
			ImageLoader imageLoader, 
			MyGame myGame, 
			GameObject player, 
			float xOffset, 
			float yOffset
			) {
		int size = 2;
		float startX = player.getX() - xOffset;
		for (int i = 0; i < RumHandler.rumCount; i++) {
			batch.draw(
					imageLoader.rum, 
					startX, 
					player.getY() + yOffset, 
					size, 
					-size
					); 
			startX += 1;
		}
	}
}
