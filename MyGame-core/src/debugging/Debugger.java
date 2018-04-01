package debugging;

import com.mygdx.mygame.MyGame;

import maps.MapEditor;
import tests.CollisionTests;

/**
 * Debugs various scenarios.
 * 
 * @author Fabulous Fellini
 *
 */
public class Debugger {
	
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
		
		// Check to see if a tile has been clicked on by mouse.
		CollisionTests.checkTileTouchedWithMouse(myGame, mapEditor);
		
		// Check to see if a tile has been touched by player.
		CollisionTests.checkTileTouchedByPlayer(myGame, mapEditor);
		
		// Check to see if player has collided wtih a solid tile, so player stops.
		CollisionTests.checkIfPlayerHasTouchedSolidTile(
				myGame, 
				mapEditor, 
				myGame.gameObjectLoader.player.getDirection()
		); 
	}
}
