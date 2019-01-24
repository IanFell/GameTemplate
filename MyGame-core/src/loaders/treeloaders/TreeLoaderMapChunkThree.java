package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThree extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThree = new PalmTree[86];
	
	@Override
	public void loadTrees() {
		startXPosition         = GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 1;
		startYPosition         = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START;
		row                    = startYPosition;
		treesMapChunkThree[0]  = new PalmTree(startXPosition + 5, row);
		treesMapChunkThree[1]  = new PalmTree(startXPosition + 15, row);
		treesMapChunkThree[2]  = new PalmTree(startXPosition + 16, row);
		treesMapChunkThree[3]  = new PalmTree(startXPosition + 17, row);
		treesMapChunkThree[4]  = new PalmTree(startXPosition + 18, row);
		treesMapChunkThree[5]  = new PalmTree(startXPosition + 19, row);
		treesMapChunkThree[6]  = new PalmTree(startXPosition + 29, row);
		treesMapChunkThree[7]  = new PalmTree(startXPosition + 30, row);
		treesMapChunkThree[8]  = new PalmTree(startXPosition + 31, row);
		treesMapChunkThree[9]  = new PalmTree(startXPosition + 32, row);
		treesMapChunkThree[10] = new PalmTree(startXPosition + 33, row);
		row                    = startYPosition + 5;
		treesMapChunkThree[11] = new PalmTree(startXPosition + 7, row);
		treesMapChunkThree[12] = new PalmTree(startXPosition + 8, row);
		treesMapChunkThree[13] = new PalmTree(startXPosition + 9, row);
		row                    = startYPosition + 14;
		treesMapChunkThree[14] = new PalmTree(startXPosition + 20, row);
		treesMapChunkThree[15] = new PalmTree(startXPosition + 21, row);
		treesMapChunkThree[16] = new PalmTree(startXPosition + 22, row);
		treesMapChunkThree[17] = new PalmTree(startXPosition + 30, row);
		treesMapChunkThree[18] = new PalmTree(startXPosition + 31, row);
		treesMapChunkThree[19] = new PalmTree(startXPosition + 32, row);
		treesMapChunkThree[20] = new PalmTree(startXPosition + 45, row);
		treesMapChunkThree[21] = new PalmTree(startXPosition + 46, row);
		treesMapChunkThree[22] = new PalmTree(startXPosition + 47, row);
		treesMapChunkThree[23] = new PalmTree(startXPosition + 48, row);
		treesMapChunkThree[24] = new PalmTree(startXPosition + 49, row);
		treesMapChunkThree[25] = new PalmTree(startXPosition + 64, row);
		treesMapChunkThree[26] = new PalmTree(startXPosition + 65, row);
		treesMapChunkThree[27] = new PalmTree(startXPosition + 66, row);
		treesMapChunkThree[28] = new PalmTree(startXPosition + 67, row);
		treesMapChunkThree[29] = new PalmTree(startXPosition + 68, row);
		row                    = startYPosition + 19;
		treesMapChunkThree[30] = new PalmTree(startXPosition + 5, row);
		treesMapChunkThree[31] = new PalmTree(startXPosition + 6, row);
		treesMapChunkThree[32] = new PalmTree(startXPosition + 10, row);
		treesMapChunkThree[33] = new PalmTree(startXPosition + 11, row);
		treesMapChunkThree[34] = new PalmTree(startXPosition + 12, row);
		treesMapChunkThree[35] = new PalmTree(startXPosition + 23, row);
		treesMapChunkThree[36] = new PalmTree(startXPosition + 24, row);
		treesMapChunkThree[37] = new PalmTree(startXPosition + 25, row);
		treesMapChunkThree[38] = new PalmTree(startXPosition + 33, row);
		treesMapChunkThree[39] = new PalmTree(startXPosition + 34, row);
		treesMapChunkThree[40] = new PalmTree(startXPosition + 45, row);
		treesMapChunkThree[41] = new PalmTree(startXPosition + 46, row);
		treesMapChunkThree[42] = new PalmTree(startXPosition + 47, row);
		row                    = startYPosition + 26;
		treesMapChunkThree[43] = new PalmTree(startXPosition + 16, row);
		treesMapChunkThree[44] = new PalmTree(startXPosition + 17, row);
		treesMapChunkThree[45] = new PalmTree(startXPosition + 18, row);
		treesMapChunkThree[46] = new PalmTree(startXPosition + 35, row);
		treesMapChunkThree[47] = new PalmTree(startXPosition + 36, row);
		treesMapChunkThree[48] = new PalmTree(startXPosition + 37, row);
		treesMapChunkThree[49] = new PalmTree(startXPosition + 55, row);
		treesMapChunkThree[50] = new PalmTree(startXPosition + 56, row);
		row                    = startYPosition + 36;
		treesMapChunkThree[51] = new PalmTree(startXPosition + 15, row);
		treesMapChunkThree[52] = new PalmTree(startXPosition + 25, row);
		treesMapChunkThree[53] = new PalmTree(startXPosition + 35, row);
		treesMapChunkThree[54] = new PalmTree(startXPosition + 55, row);
		treesMapChunkThree[55] = new PalmTree(startXPosition + 56, row);
		treesMapChunkThree[56] = new PalmTree(startXPosition + 57, row);
		treesMapChunkThree[57] = new PalmTree(startXPosition + 58, row);
		treesMapChunkThree[58] = new PalmTree(startXPosition + 67, row);
		treesMapChunkThree[59] = new PalmTree(startXPosition + 68, row);
		row                    = startYPosition + 44;
		treesMapChunkThree[60] = new PalmTree(startXPosition + 25, row);
		treesMapChunkThree[61] = new PalmTree(startXPosition + 26, row);
		treesMapChunkThree[62] = new PalmTree(startXPosition + 27, row);
		treesMapChunkThree[63] = new PalmTree(startXPosition + 28, row);
		treesMapChunkThree[64] = new PalmTree(startXPosition + 29, row);
		treesMapChunkThree[65] = new PalmTree(startXPosition + 35, row);
		treesMapChunkThree[66] = new PalmTree(startXPosition + 36, row);
		treesMapChunkThree[67] = new PalmTree(startXPosition + 46, row);
		treesMapChunkThree[68] = new PalmTree(startXPosition + 47, row);
		treesMapChunkThree[69] = new PalmTree(startXPosition + 48, row);
		treesMapChunkThree[70] = new PalmTree(startXPosition + 58, row);
		treesMapChunkThree[71] = new PalmTree(startXPosition + 59, row);
		treesMapChunkThree[72] = new PalmTree(startXPosition + 60, row);
		treesMapChunkThree[73] = new PalmTree(startXPosition + 67, row);
		treesMapChunkThree[74] = new PalmTree(startXPosition + 68, row);
		row 				   = startYPosition + 49;
		treesMapChunkThree[75] = new PalmTree(startXPosition + 28, row);
		treesMapChunkThree[76] = new PalmTree(startXPosition + 29, row);
		treesMapChunkThree[77] = new PalmTree(startXPosition + 30, row);
		treesMapChunkThree[78] = new PalmTree(startXPosition + 33, row);
		treesMapChunkThree[79] = new PalmTree(startXPosition + 34, row);
		treesMapChunkThree[80] = new PalmTree(startXPosition + 47, row);
		treesMapChunkThree[81] = new PalmTree(startXPosition + 48, row);
		treesMapChunkThree[82] = new PalmTree(startXPosition + 49, row);
		treesMapChunkThree[83] = new PalmTree(startXPosition + 55, row);
		treesMapChunkThree[84] = new PalmTree(startXPosition + 58, row);
		treesMapChunkThree[85] = new PalmTree(startXPosition + 66, row);
	
		addGameObjectsToGameObjectArrayList(treesMapChunkThree);
	}
}
