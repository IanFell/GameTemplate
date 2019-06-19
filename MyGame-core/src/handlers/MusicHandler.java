package handlers;

import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
import inventory.Inventory;
import loaders.MusicLoader;
import loaders.fireloader.FireLoader;
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

	private boolean startDayTimeAmbientAudio = true;
	private boolean startFootstepsAudio      = true;
	private boolean startOceanAudio          = true;

	/**
	 * 
	 * @param MusicLoader musicLoader
	 */
	public void handleMusic(MusicLoader musicLoader) {
		if (GameAttributeHelper.gameState == Screens.GAME_SCREEN) {
			if (NightAndDayCycle.isDayTime()) {
				if (startDayTimeAmbientAudio) {
					musicLoader.dayTimeAmbientNoise.setVolume(AudioHandler.DAY_TIME_AMBIENT_VOLUME);
					musicLoader.dayTimeAmbientNoise.setLooping(true);
					musicLoader.dayTimeAmbientNoise.play();
					startDayTimeAmbientAudio = false;
				}

				/*
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
				}*/
			} else {
				/*
				musicLoader.nightTimeAmbientNoise.setVolume(AudioHandler.DAY_TIME_AMBIENT_VOLUME);
				musicLoader.nightTimeAmbientNoise.play();

				if (musicLoader.dayTimeAmbientNoise.isPlaying()) {
					musicLoader.dayTimeAmbientNoise.stop();
				}

				if (musicLoader.rainAndThunder.isPlaying()) {
					musicLoader.rainAndThunder.stop();
				}*/
			}
			handleFootstepsAudio(musicLoader);
			handleFireAudio(musicLoader);
			handleOceanAudio(musicLoader);
		} 
	}

	/**
	 * 
	 * @param MusicLoader musicLoader
	 */
	private void handleFireAudio(MusicLoader musicLoader) {
		if (Fire.playSound) {
			musicLoader.fire.setVolume(AudioHandler.MAX_VOLUME);
			musicLoader.fire.play();
			Fire.playSound = false;
		} else {
			musicLoader.fire.stop();
		}
	}

	/**
	 * 
	 * @param MusicLoader musicLoader
	 */
	private void handleOceanAudio(MusicLoader musicLoader) {
		if (Player.isInWater) {
			startOceanAudio = true;
		} else {
			musicLoader.ocean.stop();
		}
		if (startOceanAudio) {
			musicLoader.ocean.setVolume(AudioHandler.MAX_VOLUME);
			musicLoader.ocean.setLooping(true);
			musicLoader.ocean.play();
			startOceanAudio = false;
		}
	}

	/**
	 * 
	 * @param MusicLoader musicLoader
	 */
	private void handleFootstepsAudio(MusicLoader musicLoader) {
		if (Player.playerIsMoving) {
			startFootstepsAudio = true;
		} else {
			musicLoader.footsteps.stop();
		}
		if (startFootstepsAudio) {
			musicLoader.footsteps.setVolume(AudioHandler.FOOTSTEPS_VOLUME);
			musicLoader.footsteps.setLooping(true);
			musicLoader.footsteps.play();
			startFootstepsAudio = false;
		}
	}
}
