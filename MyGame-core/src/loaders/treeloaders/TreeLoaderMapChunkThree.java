package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThree extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkThree() {
		trees = new PalmTree[86];
	}

	@Override
	public void loadTrees() {
		startXPosition  = GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 1;
		startYPosition  = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START;
		row             = startYPosition;
		trees[0]        = new PalmTree(startXPosition + 5, row);
		trees[1]        = new PalmTree(startXPosition + 15, row);
		trees[2]        = new PalmTree(startXPosition + 16, row);
		trees[3]        = new PalmTree(startXPosition + 17, row);
		trees[4]        = new PalmTree(startXPosition + 18, row);
		trees[5]        = new PalmTree(startXPosition + 19, row);
		trees[6]        = new PalmTree(startXPosition + 29, row);
		trees[7]        = new PalmTree(startXPosition + 30, row);
		trees[8]        = new PalmTree(startXPosition + 31, row);
		trees[9]        = new PalmTree(startXPosition + 32, row);
		trees[10]       = new PalmTree(startXPosition + 33, row);
		row             = startYPosition + 5;
		trees[11]       = new PalmTree(startXPosition + 7, row);
		trees[12]       = new PalmTree(startXPosition + 8, row);
		trees[13]       = new PalmTree(startXPosition + 9, row);
		row             = startYPosition + 14;
		trees[14]       = new PalmTree(startXPosition + 20, row);
		trees[15]       = new PalmTree(startXPosition + 21, row);
		trees[16]       = new PalmTree(startXPosition + 22, row);
		trees[17]       = new PalmTree(startXPosition + 30, row);
		trees[18]       = new PalmTree(startXPosition + 31, row);
		trees[19]       = new PalmTree(startXPosition + 32, row);
		trees[20]       = new PalmTree(startXPosition + 45, row);
		trees[21]       = new PalmTree(startXPosition + 46, row);
		trees[22]       = new PalmTree(startXPosition + 47, row);
		trees[23]       = new PalmTree(startXPosition + 48, row);
		trees[24]       = new PalmTree(startXPosition + 49, row);
		trees[25]       = new PalmTree(startXPosition + 64, row);
		trees[26]       = new PalmTree(startXPosition + 65, row);
		trees[27]       = new PalmTree(startXPosition + 66, row);
		trees[28]       = new PalmTree(startXPosition + 67, row);
		trees[29]       = new PalmTree(startXPosition + 68, row);
		row             = startYPosition + 19;
		trees[30]       = new PalmTree(startXPosition + 5, row);
		trees[31]       = new PalmTree(startXPosition + 6, row);
		trees[32]       = new PalmTree(startXPosition + 10, row);
		trees[33]       = new PalmTree(startXPosition + 11, row);
		trees[34]       = new PalmTree(startXPosition + 12, row);
		trees[35]       = new PalmTree(startXPosition + 23, row);
		trees[36]       = new PalmTree(startXPosition + 24, row);
		trees[37]       = new PalmTree(startXPosition + 25, row);
		trees[38]       = new PalmTree(startXPosition + 33, row);
		trees[39]       = new PalmTree(startXPosition + 34, row);
		trees[40]       = new PalmTree(startXPosition + 45, row);
		trees[41]       = new PalmTree(startXPosition + 46, row);
		trees[42]       = new PalmTree(startXPosition + 47, row);
		row             = startYPosition + 26;
		trees[43]       = new PalmTree(startXPosition + 16, row);
		trees[44]       = new PalmTree(startXPosition + 17, row);
		trees[45]       = new PalmTree(startXPosition + 18, row);
		trees[46]       = new PalmTree(startXPosition + 35, row);
		trees[47]       = new PalmTree(startXPosition + 36, row);
		trees[48]       = new PalmTree(startXPosition + 37, row);
		trees[49]       = new PalmTree(startXPosition + 55, row);
		trees[50]       = new PalmTree(startXPosition + 56, row);
		row             = startYPosition + 36;
		trees[51]       = new PalmTree(startXPosition + 15, row);
		trees[52]       = new PalmTree(startXPosition + 25, row);
		trees[53]       = new PalmTree(startXPosition + 35, row);
		trees[54]       = new PalmTree(startXPosition + 55, row);
		trees[55]       = new PalmTree(startXPosition + 56, row);
		trees[56]       = new PalmTree(startXPosition + 57, row);
		trees[57]       = new PalmTree(startXPosition + 58, row);
		trees[58]       = new PalmTree(startXPosition + 67, row);
		trees[59]       = new PalmTree(startXPosition + 68, row);
		row             = startYPosition + 44;
		trees[60]       = new PalmTree(startXPosition + 25, row);
		trees[61]       = new PalmTree(startXPosition + 26, row);
		trees[62]       = new PalmTree(startXPosition + 27, row);
		trees[63]       = new PalmTree(startXPosition + 28, row);
		trees[64]       = new PalmTree(startXPosition + 29, row);
		trees[65]       = new PalmTree(startXPosition + 35, row);
		trees[66]       = new PalmTree(startXPosition + 36, row);
		trees[67]       = new PalmTree(startXPosition + 46, row);
		trees[68]       = new PalmTree(startXPosition + 47, row);
		trees[69]       = new PalmTree(startXPosition + 48, row);
		trees[70]       = new PalmTree(startXPosition + 58, row);
		trees[71]       = new PalmTree(startXPosition + 59, row);
		trees[72]       = new PalmTree(startXPosition + 60, row);
		trees[73]       = new PalmTree(startXPosition + 67, row);
		trees[74]       = new PalmTree(startXPosition + 68, row);
		row 			= startYPosition + 49;
		trees[75]       = new PalmTree(startXPosition + 28, row);
		trees[76]       = new PalmTree(startXPosition + 29, row);
		trees[77]       = new PalmTree(startXPosition + 30, row);
		trees[78]       = new PalmTree(startXPosition + 33, row);
		trees[79]       = new PalmTree(startXPosition + 34, row);
		trees[80]       = new PalmTree(startXPosition + 47, row);
		trees[81]       = new PalmTree(startXPosition + 48, row);
		trees[82]       = new PalmTree(startXPosition + 49, row);
		trees[83]       = new PalmTree(startXPosition + 55, row);
		trees[84]       = new PalmTree(startXPosition + 58, row);
		trees[85]       = new PalmTree(startXPosition + 66, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
