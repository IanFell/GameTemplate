package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtyEight extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkFourtyEight() {
		trees = new PalmTree[8];
	}

	@Override
	public void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row 		   = startYPosition + 5;
		trees[0]       = new PalmTree(startXPosition + 2, row);
		trees[1]       = new PalmTree(startXPosition + 6, row);
		trees[2]       = new PalmTree(startXPosition + 10, row);
		trees[3]       = new PalmTree(startXPosition + 16, row);
		trees[4]       = new PalmTree(startXPosition + 20, row);
		trees[5]       = new PalmTree(startXPosition + 30, row);
		trees[6]       = new PalmTree(startXPosition + 40, row);
		trees[7]       = new PalmTree(startXPosition + 41, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
