package screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.mygame.MyGame;

import debugging.Debugger;
import gameobjects.GameObject;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import maps.MapEditor;
import maps.MapLoader;
import maps.MapRenderer;
import particles.ParticleEmitter;
import physics.Lighting.LightingHandler;
import physics.Weather.LightningBoltHandler;
import physics.Weather.RainHandler;
import physics.Weather.WeatherHandler;

/**
 * Screen of the game while in play.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameScreen extends Screens {

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
	private MapEditor mapEditor = new MapEditor();

	/**
	 * Class to load up the tiles for our level maps.
	 */
	private MapLoader mapLoader = new MapLoader();

	private LightingHandler lightingHandler = new LightingHandler();

	private WeatherHandler weatherHandler = new WeatherHandler();

	/**
	 * Used to shade the screen to simulate darkness.
	 */
	private ScreenShader screenShader = new ScreenShader(myGame);
	
	private GuiScreen guiScreen = new GuiScreen(myGame);

	/**
	 * Debugs game screen if needed / uncommented.
	 */
	private Debugger debugger = new Debugger();

	public static ParticleEmitter particleEmitterRed;
	public static ParticleEmitter particleEmitterYellow;
	public static ParticleEmitter particleEmitterOrange;
	
	/**
	 *  Screen fades in during transitions.
	 */
	private TransitionScreen transitionScreen = new TransitionScreen(myGame);

	/**
	 * 
	 * @param MyGame myGame
	 */
	public GameScreen(final MyGame myGame) {
		super(myGame);
		GameAttributeHelper.gameState = Screens.GAME_SCREEN;
		gameScreenHasBeenInitialized  = false;
	}

	/**
	 *
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
		
		guiScreen.render(myGame.renderer.batch, myGame.imageLoader);

		// If a screenshake happened, reset camera to it's original position before shake.
		if (!weatherHandler.lightningHandler.isLightningShouldBeRendered()) {
			resetCameraAfterScreenShake();
		}

		// Update objects associated with GameScreen.
		updateGameScreen();

		// Perform debug testing on GameScreen so we know different scenarios work.
		debugger.debugGameScreen(myGame, mapEditor);
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
		mapLoader.loadMap(myGame, mapEditor);
		myGame.getGameObject(GameObject.PLAYER_ONE).init(myGame);
		ParticleEmitter.initializeParticleEmitters(myGame);
		for (int i = 0; i < weatherHandler.rainHandler.length; i++) {
			weatherHandler.rainHandler[i] = new RainHandler(this);
		}
		LightningBoltHandler.init();
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
			camera.position.x = myGame.getGameObject(GameObject.PLAYER_ONE).getX();
			camera.position.y = myGame.getGameObject(GameObject.PLAYER_ONE).getY();
		}
		camera.update();
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
		ParticleEmitter.updateParticleEmitters(myGame, lightingHandler.lightHandler);
		lightingHandler.lightHandler.updateLighting(myGame.imageLoader);
		weatherHandler.nightAndDayCycle.performDayAndNightCycle();
		weatherHandler.updateStormCycle(myGame, this, mapEditor);
		myGame.getGameObject(GameObject.PLAYER_ONE).updateObject(myGame, mapEditor);
		
		// If it is night time, give the screen a dark transparent screen shader.
		screenShader.updateObject();
	}

	private void renderObjectsOnGameScreenThatUseSpriteBatch() {
		mapRenderer.renderMap(myGame, mapEditor);
		lightingHandler.lightHandler.renderLighting(
				myGame.renderer.batch, 
				myGame.imageLoader, 
				myGame.getGameObject(GameObject.PLAYER_ONE)
				);
		weatherHandler.renderStormCycle(myGame, this);
		lightingHandler.renderShadows(myGame);
		
		sortObjectsForRenderingAndRenderObjectsInOrder(
				GameObjectLoader.gameObjectList, 
				myGame.renderer.batch, 
				myGame.renderer.shapeRenderer, 
				myGame.imageLoader
				);
		
		myGame.gameObjectLoader.chest.renderObject(
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
	}
	
	/**
	 * Sort objects based on their y-axis position vs player y-axis position, and render accordingly.
	 * gameObjectList[0, 1, 2] = playerOne, playerTwo, playerThree.
	 * 
	 * @param ArrayList     gameObjectList
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	private void sortObjectsForRenderingAndRenderObjectsInOrder(
			ArrayList<GameObject> gameObjectList,
			SpriteBatch batch,
			ShapeRenderer shapeRenderer,
			ImageLoader imageLoader
			) {
		for (int i = 0; i < gameObjectList.size(); i++) {
			System.out.println(gameObjectList);
			
			if (i > 0) {
				float playerPosition = myGame.getGameObject(GameObject.PLAYER_ONE).getY() + myGame.getGameObject(GameObject.PLAYER_ONE).getHeight();
				float objectPosition = gameObjectList.get(i).getY();
				if (playerPosition < objectPosition)  {
					// Render player behind object.
					System.out.println("Player is behing Object " + i);
					gameObjectList.get(0).renderObject(batch, shapeRenderer, imageLoader);
					gameObjectList.get(1).renderObject(batch, shapeRenderer, imageLoader);
					gameObjectList.get(2).renderObject(batch, shapeRenderer, imageLoader);
					gameObjectList.get(i).renderObject(batch, shapeRenderer, imageLoader);
				} else {
					// Render player in front of object.
					gameObjectList.get(i).renderObject(batch, shapeRenderer, imageLoader);
					gameObjectList.get(0).renderObject(batch, shapeRenderer, imageLoader);
					gameObjectList.get(1).renderObject(batch, shapeRenderer, imageLoader);
					gameObjectList.get(2).renderObject(batch, shapeRenderer, imageLoader);
				}
			}
		}
	}
	
	private void renderObjectsOnGameScreenThatUseShapeRenderer() {
		ParticleEmitter.renderParticleEmitters(myGame, myGame.renderer.shapeRenderer);

		// If it is night time, give the screen a dark transparent screen shader.
		screenShader.renderObject(myGame.renderer.shapeRenderer);

		// Fade screen in during transitions of screens.
		if (!TransitionScreen.isTransitionScreenIsComplete()) {
			transitionScreen.renderObject(myGame.renderer.shapeRenderer);
		}
	}
}
