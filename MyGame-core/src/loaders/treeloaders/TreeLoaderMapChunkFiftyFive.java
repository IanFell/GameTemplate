package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyFive extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkFiftyFive() {
		trees = new PalmTree[18];
	}

	@Override
	public void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 		   = startYPosition;
		trees[0]       = new PalmTree(startXPosition, row);
		row 		   = startYPosition + 1;
		trees[1]       = new PalmTree(startXPosition, row);
		row 	       = startYPosition + 2;
		trees[2]       = new PalmTree(startXPosition, row);
		row 		   = startYPosition + 3;
		trees[3]       = new PalmTree(startXPosition, row);
		row 	       = startYPosition + 4;
		trees[4]       = new PalmTree(startXPosition, row);
		trees[5]       = new PalmTree(startXPosition + 6, row);
		trees[6]       = new PalmTree(startXPosition + 14, row);
		trees[7]       = new PalmTree(startXPosition + 24, row);
		trees[8]       = new PalmTree(startXPosition + 44, row);
		row 		   = startYPosition + 10;
		trees[9]       = new PalmTree(startXPosition, row);
		trees[10]      = new PalmTree(startXPosition + 18, row);
		trees[11]      = new PalmTree(startXPosition + 19, row);
		row 		   = startYPosition + 11;
		trees[12]      = new PalmTree(startXPosition + 20, row);
		trees[13]      = new PalmTree(startXPosition + 21, row);
		trees[14]      = new PalmTree(startXPosition + 22, row);
		row 		   = startYPosition + 20;
		trees[15]      = new PalmTree(startXPosition + 30, row);
		trees[16]      = new PalmTree(startXPosition + 31, row);
		trees[17]      = new PalmTree(startXPosition + 32, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
