package physics;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import maps.MapHandler;

/**
 * Class to handle collisions between game objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class CollisionHandler {

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public static void checkIfPlayerHasCollidedWithASolidTile(MyGame myGame, MapHandler mapHandler) {
		for(int z = 0; z < mapHandler.mapChunkOne.worldMap.length; z++) {
			for(int x = 0; x < mapHandler.mapChunkOne.worldMap[z].length; x++) {
				if (mapHandler.mapChunkOne.tileMap[z][x].isSolid()) {
					if (mapHandler.mapChunkOne.tileMap[z][x].getBoundingRectangle().overlaps(myGame.getGameObject(GameObject.PLAYER_ONE).rectangle)) {
						Player.playerShouldStopMoving = true;
						System.out.println("Player collided with solid tile!");
					}
				}
			}
		}
	}
}
