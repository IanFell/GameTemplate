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

	public void init() {
		dayTimeAmbientNoise   = Gdx.audio.newMusic(Gdx.files.internal("DayTimeAmbientNoise.wav"));
		nightTimeAmbientNoise = Gdx.audio.newMusic(Gdx.files.internal("NightTimeAmbientNoise.wav"));
		rainAndThunder        = Gdx.audio.newMusic(Gdx.files.internal("RainAndThunder.wav"));
	}

	public void dispose() {
		dayTimeAmbientNoise.dispose();
		nightTimeAmbientNoise.dispose();
		rainAndThunder.dispose();
	}
}
