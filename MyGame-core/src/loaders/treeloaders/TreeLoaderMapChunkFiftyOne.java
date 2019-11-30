package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyOne extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkFiftyOne() {
		trees = new PalmTree[12];
	}

	@Override
	public void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_THREE_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 		   = startYPosition + 10;
		trees[0]       = new PalmTree(startXPosition + 27, row);
		trees[1]       = new PalmTree(startXPosition + 28, row);
		trees[2]       = new PalmTree(startXPosition + 29, row);
		row 	       = startYPosition + 15;
		trees[3]       = new PalmTree(startXPosition + 32, row);
		trees[4]       = new PalmTree(startXPosition + 33, row);
		trees[5]       = new PalmTree(startXPosition + 34, row);
		row 		   = startYPosition + 35;
		trees[6]       = new PalmTree(startXPosition + 32, row);
		trees[7]       = new PalmTree(startXPosition + 33, row);
		trees[8]       = new PalmTree(startXPosition + 34, row);
		row 		   = startYPosition + 45;
		trees[9]       = new PalmTree(startXPosition + 48, row);
		trees[10]      = new PalmTree(startXPosition + 53, row);
		trees[11]      = new PalmTree(startXPosition + 60, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
