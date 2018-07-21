package physics;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
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
		for(int z = 0; z < mapEditor.worldMap2027.length; z++) {
			for(int x = 0; x < mapEditor.worldMap2027[z].length; x++) {
				if (mapEditor.tileMap2027[z][x].isSolid()) {
					if (mapEditor.tileMap2027[z][x].getBoundingRectangle().overlaps(myGame.getGameObject(GameObject.PLAYER_ONE).rectangle)) {
						Player.playerShouldStopMoving = true;
						System.out.println("Player collided with solid tile!");
					}
				}
			}
		}
	}
}
