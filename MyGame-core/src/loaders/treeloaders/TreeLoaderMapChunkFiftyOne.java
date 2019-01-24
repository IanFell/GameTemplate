package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyOne extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFfiftyOne = new PalmTree[12];
	
	@Override
	public void loadTrees() {
		startXPosition             = GameAttributeHelper.CHUNK_TWO_X_POSITION_START;
		startYPosition             = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				       = startYPosition + 10;
		treesMapChunkFfiftyOne[0]  = new PalmTree(startXPosition + 27, row);
		treesMapChunkFfiftyOne[1]  = new PalmTree(startXPosition + 28, row);
		treesMapChunkFfiftyOne[2]  = new PalmTree(startXPosition + 29, row);
		row 				       = startYPosition + 15;
		treesMapChunkFfiftyOne[3]  = new PalmTree(startXPosition + 32, row);
		treesMapChunkFfiftyOne[4]  = new PalmTree(startXPosition + 33, row);
		treesMapChunkFfiftyOne[5]  = new PalmTree(startXPosition + 34, row);
		row 				       = startYPosition + 35;
		treesMapChunkFfiftyOne[6]  = new PalmTree(startXPosition + 32, row);
		treesMapChunkFfiftyOne[7]  = new PalmTree(startXPosition + 33, row);
		treesMapChunkFfiftyOne[8]  = new PalmTree(startXPosition + 34, row);
		row 				       = startYPosition + 45;
		treesMapChunkFfiftyOne[9]  = new PalmTree(startXPosition + 48, row);
		treesMapChunkFfiftyOne[10] = new PalmTree(startXPosition + 53, row);
		treesMapChunkFfiftyOne[11] = new PalmTree(startXPosition + 60, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFfiftyOne);
	}
}
