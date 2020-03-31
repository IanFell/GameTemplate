package missions;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import loaders.ImageLoader;
import maps.MapHandler;
import screens.GameScreen;
import ui.LocationMarker;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Mission {

	protected final int MISSION_TEXT_DISPLAY_TIME_VALUE = 250;

	public static boolean missionComplete;
	protected int timer;

	protected int missionBeginTextTimer;

	protected LocationMarker locationMarker;

	/**
	 * Consructor.
	 */
	public Mission() {
		missionComplete = false; 
		timer           = 0;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param MyGame      myGame
	 * @param Texture     texture
	 */
	protected void renderMissionMessage(SpriteBatch batch, MyGame myGame, Texture texture) {
		if (timer < MISSION_TEXT_DISPLAY_TIME_VALUE) {
			timer++;
		}
		int missionCompleteSize = 10;
		int half                = 2;
		GameObject player       = PlayerController.getCurrentPlayer(myGame);
		if (timer < MISSION_TEXT_DISPLAY_TIME_VALUE) {
			batch.draw(
					texture, 
					player.getX() - GameScreen.cameraWidth / half, 
					player.getY() + GameScreen.cameraWidth / half, 
					missionCompleteSize, 
					-missionCompleteSize
					);
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param MyGame      myGame
	 * @param Texture     texture
	 */
	protected void renderMissionStartMessage(SpriteBatch batch, MyGame myGame, Texture texture) {
		if (missionBeginTextTimer < MISSION_TEXT_DISPLAY_TIME_VALUE) {
			int missionCompleteSize = 10;
			GameObject player       = PlayerController.getCurrentPlayer(myGame);
			batch.draw(
					texture, 
					player.getX() - GameScreen.cameraWidth / 2, 
					player.getY() + GameScreen.cameraWidth / 2, 
					missionCompleteSize, 
					-missionCompleteSize
					);
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateMission(MyGame myGame, MapHandler mapHandler) {
		if (missionBeginTextTimer < MISSION_TEXT_DISPLAY_TIME_VALUE) {
			missionBeginTextTimer++;
		}
	}
}
