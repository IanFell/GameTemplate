package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwo extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwo = new PalmTree[45];
	
	@Override
	public void loadTrees() {
		startXPosition       = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 32;
		startYPosition       = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START;
		row   		         = startYPosition;
		treesMapChunkTwo[0]  = new PalmTree(startXPosition + 2, row);
		treesMapChunkTwo[1]  = new PalmTree(startXPosition + 3, row);
		treesMapChunkTwo[2]  = new PalmTree(startXPosition + 4, row);
		treesMapChunkTwo[3]  = new PalmTree(startXPosition + 5, row);
		treesMapChunkTwo[4]  = new PalmTree(startXPosition + 6, row);
		treesMapChunkTwo[5]  = new PalmTree(startXPosition + 12, row);
		treesMapChunkTwo[6]  = new PalmTree(startXPosition + 13, row);
		treesMapChunkTwo[7]  = new PalmTree(startXPosition + 14, row);
		treesMapChunkTwo[8]  = new PalmTree(startXPosition + 15, row);
		treesMapChunkTwo[9]  = new PalmTree(startXPosition + 16, row);
		treesMapChunkTwo[10] = new PalmTree(startXPosition + 23, row);
		treesMapChunkTwo[11] = new PalmTree(startXPosition + 24, row);
		treesMapChunkTwo[12] = new PalmTree(startXPosition + 25, row);
		treesMapChunkTwo[13] = new PalmTree(startXPosition + 26, row);
		treesMapChunkTwo[14] = new PalmTree(startXPosition + 27, row);
		treesMapChunkTwo[15] = new PalmTree(startXPosition + 33, row);
		treesMapChunkTwo[16] = new PalmTree(startXPosition + 34, row);
		treesMapChunkTwo[17] = new PalmTree(startXPosition + 35, row);
		row                  = startYPosition + 3;
		treesMapChunkTwo[18] = new PalmTree(startXPosition + 7, row);
		treesMapChunkTwo[19] = new PalmTree(startXPosition + 8, row);
		treesMapChunkTwo[20] = new PalmTree(startXPosition + 9, row);
		treesMapChunkTwo[21] = new PalmTree(startXPosition + 10, row);
		treesMapChunkTwo[22] = new PalmTree(startXPosition + 11, row);
		treesMapChunkTwo[23] = new PalmTree(startXPosition + 33, row);
		treesMapChunkTwo[24] = new PalmTree(startXPosition + 34, row);
		treesMapChunkTwo[25] = new PalmTree(startXPosition + 35, row);
		row                  = startYPosition + 6;
		treesMapChunkTwo[26] = new PalmTree(startXPosition + 16, row);
		treesMapChunkTwo[27] = new PalmTree(startXPosition + 26, row);
		treesMapChunkTwo[28] = new PalmTree(startXPosition + 32, row);
		row                  = startYPosition + 9;
		treesMapChunkTwo[29] = new PalmTree(startXPosition + 22, row);
		treesMapChunkTwo[30] = new PalmTree(startXPosition + 32, row);
		treesMapChunkTwo[31] = new PalmTree(startXPosition + 35, row);
		row                  = startYPosition + 13;
		treesMapChunkTwo[32] = new PalmTree(startXPosition + 18, row);
		treesMapChunkTwo[33] = new PalmTree(startXPosition + 19, row);
		treesMapChunkTwo[34] = new PalmTree(startXPosition + 22, row);
		treesMapChunkTwo[35] = new PalmTree(startXPosition + 23, row);
		treesMapChunkTwo[36] = new PalmTree(startXPosition + 30, row);
		row                  = startYPosition + 18;
		treesMapChunkTwo[37] = new PalmTree(startXPosition + 30, row);
		treesMapChunkTwo[38] = new PalmTree(startXPosition + 31, row);
		treesMapChunkTwo[39] = new PalmTree(startXPosition + 32, row);
		row                  = startYPosition + 22;
		treesMapChunkTwo[40] = new PalmTree(startXPosition + 34, row);
		treesMapChunkTwo[41] = new PalmTree(startXPosition + 35, row);
		row                  =  + 26;
		treesMapChunkTwo[42] = new PalmTree(startXPosition + 30, row);
		treesMapChunkTwo[43] = new PalmTree(startXPosition + 34, row);
		row                  = startYPosition + 30;
		treesMapChunkTwo[44] = new PalmTree(startXPosition + 35, row);
	
		addGameObjectsToGameObjectArrayList(treesMapChunkTwo);
	}
}
