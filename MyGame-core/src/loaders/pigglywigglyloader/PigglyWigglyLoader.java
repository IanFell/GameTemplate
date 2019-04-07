package loaders.pigglywigglyloader;

import com.mygdx.mygame.MyGame;

import gameobjects.stationarygameobjects.buildings.PigglyWiggly;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PigglyWigglyLoader {

	public static PigglyWiggly pigglyWiggly;

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void loadPigglyWiggly(MyGame myGame) {
		pigglyWiggly = new PigglyWiggly(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 1, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 6,
				7,
				6,
				myGame.imageLoader.pigglywiggly
				);
		GameObjectLoader.gameObjectList.add(pigglyWiggly);
	}
}
