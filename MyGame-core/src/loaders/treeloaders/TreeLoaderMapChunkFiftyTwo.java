package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyTwo extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFiftyTwo = new PalmTree[10];
	
	@Override
	public void loadTrees() {
		startXPosition            = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition            = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				      = startYPosition + 30;
		treesMapChunkFiftyTwo[0]  = new PalmTree(startXPosition + 57, row);
		treesMapChunkFiftyTwo[1]  = new PalmTree(startXPosition + 58, row);
		treesMapChunkFiftyTwo[2]  = new PalmTree(startXPosition + 59, row);
		row 				      = startYPosition + 40;
		treesMapChunkFiftyTwo[3]  = new PalmTree(startXPosition + 57, row);
		treesMapChunkFiftyTwo[4]  = new PalmTree(startXPosition + 58, row);
		treesMapChunkFiftyTwo[5]  = new PalmTree(startXPosition + 59, row);
		row 				      = startYPosition + 44;
		treesMapChunkFiftyTwo[6]  = new PalmTree(startXPosition + 5, row);
		treesMapChunkFiftyTwo[7]  = new PalmTree(startXPosition + 6, row);
		row 				      = startYPosition + 48;
		treesMapChunkFiftyTwo[8]  = new PalmTree(startXPosition + 15, row);
		treesMapChunkFiftyTwo[9]  = new PalmTree(startXPosition + 16, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFiftyTwo);
	}
}
