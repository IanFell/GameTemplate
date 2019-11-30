package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyFour extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkFiftyFour() {
		trees = new PalmTree[17];
	}

	@Override
	public void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_SIX_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 		   = startYPosition + 10;
		trees[0]       = new PalmTree(startXPosition + 10, row);
		trees[1]       = new PalmTree(startXPosition + 11, row);
		trees[2]       = new PalmTree(startXPosition + 30, row);
		trees[3]       = new PalmTree(startXPosition + 31, row);
		trees[4]       = new PalmTree(startXPosition + 45, row);
		row 		   = startYPosition + 25;
		trees[5]       = new PalmTree(startXPosition + 19, row);
		trees[6]       = new PalmTree(startXPosition + 20, row);
		trees[7]       = new PalmTree(startXPosition + 21, row);
		trees[8]       = new PalmTree(startXPosition + 22, row);
		trees[9]       = new PalmTree(startXPosition + 23, row);
		trees[10]      = new PalmTree(startXPosition + 39, row);
		trees[11]      = new PalmTree(startXPosition + 40, row);
		trees[12]      = new PalmTree(startXPosition + 41, row);
		trees[13]      = new PalmTree(startXPosition + 42, row);
		trees[14]      = new PalmTree(startXPosition + 43, row);
		row 		   = startYPosition + 40;
		trees[15]      = new PalmTree(startXPosition + 55, row);
		trees[16]      = new PalmTree(startXPosition + 56, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
