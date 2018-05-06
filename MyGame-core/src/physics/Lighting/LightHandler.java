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
	 * Starting x position.  After resizing light, x position will resume to this coordinate.
	 */
	private float startX = 0;
	
	/**
	 * Starting y position.  After resizing light, y position will resume to this coordinate.
	 */
	private float startY = 5;
	
	public static boolean isGrowing = false;
	
	public LightHandler() {
		this.x = startX;
		this.y = startY;
	}
	
	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param GameObject  player
	 */
	@Override
	public void renderLighting(SpriteBatch batch, ImageLoader imageLoader, GameObject player) {
		batch.draw(imageLoader.light, x, y, width, height);
	}
	
	/**
	 * 
	 * @param ImageLoader imageLoader
	 */
	public void updateLighting(ImageLoader imageLoader) {
		if (isGrowing) {
			increaseLightTextureSize(imageLoader);
		} else {
			x      = startX;
			y      = startY;
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
		float amountToGrowLeft  = 0.01f;
		x                       -= amountToGrowLeft;
		y                       -= amountToGrowLeft;
		float amountToGrowRight = amountToGrowLeft * 2;
		width                   += amountToGrowRight;
		height                  += amountToGrowRight;
	}
}

