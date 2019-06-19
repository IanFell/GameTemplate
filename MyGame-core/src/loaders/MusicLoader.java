package loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Loads music.
 * 
 * @author Fabulous Fellini.
 *
 */
public class MusicLoader {

	public Music dayTimeAmbientNoise;

	public Music nightTimeAmbientNoise;

	public Music rainAndThunder;
	
	public Music fire;
	
	public Music ocean;
	
	/**
	 * This is currently a music type because it is a long file of footsteps.
	 * (It's not just one footstep sound).
	 */
	public Music footsteps;

	public void init() {
		ocean                 = Gdx.audio.newMusic(Gdx.files.internal("audio/Ocean.wav"));
		dayTimeAmbientNoise   = Gdx.audio.newMusic(Gdx.files.internal("audio/DayTimeAmbience.wav"));
		footsteps             = Gdx.audio.newMusic(Gdx.files.internal("audio/FootstepsMusic.wav"));
		rainAndThunder        = Gdx.audio.newMusic(Gdx.files.internal("audio/Rain.wav"));
		fire                  = Gdx.audio.newMusic(Gdx.files.internal("audio/Fire.wav"));
		nightTimeAmbientNoise = Gdx.audio.newMusic(Gdx.files.internal("NightTimeAmbientNoise.wav"));
	}

	public void dispose() {
		dayTimeAmbientNoise.dispose();
		nightTimeAmbientNoise.dispose();
		rainAndThunder.dispose();
		footsteps.dispose();
		fire.dispose();
		ocean.dispose();
	}
}
