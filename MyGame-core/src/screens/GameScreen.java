package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.mygame.MyGame;

import debugging.Debugger;
import helpers.GameAttributeHelper;
import maps.MapEditor;
import maps.MapLoader;
import maps.MapRenderer;
import particles.ParticleEmitter;
import physics.Lighting.LightingHandler;
import physics.Weather.LightningBoltHandler;
import physics.Weather.NightAndDayCycle;
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
	 * Used for camera rotation.
	 */
	private Matrix4 matrixO = new Matrix4();
	private Matrix4 matrixR = new Matrix4();
	
	/**
	 * Represents camera height taking device into account.
	 */
	public static float cameraDeviceHeight = GameAttributeHelper.SCREEN_HEIGHT / (float) GameAttributeHelper.SCREEN_WIDTH;
	
	/**
	 * Represents actual camera height.
	 */
	public static float cameraHeight = cameraWidth * cameraDeviceHeight;
	
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
	
	/**
	 * Debugs game screen if needed / uncommented.
	 */
	private Debugger debugger = new Debugger();
	
	public static ParticleEmitter particleEmitterRed;
	public static ParticleEmitter particleEmitterYellow;
	public static ParticleEmitter particleEmitterOrange;   
	
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
		if (!TransitionScreen.isTransitionScreenIsComplete() || !NightAndDayCycle.isDayTime()) {
			Gdx.gl.glEnable(GL20.GL_BLEND);
			Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		} 
		
		myGame.renderer.shapeRenderer.begin(ShapeType.Filled);
		renderObjectsOnGameScreenThatUseShapeRenderer();
		myGame.renderer.shapeRenderer.end();
		
		// If a screenshake happened, reset camera to it's original position before shake.
		resetCameraAfterScreenShake();
		
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
		ParticleEmitter.initializeParticleEmitters(myGame);
		for (int i = 0; i < weatherHandler.rainHandler.length; i++) {
			weatherHandler.rainHandler[i] = new RainHandler();
		}
		LightningBoltHandler.setTexture(new Texture("lightningbolt.png"));
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
			camera.position.x = myGame.gameObjectLoader.playerOne.getX();
			camera.position.y = myGame.gameObjectLoader.playerOne.getY();
		}
		camera.update();
	}
	
	private void initializeCamera() {
		float aspectRatio    = (float)Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth();
        float verticalHeight = 8.0f;
        float viewportWidth  = verticalHeight / aspectRatio;
        camera               = new OrthographicCamera(viewportWidth, verticalHeight);
        camera.position.set(viewportWidth / 2.0f, verticalHeight / 2.0f, 1.0f);
        camera.setToOrtho(true, viewportWidth, verticalHeight);
		camera.position.x = myGame.gameObjectLoader.playerOne.getX();
		camera.position.y = myGame.gameObjectLoader.playerOne.getY();
		matrixO.setToOrtho(0, cameraWidth, 0, cameraHeight, 1, 100);
		matrixR.setToRotation(new Vector3(0, 0, -1), 10);
		camera.rotate(matrixR);
		camera.update();
	}
	
	private void updateGameScreen() {
		if (!TransitionScreen.isTransitionScreenIsComplete()) {
			TransitionScreen.updateObject();
		}
		ParticleEmitter.updateParticleEmitters(myGame, lightingHandler.lightHandler);
		lightingHandler.lightHandler.updateLighting(myGame.imageLoader);
		weatherHandler.nightAndDayCycle.performDayAndNightCycle();
		myGame.gameObjectLoader.playerOne.updateObject(myGame, mapEditor);
		
		/**
		 * If it is day time, start raining.  Stop raining during night time.
		 * If it is night time, give the screen a dark transparent screen shader.
		 */
		if (NightAndDayCycle.isDayTime()) {
			RainHandler.isRaining = true;
			for (int i = 0; i < weatherHandler.rainHandler.length; i++) {
				weatherHandler.rainHandler[i].updateObject(myGame, mapEditor);
			}
		} else {
			RainHandler.isRaining = false;
		}
		weatherHandler.lightningHandler.updateObject(myGame, mapEditor);
	}
	
	private void renderObjectsOnGameScreenThatUseSpriteBatch() {
		mapRenderer.renderMap(myGame, mapEditor);
		lightingHandler.lightHandler.renderLighting(myGame.renderer.batch, myGame.imageLoader, myGame.gameObjectLoader.playerOne);
		
		if (NightAndDayCycle.isDayTime()) {
			// Do not just constantly flash lightning the whole time.
			if (weatherHandler.lightningHandler.getCurrentNumberOfFlashes() == 2) {
				LightningBoltHandler.drawLightningBolt(myGame);
			}
			lightingHandler.shadowHandler.renderLighting(myGame.renderer.batch, myGame.imageLoader, myGame.gameObjectLoader.playerOne);
			lightingHandler.shadowHandler.renderLighting(myGame.renderer.batch, myGame.imageLoader, myGame.gameObjectLoader.playerTwo);
			lightingHandler.shadowHandler.renderLighting(myGame.renderer.batch, myGame.imageLoader, myGame.gameObjectLoader.playerThree);
		}
		myGame.gameObjectLoader.playerOne.renderObject(
				myGame.renderer.batch, 
				myGame.renderer.shapeRenderer, 
				myGame.imageLoader
				);
		myGame.gameObjectLoader.playerTwo.renderObject(
				myGame.renderer.batch, 
				myGame.renderer.shapeRenderer, 
				myGame.imageLoader
				);
		myGame.gameObjectLoader.playerThree.renderObject(
				myGame.renderer.batch, 
				myGame.renderer.shapeRenderer, 
				myGame.imageLoader
				);
		myGame.gameObjectLoader.tree.renderObject(
				myGame.renderer.batch, 
				myGame.renderer.shapeRenderer, 
				myGame.imageLoader
				);
	}
	
	private void renderObjectsOnGameScreenThatUseShapeRenderer() {
		ParticleEmitter.renderParticleEmitters(myGame, myGame.renderer.shapeRenderer);
		for (int i = 0; i < weatherHandler.rainHandler.length; i++) {
			weatherHandler.rainHandler[i].renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader);
		}
		weatherHandler.lightningHandler.renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader);
		
		// Night time places a transparent dark square on the screen to simulate darkness.
		if (!NightAndDayCycle.isDayTime()) {
			screenShader.renderObject(myGame.renderer.shapeRenderer);
		}
		
		if (!TransitionScreen.isTransitionScreenIsComplete()) {
			TransitionScreen.renderObject(myGame.renderer.shapeRenderer);
		}
	}
}
