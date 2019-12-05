package handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import cutscenes.CutScene;
import gameobjects.gamecharacters.Player;
import gameobjects.weapons.Gun;
import loaders.ImageLoader;
import maps.MapHandler;
import missions.MissionChests;
import missions.MissionLegendOfTheSevenSwords;
import missions.MissionRawBar;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionHandler {
	
	private final int MISSION_CHEST_START_TIME_VALUE = 250;
	
	private int timer = 0;

	private MissionChests missionChests;
	private MissionLegendOfTheSevenSwords missionLegendOfTheSevenSwords;
	private MissionRawBar missionRawBarPhaseOne;
	private MissionRawBar missionRawBarPhaseTwo;
	private MissionRawBar missionRawBarPhaseThree;

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
			if (timer > MISSION_CHEST_START_TIME_VALUE) {
				missionChests.updateMission((Player) PlayerController.getCurrentPlayer(myGame), myGame, mapHandler);
			}
			missionLegendOfTheSevenSwords.updateMission(myGame, mapHandler);

			if (MissionRawBar.missionIsActive && MissionChests.missionComplete) {
				handleRawBarMission(myGame);
			}
			timer++;
			
			if (Gun.hasBeenCollected) {
				MissionRawBar.missionIsActive = true;
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
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	public void renderMissions(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		if (!CutScene.anyCutSceneIsInProgress) {
			
			if (timer > MISSION_CHEST_START_TIME_VALUE) {
				missionChests.renderMission(batch, imageLoader, myGame);
			}
			missionLegendOfTheSevenSwords.renderMission(batch, imageLoader, myGame);

			if (MissionRawBar.missionIsActive) {
				renderRawBarMission(batch, imageLoader, myGame);
			}
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
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
