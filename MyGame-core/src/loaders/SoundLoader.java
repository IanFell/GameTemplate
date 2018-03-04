package loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Loads sounds.
 * 
 * @author Fabulous Fellini
 *
 */
public class SoundLoader {
	
	/**
	 * Sample sound.
	 */
	public Sound sound;
	
	/**
	 * Initialize sounds.
	 */
	public void init() {
		sound = Gdx.audio.newSound(Gdx.files.internal("bomb.wav"));
	}
	
	/**
	 * Dispose of sounds.
	 */
	public void dispose() {
		sound.dispose();
	}
}
