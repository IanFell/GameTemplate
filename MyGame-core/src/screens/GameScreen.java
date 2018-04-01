package screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

import com.mygdx.mygame.MyGame;

import debugging.Debugger;
import helpers.GameAttributeHelper;
import maps.MapEditor;
import maps.MapLoader;
import maps.MapRenderer;
import particles.ParticleEmitter;

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
	 * Debugs game screen if needed / uncommented.
	 */
	private Debugger debugger = new Debugger();
	
	/**
	 * Basic particle emitters.
	 */
	private ParticleEmitter particleEmitterRed     = new ParticleEmitter(0, 0, 25, 25, "Red");
	private ParticleEmitter particleEmitterYellow  = new ParticleEmitter(0, 0, 25, 25, "Yellow");
	private ParticleEmitter particleEmitterOrange  = new ParticleEmitter(0, 0, 25, 25, "Orange");
	
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
		clearScreenAndSetScreenColor();
		
		// Screen only shakes when needed, but we must update it at all times just in case it needs to shake.
		screenShake.update(delta, camera);
		updateCamera();
		myGame.renderer.batch.begin();
		mapRenderer.renderMap(myGame, mapEditor);
		myGame.renderer.batch.end();
		
		// If a screenshake happened, reset camera to it's original position before shake.
		resetCameraAfterScreenShake();
		
		/**
		 * Since these objects use a ShapeRenderer we must draw them after sprite batch has ended,
		 * otherwise they will block the sprite batch from being rendered.
		 */
		drawAdditionalObjectsOnGameScreenThatDontUseSpriteBatch();
		
		// Update objects associated with GameScreen.
		updateGameScreen();
		
		// Perform debug testing on GameScreen so we know different scenarios work.
		debugger.debugGameScreen(myGame, mapEditor);
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
		myGame.renderer.batch.setTransformMatrix(matrix);
	    camera.update();
	}
	
	/**
	 * Initializes the game screen.
	 */
	public void initializeGameScreen() {
		mapLoader.loadMap(myGame, mapEditor);
		initializeCameraForIsometricView();
	}
	
	/**
	 * Initializes isometric camera for game screen.
	 */
	private void initializeCameraForIsometricView() {
		camera = new OrthographicCamera(
				10, 
				10 * (GameAttributeHelper.SCREEN_HEIGHT / (float) GameAttributeHelper.SCREEN_WIDTH)
		);
		camera.position.set(5, 5, 15);
		camera.direction.set(-1, -1, -1);
		matrix.setToRotation(new Vector3(1, 0, 0), -90);
	}
	
	/**
	 * Update objects associated with GameScreen.  
	 * For now we only need this for debugging purposes.
	 */
	private void updateGameScreen() {
		myGame.gameObjectLoader.enemy.updateGameObject();
		particleEmitterRed.updateParticleEmitter(myGame);
		particleEmitterYellow.updateParticleEmitter(myGame);
		particleEmitterOrange.updateParticleEmitter(myGame);
	}
	
	/**
	 * Draw objects associated with a ShapeRenderer.
	 * We need to do this after the sprite batch is rendered
	 * since if we don't, it will block the sprite batch 
	 * from rendering.
	 */
	private void drawAdditionalObjectsOnGameScreenThatDontUseSpriteBatch() {
		myGame.gameObjectLoader.enemy.draw(myGame.renderer.batch);
		myGame.gameObjectLoader.player.draw(myGame.renderer.batch);
		particleEmitterRed.drawParticleEmitter(myGame.renderer.batch, "Red");
		particleEmitterYellow.drawParticleEmitter(myGame.renderer.batch, "Yellow");
		particleEmitterOrange.drawParticleEmitter(myGame.renderer.batch, "Orange");
	}
}
