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

	public static Giant[] giants = new Giant[3];

	private int size = 5;

	/**
	 * 
	 * @param ImageLoader imageLoader
	 */
	public void init(ImageLoader imageLoader) {
		// Wewa giant.
		giants[0] = new Giant(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60, 
				3, 
				size, 
				size, 
				GameObject.DIRECTION_LEFT
				);

		// Apalachacola giant.
		giants[1] = new Giant(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 43, 
				size, 
				size, 
				GameObject.DIRECTION_LEFT
				);

		// Port St Joe giant.
		giants[2] = new Giant(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 1, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 6, 
				size, 
				size, 
				GameObject.DIRECTION_RIGHT
				);

		for (int i = 0; i < giants.length; i++) {
			GameObjectLoader.gameObjectList.add(giants[i]);
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateGiants(MyGame myGame, MapHandler mapHandler) {
		for (int i = 0; i < giants.length; i++) {
			giants[i].updateObject(myGame, mapHandler);
		}
	}
}
