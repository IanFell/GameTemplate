package physics.Weather;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import gameobjects.GameObject;
import helpers.ColorHelper;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;
import maps.MapEditor;
import screens.GameScreen;

/**
 * Handles in game rain.
 * 
 * @author Fabulous Fellini
 *
 */
public class RainHandler extends GameObject {

	public static boolean isRaining = false;

	/**
	 * Minimum falling velocity.
	 */
	private float minDy = 0.1f;

	/**
	 * Maximum falling velocity.
	 */
	private float maxDy = 0.3f;

	private float startingRainDropYPosition = 0;

	public RainHandler() {
		this.x      = RandomNumberGenerator.generateRandomInteger(GameScreen.cameraWidth * 2);
		this.y      = startingRainDropYPosition;
		this.width  = 0.04f;
		this.height = 0.2f;
		this.dy     = (float) RandomNumberGenerator.generateRandomDouble(minDy, maxDy);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (isRaining) {
			shapeRenderer.setColor(ColorHelper.BLUE);
			shapeRenderer.rect(x, y, width, height);
		}
	}

	/**
	 * 
	 * @param GameScreen gameScreen
	 * @param MapEditor  mapEditor
	 */
	public void updateObject(GameScreen gameScreen, MapEditor mapEditor) {
		if (isRaining) {
			y += dy;
			if (y > gameScreen.getVerticalHeight() * 2) {
				y  = startingRainDropYPosition;
				dy = (float) RandomNumberGenerator.generateRandomDouble(minDy, maxDy);
			}
			System.out.println("It is raining!");
		}
	}
}
