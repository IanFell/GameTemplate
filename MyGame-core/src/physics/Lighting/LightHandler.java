package physics.Lighting;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * Handles game lighting.
 * 
 * @author Fabulous Fellini
 *
 */
public class LightHandler extends GameLightingHandler {
	
	/**
	 * Amount to resize texture.
	 */
	private float amountToGrow = 0.01f;
	
	/**
	 * Keeps track whether texture is growing.
	 */
	public static boolean isGrowing = false;
	
	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param GameObject  player
	 */
	@Override
	public void renderLighting(SpriteBatch batch, ImageLoader imageLoader, GameObject player) {
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

