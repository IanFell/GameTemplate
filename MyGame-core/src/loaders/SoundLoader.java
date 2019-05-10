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

	// Debug explosion sound.
	public Sound sound;
	
	/**
	 * Game Sounds.
	 */
	// Inventory select click sound.
	public Sound click;

	public void init() {
		sound = Gdx.audio.newSound(Gdx.files.internal("bomb.wav"));
		click = Gdx.audio.newSound(Gdx.files.internal("Click.wav"));
	}

	public void dispose() {
		sound.dispose();
		click.dispose();
	}
}
