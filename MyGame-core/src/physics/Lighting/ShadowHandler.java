package physics.Lighting;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * Handles game shadows.
 * 
 * @author Fabulous Felini
 *
 */
public class ShadowHandler extends GameLightingHandler {
	
	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param GameObject  player
	 */
	@Override
	public void renderLighting(SpriteBatch batch, ImageLoader imageLoader, GameObject player) {
		int offset = 1;
		batch.draw(imageLoader.shadow, player.getX() + offset, player.getY() + offset, width, height);
	}

}

