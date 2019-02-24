package missions;

import gameobjects.gamecharacters.Player;

/**
 * Mission: Open a given amount of chests in a given amount of time, collecting loot.
 * If mission complete, player gets bonus.
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionChests {

	private static int numberOfChestsOpened                  = 0;
	private static int numberOfChestsNeededToCompleteMission = 3;

	public static boolean executeMission  = true;
	private static boolean playerHasWon   = false;

	private static int timer = 0;

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
	public static void updateMission(Player player) {

		if (executeMission) {
			// Use this to time the mission.
			timer++;
			// If mission is complete:
			if (numberOfChestsOpened >= numberOfChestsNeededToCompleteMission) {
				// Give player bonus score.
				player.updatePlayerScore(100);
				executeMission = false;
				playerHasWon   = true;
			} else {
				System.out.println("Number of chests opened for chest mission: " + numberOfChestsOpened);
			}
		}

		if (playerHasWon) {
			executeMission = false;
			System.out.println("CHEST MISSION COMPLETE!");
		} else if (timer >= maxMissionCount) {
			executeMission = false;
			playerHasWon   = false;
			System.out.println("CHEST MISSION FAILED!");
		}
	}
}
