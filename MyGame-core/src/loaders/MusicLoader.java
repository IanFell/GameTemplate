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
		ocean                 = Gdx.audio.newMusic(Gdx.files.internal("audio/ocean.ogg"));
		dayTimeAmbientNoise   = Gdx.audio.newMusic(Gdx.files.internal("audio/daytimeambience.ogg"));
		footsteps             = Gdx.audio.newMusic(Gdx.files.internal("audio/footstepsmusic.ogg"));
		rainAndThunder        = Gdx.audio.newMusic(Gdx.files.internal("audio/rain.ogg"));
		fire                  = Gdx.audio.newMusic(Gdx.files.internal("audio/fire.ogg"));
		nightTimeAmbientNoise = Gdx.audio.newMusic(Gdx.files.internal("audio/nighttimeambience.ogg"));
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
