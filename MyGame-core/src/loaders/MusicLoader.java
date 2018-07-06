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
	
	/**
	 * This is currently a music type because it is a long file of footsteps.
	 * (It's not just one footstep sound).
	 */
	public Music footsteps;

	public void init() {
		dayTimeAmbientNoise   = Gdx.audio.newMusic(Gdx.files.internal("DayTimeAmbientNoise.wav"));
		nightTimeAmbientNoise = Gdx.audio.newMusic(Gdx.files.internal("NightTimeAmbientNoise.wav"));
		rainAndThunder        = Gdx.audio.newMusic(Gdx.files.internal("RainAndThunder.wav"));
		footsteps             = Gdx.audio.newMusic(Gdx.files.internal("FootstepsMusic.wav"));
	}

	public void dispose() {
		dayTimeAmbientNoise.dispose();
		nightTimeAmbientNoise.dispose();
		rainAndThunder.dispose();
		footsteps.dispose();
	}
}
