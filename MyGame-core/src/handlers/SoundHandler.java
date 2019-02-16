package handlers;

import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;
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
		}
	}
}
