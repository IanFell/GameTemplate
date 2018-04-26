package physics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.AbstractGameObject;
import loaders.ImageLoader;

/**
 * Handles game lighting.
 * 
 * @author Fabulous Fellini
 *
 */
public class LightHandler extends AbstractGameObject {
	
	/**
	 * Initial texture size.
	 */
	private float initialTextureSize = 1;
	
	/**
	 * Amount to resize texture.
	 */
	private float amountToGrow = 0.01f;
	
	/**
	 * Keeps track whether texture is growing.
	 */
	public static boolean isGrowing = false;
	
	/**
	 * Constructor.
	 */
	public LightHandler() {
		this.width  = initialTextureSize;
		this.height = initialTextureSize;
	}
	
	/**
	 * Renders light texture.
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	public void renderLight(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(imageLoader.light, 0, 5, width, height);
	}
	
	/**
	 * Updates lighting texture.
	 * 
	 * @param ImageLoader imageLoader
	 */
	public void updateLighting(ImageLoader imageLoader) {
		if (isGrowing) {
			increaseLightTextureSize(imageLoader);
		} else {
			width  = initialTextureSize;
			height = initialTextureSize;
		}
	}
	
	/**
	 * Increases width and height of light texture.
	 * 
	 * @param ImageLoader imageLoader
	 */
	private void increaseLightTextureSize(ImageLoader imageLoader) {
		width  += amountToGrow;
		height += amountToGrow;
	}
}
