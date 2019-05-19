package handlers;

import com.mygdx.mygame.MyGame;

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

	private float baseSoundVolumeValue = 0.5f;

	/**
	 * 
	 * @param SoundLoader soundLoader
	 */
	public void handleSound(SoundLoader soundLoader, MyGame myGame) {
		if (GameAttributeHelper.gameState == Screens.GAME_SCREEN) {
			// Click sound when choosing different inventory objects.
			if (Inventory.playClickSound) {
				soundLoader.click.play(baseSoundVolumeValue);
				Inventory.playClickSound = false;
			}
			for (int i = 0; i < ChestLoader.chests.length; i++) {
				if (ChestLoader.chests[i].getPlaySound()) {
					soundLoader.sound.play(baseSoundVolumeValue);
					ChestLoader.chests[i].setPlaySound(false);
				}
			}
			if (LegendSword.playSound) {
				soundLoader.sound.play(baseSoundVolumeValue);
				LegendSword.playSound = false;
			}
			for (int i = 0; i < myGame.gameScreen.enemyHandler.enemySpawner.length; i++) {
				for (int k = 0; k < myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.size(); k++) {
					if (myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.get(k).getPlaySound()) {
						soundLoader.sound.play(baseSoundVolumeValue);
						myGame.gameScreen.enemyHandler.enemySpawner[i].enemies.get(k).setPlaySound(false);
					}
				}
			}
		}
	}
}
