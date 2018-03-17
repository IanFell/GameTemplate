package debugging;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.mygdx.mygame.MyGame;

import maps.MapEditor;
import screens.Screens;
import tests.CollisionTests;

/**
 * Debugs various scenarios.
 * 
 * @author Fabulous Fellini
 *
 */
public class Debugger {
	
	/**
	 * These variables are needed for the checkTileTouched() method.
	 */
	private final Plane xzPlane        = new Plane(new Vector3(0, 1, 0), 0);
	private final Vector3 intersection = new Vector3();
	private Sprite lastSelectedTile    = null;
	
	/**
	 * Perform debug operations.
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	public void debugGameScreen(MyGame myGame, MapEditor mapEditor) {
		
		// Check collision with player and enemy.
		CollisionTests.performPlayerAndEnemyCollisionTest(
				myGame.gameObjectLoader.player, 
				myGame.gameObjectLoader.enemy, 
				myGame
		);
		
		// This method checks to see if a tile has been clicked on by mouse.
		checkTileTouched(myGame, mapEditor);
	}
	
	/**
	 * This method checks to see if a tile has been clicked on by mouse.
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	private void checkTileTouched(MyGame myGame, MapEditor mapEditor) {
		if(Gdx.input.justTouched()) {
			Ray pickRay = Screens.camera.getPickRay(Gdx.input.getX(), Gdx.input.getY());
			Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
			int x = (int)intersection.x;
			int z = (int)intersection.z;
			if(x >= 0 && x < 10 && z >= 0 && z < 10) {
				if(lastSelectedTile != null) lastSelectedTile.setColor(1, 1, 1, 1);
				Sprite sprite = mapEditor.sprites[x][z];
				sprite.setColor(1, 0, 0, 1);
				lastSelectedTile = sprite;
			}
		}
	}
}
