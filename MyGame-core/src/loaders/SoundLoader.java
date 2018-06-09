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

	public Sound sound;

	public void init() {
		sound = Gdx.audio.newSound(Gdx.files.internal("bomb.wav"));
	}

	public void dispose() {
		sound.dispose();
	}
}
