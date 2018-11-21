package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtySeven extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtySeven = new NatureObject[14];
	
	@Override
	public void loadTrees() {
		startXPosition		         = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition		         = GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START;
		row 				         = startYPosition;
		treesMapChunkThirtySeven[0]  = new NatureObject(startXPosition, row);
		treesMapChunkThirtySeven[1]  = new NatureObject(startXPosition + 1, row);
		treesMapChunkThirtySeven[2]  = new NatureObject(startXPosition + 30, row);
		treesMapChunkThirtySeven[3]  = new NatureObject(startXPosition + 31, row);
		row 				         = startYPosition + 10;
		treesMapChunkThirtySeven[4]  = new NatureObject(startXPosition + 20, row);
		treesMapChunkThirtySeven[5]  = new NatureObject(startXPosition + 40, row);
		row 				         = startYPosition + 20;
		treesMapChunkThirtySeven[6]  = new NatureObject(startXPosition + 30, row);
		treesMapChunkThirtySeven[7]  = new NatureObject(startXPosition + 50, row);
		row 				         = startYPosition + 30;
		treesMapChunkThirtySeven[8]  = new NatureObject(startXPosition + 30, row);
		treesMapChunkThirtySeven[9]  = new NatureObject(startXPosition + 50, row);
		row 				         = startYPosition + 40;
		treesMapChunkThirtySeven[10] = new NatureObject(startXPosition + 35, row);
		treesMapChunkThirtySeven[11] = new NatureObject(startXPosition + 55, row);
		row 				         = startYPosition + 49;
		treesMapChunkThirtySeven[12] = new NatureObject(startXPosition + 60, row);
		treesMapChunkThirtySeven[13] = new NatureObject(startXPosition + 61, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkThirtySeven);
	}
}
