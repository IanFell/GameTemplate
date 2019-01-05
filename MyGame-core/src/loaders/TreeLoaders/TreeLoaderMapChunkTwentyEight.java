package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyEight extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentyEight = new PalmTree[14];
	
	@Override
	public void loadTrees() {
		startXPosition		         = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition		         = GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START;
		row 				         = startYPosition;
		treesMapChunkTwentyEight[0]  = new PalmTree(startXPosition + 17, row);
		treesMapChunkTwentyEight[1]  = new PalmTree(startXPosition + 28, row);
		treesMapChunkTwentyEight[2]  = new PalmTree(startXPosition + 40, row);
		treesMapChunkTwentyEight[3]  = new PalmTree(startXPosition + 41, row);
		row 				         = startYPosition + 10;
		treesMapChunkTwentyEight[4]  = new PalmTree(startXPosition + 30, row);
		treesMapChunkTwentyEight[5]  = new PalmTree(startXPosition + 35, row);
		treesMapChunkTwentyEight[6]  = new PalmTree(startXPosition + 36, row);
		treesMapChunkTwentyEight[7]  = new PalmTree(startXPosition + 50, row);
		treesMapChunkTwentyEight[8]  = new PalmTree(startXPosition + 51, row);
		row 				         = startYPosition + 20;
		treesMapChunkTwentyEight[9]  = new PalmTree(startXPosition + 39, row);
		treesMapChunkTwentyEight[10] = new PalmTree(startXPosition + 40, row);
		treesMapChunkTwentyEight[11] = new PalmTree(startXPosition + 41, row);
		treesMapChunkTwentyEight[12] = new PalmTree(startXPosition + 50, row);
		treesMapChunkTwentyEight[13] = new PalmTree(startXPosition + 51, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkTwentyEight);
	}
}
