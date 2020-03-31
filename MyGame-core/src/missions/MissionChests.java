package missions;

import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Player;
import maps.MapHandler;

/**
 * Mission: Open a given amount of chests in a given amount of time, collecting loot.
 * If mission complete, player gets bonus.
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionChests extends Mission {

	/**
	 * Need this to know when this mission is indeed complete.  
	 * Use this for mission complete checks.
	 */
	public static boolean chestMissionIsComplete = false;

	/**
	 * Use these variables if player doesn't complete mission.  
	 * If player doesn't complete mission, make him retry it.
	 */
	private boolean resetMission  = false;
	private int resetMissionTimer = 0;

	private static int numberOfChestsOpened                              = 0;
	private static final int AMOUNT_OF_CHESTS_NEEDED_TO_COMPLETE_MISSION = 1;

	public static boolean executeMission = true;

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
	 * @param Player     player
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateMission(Player player, MyGame myGame, MapHandler mapHandler) {

		super.updateMission(myGame, mapHandler);

		// If player fails mission, use this to display "try again" message.
		if (resetMission) {
			resetMissionTimer++;
			if (resetMissionTimer >= 30) {
				resetMission = false;
			}
		}

		if (executeMission) {
			// Use this to time the mission.
			countDownTimer++;
			// If mission is complete:
			if (numberOfChestsOpened >= AMOUNT_OF_CHESTS_NEEDED_TO_COMPLETE_MISSION) {
				executeMission  = false;
				chestMissionIsComplete = true;
			} 
		}

		if (missionComplete) {
			executeMission = false;
			//System.out.println("CHEST MISSION COMPLETE!");
		} else if (countDownTimer >= maxMissionCount) {
			/*
			// Reset mission if player fails.  Do this until player completes mission.
			executeMission       = true;
			missionComplete      = false;
			resetMission         = true;
			resetMissionTimer    = 0;
			numberOfChestsOpened = 0;
			countDownTimer       = 0; */
			//System.out.println("CHEST MISSION FAILED!");
		}
	}
}
