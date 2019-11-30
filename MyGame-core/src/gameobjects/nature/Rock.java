package gameobjects.nature;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Rock extends NatureObject {

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public Rock(int x, int y) {
		super(x, y);
		float size  = 1.0f;
		this.width  = size;
		this.height = size;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		renderNatureObject(batch, imageLoader.rock);
	}
}
