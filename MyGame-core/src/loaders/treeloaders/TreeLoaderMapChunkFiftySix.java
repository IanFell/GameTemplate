package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftySix extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkFiftySix() {
		trees = new PalmTree[14];
	}

	@Override
	public void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 	       = startYPosition;
		trees[0]       = new PalmTree(startXPosition + 5, row);
		trees[1]       = new PalmTree(startXPosition + 10, row);
		trees[2]       = new PalmTree(startXPosition + 15, row);
		trees[3]       = new PalmTree(startXPosition + 20, row);
		trees[4]       = new PalmTree(startXPosition + 25, row);
		trees[5]       = new PalmTree(startXPosition + 30, row);
		trees[6]       = new PalmTree(startXPosition + 35, row);
		row 		   = startYPosition + 5;
		trees[7]       = new PalmTree(startXPosition + 7, row);
		row 		   = startYPosition + 6;
		trees[8]       = new PalmTree(startXPosition + 17, row);
		trees[9]       = new PalmTree(startXPosition + 18, row);
		trees[10]      = new PalmTree(startXPosition + 19, row);
		row 		   = startYPosition + 7;
		trees[11]      = new PalmTree(startXPosition + 27, row);
		trees[12]      = new PalmTree(startXPosition + 28, row);
		trees[13]      = new PalmTree(startXPosition + 29, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
