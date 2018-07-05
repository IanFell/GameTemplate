package physics.Weather;

import com.mygdx.mygame.MyGame;

import helpers.RandomNumberGenerator;
import maps.MapEditor;
import screens.GameScreen;

/**
 * Handles all game weather.  This could include:
 * 	- Day and night cycles,
 *  - Rain,
 *  - Etc.
 *  
 * @author Fabulous Fellini
 *
 */
public class WeatherHandler {

	public RainHandler[] rainHandler;

	public LightningHandler lightningHandler;

	public NightAndDayCycle nightAndDayCycle;
	
	private int randomNumberToDetermineIfStormCycleShouldBegin = 0;
	
	private int maxLimitToDetermineIfStormCycleShouldBegin = 10000;
	
	private static boolean isStorming = false;

	/**
	 * Constructor.
	 */
	public WeatherHandler() {
		rainHandler      = new RainHandler[100];
		lightningHandler = new LightningHandler();
		nightAndDayCycle = new NightAndDayCycle();
	}
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	public void renderStormCycle(MyGame myGame) {
		if (isStorming) {
			lightningHandler.renderObject(
					myGame.renderer.batch, 
					myGame.renderer.shapeRenderer, 
					myGame.imageLoader
					);
			if (NightAndDayCycle.isDayTime()) {
				// Do not just constantly flash lightning the whole time.
				if (lightningHandler.getCurrentNumberOfFlashes() == 2) {
					LightningBoltHandler.drawLightningBolt(myGame);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param MyGame     myGame
	 * @param GameScreen gameScreen
	 * @param MapEditor  mapEditor
	 */
	public void updateStormCycle(MyGame myGame, GameScreen gameScreen, MapEditor mapEditor) {
		// First determine if it should start storming with a random number.
		randomNumberToDetermineIfStormCycleShouldBegin = RandomNumberGenerator.generateRandomInteger(
				maxLimitToDetermineIfStormCycleShouldBegin
				);
		if (randomNumberToDetermineIfStormCycleShouldBegin == maxLimitToDetermineIfStormCycleShouldBegin / 2) {
			isStorming = true;
		}
		
		// If it is day time, and isStorming is true, start raining.  Stop raining during night time.
		if (isStorming) {
			if (NightAndDayCycle.isDayTime()) {
				RainHandler.isRaining = true;
				for (int i = 0; i < rainHandler.length; i++) {
					rainHandler[i].updateObject(gameScreen, mapEditor);
				}
			} else {
				RainHandler.isRaining = false;
				isStorming = false;
			}
			lightningHandler.updateObject(myGame, mapEditor);
		}
	}

	/**
	 * 
	 * @return boolean
	 */
	public static boolean isStorming() {
		return isStorming;
	}
}
