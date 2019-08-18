package physics.Weather;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.GameAttributeHelper;
import loaders.ImageLoader;
import maps.MapHandler;
import screens.GameScreen;

/**
 * Handles in game lightning flashes.
 * 
 * @author Fabulous Fellini
 *
 */
public class LightningHandler extends GameObject {

	/**
	 * Maximum number of lightning flashes that can happen during one rain cycle.
	 */
	private int maxNumberOfFlashes = 3;

	/**
	 * Keeps track of how many flashes have happened in current rain cycle.
	 */
	private int currentNumberOfFlashes = 0;

	private boolean lightningShouldBeRendered = false;

	/**
	 * Time in millisecondes between lightning flashes.
	 */
	private int timeBetweenFlashes = 15;

	/**
	 * Works with timeBetweenFlashes to determine when lightning should flash.
	 */
	private int increment = 0;

	/**
	 * Construct.
	 */
	public LightningHandler() {
		this.x      = 0;
		this.y      = 0;
		this.width  = GameAttributeHelper.SCREEN_WIDTH;
		this.height = GameAttributeHelper.SCREEN_HEIGHT;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 * @param GameScreen    gameScreen
	 */
	public void renderObject(
			SpriteBatch batch, 
			ImageLoader imageLoader, 
			GameScreen gameScreen
			) {
		if (lightningShouldBeRendered) {
			batch.draw(
					imageLoader.whiteSquare, 
					GameScreen.camera.position.x - gameScreen.getViewportWidth() / gameScreen.getDenominatorOffset(), 
					GameScreen.camera.position.y - gameScreen.getVerticalHeight() / gameScreen.getDenominatorOffset(), 
					GameScreen.camera.viewportWidth, 
					GameScreen.camera.viewportHeight
					);
			
			// Shake screen a bit to simulate thunder crash shakeing things.
			GameScreen.screenShake.shake(0.3f, 3);
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		if (RainHandler.isRaining && currentNumberOfFlashes <= maxNumberOfFlashes) {
			increment++;
			if (increment >= timeBetweenFlashes) {
				lightningShouldBeRendered = true;
				increment                 = 0;
				currentNumberOfFlashes++;

				if (currentNumberOfFlashes == 2) {
					timeBetweenFlashes = 50;
				}
			} else {
				lightningShouldBeRendered = false;
			}
		} else {
			lightningShouldBeRendered = false;
			currentNumberOfFlashes    = 0;
			timeBetweenFlashes        = 15;
		}
	}

	/**
	 * 
	 * @return int
	 */
	public int getCurrentNumberOfFlashes() {
		return currentNumberOfFlashes;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isLightningShouldBeRendered() {
		return lightningShouldBeRendered;
	}
}
