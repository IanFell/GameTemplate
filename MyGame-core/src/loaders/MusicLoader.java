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
	 * Sample music.
	 */
	public Music music;
	
	/**
	 * Initialize music.
	 */
	public void init() {
		music = Gdx.audio.newMusic(Gdx.files.internal("INTRO_MUSIC.wav"));
	}
	
	/**
	 * Dispose of music.
	 */
	public void dispose() {
		music.dispose();
	}
}
