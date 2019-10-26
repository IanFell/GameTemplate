package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * Town Signs.
 * 
 * Each town should have two of these on sides where it makes sense.
 * 
 * @author Fabulous Fellini
 *
 */
public class Sign extends GameObject {

	private String townName;

	private float objectSize = 2;

	/**
	 * Constructor.
	 * 
	 * @param String townName
	 * @param int    x
	 * @param int    y
	 */
	public Sign(String townName, int x, int y) {
		this.townName = townName;
		this.x = x;
		this.y = y;
		this.width = objectSize;
		this.height = objectSize;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(imageLoader.sign, x, y, width, -height);
	}
}
