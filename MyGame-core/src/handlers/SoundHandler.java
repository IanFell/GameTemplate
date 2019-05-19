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
			for (int i = 0; i < myGame.gameScreen.enemySpawnerMexicoBeach.enemies.size(); i++) {
				if (myGame.gameScreen.enemySpawnerMexicoBeach.enemies.get(i).getPlaySound()) {
					soundLoader.sound.play(baseSoundVolumeValue);
					myGame.gameScreen.enemySpawnerMexicoBeach.enemies.get(i).setPlaySound(false);
				}
			}
			for (int i = 0; i < myGame.gameScreen.enemySpawnerPortStJoe.enemies.size(); i++) {
				if (myGame.gameScreen.enemySpawnerPortStJoe.enemies.get(i).getPlaySound()) {
					soundLoader.sound.play(baseSoundVolumeValue);
					myGame.gameScreen.enemySpawnerPortStJoe.enemies.get(i).setPlaySound(false);
				}
			}
			for (int i = 0; i < myGame.gameScreen.enemySpawnerThePoint.enemies.size(); i++) {
				if (myGame.gameScreen.enemySpawnerThePoint.enemies.get(i).getPlaySound()) {
					soundLoader.sound.play(baseSoundVolumeValue);
					myGame.gameScreen.enemySpawnerThePoint.enemies.get(i).setPlaySound(false);
				}
			}
			for (int i = 0; i < myGame.gameScreen.enemySpawnerWewa.enemies.size(); i++) {
				if (myGame.gameScreen.enemySpawnerWewa.enemies.get(i).getPlaySound()) {
					soundLoader.sound.play(baseSoundVolumeValue);
					myGame.gameScreen.enemySpawnerWewa.enemies.get(i).setPlaySound(false);
				}
			}
			for (int i = 0; i < myGame.gameScreen.enemySpawnerApalachicola.enemies.size(); i++) {
				if (myGame.gameScreen.enemySpawnerApalachicola.enemies.get(i).getPlaySound()) {
					soundLoader.sound.play(baseSoundVolumeValue);
					myGame.gameScreen.enemySpawnerApalachicola.enemies.get(i).setPlaySound(false);
				}
			}
			for (int i = 0; i < myGame.gameScreen.enemySpawnerStGeorge.enemies.size(); i++) {
				if (myGame.gameScreen.enemySpawnerStGeorge.enemies.get(i).getPlaySound()) {
					soundLoader.sound.play(baseSoundVolumeValue);
					myGame.gameScreen.enemySpawnerStGeorge.enemies.get(i).setPlaySound(false);
				}
			}
			for (int i = 0; i < myGame.gameScreen.enemySpawnerCapeSanBlas.enemies.size(); i++) {
				if (myGame.gameScreen.enemySpawnerCapeSanBlas.enemies.get(i).getPlaySound()) {
					soundLoader.sound.play(baseSoundVolumeValue);
					myGame.gameScreen.enemySpawnerCapeSanBlas.enemies.get(i).setPlaySound(false);
				}
			}
		}
	}
}
