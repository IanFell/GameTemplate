package handlers;

import helpers.GameAttributeHelper;
import loaders.MusicLoader;
import screens.Screens;

/**
 * Handles game music.
 * 
 * @author Fabulous Fellini
 *
 */
public class MusicHandler {
	
	/**
	 * Handle music in game.
	 * 
	 * @param MusicLoader musicLoader
	 */
	public void handleMusic(MusicLoader musicLoader) {
		if (GameAttributeHelper.gameState == Screens.GAME_SCREEN) {
			musicLoader.music.setVolume(1.0f);
			musicLoader.music.play();
		}
	}

}
