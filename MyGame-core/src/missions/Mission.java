package missions;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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

	protected static boolean missionComplete;

	private int timer;
	private final int MISSION_COMPLETE_DISPLAY_TIME_VALUE = 350;

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
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	protected void renderMissionCompleteMessage(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader, MyGame myGame) {
		if (timer < MISSION_COMPLETE_DISPLAY_TIME_VALUE) {
			timer++;
		}
		int missionCompleteSize = 10;
		GameObject player       = PlayerController.getCurrentPlayer(myGame);
		if (timer < MISSION_COMPLETE_DISPLAY_TIME_VALUE) {
			batch.draw(
					imageLoader.missionComplete, 
					player.getX() - GameScreen.cameraWidth / 2, 
					player.getY() + GameScreen.cameraWidth / 2, 
					missionCompleteSize, 
					-missionCompleteSize
					);
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	public void renderMission(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader, MyGame myGame) {}
}
