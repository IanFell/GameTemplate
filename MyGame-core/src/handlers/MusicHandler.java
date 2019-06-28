package handlers;

import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
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

	private boolean startDayTimeAmbientAudio   = true;
	private boolean startNightTimeAmbientAudio = true;
	private boolean startStormAudio            = true;
	private boolean startFootstepsAudio        = true;
	private boolean startOceanAudio            = true;

	/**
	 * 
	 * @param MusicLoader musicLoader
	 */
	public void handleMusic(MusicLoader musicLoader) {
		if (GameAttributeHelper.gameState == Screens.GAME_SCREEN) {
			if (NightAndDayCycle.isDayTime()) {
				handleDayTimeAudio(musicLoader);
			} else {
				handleNightTimeAudio(musicLoader);
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
	private void handleDayTimeAudio(MusicLoader musicLoader) {
		if (musicLoader.nightTimeAmbientNoise.isPlaying()) {
			musicLoader.nightTimeAmbientNoise.stop();
			startNightTimeAmbientAudio = true;
		}
		if (startDayTimeAmbientAudio) {
			musicLoader.dayTimeAmbientNoise.setVolume(AudioHandler.DAY_TIME_AMBIENT_VOLUME);
			musicLoader.dayTimeAmbientNoise.setLooping(true);
			musicLoader.dayTimeAmbientNoise.play();
			startDayTimeAmbientAudio = false;
		}
		handleStormAudio(musicLoader);
	}

	/**
	 * 
	 * @param MusicLoader musicLoader
	 */
	private void handleStormAudio(MusicLoader musicLoader) {
		if (WeatherHandler.isStorming() && startStormAudio) {
			musicLoader.rainAndThunder.setVolume(AudioHandler.MAX_VOLUME);
			musicLoader.rainAndThunder.setLooping(true);
			musicLoader.rainAndThunder.play();
			musicLoader.dayTimeAmbientNoise.stop();
			startStormAudio = false;
		} else if (!WeatherHandler.isStorming()) {
			if (musicLoader.rainAndThunder.isPlaying()) {
				musicLoader.rainAndThunder.stop();
				startStormAudio = true;
			}
		}
	}

	/**
	 * 
	 * @param MusicLoader musicLoader
	 */
	private void handleNightTimeAudio(MusicLoader musicLoader) {
		if (startNightTimeAmbientAudio) {
			musicLoader.nightTimeAmbientNoise.setVolume(AudioHandler.NIGHT_TIME_AMBIENT_VOLUME);
			musicLoader.nightTimeAmbientNoise.setLooping(true);
			musicLoader.nightTimeAmbientNoise.play();
			startNightTimeAmbientAudio = false;

			if (musicLoader.dayTimeAmbientNoise.isPlaying()) {
				musicLoader.dayTimeAmbientNoise.stop();
				startDayTimeAmbientAudio = true;
			}
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
		if (Player.playerIsMoving && Player.jumpingAction == Player.ON_GROUND && !Player.isInWater) {
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
