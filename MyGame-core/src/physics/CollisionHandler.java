package physics;

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
	 * @param GameObject player
	 * @param MapHandler mapHandler
	 * @param Tile       tile
	 */
	public static void checkIfPlayerHasCollidedWithASolidTile(GameObject player, MapHandler mapHandler, Tile tile) {
		if (tile.isSolid()) {
			if (tile.getBoundingRectangle().overlaps(player.rectangle)) {
				System.out.println("Player collided with solid tile!");
				player.stopPlayer();
				// Move player so he is not longer overlapping tile bounds.
				switch (player.getDirection()) {
				case Player.DIRECTION_LEFT:
					player.setX(player.getX() + Player.PLAYER_SPEED);
					break;
				case Player.DIRECTION_RIGHT:
					player.setX(player.getX() - Player.PLAYER_SPEED);
					break;
				case Player.DIRECTION_UP:
					player.setY(player.getY() + Player.PLAYER_SPEED);
					break;
				case Player.DIRECTION_DOWN:
					player.setY(player.getY() - Player.PLAYER_SPEED);
					break;
				}
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
