package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyThree extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFiftyThree = new PalmTree[6];
	
	@Override
	public void loadTrees() {
		startXPosition             = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition             = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				       = startYPosition + 30;
		treesMapChunkFiftyThree[0] = new PalmTree(startXPosition + 10, row);
		treesMapChunkFiftyThree[1] = new PalmTree(startXPosition + 30, row);
		treesMapChunkFiftyThree[2] = new PalmTree(startXPosition + 50, row);
		row 				       = startYPosition + 37;
		treesMapChunkFiftyThree[3] = new PalmTree(startXPosition + 20, row);
		treesMapChunkFiftyThree[4] = new PalmTree(startXPosition + 30, row);
		treesMapChunkFiftyThree[5] = new PalmTree(startXPosition + 50, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFiftyThree);
	}
}
