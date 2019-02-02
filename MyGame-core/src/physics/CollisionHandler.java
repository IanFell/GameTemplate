package physics;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.stationarygameobjects.GamePlayObject;
import maps.MapHandler;
import tiles.Tile;

/**
 * Handles collisions between game objects.
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
	
	/**
	 * If player collides with chest, increase player score.
	 * 
	 * @param GameObject player
	 * @param GameObject gameObject
	 */
	public static void checkIfPlayerHasCollidedWithChest(GameObject player, GameObject gameObject) {
		if (gameObject.rectangle.overlaps(player.rectangle)) {
			if (((GamePlayObject) gameObject).isClosed()) {
				((GamePlayObject) gameObject).setClosed(false);
				((Player) player).setPlayerScore(5);
				System.out.println("Player collided with chest!");
			}
		}
	}
}
