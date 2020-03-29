package handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import cutscenes.CutScene;
import gameobjects.gamecharacters.Player;
import loaders.ImageLoader;
import maps.MapHandler;
import missions.Mission;
import missions.MissionChests;
import missions.MissionLegendOfTheSevenSwords;
import missions.MissionRawBar;
import missions.MissionStumpHole;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionHandler extends Mission {

	private MissionChests missionChests;
	private MissionLegendOfTheSevenSwords missionLegendOfTheSevenSwords;
	private MissionRawBar missionRawBarPhaseOne;
	private MissionRawBar missionRawBarPhaseTwo;
	private MissionRawBar missionRawBarPhaseThree;
	private MissionStumpHole missionStumpHole;

	/**
	 * These variables control the timing and display of the "go to the raw bar 
	 * for the magic pearl" message.
	 */
	private boolean setUpRawBarMission                      = true;

	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public MissionHandler(MyGame myGame) {
		missionChests                 = new MissionChests();
		missionLegendOfTheSevenSwords = new MissionLegendOfTheSevenSwords(myGame);
		initializeRawBarMission();
		missionStumpHole              = new MissionStumpHole();
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

			if (!MissionChests.missionComplete) {
				missionChests.updateMission((Player) PlayerController.getCurrentPlayer(myGame), myGame, mapHandler);
			}

			if (MissionRawBar.startMission && setUpRawBarMission ) {
				MissionRawBar.missionIsActive = true;
				setUpRawBarMission            = false;
			} 

			if (MissionRawBar.missionIsActive) {
				handleRawBarMission(myGame);
			}

			if (MissionRawBar.rawBarMissionComplete) {
				missionStumpHole.updateMission(myGame, mapHandler);
			} 
		}
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	private void handleRawBarMission(MyGame myGame) {
		// Mission is the phases.
		if (missionRawBarPhaseTwo.isPhaseComplete()) {
			missionRawBarPhaseThree.updateMission(myGame);
		} else if (missionRawBarPhaseOne.isPhaseComplete()) {
			missionRawBarPhaseTwo.updateMission(myGame);
		} else {
			missionRawBarPhaseOne.updateMission(myGame);
		}

		// Entire mission is complete now.
		if (missionRawBarPhaseThree.isPhaseComplete()) {
			MissionRawBar.phasesAreInProgress   = false;
			MissionRawBar.rawBarMissionComplete = true;
			MissionRawBar.missionIsActive       = false;
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
			missionLegendOfTheSevenSwords.renderMission(batch, imageLoader, myGame);

			missionChests.renderMission(batch, imageLoader, myGame);

			if (MissionRawBar.missionIsActive) {
				renderRawBarMission(batch, imageLoader, myGame);
			}

			if (MissionRawBar.rawBarMissionComplete) {
				missionStumpHole.renderMission(batch, imageLoader, myGame);
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
