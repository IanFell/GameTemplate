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
	
	/**
	 * Sample noise for day time.
	 */
	public Music dayTimeAmbientNoise;
	
	/**
	 * Sample noise for nigh time.
	 */
	public Music nightTimeAmbientNoise;
	
	/**
	 * Sample noise for rain and thunder.
	 */
	public Music rainAndThunder;
	
	/**
	 * Initialize music.
	 */
	public void init() {
		dayTimeAmbientNoise   = Gdx.audio.newMusic(Gdx.files.internal("DayTimeAmbientNoise.wav"));
		nightTimeAmbientNoise = Gdx.audio.newMusic(Gdx.files.internal("NightTimeAmbientNoise.wav"));
		rainAndThunder        = Gdx.audio.newMusic(Gdx.files.internal("RainAndThunder.wav"));
	}
	
	/**
	 * Dispose of music.
	 */
	public void dispose() {
		dayTimeAmbientNoise.dispose();
		nightTimeAmbientNoise.dispose();
		rainAndThunder.dispose();
	}
}
