package physics;

import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Player;
import maps.MapEditor;

/**
 * Class to handle collisions between game objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class CollisionHandler {

	/**
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	public static void checkIfPlayerHasCollidedWithASolidTile(MyGame myGame, MapEditor mapEditor) {
		for(int z = 0; z < mapEditor.worldMap.length; z++) {
			for(int x = 0; x < mapEditor.worldMap[z].length; x++) {
				if (mapEditor.tileMap[z][x].isSolid()) {
					if (mapEditor.tileMap[z][x].getBoundingRectangle().overlaps(myGame.gameObjectLoader.playerOne.rectangle)) {
						Player.playerShouldStopMoving = true;
						System.out.println("Player collided with solid tile!");
					}
				}
			}
		}
	}
}
