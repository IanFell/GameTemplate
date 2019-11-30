package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtyFive extends MapChunkTreeLoader {
	
	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkFourtyFive() {
		trees = new PalmTree[34];
	}
	
	@Override
	protected void loadTrees() {
		startXPosition = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row 		   = startYPosition + 10;
		trees[0]       = new PalmTree(startXPosition + 29, row);
		trees[1]       = new PalmTree(startXPosition + 30, row);
		trees[2]       = new PalmTree(startXPosition + 31, row);
		trees[3]       = new PalmTree(startXPosition + 32, row);
		row 	       = startYPosition + 15;
		trees[4]       = new PalmTree(startXPosition + 34, row);
		trees[5]       = new PalmTree(startXPosition + 35, row);
		trees[6]       = new PalmTree(startXPosition + 36, row);
		trees[7]       = new PalmTree(startXPosition + 50, row);
		trees[8]       = new PalmTree(startXPosition + 51, row);
		trees[9]       = new PalmTree(startXPosition + 52, row);
		trees[10]      = new PalmTree(startXPosition + 60, row);
		trees[11]      = new PalmTree(startXPosition + 61, row);
		trees[12]      = new PalmTree(startXPosition + 62, row);
		row 		   = startYPosition + 25;
		trees[13]      = new PalmTree(startXPosition + 40, row);
		trees[14]      = new PalmTree(startXPosition + 41, row);
		trees[15]      = new PalmTree(startXPosition + 42, row);
		trees[16]      = new PalmTree(startXPosition + 62, row);
		trees[17]      = new PalmTree(startXPosition + 63, row);
		row 		   = startYPosition + 26;
		trees[18]      = new PalmTree(startXPosition + 40, row);
		row 		   = startYPosition + 27;
		trees[19]      = new PalmTree(startXPosition + 40, row);
		trees[20]      = new PalmTree(startXPosition + 41, row);
		trees[21]      = new PalmTree(startXPosition + 42, row);
		row 		   = startYPosition + 37;
		trees[22]      = new PalmTree(startXPosition + 45, row);
		trees[23]      = new PalmTree(startXPosition + 46, row);
		trees[24]      = new PalmTree(startXPosition + 47, row);
		trees[25]      = new PalmTree(startXPosition + 59, row);
		trees[26]      = new PalmTree(startXPosition + 60, row);
		trees[27]      = new PalmTree(startXPosition + 61, row);
		row 		   = startYPosition + 42;
		trees[28]      = new PalmTree(startXPosition + 50, row);
		trees[29]      = new PalmTree(startXPosition + 51, row);
		row 		   = startYPosition + 47;
		trees[30]      = new PalmTree(startXPosition + 55, row);
		trees[31]      = new PalmTree(startXPosition + 56, row);
		trees[32]      = new PalmTree(startXPosition + 63, row);
		trees[33]      = new PalmTree(startXPosition + 64, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
