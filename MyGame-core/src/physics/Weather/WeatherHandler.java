package physics.Weather;

import com.mygdx.mygame.MyGame;

import cutscenes.CutScene;
import gameobjects.GameObject;
import helpers.RandomNumberGenerator;
import maps.MapHandler;
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

	private int maxLimitToDetermineIfStormCycleShouldBegin = 100000;

	private static boolean isStorming = false;

	public Cloud[] cloud  = new Cloud[1];
	public Cloud[] cloud2 = new Cloud[1];
	public Cloud[] cloud3 = new Cloud[1];
	public Cloud[] cloud4 = new Cloud[1];

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
	 * Don't perform night cycle yet.  It makes the game to slow.
	 * 
	 * @param MyGame     myGame
	 * @param GameScreen gameScreen
	 * @param MapHandler mapHandler
	 */
	public void update(MyGame myGame, GameScreen gameScreen, MapHandler mapHandler) {
		updateStormCycle(myGame, gameScreen, mapHandler);
		updateClouds(myGame, gameScreen);
		if (!CutScene.anyCutSceneIsInProgress) {
			nightAndDayCycle.performDayAndNightCycle();
		}
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
			cloud[i].renderObject(myGame.renderer.batch, myGame.imageLoader);
			cloud2[i].renderObject(myGame.renderer.batch, myGame.imageLoader);
			cloud3[i].renderObject(myGame.renderer.batch, myGame.imageLoader);
			cloud4[i].renderObject(myGame.renderer.batch, myGame.imageLoader);
			//cloud[i].renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader, i);
			//cloud2[i].renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader, i);
			//cloud3[i].renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader, i);
			//cloud4[i].renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader, i);
		}
	} 

	/**
	 * 
	 * @param MyGame myGame
	 */
	private void initializeClouds(MyGame myGame) {
		float playerXPosition = myGame.getGameObject(GameObject.PLAYER_ONE).getX();
		for (int i = 0; i < cloud.length; i++) {
			double min     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 17, playerXPosition + 22);
			double max     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 20, playerXPosition + 25);
			double[] range = {min, max};
			cloud[i]       = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]),
					(float) RandomNumberGenerator.generateRandomDouble(1, 5),
					(float) RandomNumberGenerator.generateRandomDouble(1, 5)
					);
		}

		// Clouds 2 and 3 are together.
		for (int i = 0; i < cloud2.length; i++) {
			//double min = RandomNumberGenerator.generateRandomDouble(playerXPosition + 5, playerXPosition + 5.5);
			//double max = RandomNumberGenerator.generateRandomDouble(playerXPosition + 5.5, playerXPosition + 6);
			double min     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 17, playerXPosition + 22);
			double max     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 20, playerXPosition + 25);
			double[] range = {min, max};
			cloud2[i] = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]),
					(float) RandomNumberGenerator.generateRandomDouble(1, 5),
					(float) RandomNumberGenerator.generateRandomDouble(1, 5)
					);
		}

		for (int i = 0; i < cloud3.length; i++) {
			//double min = RandomNumberGenerator.generateRandomDouble(playerXPosition + 5, playerXPosition + 5.5);
			//double max = RandomNumberGenerator.generateRandomDouble(playerXPosition + 5.5, playerXPosition + 6);
			double min     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 17, playerXPosition + 22);
			double max     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 20, playerXPosition + 25);
			double[] range = {min, max};
			cloud3[i] = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]),
					(float) RandomNumberGenerator.generateRandomDouble(1, 5),
					(float) RandomNumberGenerator.generateRandomDouble(1, 5)
					);
		}

		for (int i = 0; i < cloud4.length; i++) {
			//double min = RandomNumberGenerator.generateRandomDouble(playerXPosition + 5, playerXPosition + 5.5);
			//double max = RandomNumberGenerator.generateRandomDouble(playerXPosition + 5.5, playerXPosition + 6);
			double min     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 17, playerXPosition + 22);
			double max     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 20, playerXPosition + 25);
			double[] range = {min, max};
			cloud4[i] = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]),
					(float) RandomNumberGenerator.generateRandomDouble(1, 5),
					(float) RandomNumberGenerator.generateRandomDouble(1, 5)
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
					myGame.imageLoader,
					gameScreen
					);
			//if (NightAndDayCycle.isDayTime()) {
			// Do not just constantly flash lightning the whole time.
			if (lightningHandler.getCurrentNumberOfFlashes() == 2) {
				LightningBoltHandler.drawLightningBolt(myGame);
			}
			//}
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param GameScreen gameScreen
	 * @param MapHandler mapHandler
	 */
	private void updateStormCycle(MyGame myGame, GameScreen gameScreen, MapHandler mapHandler) {
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
					rainHandler[i].updateObject(gameScreen, mapHandler, myGame);
				}
			} else {
				RainHandler.isRaining = false;
				isStorming = false;
			}
			lightningHandler.updateObject(myGame, mapHandler);
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
