package handlers;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Enemy;
import gameobjects.gamecharacters.Player;
import gameobjects.stationarygameobjects.Chest;
import gameobjects.weapons.Gun;
import gameobjects.weapons.LegendSword;
import gameobjects.weapons.Weapon;
import inventory.Inventory;
import maps.MapHandler;
import missions.MissionChests;
import missions.MissionLegendOfTheSevenSwords;
import screens.RawBarScreen;
import screens.TeePeeScreen;
import tiles.Tile;

/**
 * Handles collisions between game objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class CollisionHandler {

	/**
	 * Only player can collide with solid tiles.
	 * NPCs can walk through them.
	 * 
	 * Currently player is set to be able to walk through a solid tile.
	 * 
	 * @param GameObject player
	 * @param MapHandler mapHandler
	 * @param Tile       tile
	 */
	public static void checkIfPlayerHasCollidedWithSolidTile(GameObject player, MapHandler mapHandler, Tile tile) {
		if (tile.isSolid()) {
			if (tile.getBoundingRectangle().overlaps(player.rectangle)) {
				System.out.println("Player collided with solid tile!");
				// Move player so he is not longer overlapping tile bounds.
				switch (Player.direction) {
				case Player.DIRECTION_LEFT:
					//player.setX(player.getX() + Player.PLAYER_SPEED);
					break;
				case Player.DIRECTION_RIGHT:
					//player.setX(player.getX() - Player.PLAYER_SPEED);
					break;
				case Player.DIRECTION_UP:
					//player.setY(player.getY() + Player.PLAYER_SPEED);
					break;
				case Player.DIRECTION_DOWN:
					//player.setY(player.getY() - Player.PLAYER_SPEED);
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
	 * 
	 * @param GameObject player
	 * @param MapHandler mapHandler
	 * @param Tile       tile
	 */
	public static void checkIfNPCHasCollidedWithSandOrWaterTile(Enemy enemy, MapHandler mapHandler, Tile tile) {
		if (tile.getBoundingRectangle().overlaps(enemy.rectangle)) {
			if (tile.isWater()) {
				System.out.println("NPC collided with water tile!");
				switch(enemy.getEnemyDirection()) {
				case Enemy.DIRECTION_LEFT:
					enemy.moveRight(Player.PLAYER_SPEED);
					break;
				case Enemy.DIRECTION_RIGHT:
					enemy.moveLeft(Player.PLAYER_SPEED);
					break;
				case Enemy.DIRECTION_UP:
					enemy.moveDown(Player.PLAYER_SPEED);
					break;
				case Enemy.DIRECTION_DOWN:
					enemy.moveUp(Player.PLAYER_SPEED);
					break;
				}
			} else {
				System.out.println("NPC collided with sand tile!");
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
	 * @param MyGame     myGame
	 */
	public static void checkIfPlayerHasCollidedWithStructure(
			GameObject player, 
			GameObject structure, 
			String structureName, 
			MyGame myGame
			) {
		if (structure.rectangle.overlaps(player.rectangle)) {
			System.out.println("Player has collided with " + structureName + "!");
			if (structureName.equalsIgnoreCase("Raw Bar")) {
				new RawBarScreen(myGame);
			}
			if (structureName.equalsIgnoreCase("Tee Pee")) {
				new TeePeeScreen(myGame);
			}
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
		}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param GameObject legendSword
	 */
	public static void checkIfPlayerHasCollidedWithLegendSword(GameObject player, GameObject legendSword) {
		if (legendSword.rectangle.overlaps(player.rectangle)) {
			System.out.println("Player has collided with Legend Sword!");
			MissionLegendOfTheSevenSwords.swordsCollected++;
			MissionLegendOfTheSevenSwords.legendSwordCollection.add(legendSword);
			((Player) player).getInventory().addObjectToInventory(legendSword);

			// Uncomment this to fill up inventory.
			/*
			((Player) player).getInventory().addObjectToInventory(legendSword);
			((Player) player).getInventory().addObjectToInventory(legendSword);
			((Player) player).getInventory().addObjectToInventory(legendSword);
			((Player) player).getInventory().addObjectToInventory(legendSword);
			((Player) player).getInventory().addObjectToInventory(legendSword);
			((Player) player).getInventory().addObjectToInventory(legendSword);
			((Player) player).getInventory().addObjectToInventory(legendSword);
			((Player) player).getInventory().addObjectToInventory(legendSword);
			((Player) player).getInventory().addObjectToInventory(legendSword);
			((Player) player).getInventory().addObjectToInventory(legendSword);
			((Player) player).getInventory().addObjectToInventory(legendSword); */

			legendSword.hasBeenCollected = true;
			LegendSword.playSound        = true;
		}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param GameObject gun
	 */
	public static void checkIfPlayerHasCollidedWithGun(GameObject player, GameObject gun) {
		if (!Gun.hasBeenCollected) {
			if (gun.rectangle.overlaps(player.rectangle)) {
				System.out.println("Player has collided with Gun!");
				((Player) player).getInventory().addObjectToInventory(gun);
				Gun.hasBeenCollected = true;
			}
		}
	}

	/**
	 * 
	 * @param Enemy      enemy
	 * @param GameObject weapon
	 */
	public static void checkIfWeaponHasCollidedWithEnemy(Enemy enemy, Weapon weapon) {
		if (Player.playerIsPerformingAttack && Inventory.inventoryIsEquipped) {
			if (enemy.rectangle.overlaps(weapon.rectangle)) {
				System.out.println("Weapon has collided with Object!");
				enemy.setIsDead(true);
				enemy.setPlaySound(true);
			}
		}
	}

	/**
	 * 
	 * @param Enemy  enemy
	 * @param Player player
	 */
	public static void checkIfEnemyHasCollidedWithPlayer(Enemy enemy, Player player) {
		if (enemy.rectangle.overlaps(player.rectangle)) {
			System.out.println("Player is being attacked by enemy!");
			// Comment this out to prevent death.
			//player.setHealth(player.getHealth() + Enemy.DAMAGE_INFLICTED);

			// Kill enemy if he is overlapping with player while player is performing attack.
			if (Player.playerIsPerformingAttack) {
				enemy.setIsDead(true);
				enemy.setPlaySound(true);
			}
		}
	}
}