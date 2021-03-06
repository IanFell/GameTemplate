package handlers;

import com.mygdx.mygame.MyGame;

import loaders.MusicLoader;
import loaders.SoundLoader;

/**
 * Handles all audio in game.
 * 
 * @author Fabulous Fellini
 *
 */
public class AudioHandler {

	public static final float MINIMUM_VOLUME = 0f;
	public static final float EIGHTH_VOLUME  = 0.125f;
	public static final float QUARTER_VOLUME = 0.25F;
	public static final float MEDIAN_VOLUME  = 0.5f;
	public static final float MAX_VOLUME     = 1.0f;

	public final static float FOOTSTEPS_VOLUME = 0.06f;
	public final static float JUMP_VOLUME      = 0.10f;
	public final static float LAND_VOLUME      = 0.10f;

	public final static float DAY_TIME_AMBIENT_VOLUME   = 0.25f;
	public final static float NIGHT_TIME_AMBIENT_VOLUME = 0.7f;

	public final static float CHEST_VOLUME = .25f;

	public final static float PICK_UP_SWORD_VOLUME = 0.1f;

	/**
	 * Loads sounds.
	 */
	private SoundLoader soundLoader = new SoundLoader();

	/**
	 * Handles sounds.
	 */
	private SoundHandler soundHandler = new SoundHandler();

	/**
	 * Loads music.
	 */
	private MusicLoader musicLoader = new MusicLoader();

	/**
	 * Handles music.
	 */
	private MusicHandler musicHandler = new MusicHandler();

	public void init() {
		soundLoader.init();
		musicLoader.init();
	}

	public void dispose() {
		soundLoader.dispose();
		musicLoader.dispose();
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void handleAudio(MyGame myGame) {
		soundHandler.handleSound(soundLoader, myGame);
		musicHandler.handleMusic(musicLoader);
	}
}
