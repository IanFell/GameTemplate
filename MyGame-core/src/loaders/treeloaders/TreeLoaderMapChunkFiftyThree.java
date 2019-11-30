package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyThree extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkFiftyThree() {
		trees = new PalmTree[6];
	}

	@Override
	public void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 	       = startYPosition + 30;
		trees[0]       = new PalmTree(startXPosition + 10, row);
		trees[1]       = new PalmTree(startXPosition + 30, row);
		trees[2]       = new PalmTree(startXPosition + 50, row);
		row 		   = startYPosition + 37;
		trees[3]       = new PalmTree(startXPosition + 20, row);
		trees[4]       = new PalmTree(startXPosition + 30, row);
		trees[5]       = new PalmTree(startXPosition + 50, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
