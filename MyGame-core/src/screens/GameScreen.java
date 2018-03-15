package screens;

import com.mygdx.mygame.MyGame;

import debugging.Debugger;
import helpers.GameAttributeHelper;
import maps.MapEditor;
import maps.MapLoader;
import maps.MapRenderer;

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
	 * Debugs if needed / uncommented.
	 */
	private Debugger debugger = new Debugger();
	
	/**
	 * Angle for a camera to rotate for isometric view.
	 */
	private int rotateAngle = 45;
	
	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public GameScreen(final MyGame myGame) {
		super(myGame);
		GameAttributeHelper.gameState = Screens.GAME_SCREEN;
		hasBeenInitialized = false;
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
		updateCamera();
		myGame.renderer.batch.begin();
		mapRenderer.renderMap(myGame, mapEditor.map);
		myGame.renderer.batch.end();
		
		/**
		 * Since these objects use a ShapeRenderer we must draw them after sprite batch has ended,
		 * otherwise they will block the sprite batch from being rendered.
		 */
		
		drawAdditionalObjectsOnGameScreenThatDontUseSpriteBatch();
		
		// Update objects associated with GameScreen.
		updateGameScreen();
		
		// Perform debug testing on GameScreen so we know different scenarios work.
		//debugger.debugGameScreen(myGame);
	}
	
	/**
	 * Initializes the game screen.
	 */
	public void initializeGameScreen() {
		mapLoader.loadMap(myGame, mapEditor.map);
		camera.rotate(rotateAngle);
	}
	
	/**
	 * Update objects associated with GameScreen.
	 */
	private void updateGameScreen() {
		myGame.gameObjectLoader.enemy.updateGameObject();
		for(int i = 0; i < myGame.tileLoader.tiles.size(); i++) {
			myGame.tileLoader.tiles.get(i).updateGameObject();
		}
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
	}
}
