package physics.Lighting;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * Abstract class for game lighting.
 * 
 * @author Fabulous Fellini
 *
 */
public class AbstractLightingHandler extends GameObject {

	protected float initialTextureSize = 0.5f;

	/**
	 * Constructor.
	 * This should not have a constructor considering the class was abstract, but that was changed.
	 */
	public AbstractLightingHandler() {
		this.width  = initialTextureSize;
		this.height = initialTextureSize;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param GameObject player
	 */
	public void renderLighting(SpriteBatch batch, ImageLoader imageLoader, GameObject player) {}

}
