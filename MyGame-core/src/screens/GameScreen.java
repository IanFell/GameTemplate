package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.mygame.MyGame;

import debugging.Debugger;
import helpers.GameAttributeHelper;
import maps.MapEditor;
import maps.MapLoader;
import maps.MapRenderer;
import particles.ParticleEmitter;
import physics.Lighting.LightHandler;
import physics.Lighting.ShadowHandler;
import physics.Weather.LightningHandler;
import physics.Weather.NightAndDayCycle;
import physics.Weather.RainHandler;

/**
 * Screen of the game while in play.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameScreen extends Screens {
	
	/**
	 * Width of our camera.
	 */
	public static int cameraWidth = 10;
	
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
	 * Handles in game lighting.
	 */
	private LightHandler lightHandler = new LightHandler();
	
	/**
	 * Handles in game shadows.
	 */
	private ShadowHandler shadowHandler = new ShadowHandler();
	
	/**
	 * Handles raining in game.
	 */
	private RainHandler[] rainHandler = new RainHandler[100];
	
	/**
	 * Handles lightning, which in this case is a white flashing square.
	 */
	private LightningHandler lightningHandler = new LightningHandler();
	
	/**
	 * Used to shade the screen to simulate darkness.
	 */
	private ScreenShader screenShader = new ScreenShader(myGame);
	
	/**
	 * Debugs game screen if needed / uncommented.
	 */
	private Debugger debugger = new Debugger();
	
	/**
	 * Basic particle emitters.
	 */
	public static ParticleEmitter particleEmitterRed;
	public static ParticleEmitter particleEmitterYellow;
	public static ParticleEmitter particleEmitterOrange;
	
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
		clearScreenAndSetScreenColor(GameAttributeHelper.gameState, nightAndDayCycle);
		
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
	
	/**
	 * Handle projection matrix and screen shake.
	 */
	@Override
	protected void updateCamera() {
		myGame.renderer.batch.setProjectionMatrix(camera.combined);
		myGame.renderer.shapeRenderer.setProjectionMatrix(camera.combined);
		
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
		ParticleEmitter.initializeParticleEmitters(myGame);
		for (int i = 0; i < rainHandler.length; i++) {
			rainHandler[i] = new RainHandler();
		}
		/**
		 * This overlays the game screen and fades out from black.
		 * This makes the transition between screens much smoother.
		 */
		new TransitionScreen(myGame);
		initializeCamera();
	}
	
	/**
	 * Initializes camera for game screen.
	 */
	private void initializeCamera() {
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
		
		if (!TransitionScreen.isTransitionScreenIsComplete()) {
			TransitionScreen.updateObject();
		}
		
		ParticleEmitter.updateParticleEmitters(myGame, lightHandler);
		lightHandler.updateLighting(myGame.imageLoader);
		nightAndDayCycle.performDayAndNightCycle();
		myGame.gameObjectLoader.player.updateObject(myGame, mapEditor);
		
		/**
		 * If it is day time, start raining.  Stop raining during night time.
		 * If it is night time, give the screen a dark transparent screen shader.
		 */
		if (NightAndDayCycle.isDayTime()) {
			RainHandler.isRaining = true;
			for (int i = 0; i < rainHandler.length; i++) {
				rainHandler[i].updateObject(myGame, mapEditor);
			}
		} else {
			RainHandler.isRaining = false;
		}
		lightningHandler.updateObject(myGame, mapEditor);
	}
	
	/**
	 * Draw objects associated with SpriteBatch.
	 */
	private void renderObjectsOnGameScreenThatUseSpriteBatch() {
		mapRenderer.renderMap(myGame, mapEditor);
		lightHandler.renderLighting(myGame.renderer.batch, myGame.imageLoader, myGame.gameObjectLoader.player);
		
		if (NightAndDayCycle.isDayTime()) {
			shadowHandler.renderLighting(myGame.renderer.batch, myGame.imageLoader, myGame.gameObjectLoader.player);
		}
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
		ParticleEmitter.renderParticleEmitters(myGame, myGame.renderer.shapeRenderer);
		for (int i = 0; i < rainHandler.length; i++) {
			rainHandler[i].renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader);
		}
		lightningHandler.renderObject(myGame.renderer.batch, myGame.renderer.shapeRenderer, myGame.imageLoader);
		
		// Night time places a transparent dark square on the screen to simulate darkness.
		if (!NightAndDayCycle.isDayTime()) {
			screenShader.renderObject(myGame.renderer.shapeRenderer);
		}
		
		if (!TransitionScreen.isTransitionScreenIsComplete()) {
			TransitionScreen.renderObject(myGame.renderer.shapeRenderer);
		}
	}
}
