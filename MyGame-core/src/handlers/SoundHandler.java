package handlers;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.GameAttributeHelper;
import loaders.SoundLoader;
import screens.Screens;

/**
 * Handles game sounds.
 * 
 * @author Fabulous Fellini
 *
 */
public class SoundHandler {

	/**
	 * 
	 * @param SoundLoader soundLoader
	 */
	public void handleSound(SoundLoader soundLoader, MyGame myGame) {
		if (GameAttributeHelper.gameState == Screens.GAME_SCREEN) {
			if (myGame.getGameObject(GameObject.CHEST).getPlaySound()) {
				soundLoader.sound.play(0.5f);
				myGame.getGameObject(GameObject.CHEST).setPlaySound(false);
			}
		} 
	}
}
