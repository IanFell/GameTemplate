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
	 * @param float       xOffset
	 * @param float       yOffset
	 */
	@Override
	public void renderUi(
			SpriteBatch batch, 
			ImageLoader imageLoader, 
			MyGame myGame, 
			String text, 
			GameObject player, 
			float xOffset, 
			float yOffset
			) {
		batch.draw(
				imageLoader.rum, 
				player.getX() - xOffset - 2, 
				player.getY() + yOffset + 1, 
				rumIconSize, 
				-rumIconSize
				); 
		super.renderUi(batch, imageLoader, myGame, text, player, xOffset, yOffset);
	}	
}
