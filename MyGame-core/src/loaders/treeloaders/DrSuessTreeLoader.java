package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.nature.trees.DrSuessTree;
import helpers.GameAttributeHelper;
import loaders.ClassObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class DrSuessTreeLoader extends ClassObjectLoader {

	public static GameObject[] drSuessTrees = new DrSuessTree[61];

	public void loadTrees() {
		drSuessTrees[0]  = new DrSuessTree(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 45, 12);
		drSuessTrees[1]  = new DrSuessTree(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 75, 30);
		drSuessTrees[2]  = new DrSuessTree(GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 5, 6);
		drSuessTrees[3]  = new DrSuessTree(GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 30, 30);
		drSuessTrees[4]  = new DrSuessTree(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 15, 15);
		drSuessTrees[5]  = new DrSuessTree(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 40, 40);
		drSuessTrees[6]  = new DrSuessTree(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START, 5);
		drSuessTrees[7]  = new DrSuessTree(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 15, 15);
		drSuessTrees[8]  = new DrSuessTree(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 23, 20);
		drSuessTrees[9]  = new DrSuessTree(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 5, 45);
		drSuessTrees[10] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 5, 8);
		drSuessTrees[11] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 43, 8);
		drSuessTrees[12] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 27, 25);
		drSuessTrees[13] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 28, 25);
		drSuessTrees[14] = new DrSuessTree(GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 20, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START);
		drSuessTrees[15] = new DrSuessTree(GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 56, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 25);
		drSuessTrees[16] = new DrSuessTree(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 17, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 7);
		drSuessTrees[17] = new DrSuessTree(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 18, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 7);
		drSuessTrees[18] = new DrSuessTree(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 17, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 27);
		drSuessTrees[19] = new DrSuessTree(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 18, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 28);
		drSuessTrees[20] = new DrSuessTree(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 4, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 5);
		drSuessTrees[21] = new DrSuessTree(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 44, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 36);
		drSuessTrees[22] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 17, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 10);
		drSuessTrees[23] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 35, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 35);
		drSuessTrees[24] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 17, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 27);
		drSuessTrees[25] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 18, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 28);
		drSuessTrees[26] = new DrSuessTree(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 10, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 28);
		drSuessTrees[27] = new DrSuessTree(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 30, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 5);
		drSuessTrees[28] = new DrSuessTree(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 40, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 25);
		drSuessTrees[29] = new DrSuessTree(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 30, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 7);
		drSuessTrees[30] = new DrSuessTree(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 31, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 10);
		drSuessTrees[31] = new DrSuessTree(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 1, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 15);
		drSuessTrees[32] = new DrSuessTree(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 5, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 15);
		drSuessTrees[33] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 1, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 15);
		drSuessTrees[34] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 5, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 15);
		drSuessTrees[35] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 11, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 10);
		drSuessTrees[36] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 42, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 37);
		drSuessTrees[37] = new DrSuessTree(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 5, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START);
		drSuessTrees[38] = new DrSuessTree(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 7, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START);
		drSuessTrees[39] = new DrSuessTree(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 42, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 12);
		drSuessTrees[40] = new DrSuessTree(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 43, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 13);
		drSuessTrees[41] = new DrSuessTree(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 44, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 14);
		drSuessTrees[42] = new DrSuessTree(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 45, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 15);
		drSuessTrees[43] = new DrSuessTree(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 20, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 25);
		drSuessTrees[44] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 25, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 38);
		drSuessTrees[45] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 26, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 38);
		drSuessTrees[46] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 27, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 38);
		drSuessTrees[47] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 10, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + 7);
		drSuessTrees[48] = new DrSuessTree(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 10, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + 7);
		drSuessTrees[49] = new DrSuessTree(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 14, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + 7);
		drSuessTrees[50] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 35, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + 22);
		drSuessTrees[51] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 50, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + 31);
		drSuessTrees[52] = new DrSuessTree(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 50, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 31);
		drSuessTrees[53] = new DrSuessTree(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 15, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 31);
		drSuessTrees[54] = new DrSuessTree(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 16, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 32);
		drSuessTrees[55] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 21, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 6);
		drSuessTrees[56] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 22, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 8);
		drSuessTrees[57] = new DrSuessTree(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 23, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 10);
		drSuessTrees[58] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 21, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 6);
		drSuessTrees[59] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 22, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 8);
		drSuessTrees[60] = new DrSuessTree(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 23, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 10);
		addGameObjectsToGameObjectArrayList(drSuessTrees);
	}
}
