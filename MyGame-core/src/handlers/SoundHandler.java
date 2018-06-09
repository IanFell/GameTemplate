package handlers;

import helpers.GameAttributeHelper;
import loaders.SoundLoader;
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
	public void handleSound(SoundLoader soundLoader) {
		if (GameAttributeHelper.gameState == Screens.SPLASH_SCREEN) {
			//soundLoader.sound.play(0.5f);
		} else {
			//soundLoader.sound.stop();
		}
	}
}
