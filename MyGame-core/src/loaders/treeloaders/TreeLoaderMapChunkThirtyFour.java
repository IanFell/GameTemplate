package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyFour extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkThirtyFour() {
		trees = new PalmTree[4];
	}

	@Override
	public void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_TWO_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START;
		row 		   = startYPosition;
		trees[0]       = new PalmTree(startXPosition + 27, row);
		trees[1]       = new PalmTree(startXPosition + 36, row);
		row 		   = startYPosition + 25;
		trees[2]       = new PalmTree(startXPosition + 39, row);
		trees[3]       = new PalmTree(startXPosition + 46, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
