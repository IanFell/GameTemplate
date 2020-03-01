package handlers;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Giant;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class GiantHandler {

	private Giant giantOne;

	private int size = 5;

	/**
	 * 
	 * @param ImageLoader imageLoader
	 */
	public void init(ImageLoader imageLoader) {
		giantOne = new Giant(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 43, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 10, 
				size, 
				size, 
				GameObject.DIRECTION_LEFT
				);

		GameObjectLoader.gameObjectList.add(giantOne);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateGiants(MyGame myGame, MapHandler mapHandler) {
		//for (int i = 0; i < gruntSpawner.length; i++) {
		//gruntSpawner[i].updateGrunts(myGame, mapHandler);
		giantOne.updateObject(myGame, mapHandler);
		//fire[i].updateObject(myGame, mapHandler);
		//}
	}
}
