package handlers;

import helpers.GameAttributeHelper;
import loaders.MusicLoader;
import physics.Weather.NightAndDayCycle;
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
			
			if (NightAndDayCycle.isDayTime()) {
				musicLoader.dayTimeAmbientNoise.setVolume(1.0f);
				musicLoader.dayTimeAmbientNoise.play();
				
				if (musicLoader.nightTimeAmbientNoise.isPlaying()) {
					musicLoader.nightTimeAmbientNoise.stop();
				}
			} else {
				musicLoader.nightTimeAmbientNoise.setVolume(1.0f);
				musicLoader.nightTimeAmbientNoise.play();
				
				if (musicLoader.dayTimeAmbientNoise.isPlaying()) {
					musicLoader.dayTimeAmbientNoise.stop();
				}
			}
		}
	}
}
