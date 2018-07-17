package physics.Weather;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
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

	/**
	 * Constructor.
	 * 
	 * @param GameScreen gameScreen
	 */
	public RainHandler(GameScreen gameScreen) {
		this.x      = RandomNumberGenerator.generateRandomInteger((int)gameScreen.getViewportWidth());
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
	 * @param GameScreen    gameScreen
	 */
	public void renderObject(
			SpriteBatch batch, 
			ShapeRenderer shapeRenderer, 
			ImageLoader imageLoader, 
			GameScreen gameScreen
			) {
		if (isRaining) {
			batch.setProjectionMatrix(GameScreen.camera.combined);
			batch.draw(imageLoader.rain, x, y, width, height);
		}
	}

	/**
	 * 
	 * @param GameScreen gameScreen
	 * @param MapEditor  mapEditor
	 */
	public void updateObject(GameScreen gameScreen, MapEditor mapEditor, MyGame myGame) {
		if (isRaining) {
			y += dy;
			if (y > gameScreen.getVerticalHeight() * 2.5f) {
				// Only make it rain around player.
				int rainBoundary       = 10;
				float middleOfBoundary = myGame.getPlayer(Player.PLAYER_ONE).getX();
				x  = (float) RandomNumberGenerator.generateRandomDouble(
						middleOfBoundary - rainBoundary, 
						middleOfBoundary + rainBoundary
						);
				y  = myGame.getPlayer(Player.PLAYER_ONE).getY() - rainBoundary / 2;
				dy = (float) RandomNumberGenerator.generateRandomDouble(minDy, maxDy);
			}
			System.out.println("It is raining!");
		}
	}
}
