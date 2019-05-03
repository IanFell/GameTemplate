package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import cutscenes.CutSceneIntro;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import handlers.MissionHandler;
import handlers.WeaponHandler;
import helpers.GameAttributeHelper;
import helpers.GamePlayHelper;
import loaders.GameObjectLoader;
import loaders.GameWorld;
import maps.MapHandler;
import maps.MapLoader;
import maps.MapRenderer;
import physics.Lighting.LightingHandler;
import physics.Weather.LightningBoltHandler;
import physics.Weather.WeatherHandler;
import spawners.EnemySpawner;

/**
 * Screen of the game while in play.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameScreen extends Screens {

	public EnemySpawner enemySpawner;

	public static int cameraWidth = 10;

	/**
	 * Keeps track if screen has been initialized.
	 */
	private boolean gameScreenHasBeenInitialized;

	/**
	 * Class to render our level maps.
	 */
	private MapRenderer mapRenderer = new MapRenderer();

	/**
	 * Class to draw our level maps.
	 */
	private MapHandler mapHandler = new MapHandler();

	/**
	 * Class to load up the tiles for our level maps.
	 */
	private MapLoader mapLoader = new MapLoader();

	private LightingHandler lightingHandler = new LightingHandler();

	private WeatherHandler weatherHandler = new WeatherHandler();

	/**
	 * Used to shade the screen to simulate darkness.
	 */
	private ScreenShader screenShader          = new ScreenShader(myGame);
	private ScreenShader screenShaderPostIntro = new ScreenShader(myGame);

	private GuiScreen guiScreen = new GuiScreen(myGame);

	/**
	 *  Screen fades in during transitions.
	 */
	private TransitionScreen transitionScreen = new TransitionScreen(myGame);

	/**
	 * Handles all game missions.
	 */
	private MissionHandler missionHandler;

	/**
	 * We need this to instantiate weapons, however all other 
	 * calls to the weapon handler will deal with static variables.
	 */
	private WeaponHandler weaponHandler = new WeaponHandler();

	private CutSceneIntro cutSceneIntro;

	/**
	 * 
	 * @param MyGame myGame
	 */
	public GameScreen(final MyGame myGame) {
		super(myGame);
		GameAttributeHelper.gameState = Screens.GAME_SCREEN;
		gameScreenHasBeenInitialized  = false;
		cutSceneIntro = new CutSceneIntro("Intro");
	}

	/**
	 *
	 * @param float delta
	 */
	@Override
	public void render(float delta) {
		// If game screen has not been initialized, go ahead and initialize it.
		if (!gameScreenHasBeenInitialized) {
			initializeGameScreen();
			gameScreenHasBeenInitialized = !gameScreenHasBeenInitialized;
		}
		clearScreenAndSetScreenColor(GameAttributeHelper.gameState, weatherHandler);

		// Screen only shakes when needed, but we must update it at all times just in case it needs to shake.
		screenShake.update(delta, camera);
		updateCamera();

		// Draw SpriteBatch.
		myGame.renderer.batch.begin();
		renderObjectsOnGameScreenThatUseSpriteBatch();
		myGame.renderer.batch.end();

		// Draw ShapeRenderer.
		if (!TransitionScreen.isTransitionScreenIsComplete()) {
			Gdx.gl.glEnable(GL20.GL_BLEND);
			Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		} 

		myGame.renderer.shapeRenderer.begin(ShapeType.Filled);
		renderObjectsOnGameScreenThatUseShapeRenderer();
		myGame.renderer.shapeRenderer.end();

		// If a screenshake happened, reset camera to it's original position before shake.
		if (!weatherHandler.lightningHandler.isLightningShouldBeRendered()) {
			resetCameraAfterScreenShake();
		}

		// Update objects associated with GameScreen.
		updateGameScreen();
	}

	/**
	 * Resets camera to it's original position before screenshake.
	 */
	public static void resetCameraAfterScreenShake() {
		camera.position.x           = cameraX;
		camera.position.y           = cameraY;
		ScreenShake.screenIsShaking = false;
	}

	public void initializeGameScreen() {
		mapLoader.loadMap(myGame, mapHandler);
		myGame.getGameObject(GameObject.PLAYER_ONE).init(myGame);
		myGame.getGameObject(GameObject.PLAYER_TWO).init(myGame);
		myGame.getGameObject(GameObject.PLAYER_THREE).init(myGame);
		enemySpawner = new EnemySpawner(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 48, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 12.5f, 
				"Mexico Beach"
				);
		weatherHandler.init(myGame, this);
		LightningBoltHandler.init();
		missionHandler = new MissionHandler(myGame);
		/**
		 * This overlays the game screen and fades out from black.
		 * This makes the transition between screens much smoother.
		 */
		new TransitionScreen(myGame);
		initializeCamera();
	}

	/**
	 * Handle projection matrix and screen shake.
	 */
	@Override
	protected void updateCamera() {
		myGame.renderer.batch.setProjectionMatrix(camera.combined);
		myGame.renderer.shapeRenderer.setProjectionMatrix(camera.combined);
		if (!ScreenShake.screenIsShaking) {
			if (cutSceneIntro.isCutSceneIsInProgress()) {
				camera.position.x = cutSceneIntro.getStartXPosition() + 5;
				camera.position.y = cutSceneIntro.getStartYPosition() + 1;
			} else {
				cameraFollowCurrentPlayer();
			}
		}
		camera.update();
	}

	private void cameraFollowCurrentPlayer() {
		GameObject player = PlayerController.getCurrentPlayer(myGame);
		camera.position.x = player.getX();
		camera.position.y = player.getY();
	}

	private void initializeCamera() {
		camera = new OrthographicCamera(viewportWidth, verticalHeight);
		camera.setToOrtho(true, viewportWidth, verticalHeight);
		camera.position.x = myGame.getGameObject(GameObject.PLAYER_ONE).getX();
		camera.position.y = myGame.getGameObject(GameObject.PLAYER_ONE).getY();  
		camera.update();
	}

	private void updateGameScreen() {
		if (!TransitionScreen.isTransitionScreenIsComplete()) {
			TransitionScreen.updateObject();
		}
		lightingHandler.lightHandler.updateLighting(myGame.imageLoader);
		weatherHandler.update(myGame, this, mapHandler);
		myGame.getGameObject(GameObject.PLAYER_ONE).updateObject(myGame, mapHandler);
		myGame.getGameObject(GameObject.PLAYER_TWO).updateObject(myGame, mapHandler);
		myGame.getGameObject(GameObject.PLAYER_THREE).updateObject(myGame, mapHandler);
		enemySpawner.updateEnemies(myGame, mapHandler);
		GameWorld.updateGameWorld(myGame, mapHandler);

		// If it is night time, give the screen a dark transparent screen shader.
		screenShader.updateObject();

		// Fade into gameplay after intro cutscene.
		if (cutSceneIntro.isCutSceneConcluded()) {
			screenShaderPostIntro.updateObject();
		}

		// Start missions after intro cutscene.
		if (cutSceneIntro.isCutSceneConcluded()) {
			missionHandler.handleMissions(myGame, mapHandler);
		}

		WeaponHandler.updateWeapons(myGame, mapHandler);

		if (cutSceneIntro.isCutSceneIsInProgress()) {
			cutSceneIntro.updateCutScene();
		}
	}

	private void renderObjectsOnGameScreenThatUseSpriteBatch() {
		mapRenderer.renderMapOfChunks(myGame, mapHandler);
		lightingHandler.lightHandler.renderLighting(
				myGame.renderer.batch, 
				myGame.imageLoader, 
				myGame.getGameObject(GameObject.PLAYER_ONE)
				);
		weatherHandler.renderStormCycle(myGame, this);
		lightingHandler.renderShadows(myGame);

		GamePlayHelper.sortAndRenderObjectsInYPositionOrder(
				GameObjectLoader.gameObjectList, 
				myGame.renderer.batch, 
				myGame.renderer.shapeRenderer, 
				myGame.imageLoader
				);

		// Rain should be in front of all objects. 
		for (int i = 0; i < weatherHandler.rainHandler.length; i++) {
			weatherHandler.rainHandler[i].renderObject(
					myGame.renderer.batch, 
					myGame.renderer.shapeRenderer, 
					myGame.imageLoader,
					this
					);
		}

		missionHandler.renderMissions(
				myGame.renderer.batch, 
				myGame.renderer.shapeRenderer, 
				myGame.imageLoader,
				myGame
				);

		WeaponHandler.renderWeapons(
				myGame.renderer.batch, 
				myGame.renderer.shapeRenderer, 
				myGame.imageLoader, 
				myGame
				);
		if (!cutSceneIntro.isCutSceneIsInProgress()) {
			guiScreen.render(myGame.renderer.batch, myGame.imageLoader);
		}
		myGame.getGameObject(Player.PLAYER_ONE).inventory.renderInventory(
				myGame.renderer.batch, 
				myGame.renderer.shapeRenderer, 
				myGame.imageLoader
				);

		if (cutSceneIntro.isCutSceneIsInProgress()) {
			cutSceneIntro.renderCutScene(
					myGame.renderer.batch, 
					myGame.renderer.shapeRenderer, 
					myGame.imageLoader
					);
		}
	}

	private void renderObjectsOnGameScreenThatUseShapeRenderer() {
		// If it is night time, give the screen a dark transparent screen shader.
		screenShader.renderObject(myGame.renderer.shapeRenderer);

		// Fade screen in during transitions of screens.
		if (!TransitionScreen.isTransitionScreenIsComplete()) {
			transitionScreen.renderObject(myGame.renderer.shapeRenderer);
		}

		weatherHandler.renderClouds(myGame);
	}

	/**
	 * 
	 * @return WeatherHandler
	 */
	public WeatherHandler getWeatherHandler() {
		return weatherHandler;
	}
}
