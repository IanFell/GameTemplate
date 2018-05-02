package physics.Lighting;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.AbstractGameObject;
import gameobjects.GameObject;
import loaders.ImageLoader;

public class GameLightingHandler extends AbstractGameObject {
	
	/**
	 * Initial texture size.
	 */
	protected float initialTextureSize = 1;
	
	/**
	 * Constructor.
	 */
	public GameLightingHandler() {
		this.width  = initialTextureSize;
		this.height = initialTextureSize;
	}
	
	/**
	 * Renders lighting texture.
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param GameObject player
	 */
	public void renderLighting(SpriteBatch batch, ImageLoader imageLoader, GameObject player) {}

}
