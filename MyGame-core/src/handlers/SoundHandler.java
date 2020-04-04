package handlers;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.Heart;
import gameobjects.Rum;
import gameobjects.gamecharacters.Player;
import gameobjects.nature.Feather;
import gameobjects.weapons.Gun;
import gameobjects.weapons.LegendSword;
import gameobjects.weapons.MagicPearl;
import helpers.GameAttributeHelper;
import inventory.Inventory;
import loaders.SoundLoader;
import loaders.cannonballloader.CannonBallLoader;
import loaders.cannonloader.CannonLoader;
import loaders.chestloader.ChestLoader;
import missions.MissionRawBar;
import missions.MissionStumpHole;
import screens.Screens;
import ui.LocationMarker;

/**
 * Handles game sounds.
 * 
 * @author Fabulous Fellini
 *
 */
public class SoundHandler {

	private boolean startLandingAudio = false;

	private int attackTimer    = GameAttributeHelper.TIMER_START_VALUE;
	private int inventoryTimer = GameAttributeHelper.TIMER_START_VALUE;
	private int jumpTimer      = GameAttributeHelper.TIMER_START_VALUE;

	/**
	 * 
	 * @param SoundLoader soundLoader
	 * @param MyGame      myGame
	 */
	public void handleSound(SoundLoader soundLoader, MyGame myGame) {
		if (GameAttributeHelper.gameState == Screens.GAME_SCREEN) {
			if (LegendSword.playSound) {
				soundLoader.pickUpSwordSound.play(AudioHandler.PICK_UP_SWORD_VOLUME);
				LegendSword.playSound = false;
			}
			if (Gun.playCollectionSound) {
				soundLoader.pickUpGunSound.play(AudioHandler.MAX_VOLUME);
				Gun.playCollectionSound = false;
			}
			if (MagicPearl.playCollectionSound) {
				soundLoader.bubbleSound.play(AudioHandler.MAX_VOLUME);
				MagicPearl.playCollectionSound = false;
			}
			if (MissionRawBar.playCollectionSound) {
				soundLoader.bubbleSound.play(AudioHandler.MAX_VOLUME);
				MissionRawBar.playCollectionSound = false;
			}

			handleEnemyDeathSound(myGame, soundLoader);
			handleCannonSound(myGame, soundLoader);

			// Handle the landing/explosion of the cannon balls.
			for (int i = 0; i < CannonBallLoader.cannonballs.size(); i++) {
				if (CannonBallLoader.cannonballs.get(i).getAttackBoundary().overlaps(myGame.getGameObject(Player.PLAYER_ONE).rectangle)) {
					if (CannonBallLoader.cannonballs.get(i).isPlayLandSound()) {
						soundLoader.bombSound.play(AudioHandler.EIGHTH_VOLUME);
						CannonBallLoader.cannonballs.get(i).setPlayLandSound(false);
					}
				}
			}

			attackTimer++;
			if (attackTimer > 2) {
				attackTimer = GameAttributeHelper.TIMER_START_VALUE;
			}
			if (Player.playerIsPerformingAttack) {
				if (attackTimer > 1) {
					if (myGame.getGameObject(Player.PLAYER_ONE).getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) instanceof LegendSword) {
						soundLoader.swordSound.play(AudioHandler.MAX_VOLUME);
					} else if (myGame.getGameObject(Player.PLAYER_ONE).getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) instanceof Gun) {
						soundLoader.pistolSound.play(AudioHandler.MEDIAN_VOLUME);
					} else {
						soundLoader.bubbleSound.play(AudioHandler.MAX_VOLUME);
					}
				}
			}

			// Collectibles.
			if (Heart.playSound) {
				soundLoader.heartSound.play(AudioHandler.MAX_VOLUME);
				Heart.playSound = false;
			}
			if (Rum.playSound) {
				soundLoader.rumSound.play(AudioHandler.MAX_VOLUME);
				Rum.playSound = false;
			}
			for (int i = 0; i < ChestLoader.chests.length; i++) {
				if (ChestLoader.chests[i].getPlaySound()) {
					soundLoader.chestSound.play(AudioHandler.CHEST_VOLUME);
					ChestLoader.chests[i].setPlaySound(false);
				}
			}
			if (Feather.playSound) {
				soundLoader.pickUpSwordSound.play(AudioHandler.MAX_VOLUME);
				Feather.playSound = false;
			}

			// Click sound when choosing different inventory objects.
			inventoryTimer++;
			if (inventoryTimer > 2) {
				inventoryTimer = GameAttributeHelper.TIMER_START_VALUE;
			}
			if (Inventory.playClickSound) {
				if (inventoryTimer < 1) {
					soundLoader.clickSound.play(AudioHandler.MAX_VOLUME);
					Inventory.playClickSound = false;
					inventoryTimer           = GameAttributeHelper.TIMER_START_VALUE;
				}
			}
			handleJumpingAudio(soundLoader);
			handleLandingAudio(soundLoader);
			
			if (LocationMarker.playSound) {
				soundLoader.clickSound.play(AudioHandler.MAX_VOLUME);
				LocationMarker.playSound = false;
			}
		}
	}

	/**
	 * Handles sound when cannon fires or knight dies.
	 * 
	 * @param MyGame      myGame
	 * @param SoundLoader soundLoader
	 */
	private void handleCannonSound(MyGame myGame, SoundLoader soundLoader) {
		for (int i = 0; i < CannonLoader.cannons.length; i++) {
			if (CannonLoader.cannons[i].isPlayBlastSound()) {
				GameObject player = myGame.getGameObject(Player.PLAYER_ONE);
				if (CannonLoader.cannons[i].getAttackBoundary().overlaps(player.rectangle)) {
					soundLoader.cannonFire.play(AudioHandler.MAX_VOLUME);

				}
				CannonLoader.cannons[i].setPlayBlastSound(false);

				// If the knight dies.
				if (CannonLoader.cannons[i].knight.getPlaySound()) {
					soundLoader.enemyDeathSound.play(AudioHandler.MAX_VOLUME);
					CannonLoader.cannons[i].knight.setPlaySound(false);
				}
			}
		}
	}

	/**
	 * 
	 * @param MyGame      myGame
	 * @param SoundLoader soundLoader
	 */
	private void handleEnemyDeathSound(MyGame myGame, SoundLoader soundLoader) {
		for (int i = 0; i < myGame.gameScreen.enemyHandler.enemySpawner.length; i++) {
			for (int k = 0; k < myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.size(); k++) {
				// For now make the same sound for every enemy killing.  
				if (myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.get(k).getPlaySound()) {
					soundLoader.enemyDeathSound.play(AudioHandler.MAX_VOLUME);
					myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.get(k).setPlaySound(false);
				}
			}
		}
		for (int i = 0; i < myGame.gameScreen.gruntHandler.gruntSpawner.length; i++) {
			for (int k = 0; k < myGame.gameScreen.gruntHandler.gruntSpawner[i].grunts.size(); k++) {
				// For now make the same sound for every grunt killing.  
				if (myGame.gameScreen.gruntHandler.gruntSpawner[i].grunts.get(k).getPlaySound()) {
					soundLoader.enemyDeathSound.play(AudioHandler.MAX_VOLUME);
					myGame.gameScreen.gruntHandler.gruntSpawner[i].grunts.get(k).setPlaySound(false);
				}
			}
		}
		for (int i = 0; i < GiantHandler.giants.length; i++) {
			if (GiantHandler.giants[i].getPlaySound()) {
				soundLoader.enemyDeathSound.play(AudioHandler.MAX_VOLUME);
				GiantHandler.giants[i].setPlaySound(false);
			}
		}
	}

	/**
	 * This also handles jumping audio in Stump Hole mission.
	 * We use a different jumping variable in Stump Hole mission so the camera doesn't
	 * move everytime the player jumps in that mission.
	 * 
	 * @param SoundLoader soundLoader
	 */
	private void handleJumpingAudio(SoundLoader soundLoader) {
		if (Player.isJumping || MissionStumpHole.jumpSoundShouldPlay) {
			if (jumpTimer < 1) {
				soundLoader.jumpSound.play(AudioHandler.JUMP_VOLUME);
			}
			jumpTimer++;
			if (jumpTimer > 50) {
				jumpTimer = GameAttributeHelper.TIMER_START_VALUE;
			}
		} else {
			jumpTimer = GameAttributeHelper.TIMER_START_VALUE;
		}
	}

	/**
	 * 
	 * @param SoundLoader soundLoader
	 */
	private void handleLandingAudio(SoundLoader soundLoader) {
		if (startLandingAudio && Player.jumpingAction == Player.ON_GROUND) {
			soundLoader.landSound.play(AudioHandler.LAND_VOLUME);
			startLandingAudio = false;
		}
		if (Player.isJumping) {
			startLandingAudio = true;
		}
	}
}
