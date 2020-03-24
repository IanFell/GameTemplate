package loaders.quicksandloader;

import gameobjects.nature.QuickSand;
import helpers.GameAttributeHelper;
import loaders.ClassObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class QuickSandLoader extends ClassObjectLoader {

	public static QuickSand[] quickSand = new QuickSand[3];

	public void loadQuickSand() {
		quickSand[0] = new QuickSand(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 10,
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 20
				);
		quickSand[1] = new QuickSand(
				GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 3,
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 20
				);
		quickSand[2] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 35,
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 20
				);
		addGameObjectsToGameObjectArrayList(quickSand);
	}
}
