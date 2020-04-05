package helpers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import loaders.ImageLoader;
import ui.TextBasedUiParent;

/**
 * Contains helper methods for images.
 * 
 * @author Fabulous Fellini
 *
 */
public class ImageHelper {

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param Texture     texture
	 * @param int         width
	 * @param int         height
	 */
	public static void drawImageInMiddleOfScreen(SpriteBatch batch, Texture texture, int width, int height) {
		batch.draw(texture, (width / 2) - (texture.getWidth() / 2), (height / 2) - (texture.getHeight() / 2));
	}

	/**
	 * Gets the current value of the digit and sets the corresponding texture.
	 * 
	 * @param int         number
	 * @param ImageLoader imageLoader
	 * @param int         digit
	 * @return texture
	 */
	public static Texture getConvertedTextureForDigit(int number, ImageLoader imageLoader, int digit) {
		Texture texture   = imageLoader.number[0];
		int digitToRender = 0;
		// If number is bigger than 10, split the digits up so we can handle them seperately.
		if (number > 9) {
			if (digit == TextBasedUiParent.DIGIT_ONE) {
				digitToRender = number / 10;
			} else {
				digitToRender = number % 10;
			}

		} else {
			digitToRender = number;
		}
		texture = setTextureNumber(digitToRender, imageLoader);
		return texture;
	}

	/**
	 * Returns the texture of the actual number of the digit.
	 * For instance, if the number is 15, either 1 or 5 will be returned.
	 * 
	 * @param int         digit
	 * @param ImageLoader imageLoader
	 * @return texture
	 */
	private static Texture setTextureNumber(int digit, ImageLoader imageLoader) {
		Texture texture = imageLoader.number[0];
		for (int i = 0; i < 10; i++) {
			if (digit == i) {
				texture = imageLoader.number[digit];
			}
		}
		return texture;
	}
}
