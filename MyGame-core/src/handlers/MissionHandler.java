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

	private MissionLegendOfTheSevenSwords missionLegendOfTheSevenSwords = new MissionLegendOfTheSevenSwords();

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHanlder mapHandler
	 */
	public void handleMissions(MyGame myGame, MapHandler mapHandler) {
		MissionChests.updateMission((Player) PlayerController.getCurrentPlayer(myGame));
		missionLegendOfTheSevenSwords.updateMission(myGame, mapHandler);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	public void renderMissions(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		missionLegendOfTheSevenSwords.renderMission(batch, shapeRenderer, imageLoader);
	}
}
