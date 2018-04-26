package screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
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
	 * Used for isometric camera view.
	 */
	private final Matrix4 matrix = new Matrix4();
	
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
	
	private ParticleEmitter particleEmitterRed2;
	private ParticleEmitter particleEmitterYellow2;
	private ParticleEmitter particleEmitterOrange2;
	
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
		//debugger.debugGameScreen(myGame, mapEditor);
	}
	
	/**
	 * Resets camera to it's original position before screenshake.
	 */
	public static void resetCameraAfterScreenShake() {
		camera.position.x = cameraX;
		camera.position.y = cameraY;
	}
	
	/**
	 * Overriden in order to set the camera to isometric.  Splash screen is not isometric.
	 */
	@Override
	protected void updateCamera() {
		myGame.renderer.batch.setProjectionMatrix(camera.combined);
		myGame.renderer.shapeRenderer.setProjectionMatrix(camera.combined);
		myGame.renderer.batch.setTransformMatrix(matrix);
		camera.update();
	}
	
	/**
	 * Initializes the game screen.
	 */
	public void initializeGameScreen() {
		mapLoader.loadMap(myGame, mapEditor);
		initializeParticleEmitters();
		initializeCameraForIsometricView();
	}
	
	/**
	 * Initializes isometric camera for game screen.
	 */
	private void initializeCameraForIsometricView() {
		int cameraSize = 10;
		camera = new OrthographicCamera(
				cameraSize, 
				cameraSize * (GameAttributeHelper.SCREEN_HEIGHT / (float) GameAttributeHelper.SCREEN_WIDTH)
		);
		int cameraXYPosition = 10;
		camera.position.set(cameraXYPosition, cameraXYPosition, cameraXYPosition * 2);
		int cameraDirection = -1;
		camera.direction.set(cameraDirection, cameraDirection, cameraDirection);
		int matrixNonRotationValue = 0;
		matrix.setToRotation(new Vector3(1, matrixNonRotationValue, matrixNonRotationValue), 90);
		camera.position.x = myGame.gameObjectLoader.player.getX() + 10;
		camera.position.y = myGame.gameObjectLoader.player.getY();
	}
	
	/**
	 * Update objects associated with GameScreen.  
	 * For now we only need this for debugging purposes.
	 */
	private void updateGameScreen() {
		//myGame.gameObjectLoader.enemy.updateGameObject();
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
		myGame.gameObjectLoader.player.renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader);
	}
	
	/**
	 * Draw objects associated with ShapeRenderer.
	 */
	private void renderObjectsOnGameScreenThatUseShapeRenderer() {
		//myGame.gameObjectLoader.enemy.draw(myGame.renderer.shapeRenderer);
		renderParticleEmitters();
	}
	
	/**
	 * Initializes particle emitters.
	 */
	private void initializeParticleEmitters() {
		particleEmitterRed     = new ParticleEmitter(6, 6, 1, 1, "Red", myGame);
		particleEmitterYellow  = new ParticleEmitter(6, 6, 1, 1, "Yellow", myGame);
		particleEmitterOrange  = new ParticleEmitter(6, 6, 1, 1, "Orange", myGame);
		
		particleEmitterRed2     = new ParticleEmitter(5, 5, 1, 1, "Red", myGame);
		particleEmitterYellow2  = new ParticleEmitter(5, 5, 1, 1, "Yellow", myGame);
		particleEmitterOrange2  = new ParticleEmitter(5, 5, 1, 1, "Orange", myGame);
		
		particleEmitterRed.setX(-particleEmitterRed.getX());
		particleEmitterYellow.setX(-particleEmitterYellow.getX());
		particleEmitterOrange.setX(-particleEmitterOrange.getX());
		
		particleEmitterRed.setY(-particleEmitterRed.getY());
		particleEmitterYellow.setY(-particleEmitterYellow.getY());
		particleEmitterOrange.setY(-particleEmitterOrange.getY());
		
		particleEmitterRed2.setX(-particleEmitterRed2.getX());
		particleEmitterYellow2.setX(-particleEmitterYellow2.getX());
		particleEmitterOrange2.setX(-particleEmitterOrange2.getX());
		
		particleEmitterRed2.setY(-particleEmitterRed2.getY());
		particleEmitterYellow2.setY(-particleEmitterYellow2.getY());
		particleEmitterOrange2.setY(-particleEmitterOrange2.getY());
	}
	
	/**
	 * Updates particle emitters.
	 */
	private void updateParticleEmitters() {
		particleEmitterRed.updateParticleEmitter(myGame, lightHandler);
		particleEmitterYellow.updateParticleEmitter(myGame, lightHandler);
		particleEmitterOrange.updateParticleEmitter(myGame, lightHandler);
		
		particleEmitterRed2.updateParticleEmitter(myGame, lightHandler);
		particleEmitterYellow2.updateParticleEmitter(myGame, lightHandler);
		particleEmitterOrange2.updateParticleEmitter(myGame, lightHandler);
	}
	
	/**
	 * Renders particle emitters.
	 */
	private void renderParticleEmitters() {
		particleEmitterRed.renderParticleEmitter(myGame.renderer.shapeRenderer, "Red", myGame.renderer.batch, myGame.imageLoader);
		particleEmitterYellow.renderParticleEmitter(myGame.renderer.shapeRenderer, "Yellow", myGame.renderer.batch, myGame.imageLoader);
		particleEmitterOrange.renderParticleEmitter(myGame.renderer.shapeRenderer, "Orange", myGame.renderer.batch, myGame.imageLoader);
		
		particleEmitterRed2.renderParticleEmitter(myGame.renderer.shapeRenderer, "Red", myGame.renderer.batch, myGame.imageLoader);
		particleEmitterYellow2.renderParticleEmitter(myGame.renderer.shapeRenderer, "Yellow", myGame.renderer.batch, myGame.imageLoader);
		particleEmitterOrange2.renderParticleEmitter(myGame.renderer.shapeRenderer, "Orange", myGame.renderer.batch, myGame.imageLoader);
	}
}
