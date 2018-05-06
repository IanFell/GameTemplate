package physics.Lighting;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.AbstractGameObject;
import gameobjects.GameObject;
import loaders.ImageLoader;

public class GameLightingHandler extends AbstractGameObject {
	
	protected float initialTextureSize = 1;
	
	public GameLightingHandler() {
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
