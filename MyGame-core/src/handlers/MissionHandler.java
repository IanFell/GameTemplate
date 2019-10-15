package handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

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

	private MissionChests missionChests;
	private MissionLegendOfTheSevenSwords missionLegendOfTheSevenSwords;
	private MissionRawBar missionRawBarPhaseOne;
	private MissionRawBar missionRawBarPhaseTwo;
	private MissionRawBar missionRawBarPhaseThree;

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
		//missionChests.updateMission((Player) PlayerController.getCurrentPlayer(myGame));
		//missionLegendOfTheSevenSwords.updateMission(myGame, mapHandler);
		handleRawBarMission();
	}

	private void handleRawBarMission() {
		if (missionRawBarPhaseTwo.isPhaseComplete()) {
			missionRawBarPhaseThree.updateMission();
		} else if (missionRawBarPhaseOne.isPhaseComplete()) {
			missionRawBarPhaseTwo.updateMission();
		} else {
			missionRawBarPhaseOne.updateMission();
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	public void renderMissions(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		//missionChests.renderMission(batch, imageLoader, myGame);
		//missionLegendOfTheSevenSwords.renderMission(batch, imageLoader, myGame);
		renderRawBarMission(batch, imageLoader, myGame);
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
