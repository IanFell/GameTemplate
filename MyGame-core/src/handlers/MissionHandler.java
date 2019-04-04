package handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.gamecharacters.Player;
import loaders.ImageLoader;
import maps.MapHandler;
import missions.MissionChests;
import missions.MissionLegendOfTheSevenSwords;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionHandler {

	private MissionChests missionChests                                ;
	private MissionLegendOfTheSevenSwords missionLegendOfTheSevenSwords ;

	/**
	 * 
	 * @param MyGame myGame
	 */
	public MissionHandler(MyGame myGame) {
		missionChests                 = new MissionChests();
		missionLegendOfTheSevenSwords = new MissionLegendOfTheSevenSwords(myGame);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHanlder mapHandler
	 */
	public void handleMissions(MyGame myGame, MapHandler mapHandler) {
		missionChests.updateMission((Player) PlayerController.getCurrentPlayer(myGame));
		missionLegendOfTheSevenSwords.updateMission(myGame, mapHandler);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	public void renderMissions(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader, MyGame myGame) {
		missionChests.renderMission(batch, shapeRenderer, imageLoader, myGame);
		missionLegendOfTheSevenSwords.renderMission(batch, shapeRenderer, imageLoader, myGame);
	}
}
