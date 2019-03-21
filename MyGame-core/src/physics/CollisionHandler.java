package physics;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.stationarygameobjects.Chest;
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
	public static void checkIfPlayerHasCollidedWithSandOrWaterTile(GameObject player, MapHandler mapHandler, Tile tile) {
		if (tile.getBoundingRectangle().overlaps(player.rectangle)) {
			if (tile.isWater()) {
				System.out.println("Player collided with water tile!");
				Player.isInWater = true;
			} else {
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
	 * @param GameObject structure
	 * @param String     structureName
	 */
	public static void checkIfPlayerHasCollidedWithStructure(GameObject player, GameObject structure, String structureName) {
		if (structure.rectangle.overlaps(player.rectangle)) {
			System.out.println("Player has collided with " + structureName + "!");
			System.exit(0);
		}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param GameObject fire
	 */
	public static void checkIfPlayerHasCollidedWithFire(GameObject player, GameObject fire) {
		if (fire.rectangle.overlaps(player.rectangle)) {
			System.out.println("Player has collided with fire!");
			System.exit(0);
		}
	}
}
