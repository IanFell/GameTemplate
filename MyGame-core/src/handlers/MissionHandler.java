package handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import cutscenes.CutScene;
import gameobjects.gamecharacters.Player;
import gameobjects.weapons.Gun;
import loaders.ImageLoader;
import maps.MapHandler;
import missions.Mission;
import missions.MissionChests;
import missions.MissionLegendOfTheSevenSwords;
import missions.MissionRawBar;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionHandler extends Mission {

	/**
	 * Make this huge for now, because this is the only way I can get the mission 
	 * to work.  If the time limit runs out, the rest of the missions get all 
	 * fucked up.
	 */
	private final long MISSION_CHEST_START_TIME_VALUE = 1000000000L;

	private int timer = 0;

	private MissionChests missionChests;
	private MissionLegendOfTheSevenSwords missionLegendOfTheSevenSwords;
	private MissionRawBar missionRawBarPhaseOne;
	private MissionRawBar missionRawBarPhaseTwo;
	private MissionRawBar missionRawBarPhaseThree;

	/**
	 * These variables control the timing and display of the "go to the raw bar 
	 * for the magic pearl" message.
	 */
	private boolean setUpRawBarMission                      = true;
	private boolean displayGoToRawBar                       = false;
	private boolean rawBarMessageHasBeenDisplayed           = false;
	private int goToRawBarDisplayTimer                      = 0;
	private final int GO_TO_RAW_BAR_DISPLAY_TIMER_MAX_VALUE = 50;

	//int i = 0;

	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public MissionHandler(MyGame myGame) {
		missionChests                 = new MissionChests();
		missionLegendOfTheSevenSwords = new MissionLegendOfTheSevenSwords(myGame);
		initializeRawBarMission();
	}

	private void initializeRawBarMission() {
		missionRawBarPhaseOne   = new MissionRawBar(MissionRawBar.NUMBER_OF_OYSTERS_NEEDED_PHASE_ONE, MissionRawBar.MAX_MISSION_TIME_PHASE_ONE);
		missionRawBarPhaseTwo   = new MissionRawBar(MissionRawBar.NUMBER_OF_OYSTERS_NEEDED_PHASE_TWO, MissionRawBar.MAX_MISSION_TIME_PHASE_TWO);
		missionRawBarPhaseThree = new MissionRawBar(MissionRawBar.NUMBER_OF_OYSTERS_NEEDED_PHASE_THREE, MissionRawBar.MAX_MISSION_TIME_PHASE_THREE);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHanlder mapHandler
	 */
	public void handleMissions(MyGame myGame, MapHandler mapHandler) {
		if (!CutScene.anyCutSceneIsInProgress) {
			missionLegendOfTheSevenSwords.updateMission(myGame, mapHandler);

			// For now, don't make this a timed mission.  Maybe later.
			//if (timer > MISSION_CHEST_START_TIME_VALUE) {
			if (!MissionChests.missionComplete) {
				missionChests.updateMission((Player) PlayerController.getCurrentPlayer(myGame), myGame, mapHandler);
			}

			//} else {
			//timer++;
			//}

			handleGoToRawBarMessage();

			if (MissionRawBar.missionIsActive) {
				handleRawBarMission(myGame);
			}

			if (MissionRawBar.startMission && setUpRawBarMission ) {
				MissionRawBar.missionIsActive = true;
				setUpRawBarMission            = false;
			}
		}
	}

	private void handleGoToRawBarMessage() {
		if (Gun.hasBeenCollected && !rawBarMessageHasBeenDisplayed) {
			displayGoToRawBar = true;
		}
		if (displayGoToRawBar) {
			goToRawBarDisplayTimer++;
			if (goToRawBarDisplayTimer > GO_TO_RAW_BAR_DISPLAY_TIMER_MAX_VALUE) {
				displayGoToRawBar = false;
				rawBarMessageHasBeenDisplayed = true;
			}
		}
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	private void handleRawBarMission(MyGame myGame) {
		if (missionRawBarPhaseThree.isPhaseComplete()) {
			// Entire mission is complete now.
			MissionRawBar.phasesAreInProgress   = false;
			MissionRawBar.rawBarMissionComplete = true;
		}

		// Mission is the phases.
		if (missionRawBarPhaseTwo.isPhaseComplete()) {
			missionRawBarPhaseThree.updateMission(myGame);
		} else if (missionRawBarPhaseOne.isPhaseComplete()) {
			missionRawBarPhaseTwo.updateMission(myGame);
		} else {
			missionRawBarPhaseOne.updateMission(myGame);
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	public void renderMissions(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		if (!CutScene.anyCutSceneIsInProgress) {
			/**
			 * This mission runs throughout the whole entire game.  It will always be active.
			 * The only way to beat the game is to collect all the seven swords.
			 */
			missionLegendOfTheSevenSwords.renderMission(batch, imageLoader, myGame);

			if (timer > MISSION_CHEST_START_TIME_VALUE) {
				missionChests.renderMission(batch, imageLoader, myGame);
			}

			if (MissionRawBar.missionIsActive) {
				renderRawBarMission(batch, imageLoader, myGame);
			}

			if (displayGoToRawBar) {
				renderMissionStartMessage(batch, myGame, imageLoader.goToTheRawBar);
			}
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	private void renderRawBarMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		if (missionRawBarPhaseTwo.isPhaseComplete()) {
			missionRawBarPhaseThree.renderMission(batch, imageLoader, myGame);
		} else if (missionRawBarPhaseOne.isPhaseComplete()) {
			missionRawBarPhaseTwo.renderMission(batch, imageLoader, myGame);
		} else {
			missionRawBarPhaseOne.renderMission(batch, imageLoader, myGame);
		}
	}
}
