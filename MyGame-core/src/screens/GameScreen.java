package screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Matrix4;

import com.mygdx.mygame.MyGame;

import debugging.Debugger;
import helpers.GameAttributeHelper;
import maps.MapEditor;
import maps.MapLoader;
import maps.MapRenderer;
import particles.ParticleEmitter;
import physics.LightHandler;
import physics.WeatherHandler;

/**
 * Screen of the game while in play.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameScreen extends Screens {
	
	/**
	 * Keeps track if screen has been initialized.
	 */
	private boolean hasBeenInitialized;
	
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
	
	/**
	 * Handles all in game lighting.
	 */
	private LightHandler lightHandler = new LightHandler();

	/**
	 * Handles in game weather.  This can include:
	 * 	- Night and day cycles,
	 *  - Rain,
	 *  - Etc.
	 */
	private WeatherHandler weatherHandler = new WeatherHandler();
	
	/**
	 * Debugs game screen if needed / uncommented.
	 */
	private Debugger debugger = new Debugger();
	
	/**
	 * Basic particle emitters.
	 */
	private ParticleEmitter particleEmitterRed;
	private ParticleEmitter particleEmitterYellow;
	private ParticleEmitter particleEmitterOrange;
	
	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public GameScreen(final MyGame myGame) {
		super(myGame);
		GameAttributeHelper.gameState = Screens.GAME_SCREEN;
		hasBeenInitialized            = false;
	}
	
	/**
	 * Render game screen.
	 * 
	 * @param float delta
	 */
	@Override
	public void render(float delta) {
		
		// If game screen has not been initialized, go ahead and initialize it.
		if (!hasBeenInitialized) {
			initializeGameScreen();
			hasBeenInitialized = !hasBeenInitialized;
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
	
	/**
	 * Overriden in order to set the camera to isometric.  Splash screen is not isometric.
	 */
	@Override
	protected void updateCamera() {
		myGame.renderer.batch.setProjectionMatrix(camera.combined);
		myGame.renderer.shapeRenderer.setProjectionMatrix(camera.combined);
		myGame.renderer.batch.setTransformMatrix(new Matrix4());
		
		if (!ScreenShake.screenIsShaking) {
			camera.position.x = myGame.gameObjectLoader.player.getX();
			camera.position.y = myGame.gameObjectLoader.player.getY();
		}
		camera.update();
	}
	
	/**
	 * Initializes the game screen.
	 */
	public void initializeGameScreen() {
		mapLoader.loadMap(myGame, mapEditor);
		initializeParticleEmitters();
		initializeCamera();
	}
	
	/**
	 * Initializes camera for game screen.
	 */
	private void initializeCamera() {
		int cameraWidth          = 10;
		float cameraDeviceHeight = GameAttributeHelper.SCREEN_HEIGHT / (float) GameAttributeHelper.SCREEN_WIDTH;
		float cameraHeight       = cameraWidth * cameraDeviceHeight;
		camera                   = new OrthographicCamera(cameraWidth, cameraHeight);
		camera.position.x        = myGame.gameObjectLoader.player.getX();
		camera.position.y        = myGame.gameObjectLoader.player.getY();
		camera.setToOrtho(true, cameraWidth, cameraHeight);
	}
	
	/**
	 * Update objects associated with GameScreen.  
	 * For now we only need this for debugging purposes.
	 */
	private void updateGameScreen() {
		updateParticleEmitters();
		lightHandler.updateLighting(myGame.imageLoader);
		weatherHandler.performDayAndNightCycle();
		myGame.gameObjectLoader.player.updateObject(myGame, mapEditor);
	}
	
	/**
	 * Draw objects associated with SpriteBatch.
	 */
	private void renderObjectsOnGameScreenThatUseSpriteBatch() {
		mapRenderer.renderMap(myGame, mapEditor);
		lightHandler.renderLight(myGame.renderer.batch, myGame.imageLoader);
		myGame.gameObjectLoader.player.renderObject(
				myGame.renderer.batch, 
				myGame.renderer.shapeRenderer, 
				myGame.imageLoader
				);
	}
	
	/**
	 * Draw objects associated with ShapeRenderer.
	 */
	private void renderObjectsOnGameScreenThatUseShapeRenderer() {
		renderParticleEmitters();
	}
	
	/**
	 * Initializes particle emitters.
	 */
	private void initializeParticleEmitters() {
		particleEmitterRed     = new ParticleEmitter(0, 5, 1, 1, "Red", myGame);
		particleEmitterYellow  = new ParticleEmitter(0, 5, 1, 1, "Yellow", myGame);
		particleEmitterOrange  = new ParticleEmitter(0, 5, 1, 1, "Orange", myGame);
		
		particleEmitterRed.setX(particleEmitterRed.getX());
		particleEmitterYellow.setX(particleEmitterYellow.getX());
		particleEmitterOrange.setX(particleEmitterOrange.getX());
		
		particleEmitterRed.setY(particleEmitterRed.getY());
		particleEmitterYellow.setY(particleEmitterYellow.getY());
		particleEmitterOrange.setY(particleEmitterOrange.getY());
	}
	
	/**
	 * Updates particle emitters.
	 */
	private void updateParticleEmitters() {
		particleEmitterRed.updateParticleEmitter(myGame, lightHandler);
		particleEmitterYellow.updateParticleEmitter(myGame, lightHandler);
		particleEmitterOrange.updateParticleEmitter(myGame, lightHandler);
	}
	
	/**
	 * Renders particle emitters.
	 */
	private void renderParticleEmitters() {
		particleEmitterRed.renderParticleEmitter(myGame.renderer.shapeRenderer, "Red", myGame.renderer.batch, myGame.imageLoader);
		particleEmitterYellow.renderParticleEmitter(myGame.renderer.shapeRenderer, "Yellow", myGame.renderer.batch, myGame.imageLoader);
		particleEmitterOrange.renderParticleEmitter(myGame.renderer.shapeRenderer, "Orange", myGame.renderer.batch, myGame.imageLoader);
	}
}
