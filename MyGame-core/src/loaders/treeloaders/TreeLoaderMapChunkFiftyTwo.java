package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyTwo extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkFiftyTwo() {
		trees = new PalmTree[10];
	}

	@Override
	public void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 		   = startYPosition + 30;
		trees[0]       = new PalmTree(startXPosition + 57, row);
		trees[1]       = new PalmTree(startXPosition + 58, row);
		trees[2]       = new PalmTree(startXPosition + 59, row);
		row 		   = startYPosition + 40;
		trees[3]       = new PalmTree(startXPosition + 57, row);
		trees[4]       = new PalmTree(startXPosition + 58, row);
		trees[5]       = new PalmTree(startXPosition + 59, row);
		row 		   = startYPosition + 44;
		trees[6]       = new PalmTree(startXPosition + 5, row);
		trees[7]       = new PalmTree(startXPosition + 6, row);
		row 		   = startYPosition + 48;
		trees[8]       = new PalmTree(startXPosition + 15, row);
		trees[9]       = new PalmTree(startXPosition + 16, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
