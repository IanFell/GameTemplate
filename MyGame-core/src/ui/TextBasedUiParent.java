package ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TextBasedUiParent {

	protected BitmapFont font;

	/**
	 * Constructor.
	 */
	public TextBasedUiParent() {
		// The true paramater signifies font is flipped.
		font = new BitmapFont(true);
		// Uncomment this to make text seem smoother.
		//font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		float scale = 0.1f;
		font.getData().setScale(scale, scale);
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
	public void renderUi(
			SpriteBatch batch, 
			ImageLoader imageLoader, 
			MyGame myGame, 
			String text, 
			GameObject player, 
			float xOffset, 
			float yOffset
			) {
		font.draw(
				batch, 
				text, 
				player.getX() - xOffset, 
				player.getY() + yOffset
				);
	}
}
