package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyFive extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFiftyFive = new PalmTree[18];
	
	@Override
	public void loadTrees() {
		startXPosition             = GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START;
		startYPosition             = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				       = startYPosition;
		treesMapChunkFiftyFive[0]  = new PalmTree(startXPosition, row);
		row 				       = startYPosition + 1;
		treesMapChunkFiftyFive[1]  = new PalmTree(startXPosition, row);
		row 				       = startYPosition + 2;
		treesMapChunkFiftyFive[2]  = new PalmTree(startXPosition, row);
		row 				       = startYPosition + 3;
		treesMapChunkFiftyFive[3]  = new PalmTree(startXPosition, row);
		row 				       = startYPosition + 4;
		treesMapChunkFiftyFive[4]  = new PalmTree(startXPosition, row);
		treesMapChunkFiftyFive[5]  = new PalmTree(startXPosition + 6, row);
		treesMapChunkFiftyFive[6]  = new PalmTree(startXPosition + 14, row);
		treesMapChunkFiftyFive[7]  = new PalmTree(startXPosition + 24, row);
		treesMapChunkFiftyFive[8]  = new PalmTree(startXPosition + 44, row);
		row 				       = startYPosition + 10;
		treesMapChunkFiftyFive[9]  = new PalmTree(startXPosition, row);
		treesMapChunkFiftyFive[10] = new PalmTree(startXPosition + 18, row);
		treesMapChunkFiftyFive[11] = new PalmTree(startXPosition + 19, row);
		row 				       = startYPosition + 11;
		treesMapChunkFiftyFive[12] = new PalmTree(startXPosition + 20, row);
		treesMapChunkFiftyFive[13] = new PalmTree(startXPosition + 21, row);
		treesMapChunkFiftyFive[14] = new PalmTree(startXPosition + 22, row);
		row 				       = startYPosition + 20;
		treesMapChunkFiftyFive[15] = new PalmTree(startXPosition + 30, row);
		treesMapChunkFiftyFive[16] = new PalmTree(startXPosition + 31, row);
		treesMapChunkFiftyFive[17] = new PalmTree(startXPosition + 32, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFiftyFive);
	}
}
