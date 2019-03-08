package physics;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.stationarygameobjects.Chest;
import gameobjects.stationarygameobjects.RawBar;
import gameobjects.stationarygameobjects.TeePee;
import maps.MapHandler;
import missions.MissionChests;
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
	public static void checkIfPlayerHasCollidedWithSolidTile(GameObject player, MapHandler mapHandler, Tile tile) {
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
	 * 
	 * @param GameObject player
	 * @param MapHandler mapHandler
	 * @param Tile       tile
	 */
	public static void checkIfPlayerHasCollidedWithWaterTile(GameObject player, MapHandler mapHandler, Tile tile) {
		if (tile.isWater()) {
			if (tile.getBoundingRectangle().overlaps(player.rectangle)) {
				System.out.println("Player collided with water tile!");
				Player.isInWater = true;
			} 
		} 
	}

	/**
	 * 
	 * @param GameObject player
	 * @param MapHandler mapHandler
	 * @param Tile       tile
	 */
	public static void checkIfPlayerHasCollidedWithSandTile(GameObject player, MapHandler mapHandler, Tile tile) {
		if (!tile.isWater()) {
			if (tile.getBoundingRectangle().overlaps(player.rectangle)) {
				System.out.println("Player collided with sand tile!");
				Player.isInWater = false;
			} 
		} 
	}

	/**
	 * If player collides with chest, increase player score and play chest opening sound.
	 * 
	 * @param GameObject player
	 * @param Chest      chest
	 */
	public static void checkIfPlayerHasCollidedWithChest(GameObject player, Chest chest) {
		if (chest.rectangle.overlaps(player.rectangle)) {
			if (chest.isClosed()) {
				chest.setChestValuesAfterCollisionWithPlayer();
				((Player) player).updatePlayerScore(5);
				System.out.println("Player collided with chest!");

				// Testing mission.  Later, this will be controlled.  Right now, it is always on.
				if (MissionChests.executeMission) {
					MissionChests.increaseNumberOfChestsOpened();
				}
			}
		}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param TeePee     teePee
	 */
	public static void checkIfPlayerHasCollidedWithTeePee(GameObject player, TeePee teePee) {
		if (teePee.rectangle.overlaps(player.rectangle)) {
			System.out.println("Player has collided with tee pee!");
			System.exit(0);
		}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param RawBar     rawbar
	 */
	public static void checkIfPlayerHasCollidedWithRawBar(GameObject player, RawBar rawbar) {
		if (rawbar.rectangle.overlaps(player.rectangle)) {
			System.out.println("Player has collided with Raw Bar!");
			System.exit(0);
		}
	}
}
