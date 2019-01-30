package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkEleven extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkEleven = new PalmTree[30];
	
	@Override
	public void loadTrees() {
		startXPosition         = GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 1;
		startYPosition         = GameAttributeHelper.CHUNK_TWO_Y_POSITION_START;
		row                    = startYPosition + 2;
		treesMapChunkEleven[0] = new PalmTree(startXPosition + 20, row);
		treesMapChunkEleven[1] = new PalmTree(startXPosition + 30, row);
		treesMapChunkEleven[2] = new PalmTree(startXPosition + 45, row);
		treesMapChunkEleven[3] = new PalmTree(startXPosition + 55, row);
		treesMapChunkEleven[4] = new PalmTree(startXPosition + 65, row);
		row                    = startYPosition + 7;
		treesMapChunkEleven[5] = new PalmTree(startXPosition + 27, row);
		treesMapChunkEleven[6] = new PalmTree(startXPosition + 28, row);
		treesMapChunkEleven[7] = new PalmTree(startXPosition + 38, row);
		treesMapChunkEleven[8] = new PalmTree(startXPosition + 39, row);
		treesMapChunkEleven[9] = new PalmTree(startXPosition + 50, row);
		row                    = startYPosition + 12;
		treesMapChunkEleven[10] = new PalmTree(startXPosition + 35, row);
		treesMapChunkEleven[11] = new PalmTree(startXPosition + 45, row);
		treesMapChunkEleven[12] = new PalmTree(startXPosition + 55, row);
		treesMapChunkEleven[13] = new PalmTree(startXPosition + 63, row);
		treesMapChunkEleven[14] = new PalmTree(startXPosition + 64, row);
		treesMapChunkEleven[15] = new PalmTree(startXPosition + 65, row);
		row 				    = startYPosition + 21;
		treesMapChunkEleven[16] = new PalmTree(startXPosition + 40, row);
		treesMapChunkEleven[17] = new PalmTree(startXPosition + 50, row);
		treesMapChunkEleven[18] = new PalmTree(startXPosition + 60, row);
		treesMapChunkEleven[19] = new PalmTree(startXPosition + 65, row);
		row 				    = startYPosition + 30;
		treesMapChunkEleven[20] = new PalmTree(startXPosition + 50, row);
		treesMapChunkEleven[21] = new PalmTree(startXPosition + 51, row);
		row 				    = startYPosition + 35;
		treesMapChunkEleven[22] = new PalmTree(startXPosition + 54, row);
		treesMapChunkEleven[23] = new PalmTree(startXPosition + 55, row);
		treesMapChunkEleven[24] = new PalmTree(startXPosition + 62, row);
		row 				    = startYPosition + 40;
		treesMapChunkEleven[25] = new PalmTree(startXPosition + 59, row);
		treesMapChunkEleven[26] = new PalmTree(startXPosition + 62, row);
		row 				    = startYPosition + 43;
		treesMapChunkEleven[27] = new PalmTree(startXPosition + 62, row);
		treesMapChunkEleven[28] = new PalmTree(startXPosition + 66, row);
		row 				    = startYPosition + 49;
		treesMapChunkEleven[29] = new PalmTree(startXPosition + 68, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkEleven);
	}
}
