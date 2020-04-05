package handlers;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import cutscenes.CutScene;
import gameobjects.GameObject;
import gameobjects.Heart;
import gameobjects.Rum;
import gameobjects.gamecharacters.Enemy;
import gameobjects.gamecharacters.Player;
import gameobjects.nature.Feather;
import gameobjects.nature.QuickSand;
import gameobjects.stationarygameobjects.Chest;
import gameobjects.weapons.CannonBall;
import gameobjects.weapons.Gun;
import gameobjects.weapons.LegendSword;
import gameobjects.weapons.MagicPearl;
import gameobjects.weapons.Weapon;
import inventory.Inventory;
import loaders.GameObjectLoader;
import maps.MapHandler;
import missions.MissionChests;
import missions.MissionLegendOfTheSevenSwords;
import missions.MissionStumpHole;
import tiles.Tile;
import ui.LocationMarker;

/**
 * Handles collisions between game objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class CollisionHandler {

	// Keep track of enemy collision timing for player health.
	//private static int enemyTimer = 0;

	// Keep track of quick sand collision timing for player health.
	private static int quickSandTimer = 0;

	private final static int HEALTH_TIMER_MAX = 25;

	// Times the removal of hearts so they don't dissapear really fast and kill the player.
	private final static int HEALTH_TIMER_TRIGGER = 24;

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
				Player.isInWater = true;
			} else {
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
			float offset = 0.5f;
			switch (Player.direction) {
			case Player.DIRECTION_LEFT:
				player.setX(player.getX() + Player.PLAYER_SPEED + offset);
				break;
			case Player.DIRECTION_RIGHT:
				player.setX(player.getX() - Player.PLAYER_SPEED - offset);
				break;
			case Player.DIRECTION_UP:
				player.setY(player.getY() + Player.PLAYER_SPEED + offset);
				break;
			case Player.DIRECTION_DOWN:
				player.setY(player.getY() - Player.PLAYER_SPEED - offset);
				break;
			} 
			if (chest.isClosed()) {
				chest.setChestValuesAfterCollisionWithPlayer();
				((Player) player).updatePlayerLoot(Chest.LOOT_VALUE);

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
			if (structureName.equalsIgnoreCase("Raw Bar")) {
				// Start the mission.
				//MissionRawBar.startMission = true;
			} else if (structureName.equalsIgnoreCase("Trading Post")) {
				//TradingPost.hasBeenEntered = true;
			}
			/*
			if (structureName.equalsIgnoreCase("Tee Pee")) {
				new TeePeeScreen(myGame);
			} */
		}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param GameObject fire
	 */
	public static void checkIfPlayerHasCollidedWithFire(GameObject player, GameObject fire) {
		if (fire.rectangle.overlaps(player.rectangle)) {}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param GameObject legendSword
	 */
	public static void checkIfPlayerHasCollidedWithLegendSword(GameObject player, GameObject legendSword) {
		if (legendSword.rectangle.overlaps(player.rectangle)) {
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

			legendSword.hasBeenCollected            = true;
			LegendSword.playSound                   = true;
			Inventory.inventoryHasStartedCollection = true;
		}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param GameObject gun
	 */
	public static void checkIfPlayerHasCollidedWithGun(GameObject player, GameObject gun) {
		// Only collect gun if we have enough loot.
		if (player.getPlayerLoot() >= Gun.LOOT_NEEDED_TO_BUY_GUN) {
			if (gun.rectangle.overlaps(player.rectangle)) {
				((Player) player).getInventory().addObjectToInventory(gun);
				Inventory.inventoryHasStartedCollection = true;
				Gun.hasBeenCollected                    = true;
				Gun.playCollectionSound                 = true;
				GameObjectLoader.gameObjectList.add(gun);
				// Remove loot (player has bought gun).
				player.updatePlayerLoot(-Gun.LOOT_NEEDED_TO_BUY_GUN);
			}
		}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param GameObject gun
	 */
	public static void checkIfPlayerHasCollidedWithMagicPearl(GameObject player, GameObject pearl) {
		if (pearl.rectangle.overlaps(player.rectangle)) {
			((Player) player).getInventory().addObjectToInventory(pearl);
			Inventory.inventoryHasStartedCollection = true;
			pearl.hasBeenCollected                  = true;
			MagicPearl.playCollectionSound          = true;
			GameObjectLoader.gameObjectList.add(pearl);
		}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param GameObject birdWeapon
	 */
	public static void checkIfPlayerHasCollidedWithBirdWeapon(GameObject player, GameObject birdWeapon) {
		if (birdWeapon.rectangle.overlaps(player.rectangle)) {
			((Player) player).getInventory().addObjectToInventory(birdWeapon);
			Inventory.inventoryHasStartedCollection = true;
			birdWeapon.hasBeenCollected             = true;
			//MagicPearl.playCollectionSound        = true;
			GameObjectLoader.gameObjectList.add(birdWeapon);
		}
	}

	/**
	 * 
	 * @param Enemy  enemy
	 * @param Weapon weapon
	 */
	public static void checkIfWeaponHasCollidedWithEnemy(Enemy enemy, Weapon weapon) {
		if (weapon instanceof LegendSword) {
			if (Player.playerIsPerformingAttack && Inventory.inventoryIsEquipped) {
				// Checking if dead is false keeps the sound from playing repeatedly.
				if (enemy.rectangle.overlaps(weapon.rectangle) && !enemy.isDead()) {
					handleEnemyDeath(enemy);
				}
			}
		}
	}

	/**
	 * 
	 * @param Enemy  enemy
	 * @param Weapon weapon
	 */
	public static void checkIfProjectileHasCollidedWithEnemy(Enemy enemy, Weapon weapon)  {
		if (Inventory.inventoryIsEquipped) {  
			// Checking if dead is false keeps the sound from playing repeatedly.
			if (enemy.rectangle.overlaps(weapon.rectangle) /*&& !enemy.isDead()*/) {
				handleEnemyDeath(enemy);
			}
		}
	}

	/**
	 * 
	 * @param Player     player
	 * @param CannonBall cannonBall
	 */
	public static void checkIfCannonBallHasCollidedWithPlayer(Player player, CannonBall cannonBall)  {
		if (player.rectangle.overlaps(cannonBall.rectangle) && !cannonBall.isCannonBallHasHitPlayer()) {
			if (!Player.isInvincible) {
				player.setHealth(player.getHealth() - 1);
			}
			cannonBall.setCannonBallHasHitPlayer(true);
			// Make cannonball stop and hit player and explode instead of going through him.
			cannonBall.setDx(0);
		}
	}

	/**
	 * 
	 * @param Enemy  enemy
	 * @param Player player
	 */
	public static void checkIfEnemyHasCollidedWithPlayer(Enemy enemy, Player player) {
		if (enemy.rectangle.overlaps(player.rectangle)) {
			/*
			// Use this so enemies don't drain player's health really quick.
			enemyTimer++;
			if (enemyTimer > HEALTH_TIMER_MAX) {
				enemyTimer = 0;
			}
			// Comment this out to prevent death.
			if (enemyTimer > HEALTH_TIMER_TRIGGER) {
				// Put this here so player can't get hurt in cutscene.
				if (!CutScene.anyCutSceneIsInProgress) {
					if (!Player.isInvincible) {
						player.setHealth(player.getHealth() - 1);
					}
				}
			} */

			// Kill enemy if he is overlapping with player while player is performing attack.
			if (Player.jumpingAction == Player.DESCENDING_JUMP) {
				handleEnemyDeath(enemy);
				// Player should bounce back upon attacking an enemy with a jump.
				player.setBouncingBack(true);
			} else {
				// Lets try this instead of the above method to see how it works out.
				if (!CutScene.anyCutSceneIsInProgress) {
					if (!Player.isInvincible) {
						player.setHealth(player.getHealth() - 1);
						player.setPlaySound(true);
					}
				}
				player.setBouncingBack(true);
			}
		}
	}

	/**
	 * 
	 * @param Enemy enemy
	 */
	private static void handleEnemyDeath(Enemy enemy) {
		enemy.setIsDead(true);
		enemy.setPlaySound(true);
	}

	/**
	 * 
	 * @param GameObject player
	 * @param Heart      heart
	 */
	public static void checkIfPlayerCollidedWithHeart(GameObject player, Heart heart) {
		if (player.rectangle.overlaps(heart.rectangle)) {
			heart.setHasBeenCollected(true);
			((Player) player).setHealth(player.getHealth() + Heart.HEALTH);
			Heart.playSound = true;
		}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param QuickSand  quickSand
	 */
	public static void checkIfPlayerCollidedWithQuickSand(GameObject player, QuickSand quickSand) {
		if (player.rectangle.overlaps(quickSand.rectangle)) {
			// Use this so quick sand doesn't drain player's health really quick.
			quickSandTimer++;
			if (quickSandTimer > HEALTH_TIMER_MAX) {
				quickSandTimer = 0;
			}
			// Comment this out to prevent death.
			if (quickSandTimer > HEALTH_TIMER_TRIGGER) {
				player.setHealth(player.getHealth() - Heart.HEALTH);
			}

			//Heart.playSound = true;
			Player.quickSandTimer = 0;
			Player.isInQuickSand  = true;
		}
	}

	/**
	 * 
	 * @param GameObject player
	 * @param Rum        rum
	 */
	public static void checkIfPlayerCollidedWithRum(GameObject player, Rum rum) {
		if (player.rectangle.overlaps(rum.rectangle)) {
			rum.setHasBeenCollected(true);
			Rum.playSound = true;
			RumHandler.rumCount++;
		}
	}

	/**
	 * Collision with a stump starts the mission.
	 * 
	 * @param GameObject player
	 * @param Stump      stump
	 */
	/*
	public static void checkIfPlayerCollidedWithStump(GameObject player, Stump stump) {
		if (player.rectangle.overlaps(stump.rectangle) && MissionRawBar.rawBarMissionComplete) {
			MissionStumpHole.missionIsActive = true;
		}
	} */

	/**
	 * This method does not use the regular player.
	 * Instead, it uses the unique rectangle (player) from MissionStumpHole.
	 * 
	 * @param Rectangle player
	 * @param Feather   feather
	 */
	public static void checkIfPlayerHasCollidedWithFeather(Rectangle player, Feather feather) {
		if (player.overlaps(feather.rectangle)) {
			if (!feather.hasBeenCollected) {
				MissionStumpHole.playerFeatherScore += MissionStumpHole.FEATHER_VALUE;
				feather.hasBeenCollected = true;
				Feather.playSound        = true;
			}
		}
	}

	/**
	 * Attack bird is in Stump Hole mission.
	 * 
	 * @param GameObject player
	 * @param Rectangle  birdWeapon
	 */
	public static void checkIfPlayerHasCollidedWithAttackBird(GameObject player, Rectangle birdWeapon) {
		if (birdWeapon.overlaps(player.rectangle)) {
			if (!Player.isInvincible) {
				player.setHealth(player.getHealth() - 1);
			}
		}
	}

	/**
	 * 
	 * @param GameObject     player
	 * @param LocationMarker locationMarker
	 * @return boolean
	 */
	public static boolean playerHasCollidedWithLocationMarker(GameObject player, LocationMarker locationMarker) {
		// This checks if we should play the beeping sound to alert player he is close to a locator.
		int soundBoundaryOffset = 10;
		if (
				player.getX() > locationMarker.getLocator().getX() - soundBoundaryOffset && 
				player.getX() < locationMarker.getLocator().getX() - soundBoundaryOffset + locationMarker.getLocator().getWidth() + soundBoundaryOffset &&
				player.getY() > locationMarker.getLocator().getY() - soundBoundaryOffset && 
				player.getY() < locationMarker.getLocator().getY() - soundBoundaryOffset + locationMarker.getLocator().getHeight() + soundBoundaryOffset

				) {
			LocationMarker.playerIsWithinSoundBounds = true;
		} else {
			LocationMarker.playerIsWithinSoundBounds = false;
		}
		// This checks if player has actually hit the location marker itself.
		if (player.rectangle.overlaps(locationMarker.getLocator())) {
			LocationMarker.playSound = true;
			return true;
		}
		return false;
	}
}