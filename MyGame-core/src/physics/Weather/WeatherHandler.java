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

	/**
	 * Keep these as arrays for now because I might want to change this later 
	 * to put in a lot more clouds.
	 */
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
			cloud[i].updateObject(myGame, gameScreen, myGame.gameObjectLoader.playerOne.getY() - 4);
			cloud2[i].updateObject(myGame, gameScreen, myGame.gameObjectLoader.playerOne.getY() - 1);
			cloud3[i].updateObject(myGame, gameScreen, myGame.gameObjectLoader.playerOne.getY() + 3);
			cloud4[i].updateObject(myGame, gameScreen, myGame.gameObjectLoader.playerOne.getY() + 7);
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
		}
	} 

	/**
	 * 
	 * @param MyGame myGame
	 */
	private void initializeClouds(MyGame myGame) {

		float playerXPosition = myGame.getGameObject(GameObject.PLAYER_ONE).getX();
		float sizeMin         = 1.0f;
		float sizeMax         = 5.0f;

		for (int i = 0; i < cloud.length; i++) {
			double min     = RandomNumberGenerator.generateRandomDouble(playerXPosition - 17, playerXPosition + 22);
			double max     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 20, playerXPosition + 25);
			double[] range = {min, max};
			cloud[i]       = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]),
					(float) RandomNumberGenerator.generateRandomDouble(sizeMin, sizeMax),
					(float) RandomNumberGenerator.generateRandomDouble(sizeMin, sizeMax)
					);
		}

		for (int i = 0; i < cloud2.length; i++) {
			double min     = RandomNumberGenerator.generateRandomDouble(playerXPosition - 17, playerXPosition + 22);
			double max     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 20, playerXPosition + 25);
			double[] range = {min, max};
			cloud2[i] = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]),
					(float) RandomNumberGenerator.generateRandomDouble(sizeMin, sizeMax),
					(float) RandomNumberGenerator.generateRandomDouble(sizeMin, sizeMax)
					);
		}

		for (int i = 0; i < cloud3.length; i++) {
			double min     = RandomNumberGenerator.generateRandomDouble(playerXPosition - 17, playerXPosition + 22);
			double max     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 20, playerXPosition + 25);
			double[] range = {min, max};
			cloud3[i] = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]),
					(float) RandomNumberGenerator.generateRandomDouble(sizeMin, sizeMax),
					(float) RandomNumberGenerator.generateRandomDouble(sizeMin, sizeMax)
					);
		}

		for (int i = 0; i < cloud4.length; i++) {
			double min     = RandomNumberGenerator.generateRandomDouble(playerXPosition - 17, playerXPosition + 22);
			double max     = RandomNumberGenerator.generateRandomDouble(playerXPosition + 20, playerXPosition + 25);
			double[] range = {min, max};
			cloud4[i] = new Cloud(
					myGame, 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]), 
					(float) RandomNumberGenerator.generateRandomDouble(range[0], range[1]),
					(float) RandomNumberGenerator.generateRandomDouble(sizeMin, sizeMax),
					(float) RandomNumberGenerator.generateRandomDouble(sizeMin, sizeMax)
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
			if (lightningHandler.getCurrentNumberOfFlashes() == 2) {
				LightningBoltHandler.drawLightningBolt(myGame);
			}
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
