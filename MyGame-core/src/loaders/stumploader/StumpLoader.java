package loaders.stumploader;

import java.util.ArrayList;

import gameobjects.GameObject;
import gameobjects.nature.Stump;
import helpers.GameAttributeHelper;
import loaders.ClassObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class StumpLoader extends ClassObjectLoader {

	private final int AMOUNT_OF_STUMPS = 1;

	public static ArrayList <GameObject> stumps = new ArrayList <GameObject>();

	public void loadStumps() {
		int startX = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 17;
		int startY = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 35;
		for (int i = 0; i < AMOUNT_OF_STUMPS; i++) {
			stumps.add(new Stump(startX, startY));
		}
		addGameObjectsToGameObjectArrayList(stumps);
	}
}
