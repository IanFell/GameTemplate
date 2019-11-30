package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwenty extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkTwenty() {
		trees = new PalmTree[49];
	}

	@Override
	public void loadTrees() {
		startXPosition  = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition	= GameAttributeHelper.CHUNK_THREE_Y_POSITION_START;
		row             = startYPosition + 5;
		trees[0]        = new PalmTree(startXPosition + 25, row);
		trees[1]        = new PalmTree(startXPosition + 40, row);
		trees[2]        = new PalmTree(startXPosition + 41, row);
		trees[3]        = new PalmTree(startXPosition + 42, row);
		trees[4]        = new PalmTree(startXPosition + 52, row);
		trees[5]        = new PalmTree(startXPosition + 53, row);
		trees[6]        = new PalmTree(startXPosition + 54, row);
		row             = startYPosition + 13;
		trees[7]        = new PalmTree(startXPosition + 34, row);
		trees[8]        = new PalmTree(startXPosition + 35, row);
		trees[9]        = new PalmTree(startXPosition + 51, row);
		trees[10]       = new PalmTree(startXPosition + 52, row);
		row             = startYPosition + 17;
		trees[11]       = new PalmTree(startXPosition + 43, row);
		trees[12]       = new PalmTree(startXPosition + 44, row);
		trees[13]       = new PalmTree(startXPosition + 48, row);
		trees[14]       = new PalmTree(startXPosition + 52, row);
		trees[15]       = new PalmTree(startXPosition + 56, row);
		trees[16]       = new PalmTree(startXPosition + 60, row);
		trees[17]       = new PalmTree(startXPosition + 67, row);
		row             = startYPosition + 21;
		trees[18]       = new PalmTree(startXPosition + 32, row);
		trees[19]       = new PalmTree(startXPosition + 33, row);
		trees[20]       = new PalmTree(startXPosition + 37, row);
		trees[21]       = new PalmTree(startXPosition + 38, row);
		trees[22]       = new PalmTree(startXPosition + 45, row);
		trees[23]       = new PalmTree(startXPosition + 46, row);
		trees[24]       = new PalmTree(startXPosition + 50, row);
		trees[25]       = new PalmTree(startXPosition + 55, row);
		trees[26]       = new PalmTree(startXPosition + 63, row);
		row             = startYPosition + 29;
		trees[27]       = new PalmTree(startXPosition + 40, row);
		trees[28]       = new PalmTree(startXPosition + 41, row);
		trees[29]       = new PalmTree(startXPosition + 42, row);
		trees[30]       = new PalmTree(startXPosition + 43, row);
		trees[31]       = new PalmTree(startXPosition + 44, row);
		trees[32]       = new PalmTree(startXPosition + 54, row);
		trees[33]       = new PalmTree(startXPosition + 55, row);
		trees[34]       = new PalmTree(startXPosition + 56, row);
		trees[35]       = new PalmTree(startXPosition + 57, row);
		trees[36]       = new PalmTree(startXPosition + 58, row);
		row             = startYPosition + 35;
		trees[37]       = new PalmTree(startXPosition + 31, row);
		trees[38]       = new PalmTree(startXPosition + 34, row);
		trees[39]       = new PalmTree(startXPosition + 37, row);
		trees[40]       = new PalmTree(startXPosition + 46, row);
		trees[41]       = new PalmTree(startXPosition + 47, row);
		trees[42]       = new PalmTree(startXPosition + 48, row);
		trees[43]       = new PalmTree(startXPosition + 60, row);
		trees[44]       = new PalmTree(startXPosition + 61, row);
		trees[45]       = new PalmTree(startXPosition + 62, row);
		row             = startYPosition + 45;
		trees[46]       = new PalmTree(startXPosition + 35, row);
		trees[47]       = new PalmTree(startXPosition + 45, row);
		trees[48]       = new PalmTree(startXPosition + 55, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
