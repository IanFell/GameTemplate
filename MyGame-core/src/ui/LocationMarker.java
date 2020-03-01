package ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import loaders.ImageLoader;

/**
 * This class represents the flashing skull to tell player where to go during a mission.
 * 
 * @author Fabulous Fellini
 *
 */
public class LocationMarker {

	private int flashTimer;

	private Rectangle locator;

	private int size;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 */
	public LocationMarker(float x, float y) {
		size      = 1;
		locator   = new Rectangle(
				x, y,
				size, 
				size
				);
		flashTimer = 0;
	}

	/**
	 * 
	 * @return Rectangle
	 */
	public Rectangle getLocator() {
		return locator;
	}

	public void updateObject() {
		flashTimer++;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.locationSkull, 
				locator.x, 
				locator.y,
				locator.width, 
				-locator.height
				);
	}

	/**
	 * This method determines if skull should be rendered (flashing).
	 * 
	 * @return boolean
	 */
	public boolean timerValuesAreCorrectToFlash() {
		if (flashTimer % 10 >= 0 && flashTimer % 10 <= 5) {
			return true;
		}
		return false;
	}
}
