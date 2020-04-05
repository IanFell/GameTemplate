package ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.ImageHelper;
import loaders.ImageLoader;

/**
 * Extend GameObject to use animation variables.
 * 
 * @author Fabulous Fellini
 *
 */
public class TextBasedUiParent extends GameObject {

	public static final int DIGIT_ONE = 1;
	public static final int DIGIT_TWO = 2;

	private int textSize = 1;

	//protected BitmapFont font;

	/**
	 * Constructor.
	 */
	public TextBasedUiParent() {
		// The true paramater signifies font is flipped.
		//font = new BitmapFont(true);
		// Uncomment this to make text seem smoother.
		//font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		//float scale = 0.1f;
		//font.getData().setScale(scale, scale);
		//font.setColor(Color.BLACK);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 * @param GameOjbect  player
	 * @param float       xOffset
	 * @param float       yOffset
	 * @param int         numberToDisplay
	 */
	public void renderUi(
			SpriteBatch batch, 
			ImageLoader imageLoader, 
			MyGame myGame, 
			GameObject player, 
			float xOffset, 
			float yOffset,
			int numberToDisplay
			) {
		batch.draw(
				ImageHelper.getConvertedTextureForDigit(numberToDisplay, imageLoader, DIGIT_ONE), 
				xOffset, 
				yOffset, 
				textSize, 
				-textSize
				);
		if (numberToDisplay > 9) {
			batch.draw(
					ImageHelper.getConvertedTextureForDigit(numberToDisplay, imageLoader, DIGIT_TWO),
					xOffset + textSize, 
					yOffset, 
					textSize, 
					-textSize
					);
		}
	}
}
