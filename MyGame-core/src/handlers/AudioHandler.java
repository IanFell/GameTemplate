package handlers;

import loaders.MusicLoader;
import loaders.SoundLoader;

/**
 * Handles all audio in game.
 * 
 * @author Fabulous Fellini
 *
 */
public class AudioHandler {
	
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
	
	public void handleAudio() {
		soundHandler.handleSound(soundLoader);
		musicHandler.handleMusic(musicLoader);
	}
}
