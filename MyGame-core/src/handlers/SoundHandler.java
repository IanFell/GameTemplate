package handlers;

import com.mygdx.mygame.MyGame;

import gameobjects.Heart;
import gameobjects.gamecharacters.Player;
import gameobjects.weapons.Gun;
import gameobjects.weapons.LegendSword;
import gameobjects.weapons.MagicPearl;
import helpers.GameAttributeHelper;
import inventory.Inventory;
import loaders.SoundLoader;
import loaders.cannonloader.CannonLoader;
import loaders.chestloader.ChestLoader;
import missions.MissionRawBar;
import screens.Screens;

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

			for (int i = 0; i < myGame.gameScreen.enemyHandler.enemySpawner.length; i++) {
				for (int k = 0; k < myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.size(); k++) {
					// For now make the same sound for every enemy killing.  The explosion sounds cool.
					if (myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.get(k).getPlaySound()) {
						soundLoader.bombSound.play(AudioHandler.MEDIAN_VOLUME);
						myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.get(k).setPlaySound(false);
					}
				}
			}

			for (int i = 0; i < CannonLoader.cannons.length; i++) {
				if (CannonLoader.cannons[i].isPlayBlastSound()) {
					if (CannonLoader.cannons[i].getAttackBoundary().overlaps(myGame.getGameObject(Player.PLAYER_ONE).rectangle)) {
						soundLoader.pistolSound.play(AudioHandler.QUARTER_VOLUME);
					}
					CannonLoader.cannons[i].setPlayBlastSound(false);
				}
			}

			/**
			 * This currently does not work.
			 * I cannot get the cannon balls' audio to only fire when in 
			 * the same location as the player.  Any option below will result
			 * in every single cannon ball explosion sound firing every time, regardless
			 * of where the player is vs the cannon ball.  This results in way too many explosion sounds
			 * and becomes unbarable.  
			 * 
			 * Take it out for now.
			 */
			//for (int i = 0; i < CannonBallLoader.cannonballs.size(); i++) {
			//if (CannonBallLoader.cannonballs.get(i).isPlayLandSound()) {
			//if (
			//myGame.getGameObject(Player.PLAYER_ONE).getX() < 500) {
			//if (GamePlayHelper.gameObjectIsWithinScreenBounds(CannonBallLoader.cannonballs.get(i))) {
			//if (CannonBallLoader.cannonballs.get(i).getAttackBoundary().overlaps(myGame.getGameObject(Player.PLAYER_ONE).rectangle)) {
			//soundLoader.bombSound.play(AudioHandler.QUARTER_VOLUME);
			//}
			//}
			//CannonBallLoader.cannonballs.get(i).setPlayLandSound(false);
			//}
			//}

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
			for (int i = 0; i < ChestLoader.chests.length; i++) {
				if (ChestLoader.chests[i].getPlaySound()) {
					soundLoader.chestSound.play(AudioHandler.CHEST_VOLUME);
					ChestLoader.chests[i].setPlaySound(false);
				}
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
		}
	}

	/**
	 * 
	 * @param SoundLoader soundLoader
	 */
	private void handleJumpingAudio(SoundLoader soundLoader) {
		if (Player.isJumping) {
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
