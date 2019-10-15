package missions;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Player;
import loaders.ImageLoader;

/**
 * Mission: Open a given amount of chests in a given amount of time, collecting loot.
 * If mission complete, player gets bonus.
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionChests extends Mission {

	private static int numberOfChestsOpened                              = 0;
	private static final int AMOUNT_OF_CHESTS_NEEDED_TO_COMPLETE_MISSION = 3;

	public static boolean executeMission  = true;

	private static int countDownTimer = 0;

	/**
	 * Must complete mission in this amount of a count.
	 * This does not use a formal timer because I wanted it to be a little more random.
	 */
	private static int maxMissionCount = 1000;

	public static void increaseNumberOfChestsOpened() {
		numberOfChestsOpened++;
	}

	/**
	 * 
	 * @param Player player
	 */
	public void updateMission(Player player) {

		if (executeMission) {
			// Use this to time the mission.
			countDownTimer++;
			// If mission is complete:
			if (numberOfChestsOpened >= AMOUNT_OF_CHESTS_NEEDED_TO_COMPLETE_MISSION) {
				// Give player bonus score.
				player.updatePlayerScore(100);
				executeMission  = false;
				missionComplete = true;
			} else {
				System.out.println("Number of chests opened for chest mission: " + numberOfChestsOpened);
			}
		}

		if (missionComplete) {
			executeMission = false;
			System.out.println("CHEST MISSION COMPLETE!");
		} else if (countDownTimer >= maxMissionCount) {
			executeMission   = false;
			missionComplete = false;
			System.out.println("CHEST MISSION FAILED!");
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	@Override
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		// If mission is complete, render "Mission Complete" message for a little while.
		if (missionComplete) {
			renderMissionCompleteMessage(batch, imageLoader, myGame);
		}
	}
}
