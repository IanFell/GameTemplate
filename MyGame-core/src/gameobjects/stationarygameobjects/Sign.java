package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.Texture;
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

	private float objectSize = 3;

	/**
	 * Constructor.
	 * 
	 * @param String townName
	 * @param int    x
	 * @param int    y
	 */
	public Sign(String townName, int x, int y) {
		this.townName = townName;
		this.x        = x;
		this.y        = y;
		this.width    = objectSize;
		this.height   = objectSize;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		Texture townSign = null;
		if (townName.equalsIgnoreCase("Apalachicola")) {
			townSign = imageLoader.townSigns[0];
		} else if (townName.equalsIgnoreCase("Port St Joe")) {
			townSign = imageLoader.townSigns[1];
		} else if (townName.equalsIgnoreCase("Wewa")) {
			townSign = imageLoader.townSigns[2];
		} else if (townName.equalsIgnoreCase("Mexico Beach")) {
			townSign = imageLoader.townSigns[3];
		} else if (townName.equalsIgnoreCase("St George")) {
			townSign = imageLoader.townSigns[4];
		} else if (townName.equalsIgnoreCase("Cape San Blas")) {
			townSign = imageLoader.townSigns[5];
		} else if (townName.equalsIgnoreCase("The Point")) {
			townSign = imageLoader.townSigns[6];
		}
		batch.draw(townSign, x, y, width, -height);
	}
}
