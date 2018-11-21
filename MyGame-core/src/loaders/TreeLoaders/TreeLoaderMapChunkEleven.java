package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkEleven extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkEleven = new NatureObject[30];
	
	@Override
	public void loadTrees() {
		startXPosition         = GameAttributeHelper.CHUNK_TWO_X_POSITION_START - 1;
		startYPosition         = GameAttributeHelper.CHUNK_TWO_Y_POSITION_START;
		row                    = startYPosition + 2;
		treesMapChunkEleven[0] = new NatureObject(startXPosition + 20, row);
		treesMapChunkEleven[1] = new NatureObject(startXPosition + 30, row);
		treesMapChunkEleven[2] = new NatureObject(startXPosition + 45, row);
		treesMapChunkEleven[3] = new NatureObject(startXPosition + 55, row);
		treesMapChunkEleven[4] = new NatureObject(startXPosition + 65, row);
		row                    = startYPosition + 7;
		treesMapChunkEleven[5] = new NatureObject(startXPosition + 27, row);
		treesMapChunkEleven[6] = new NatureObject(startXPosition + 28, row);
		treesMapChunkEleven[7] = new NatureObject(startXPosition + 38, row);
		treesMapChunkEleven[8] = new NatureObject(startXPosition + 39, row);
		treesMapChunkEleven[9] = new NatureObject(startXPosition + 50, row);
		row                    = startYPosition + 12;
		treesMapChunkEleven[10] = new NatureObject(startXPosition + 35, row);
		treesMapChunkEleven[11] = new NatureObject(startXPosition + 45, row);
		treesMapChunkEleven[12] = new NatureObject(startXPosition + 55, row);
		treesMapChunkEleven[13] = new NatureObject(startXPosition + 63, row);
		treesMapChunkEleven[14] = new NatureObject(startXPosition + 64, row);
		treesMapChunkEleven[15] = new NatureObject(startXPosition + 65, row);
		row 				    = startYPosition + 21;
		treesMapChunkEleven[16] = new NatureObject(startXPosition + 40, row);
		treesMapChunkEleven[17] = new NatureObject(startXPosition + 50, row);
		treesMapChunkEleven[18] = new NatureObject(startXPosition + 60, row);
		treesMapChunkEleven[19] = new NatureObject(startXPosition + 65, row);
		row 				    = startYPosition + 30;
		treesMapChunkEleven[20] = new NatureObject(startXPosition + 50, row);
		treesMapChunkEleven[21] = new NatureObject(startXPosition + 51, row);
		row 				    = startYPosition + 35;
		treesMapChunkEleven[22] = new NatureObject(startXPosition + 54, row);
		treesMapChunkEleven[23] = new NatureObject(startXPosition + 55, row);
		treesMapChunkEleven[24] = new NatureObject(startXPosition + 62, row);
		row 				    = startYPosition + 40;
		treesMapChunkEleven[25] = new NatureObject(startXPosition + 59, row);
		treesMapChunkEleven[26] = new NatureObject(startXPosition + 62, row);
		row 				    = startYPosition + 43;
		treesMapChunkEleven[27] = new NatureObject(startXPosition + 62, row);
		treesMapChunkEleven[28] = new NatureObject(startXPosition + 66, row);
		row 				    = startYPosition + 49;
		treesMapChunkEleven[29] = new NatureObject(startXPosition + 68, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkEleven);
	}
}
