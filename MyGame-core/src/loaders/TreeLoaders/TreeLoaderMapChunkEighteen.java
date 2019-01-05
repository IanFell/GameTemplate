package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkEighteen extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkEighteen = new PalmTree[9];
	
	@Override
	public void loadTrees() {
		startXPosition		     = GameAttributeHelper.CHUNK_TWO_X_POSITION_START;
		startYPosition           = GameAttributeHelper.CHUNK_THREE_Y_POSITION_START;
		row                      = startYPosition;
		treesMapChunkEighteen[0] = new PalmTree(startXPosition + 8, row);
		row                      = startYPosition + 1;
		treesMapChunkEighteen[1] = new PalmTree(startXPosition + 9, row);
		row                      = startYPosition + 12;
		treesMapChunkEighteen[2] = new PalmTree(startXPosition + 9, row);
		row                      = startYPosition + 20;
		treesMapChunkEighteen[3] = new PalmTree(startXPosition + 7, row);
		row                      = startYPosition + 30;
		treesMapChunkEighteen[4] = new PalmTree(startXPosition + 9, row);
		row                      = startYPosition + 37;
		treesMapChunkEighteen[5] = new PalmTree(startXPosition + 1, row);
		treesMapChunkEighteen[6] = new PalmTree(startXPosition + 2, row);
		row                      = startYPosition + 42;
		treesMapChunkEighteen[7] = new PalmTree(startXPosition + 3, row);
		treesMapChunkEighteen[8] = new PalmTree(startXPosition + 4, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkEighteen);
	}
}
