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
	
	private int maxLimitToDetermineIfStormCycleShouldBegin = 1000;
	
	private static boolean isStorming = false;
	
	public Cloud[] cloud  = new Cloud[250];
	public Cloud[] cloud2 = new Cloud[250];
	public Cloud[] cloud3 = new Cloud[250];
	public Cloud[] cloud4 = new Cloud[250];

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
	 * @param MyGame     myGame
	 * @param GameScreen gameScreen
	 */
	public void init(MyGame myGame, GameScreen gameScreen) {
		for (int i = 0; i < rainHandler.length; i++) {
			rainHandler[i] = new RainHandler(gameScreen);
		}
		initializeClouds(myGame);
	}
	
	/**
	 * 
	 * @param MyGame     myGame
	 * @param GameScreen gameScreen
	 * @param MapEditor  mapEditor
	 */
	public void update(MyGame myGame, GameScreen gameScreen, MapEditor mapEditor) {
		nightAndDayCycle.performDayAndNightCycle();
		updateStormCycle(myGame, gameScreen, mapEditor);
		updateClouds(myGame, gameScreen);
	}
	
	/**
	 * 
	 * @param MyGame     myGame
	 * @param GameScreen gameScreen
	 */
	private void updateClouds(MyGame myGame, GameScreen gameScreen) {
		for (int i = 0; i < cloud.length; i++) {
			cloud[i].updateObject(myGame, gameScreen);
			cloud2[i].updateObject(myGame, gameScreen);
			cloud3[i].updateObject(myGame, gameScreen);
			cloud4[i].updateObject(myGame, gameScreen);
		}
	}
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	public void renderClouds(MyGame myGame) {
		for (int i = 0; i < cloud.length; i++) {
			cloud[i].renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader, i);
			cloud2[i].renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader, i);
			cloud3[i].renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader, i);
			cloud4[i].renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader, i);
		}
	}
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	private void initializeClouds(MyGame myGame) {
		for (int i = 0; i < cloud.length; i++) {
			double min = RandomNumberGenerator.generateRandomDouble(7, 7.5);
			double max = RandomNumberGenerator.generateRandomDouble(7.5, 8);
			double[] range = {min, max};
			cloud[i] = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]),
					(float) RandomNumberGenerator.generateRandomDouble(.1, 0.2f),
					(float) RandomNumberGenerator.generateRandomDouble(.1, 0.2f)
					);
		}
		
		// Clouds 2 and 3 are together.
		for (int i = 0; i < cloud2.length; i++) {
			double min = RandomNumberGenerator.generateRandomDouble(5, 5.5);
			double max = RandomNumberGenerator.generateRandomDouble(5.5, 6);
			double[] range = {min, max};
			cloud2[i] = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0] + 3, range[1] + 3),
					(float) RandomNumberGenerator.generateRandomDouble(.1, 0.5f),
					(float) RandomNumberGenerator.generateRandomDouble(.1, 0.2f)
					);
		}
		
		for (int i = 0; i < cloud3.length; i++) {
			double min = RandomNumberGenerator.generateRandomDouble(5, 5.5);
			double max = RandomNumberGenerator.generateRandomDouble(5.5, 6);
			double[] range = {min, max};
			cloud3[i] = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0] + .7f, range[1] + .7f), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0] + 3, range[1] + 3),
					(float) RandomNumberGenerator.generateRandomDouble(.1, 0.2f),
					(float) RandomNumberGenerator.generateRandomDouble(.1, 0.5f)
					);
		}
		
		for (int i = 0; i < cloud4.length; i++) {
			double min = RandomNumberGenerator.generateRandomDouble(5, 5.5);
			double max = RandomNumberGenerator.generateRandomDouble(5.5, 6);
			double[] range = {min, max};
			cloud4[i] = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0] + 4, range[1] + 4), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0] + 5, range[1] + 5),
					(float) RandomNumberGenerator.generateRandomDouble(.1, 0.2f),
					(float) RandomNumberGenerator.generateRandomDouble(.1, 0.5f)
					);
		}
	}
	
	/**
	 * 
	 * @param MyGame     myGame
	 * @param GameScreen gameScreen
	 */
	public void renderStormCycle(MyGame myGame, GameScreen gameScreen) {
		if (isStorming) { 
			lightningHandler.renderObject(
					myGame.renderer.batch, 
					myGame.renderer.shapeRenderer, 
					myGame.imageLoader,
					gameScreen
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
	private void updateStormCycle(MyGame myGame, GameScreen gameScreen, MapEditor mapEditor) {
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
					rainHandler[i].updateObject(gameScreen, mapEditor, myGame);
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
