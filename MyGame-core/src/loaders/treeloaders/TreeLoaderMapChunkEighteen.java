package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkEighteen extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkEighteen() {
		trees = new PalmTree[9];
	}

	@Override
	public void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_TWO_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_THREE_Y_POSITION_START;
		row            = startYPosition;
		trees[0]       = new PalmTree(startXPosition + 8, row);
		row            = startYPosition + 1;
		trees[1]       = new PalmTree(startXPosition + 9, row);
		row            = startYPosition + 12;
		trees[2]       = new PalmTree(startXPosition + 9, row);
		row            = startYPosition + 20;
		trees[3]       = new PalmTree(startXPosition + 7, row);
		row            = startYPosition + 30;
		trees[4]       = new PalmTree(startXPosition + 9, row);
		row            = startYPosition + 37;
		trees[5]       = new PalmTree(startXPosition + 1, row);
		trees[6]       = new PalmTree(startXPosition + 2, row);
		row            = startYPosition + 42;
		trees[7]       = new PalmTree(startXPosition + 3, row);
		trees[8]       = new PalmTree(startXPosition + 4, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
