package missions;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import loaders.ImageLoader;
import screens.GameScreen;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Mission {

	private final int MISSION_COMPLETE_DISPLAY_TIME_VALUE = 350;

	protected static boolean missionComplete;
	private int timer;

	/**
	 * Consructor.
	 */
	public Mission() {
		missionComplete = false;
		timer           = 0;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	protected void renderMissionCompleteMessage(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		if (timer < MISSION_COMPLETE_DISPLAY_TIME_VALUE) {
			timer++;
		}
		int missionCompleteSize = 10;
		int half                = 2;
		GameObject player       = PlayerController.getCurrentPlayer(myGame);
		if (timer < MISSION_COMPLETE_DISPLAY_TIME_VALUE) {
			batch.draw(
					imageLoader.missionComplete, 
					player.getX() - GameScreen.cameraWidth / half, 
					player.getY() + GameScreen.cameraWidth / half, 
					missionCompleteSize, 
					-missionCompleteSize
					);
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {}
}
