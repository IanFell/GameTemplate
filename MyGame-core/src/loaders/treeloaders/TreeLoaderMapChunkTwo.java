package loaders.treeloaders;

import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwo extends MapChunkTreeLoader {

	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkTwo() {
		trees = new PalmTree[45];
	}

	@Override
	public void loadTrees() {
		startXPosition  = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 32;
		startYPosition  = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START;
		row   		    = startYPosition;
		trees[0]        = new PalmTree(startXPosition + 2, row);
		trees[1]        = new PalmTree(startXPosition + 3, row);
		trees[2]        = new PalmTree(startXPosition + 4, row);
		trees[3]        = new PalmTree(startXPosition + 5, row);
		trees[4]        = new PalmTree(startXPosition + 6, row);
		trees[5]        = new PalmTree(startXPosition + 12, row);
		trees[6]        = new PalmTree(startXPosition + 13, row);
		trees[7]        = new PalmTree(startXPosition + 14, row);
		trees[8]        = new PalmTree(startXPosition + 15, row);
		trees[9]        = new PalmTree(startXPosition + 16, row);
		trees[10]       = new PalmTree(startXPosition + 23, row);
		trees[11]       = new PalmTree(startXPosition + 24, row);
		trees[12]       = new PalmTree(startXPosition + 25, row);
		trees[13]       = new PalmTree(startXPosition + 26, row);
		trees[14]       = new PalmTree(startXPosition + 27, row);
		trees[15]       = new PalmTree(startXPosition + 33, row);
		trees[16]       = new PalmTree(startXPosition + 34, row);
		trees[17]       = new PalmTree(startXPosition + 35, row);
		row             = startYPosition + 3;
		trees[18]       = new PalmTree(startXPosition + 7, row);
		trees[19]       = new PalmTree(startXPosition + 8, row);
		trees[20]       = new PalmTree(startXPosition + 9, row);
		trees[21]       = new PalmTree(startXPosition + 10, row);
		trees[22]       = new PalmTree(startXPosition + 11, row);
		trees[23]       = new PalmTree(startXPosition + 33, row);
		trees[24]       = new PalmTree(startXPosition + 34, row);
		trees[25]       = new PalmTree(startXPosition + 35, row);
		row             = startYPosition + 6;
		trees[26]       = new PalmTree(startXPosition + 16, row);
		trees[27]       = new PalmTree(startXPosition + 26, row);
		trees[28]       = new PalmTree(startXPosition + 32, row);
		row             = startYPosition + 9;
		trees[29]       = new PalmTree(startXPosition + 22, row);
		trees[30]       = new PalmTree(startXPosition + 32, row);
		trees[31]       = new PalmTree(startXPosition + 35, row);
		row             = startYPosition + 13;
		trees[32]       = new PalmTree(startXPosition + 18, row);
		trees[33]       = new PalmTree(startXPosition + 19, row);
		trees[34]       = new PalmTree(startXPosition + 22, row);
		trees[35]       = new PalmTree(startXPosition + 23, row);
		trees[36]       = new PalmTree(startXPosition + 30, row);
		row             = startYPosition + 18;
		trees[37]       = new PalmTree(startXPosition + 30, row);
		trees[38]       = new PalmTree(startXPosition + 31, row);
		trees[39]       = new PalmTree(startXPosition + 32, row);
		row             = startYPosition + 22;
		trees[40]       = new PalmTree(startXPosition + 34, row);
		trees[41]       = new PalmTree(startXPosition + 35, row);
		row             = startYPosition + 26;
		trees[42]       = new PalmTree(startXPosition + 30, row);
		trees[43]       = new PalmTree(startXPosition + 34, row);
		row             = startYPosition + 30;
		trees[44]       = new PalmTree(startXPosition + 35, row);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
