package handlers;

import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Enemy;
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
				soundLoader.sound.play(0.5f);
				Inventory.playClickSound = false;
			}
			
			if (Enemy.playSound) {
				soundLoader.sound.play(0.5f);
				Enemy.playSound = false;
			}
		}
	}
}
