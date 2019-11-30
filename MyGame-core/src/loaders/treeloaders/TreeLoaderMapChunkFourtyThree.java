package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtyThree extends MapChunkTreeLoader {
	
	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkFourtyThree() {
		trees = new PalmTree[7];
	}

	@Override
	protected void loadTrees() {
		startXPosition	= GameAttributeHelper.CHUNK_THREE_X_POSITION_START;
		startYPosition	= GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row 			= startYPosition + 15;
		trees[0]        = new PalmTree(startXPosition + 5, row);
		row 			= startYPosition + 20;
		trees[1]        = new PalmTree(startXPosition + 5, row);
		row 			= startYPosition + 25;
		trees[2]        = new PalmTree(startXPosition + 5, row);
		row 		    = startYPosition + 30;
		trees[3]        = new PalmTree(startXPosition + 5, row);
		row 		    = startYPosition + 35;
		trees[4]        = new PalmTree(startXPosition + 10, row);
		row 			= startYPosition + 40;
		trees[5]        = new PalmTree(startXPosition + 10, row);
		row 		    = startYPosition + 45;
		trees[6]        = new PalmTree(startXPosition + 20, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
