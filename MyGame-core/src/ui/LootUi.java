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
public class LootUi extends TextBasedUiParent {

	/**
	 * Constructor.
	 */
	public LootUi() {
		super();
	}

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
		int size = 1;
		batch.draw(
				imageLoader.loot,
				player.getX() - 12.5f,
				player.getY() - 5.0f,
				size, 
				-size
				);
		super.renderUi(batch, imageLoader, myGame, text, player, xOffset, yOffset);
	}
}
