package handlers;

import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
import inventory.Inventory;
import loaders.MusicLoader;
import physics.Lighting.Fire;
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
			if (NightAndDayCycle.isDayTime()) {
				musicLoader.dayTimeAmbientNoise.setVolume(AudioHandler.TEMP_VOLUME);
				musicLoader.dayTimeAmbientNoise.play();

				if (WeatherHandler.isStorming()) {
					musicLoader.rainAndThunder.setVolume(AudioHandler.TEMP_VOLUME);
					musicLoader.rainAndThunder.play();
					musicLoader.dayTimeAmbientNoise.stop();
				} else {
					if (musicLoader.rainAndThunder.isPlaying()) {
						musicLoader.rainAndThunder.stop();
					}
				}

				if (musicLoader.nightTimeAmbientNoise.isPlaying()) {
					musicLoader.nightTimeAmbientNoise.stop();
				}
			} else {
				musicLoader.nightTimeAmbientNoise.setVolume(AudioHandler.TEMP_VOLUME);
				musicLoader.nightTimeAmbientNoise.play();

				if (musicLoader.dayTimeAmbientNoise.isPlaying()) {
					musicLoader.dayTimeAmbientNoise.stop();
				}

				if (musicLoader.rainAndThunder.isPlaying()) {
					musicLoader.rainAndThunder.stop();
				}
			}
			
			handleFootsteps(musicLoader);

			// Fire to match inventory selection fire rendering.
			if (Inventory.allInventoryShouldBeRendered) {
				if (Fire.playSound) {
					musicLoader.fire.setVolume(AudioHandler.MAX_VOLUME);
					musicLoader.fire.play();
					Fire.playSound = false;
				}
			} else {
				musicLoader.fire.stop();
			}
		}
	}
	
	/**
	 * 
	 * @param MusicLoader musicLoader
	 */
	private void handleFootsteps(MusicLoader musicLoader) {
		if (Player.playerIsMoving) {
			musicLoader.footsteps.setVolume(AudioHandler.TEMP_VOLUME);
			//musicLoader.footsteps.play();
		} else {
			//musicLoader.footsteps.stop();
		}
	}
}
