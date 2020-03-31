package ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.weapons.Gun;
import loaders.ImageLoader;
import missions.MissionChests;
import missions.MissionRawBar;
import missions.MissionStumpHole;
import missions.MissionTradinPost;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Objective {

	// Use this to flash objective.
	private int flashTimer = 0;

	private final int VALUE_TO_FLASH    = 7;
	private final int RESET_TIMER_VALUE = 17;

	private final int WIDTH  = 5;
	private final int HEIGHT = 1;

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 * @param GameOjbect  player
	 */
	public void renderUi(
			SpriteBatch batch, 
			ImageLoader imageLoader, 
			MyGame myGame, 
			GameObject player
			) {
		if (flashTimer > VALUE_TO_FLASH) {
			Texture objectiveTexture = getObjectiveTexture(imageLoader);
			batch.draw(
					objectiveTexture,
					player.getX() + 7, 
					player.getY() - 5, 
					WIDTH, 
					-HEIGHT
					); 
		}
	}

	/**
	 * 
	 * @param ImageLoader imageLoader
	 * @return Texture
	 */
	private Texture getObjectiveTexture(ImageLoader imageLoader) {
		Texture objectiveTexture = imageLoader.objectiveCollectLoot;
		if (MissionChests.chestMissionIsComplete) {
			objectiveTexture = imageLoader.objectiveTradinPost;
			if (MissionTradinPost.locationMarkerHasBeenHit) {
				objectiveTexture = imageLoader.objectiveBuyTheGun;
			}
			if (Gun.hasBeenCollected) {
				objectiveTexture = imageLoader.objectiveRawBar;
				if (MissionRawBar.rawBarMissionComplete) {
					objectiveTexture = imageLoader.objectiveStumpHole;
					if (MissionStumpHole.missionIsActive) {
						objectiveTexture = imageLoader.objectiveCollectFeathers;
					}
				}
			}
		}
		if (MissionRawBar.phasesAreInProgress) {
			objectiveTexture = imageLoader.objectiveCollectOysters;
		}
		return objectiveTexture;
	}

	public void updateObjective() {
		flashTimer++;
		if (flashTimer > RESET_TIMER_VALUE) {
			flashTimer = 0;
		}
	}
}
