package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtySeven extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkThirtySeven() {
		trees = new PalmTree[14];
	}

	@Override
	public void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START;
		row 		   = startYPosition;
		trees[0]       = new PalmTree(startXPosition, row);
		trees[1]       = new PalmTree(startXPosition + 1, row);
		trees[2]       = new PalmTree(startXPosition + 30, row);
		trees[3]       = new PalmTree(startXPosition + 31, row);
		row 		   = startYPosition + 10;
		trees[4]       = new PalmTree(startXPosition + 20, row);
		trees[5]       = new PalmTree(startXPosition + 40, row);
		row 		   = startYPosition + 20;
		trees[6]       = new PalmTree(startXPosition + 30, row);
		trees[7]       = new PalmTree(startXPosition + 50, row);
		row 		   = startYPosition + 30;
		trees[8]       = new PalmTree(startXPosition + 30, row);
		trees[9]       = new PalmTree(startXPosition + 50, row);
		row 		   = startYPosition + 40;
		trees[10]      = new PalmTree(startXPosition + 35, row);
		trees[11]      = new PalmTree(startXPosition + 55, row);
		row 		   = startYPosition + 49;
		trees[12]      = new PalmTree(startXPosition + 60, row);
		trees[13]      = new PalmTree(startXPosition + 61, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
