package missions;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import loaders.ImageLoader;
import maps.MapHandler;
import screens.GameScreen;

/**
 * Mission: Open a given amount of chests in a given amount of time, collecting loot.
 * If mission complete, player gets bonus.
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionChests extends Mission {

	/**
	 * Use these variables if player doesn't complete mission.  
	 * If player doesn't complete mission, make him retry it.
	 */
	private boolean resetMission  = false;
	private int resetMissionTimer = 0;

	private static int numberOfChestsOpened                              = 0;
	private static final int AMOUNT_OF_CHESTS_NEEDED_TO_COMPLETE_MISSION = 5;

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
				missionComplete = true;
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

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	@Override
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		// If mission is complete, render "Mission Complete" message for a little while.
		if (missionComplete) {
			renderMissionMessage(batch, myGame, imageLoader.goToTradingPost);
		}

		// Place holder "try again" message.
		if (resetMission) {
			/*
			int collectOysterMessageSize = 10;
			int half                     = 2;
			GameObject player            = PlayerController.getCurrentPlayer(myGame);
			batch.draw(
					imageLoader.collectOysters, 
					player.getX() - GameScreen.cameraWidth / half, 
					player.getY() + GameScreen.cameraWidth / half, 
					collectOysterMessageSize, 
					-collectOysterMessageSize
					); */
		}

		// Render start message this long.
		if (timer < 100) {
			renderMissionStartMessage(batch, myGame, imageLoader.collectLoot);
		}
		if (timer <= 100) {
			timer++;
		}
	}
}
