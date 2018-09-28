package physics;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import maps.MapHandler;
import tiles.Tile;

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
	 * @param Tile       tile
	 */
	public static void checkIfPlayerHasCollidedWithASolidTile(MyGame myGame, MapHandler mapHandler, Tile tile) {
		if (tile.isSolid()) {
			if (tile.getBoundingRectangle().overlaps(myGame.getGameObject(GameObject.PLAYER_ONE).rectangle)) {
				Player.playerShouldStopMoving = true;
				System.out.println("Player collided with solid tile!");
			}
		}
	}
}
