package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentySix extends MapChunkTreeLoader {
	
	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkTwentySix() {
		trees = new PalmTree[16];
	}
	
	@Override
	public void loadTrees() {
		startXPosition	 = GameAttributeHelper.CHUNK_TWO_X_POSITION_START;
		startYPosition   = GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START;
		row 			 = startYPosition;
		trees[0]         = new PalmTree(startXPosition, row);
		trees[1]          = new PalmTree(startXPosition + 1, row);
		trees[2]          = new PalmTree(startXPosition + 2, row);
		trees[3]          = new PalmTree(startXPosition + 10, row);
		trees[4]          = new PalmTree(startXPosition + 15, row);
		row 			  = startYPosition + 5;
		trees[5]          = new PalmTree(startXPosition + 5, row);
		trees[6]          = new PalmTree(startXPosition + 8, row);
		row 			  = startYPosition + 15;
		trees[7]          = new PalmTree(startXPosition + 9, row);
		trees[8]          = new PalmTree(startXPosition + 10, row);
		trees[9]          = new PalmTree(startXPosition + 11, row);
		row 			  = startYPosition + 25;
		trees[10]         = new PalmTree(startXPosition + 12, row);
		trees[11]         = new PalmTree(startXPosition + 17, row);
		row 			  = startYPosition + 35;
		trees[12]         = new PalmTree(startXPosition + 12, row);
		trees[13]         = new PalmTree(startXPosition + 17, row);
		row 			  = startYPosition + 45;
		trees[14]         = new PalmTree(startXPosition + 25, row);
		trees[15]         = new PalmTree(startXPosition + 30, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
