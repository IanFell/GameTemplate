package physics.Weather;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

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
public class RainHandler extends WeatherHandler {
	
	/**
	 * Keeps track whether or not it is raining.
	 */
	public static boolean isRaining = false;
	
	/**
	 * Minimum falling velocity.
	 */
	private float minDy = 0.1f;
	
	/**
	 * Maximum falling velocity.
	 */
	private float maxDy = 0.3f;
	
	/**
	 * Position where raindrops begin to fall.
	 */
	private float startingYPosition = 0;
	
	/**
	 * Constructor.
	 */
	public RainHandler() {
		this.x      = RandomNumberGenerator.generateRandomInteger(GameScreen.cameraWidth * 2);
		this.y      = startingYPosition;
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
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	@Override
	public void updateObject(MyGame myGame, MapEditor mapEditor) {
		if (isRaining) {
			y += dy;
			if (y > GameScreen.cameraHeight * 2) {
				y  = startingYPosition;
				dy = (float) RandomNumberGenerator.generateRandomDouble(minDy, maxDy);
			}
			System.out.println("It is raining!");
		}
	}
}
