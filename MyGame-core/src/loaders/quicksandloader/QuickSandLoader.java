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

	public static QuickSand[] quickSand = new QuickSand[30];

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
		quickSand[3] = new QuickSand(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 25,
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 10
				);
		quickSand[4] = new QuickSand(
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START,
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 10
				);
		quickSand[5] = new QuickSand(
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 5,
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 7
				);
		quickSand[6] = new QuickSand(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 4,
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START - 90
				);
		quickSand[7] = new QuickSand(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 11,
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START - 45
				);
		quickSand[8] = new QuickSand(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 45,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START
				);
		quickSand[9] = new QuickSand(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 18,
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 50
				);
		quickSand[10] = new QuickSand(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 41,
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 17
				);
		quickSand[11] = new QuickSand(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 45,
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 35
				);
		quickSand[12] = new QuickSand(
				GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 23,
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 35
				);
		quickSand[13] = new QuickSand(
				GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 26,
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 35
				);
		quickSand[14] = new QuickSand(
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START - 10,
				GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START - 6
				);
		quickSand[15] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 43
				);
		quickSand[16] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 30,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 9
				);
		quickSand[17] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 33,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 9
				);
		quickSand[18] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 36,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 9
				);
		quickSand[19] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 30,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 12
				);
		quickSand[20] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 33,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 12
				);
		quickSand[21] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 36,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 12
				);
		quickSand[22] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 30,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 15
				);
		quickSand[23] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 33,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 15
				);
		quickSand[24] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 36,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 15
				);
		quickSand[25] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 57,
				GameAttributeHelper.CHUNK_TWO_Y_POSITION_START - 10
				);
		quickSand[26] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 57,
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 4
				);
		quickSand[27] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60,
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 4
				);
		quickSand[28] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60,
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 4
				);
		quickSand[29] = new QuickSand(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 55,
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + 4
				);
		addGameObjectsToGameObjectArrayList(quickSand);
	}
}
