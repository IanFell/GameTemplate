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
public class RumUi extends TextBasedUiParent {

	private int rumIconSize = 2;

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 * @param String      text
	 * @param GameOjbect  player
	 */
	public void renderUi(
			SpriteBatch batch, 
			ImageLoader imageLoader, 
			MyGame myGame, 
			String text, 
			GameObject player
			) {
		float xPos = player.getX() - 13.0f;
		float yPos = player.getY() - 2.0f;
		batch.draw(
				imageLoader.rum, 
				xPos,
				yPos,
				rumIconSize, 
				-rumIconSize
				); 
		super.renderUi(batch, imageLoader, myGame, text, player, xPos + 2, yPos - 1);
	}	
}
