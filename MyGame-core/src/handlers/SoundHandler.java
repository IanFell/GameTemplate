package handlers;

import com.mygdx.mygame.MyGame;

import gameobjects.Heart;
import gameobjects.gamecharacters.Player;
import gameobjects.weapons.LegendSword;
import helpers.GameAttributeHelper;
import inventory.Inventory;
import loaders.SoundLoader;
import loaders.chestloader.ChestLoader;
import screens.Screens;

/**
 * Handles game sounds.
 * 
 * @author Fabulous Fellini
 *
 */
public class SoundHandler {
	
	private int soundId = 0; 

	private boolean startLandingAudio = false;

	private int attackTimer    = 0;
	private int inventoryTimer = 0;
	private int jumpTimer      = 0;

	/**
	 * 
	 * @param SoundLoader soundLoader
	 */
	public void handleSound(SoundLoader soundLoader, MyGame myGame) {
		if (GameAttributeHelper.gameState == Screens.GAME_SCREEN) {
			if (LegendSword.playSound) {
				soundLoader.pickUpSwordSound.play(AudioHandler.PICK_UP_SWORD_VOLUME);
				LegendSword.playSound = false;
			}

			for (int i = 0; i < myGame.gameScreen.enemyHandler.enemySpawner.length; i++) {
				for (int k = 0; k < myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.size(); k++) {
					if (myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.get(k).getPlaySound()) {
						soundLoader.enemyDeathSound.play(AudioHandler.MAX_VOLUME);
						myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.get(k).setPlaySound(false);
					}
				}
			}

			attackTimer++;
			if (attackTimer > 2) {
				attackTimer = 0;
			}
			if (Player.playerIsPerformingAttack) {
				if (attackTimer > 1) {
					soundLoader.swordSound.play(AudioHandler.MEDIAN_VOLUME);
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
				inventoryTimer = 0;
			}
			if (Inventory.playClickSound) {
				if (inventoryTimer > 1) {
					soundLoader.clickSound.play(AudioHandler.MAX_VOLUME);
					Inventory.playClickSound = false;
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
				soundLoader.swordSound.setVolume(soundId, AudioHandler.MAX_VOLUME);
				soundLoader.swordSound.play();
			}
			jumpTimer++;
		} else {
			jumpTimer = 0;
		}
	}

	/**
	 * 
	 * @param SoundLoader soundLoader
	 */
	private void handleLandingAudio(SoundLoader soundLoader) {
		if (startLandingAudio && Player.jumpingAction == Player.ON_GROUND) {
			soundLoader.swordSound.setVolume(soundId, AudioHandler.MAX_VOLUME);
			soundLoader.swordSound.play();
			startLandingAudio = false;
		}
		if (Player.isJumping) {
			startLandingAudio = true;
		}
	}
}
