package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtySeven extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtySeven = new PalmTree[14];
	
	@Override
	public void loadTrees() {
		startXPosition		         = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition		         = GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START;
		row 				         = startYPosition;
		treesMapChunkThirtySeven[0]  = new PalmTree(startXPosition, row);
		treesMapChunkThirtySeven[1]  = new PalmTree(startXPosition + 1, row);
		treesMapChunkThirtySeven[2]  = new PalmTree(startXPosition + 30, row);
		treesMapChunkThirtySeven[3]  = new PalmTree(startXPosition + 31, row);
		row 				         = startYPosition + 10;
		treesMapChunkThirtySeven[4]  = new PalmTree(startXPosition + 20, row);
		treesMapChunkThirtySeven[5]  = new PalmTree(startXPosition + 40, row);
		row 				         = startYPosition + 20;
		treesMapChunkThirtySeven[6]  = new PalmTree(startXPosition + 30, row);
		treesMapChunkThirtySeven[7]  = new PalmTree(startXPosition + 50, row);
		row 				         = startYPosition + 30;
		treesMapChunkThirtySeven[8]  = new PalmTree(startXPosition + 30, row);
		treesMapChunkThirtySeven[9]  = new PalmTree(startXPosition + 50, row);
		row 				         = startYPosition + 40;
		treesMapChunkThirtySeven[10] = new PalmTree(startXPosition + 35, row);
		treesMapChunkThirtySeven[11] = new PalmTree(startXPosition + 55, row);
		row 				         = startYPosition + 49;
		treesMapChunkThirtySeven[12] = new PalmTree(startXPosition + 60, row);
		treesMapChunkThirtySeven[13] = new PalmTree(startXPosition + 61, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkThirtySeven);
	}
}
