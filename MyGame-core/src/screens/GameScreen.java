package screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;
import maps.MapEditor;
import maps.MapLoader;
import maps.MapRenderer;
import tests.CollisionTests;

/**
 * Screen of the game while in play.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameScreen extends Screens {
	
	/**
	 * Keep track if screen has been initialized.
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
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public GameScreen(final MyGame myGame) {
		super(myGame);
		int width                     = GameAttributeHelper.WIDTH;
		int height                    = GameAttributeHelper.HEIGHT;
		camera                        = new OrthographicCamera(width, height);
		viewport                      = new ExtendViewport(width, height, camera);
		GameAttributeHelper.gameState = Screens.GAME_SCREEN;
		hasBeenInitialized = false;
		camera.setToOrtho(false, width, height);
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
		debugGameScreen();
	}
	
	/**
	 * Initializes the game screen.
	 */
	public void initializeGameScreen() {
		mapLoader.loadMap(myGame, mapEditor.map);
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
		for(int i = 0; i < myGame.tileLoader.tiles.size(); i++) {
			myGame.tileLoader.tiles.get(i).drawTileOverlayForDebugging();
		}
		myGame.gameObjectLoader.enemy.draw(myGame.renderer.batch);
		myGame.gameObjectLoader.player.draw(myGame.renderer.batch);
	}
	
	/**
	 * Performs debug operations to test / debug GameScreen.
	 */
	private void debugGameScreen() {
		
		// Check collision with player and enemy.
		CollisionTests.performPlayerAndEnemyCollisionTest(
				myGame.gameObjectLoader.player, 
				myGame.gameObjectLoader.enemy, 
				myGame
		);
		
		// Verify x, y position of each tile.
		for(int i = 0; i < myGame.tileLoader.tiles.size(); i++) {
			System.out.println(
					"Tile #" 
					+ i 
					+ " X, Y position: " 
					+ myGame.tileLoader.tiles.get(i).getX()
					+ ", " 
					+ myGame.tileLoader.tiles.get(i).getY()
			);
		}
		
		// Check tiles[0] x, y position to verify it scrolls correctly.
		System.out.println(
				"Tile #0 X, Y position: " 
				+ myGame.tileLoader.tiles.get(0).rectangle.getX()
				+ ", " 
				+ myGame.tileLoader.tiles.get(0).getY()
		);
		System.out.println("Player X, Y position: " + myGame.gameObjectLoader.player.getX() + ", " + myGame.gameObjectLoader.player.getY());
	
		// Verify tile collisions with player.
		Vector2 point = new Vector2(myGame.gameObjectLoader.player.getX(), myGame.gameObjectLoader.player.getY());	
		for(int i = 0; i < myGame.tileLoader.tiles.size(); i++) {
			if (myGame.tileLoader.tiles.get(i).rectangle.contains(point)) {
				System.out.println("We have a collision");
			}
		}
	}
}
