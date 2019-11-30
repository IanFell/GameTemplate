package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyEight extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkTwentyEight() {
		trees = new PalmTree[14];
	}

	@Override
	public void loadTrees() {
		startXPosition	 = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition	 = GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START;
		row 			 = startYPosition;
		trees[0]         = new PalmTree(startXPosition + 17, row);
		trees[1]         = new PalmTree(startXPosition + 28, row);
		trees[2]         = new PalmTree(startXPosition + 40, row);
		trees[3]         = new PalmTree(startXPosition + 41, row);
		row 			 = startYPosition + 10;
		trees[4]         = new PalmTree(startXPosition + 30, row);
		trees[5]         = new PalmTree(startXPosition + 35, row);
		trees[6]         = new PalmTree(startXPosition + 36, row);
		trees[7]         = new PalmTree(startXPosition + 50, row);
		trees[8]         = new PalmTree(startXPosition + 51, row);
		row 		     = startYPosition + 20;
		trees[9]         = new PalmTree(startXPosition + 39, row);
		trees[10]        = new PalmTree(startXPosition + 40, row);
		trees[11]        = new PalmTree(startXPosition + 41, row);
		trees[12]        = new PalmTree(startXPosition + 50, row);
		trees[13]        = new PalmTree(startXPosition + 51, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
