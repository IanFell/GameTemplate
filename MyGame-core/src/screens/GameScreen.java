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
		clearScreenAndSetScreenColor();
		
		// Screen only shakes when needed, but we must update it at all times just in case it needs to shake.
		screenShake.update(delta, camera);
		updateCamera();
		myGame.renderer.batch.begin();
		myGame.renderer.shapeRenderer.begin(ShapeType.Filled);
		mapRenderer.renderMap(myGame, mapEditor);
		drawAdditionalObjectsOnGameScreenThatDontUseSpriteBatch();
		myGame.renderer.batch.end();
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
		camera.position.x = cameraX;
		camera.position.y = cameraY;
	}
	
	/**
	 * Overriden in order to set the camera to isometric.  Splash screen is not isometric.
	 */
	@Override
	protected void updateCamera() {
		myGame.renderer.batch.setProjectionMatrix(camera.combined);
		myGame.renderer.shapeRenderer.setProjectionMatrix(myGame.renderer.batch.getProjectionMatrix());
		myGame.renderer.batch.setTransformMatrix(matrix);
		myGame.renderer.shapeRenderer.setTransformMatrix(matrix);
	    camera.update();
	}
	
	/**
	 * Initializes the game screen.
	 */
	public void initializeGameScreen() {
		mapLoader.loadMap(myGame, mapEditor);
		particleEmitterRed     = new ParticleEmitter(0, 0, 1, 1, "Red", myGame);
		particleEmitterYellow  = new ParticleEmitter(0, 0, 1, 1, "Yellow", myGame);
		particleEmitterOrange  = new ParticleEmitter(0, 0, 1, 1, "Orange", myGame);
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
		myGame.gameObjectLoader.enemy.draw(myGame.renderer.shapeRenderer);
		myGame.gameObjectLoader.player.draw(myGame.renderer.shapeRenderer);
		particleEmitterRed.drawParticleEmitter(myGame.renderer.shapeRenderer, "Red");
		particleEmitterYellow.drawParticleEmitter(myGame.renderer.shapeRenderer, "Yellow");
		particleEmitterOrange.drawParticleEmitter(myGame.renderer.shapeRenderer, "Orange");
	}
}
