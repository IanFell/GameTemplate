package handlers;

import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
import loaders.MusicLoader;
import physics.Weather.NightAndDayCycle;
import physics.Weather.WeatherHandler;
import screens.Screens;

/**
 * Handles game music.
 * 
 * @author Fabulous Fellini
 *
 */
public class MusicHandler {

	/**
	 * 
	 * @param MusicLoader musicLoader
	 */
	public void handleMusic(MusicLoader musicLoader) {
		if (GameAttributeHelper.gameState == Screens.GAME_SCREEN) {
			
			if (Player.playerIsMoving) {
				musicLoader.footsteps.setVolume(1.0f);
				musicLoader.footsteps.play();
			} else {
				musicLoader.footsteps.stop();
			}
			
			if (NightAndDayCycle.isDayTime()) {
				musicLoader.dayTimeAmbientNoise.setVolume(1.0f);
				musicLoader.dayTimeAmbientNoise.play();

				if (WeatherHandler.isStorming()) {
					musicLoader.rainAndThunder.setVolume(1.0f);
					musicLoader.rainAndThunder.play();
				} else {
					if (musicLoader.rainAndThunder.isPlaying()) {
						musicLoader.rainAndThunder.stop();
					}
				}

				if (musicLoader.nightTimeAmbientNoise.isPlaying()) {
					musicLoader.nightTimeAmbientNoise.stop();
				}
			} else {
				musicLoader.nightTimeAmbientNoise.setVolume(1.0f);
				musicLoader.nightTimeAmbientNoise.play();

				if (musicLoader.dayTimeAmbientNoise.isPlaying()) {
					musicLoader.dayTimeAmbientNoise.stop();
				}

				if (musicLoader.rainAndThunder.isPlaying()) {
					musicLoader.rainAndThunder.stop();
				}
			}
		}
	}
}
