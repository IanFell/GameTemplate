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
public class RumUi extends TextBasedUiParent {

	private int rumIconSize = 1;

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 * @param GameOjbect  player
	 */
	public void renderUi(
			SpriteBatch batch, 
			ImageLoader imageLoader, 
			MyGame myGame, 
			GameObject player
			) {
		float xPos = player.getX() - 12.5f;
		float yPos = player.getY() - 2.0f;
		batch.draw(
				imageLoader.rum, 
				xPos,
				yPos - 1,
				rumIconSize, 
				-rumIconSize
				); 
		super.renderUi(batch, imageLoader, myGame, player, xPos + 2, yPos - 1, RumHandler.rumCount);
	}	
}
