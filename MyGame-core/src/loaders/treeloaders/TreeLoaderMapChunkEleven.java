package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkEleven extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkEleven() {
		trees = new PalmTree[30];
	}

	@Override
	public void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 1;
		startYPosition = GameAttributeHelper.CHUNK_TWO_Y_POSITION_START;
		row            = startYPosition + 2;
		trees[0]       = new PalmTree(startXPosition + 20, row);
		trees[1]       = new PalmTree(startXPosition + 30, row);
		trees[2]       = new PalmTree(startXPosition + 45, row);
		trees[3]       = new PalmTree(startXPosition + 55, row);
		trees[4]       = new PalmTree(startXPosition + 65, row);
		row            = startYPosition + 7;
		trees[5]       = new PalmTree(startXPosition + 27, row);
		trees[6]       = new PalmTree(startXPosition + 28, row);
		trees[7]       = new PalmTree(startXPosition + 38, row);
		trees[8]       = new PalmTree(startXPosition + 39, row);
		trees[9]       = new PalmTree(startXPosition + 50, row);
		row            = startYPosition + 12;
		trees[10]      = new PalmTree(startXPosition + 35, row);
		trees[11]      = new PalmTree(startXPosition + 45, row);
		trees[12]      = new PalmTree(startXPosition + 55, row);
		trees[13]      = new PalmTree(startXPosition + 63, row);
		trees[14]      = new PalmTree(startXPosition + 64, row);
		trees[15]      = new PalmTree(startXPosition + 65, row);
		row 		   = startYPosition + 21;
		trees[16]      = new PalmTree(startXPosition + 40, row);
		trees[17]      = new PalmTree(startXPosition + 50, row);
		trees[18]      = new PalmTree(startXPosition + 60, row);
		trees[19]      = new PalmTree(startXPosition + 65, row);
		row 		   = startYPosition + 30;
		trees[20]      = new PalmTree(startXPosition + 50, row);
		trees[21]      = new PalmTree(startXPosition + 51, row);
		row 		   = startYPosition + 35;
		trees[22]      = new PalmTree(startXPosition + 54, row);
		trees[23]      = new PalmTree(startXPosition + 55, row);
		trees[24]      = new PalmTree(startXPosition + 62, row);
		row 		   = startYPosition + 40;
		trees[25]      = new PalmTree(startXPosition + 59, row);
		trees[26]      = new PalmTree(startXPosition + 62, row);
		row 		   = startYPosition + 43;
		trees[27]      = new PalmTree(startXPosition + 62, row);
		trees[28]      = new PalmTree(startXPosition + 66, row);
		row 		   = startYPosition + 49;
		trees[29]      = new PalmTree(startXPosition + 68, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
