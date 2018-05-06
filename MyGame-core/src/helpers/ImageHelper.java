package helpers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
}
