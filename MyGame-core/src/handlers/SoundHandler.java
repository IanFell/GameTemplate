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

	/**
	 * 
	 * @param SoundLoader soundLoader
	 */
	public void handleSound(SoundLoader soundLoader, MyGame myGame) {
		if (GameAttributeHelper.gameState == Screens.GAME_SCREEN) {
			for (int i = 0; i < ChestLoader.chests.length; i++) {
				if (ChestLoader.chests[i].getPlaySound()) {
					soundLoader.sound.play(0.5f);
					ChestLoader.chests[i].setPlaySound(false);
				}
			}
			if (LegendSword.playSound) {
				soundLoader.sound.play(0.5f);
				LegendSword.playSound = false;
			}
			// Click sound when choosing different inventory objects.
			if (Inventory.playClickSound) {
				soundLoader.click.play(0.5f);
				Inventory.playClickSound = false;
			}
			for (int i = 0; i < myGame.gameScreen.enemySpawner.enemies.size(); i++) {
				if (myGame.gameScreen.enemySpawner.enemies.get(i).getPlaySound()) {
					soundLoader.sound.play(0.5f);
					myGame.gameScreen.enemySpawner.enemies.get(i).setPlaySound(false);
				}
			}
		}
	}
}
