package loaders.chestloader;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.Chest;
import helpers.GameAttributeHelper;
import loaders.ClassObjectLoader;

/**
 * Loads chests for all chunks.
 * 
 * @author Fabulous Fellini
 *
 */
public class ChestLoader extends ClassObjectLoader {

	public static GameObject[] chests = new GameObject[65];

	public void loadChests() {

		int chestOneForAllSandChunkXPositionOffset = 10;
		int chestTwoForAllSandChunkXPositionOffset = 34;
		int chestOneForAllSandChunkYPositionOffset = 29;

		chests[0]  = new Chest(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 38, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 2);
		chests[1]  = new Chest(GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 1, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 34);
		chests[2]  = new Chest(GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 58, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 4);
		chests[3]  = new Chest(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START);
		chests[4]  = new Chest(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[5]  = new Chest(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START);
		chests[6]  = new Chest(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[7]  = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START);
		chests[8]  = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[9]  = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START);
		chests[10] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[11] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START);
		chests[12] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[13] = new Chest(GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 67, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + 4);
		chests[14] = new Chest(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START);
		chests[15] = new Chest(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[16] = new Chest(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START);
		chests[17] = new Chest(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[18] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START);
		chests[19] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[20] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START);
		chests[21] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[22] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START);
		chests[23] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_TWO_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[24] = new Chest(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 6, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 1);
		chests[25] = new Chest(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 28, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 18);
		chests[26] = new Chest(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START);
		chests[27] = new Chest(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[28] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START);
		chests[29] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[30] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START);
		chests[31] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[32] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START);
		chests[33] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[34] = new Chest(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START);
		chests[35] = new Chest(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[36] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START);
		chests[37] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[38] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START);
		chests[39] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[40] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START);
		chests[41] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[42] = new Chest(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 8, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START);
		chests[43] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START);
		chests[44] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[45] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START);
		chests[46] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[47] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START);
		chests[48] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[49] = new Chest(GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 1, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 11);
		chests[50] = new Chest(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 67, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 1);
		chests[51] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START);
		chests[52] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[53] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START);
		chests[54] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + chestTwoForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + chestOneForAllSandChunkYPositionOffset);
		chests[55] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + chestOneForAllSandChunkXPositionOffset, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START);
		chests[56] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 11, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START);
		chests[57] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 12, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START);
		chests[58] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 13, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START);
		chests[59] = new Chest(GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 32, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 2);
		chests[60] = new Chest(GameAttributeHelper.CHUNK_FIVE_X_POSITION_START + 9, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 24);
		chests[61] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 1, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 1);
		chests[62] = new Chest(GameAttributeHelper.CHUNK_SIX_X_POSITION_START + 2, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 1);
		chests[63] = new Chest(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 67, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 1);
		chests[64] = new Chest(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 58, GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 3);
		addGameObjectsToGameObjectArrayList(chests);
	}
}
