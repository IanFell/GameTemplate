package gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Bird extends GameObject {

	private int size = 1;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 */
	public Bird(float x, float y) {
		this.x      = x;
		this.y      = y;
		this.width  = size;
		this.height = size;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.knightLeft, 
				x, 
				y, 
				width, 
				-height
				);
	}
}
