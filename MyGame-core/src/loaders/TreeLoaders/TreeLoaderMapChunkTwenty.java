package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwenty extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwenty = new PalmTree[49];

	@Override
	public void loadTrees() {
		startXPosition		     = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition		     = GameAttributeHelper.CHUNK_THREE_Y_POSITION_START;
		row                      = startYPosition + 5;
		treesMapChunkTwenty[0]   = new PalmTree(startXPosition + 25, row);
		treesMapChunkTwenty[1]   = new PalmTree(startXPosition + 40, row);
		treesMapChunkTwenty[2]   = new PalmTree(startXPosition + 41, row);
		treesMapChunkTwenty[3]   = new PalmTree(startXPosition + 42, row);
		treesMapChunkTwenty[4]   = new PalmTree(startXPosition + 52, row);
		treesMapChunkTwenty[5]   = new PalmTree(startXPosition + 53, row);
		treesMapChunkTwenty[6]   = new PalmTree(startXPosition + 54, row);
		row                      = startYPosition + 13;
		treesMapChunkTwenty[7]   = new PalmTree(startXPosition + 34, row);
		treesMapChunkTwenty[8]   = new PalmTree(startXPosition + 35, row);
		treesMapChunkTwenty[9]   = new PalmTree(startXPosition + 51, row);
		treesMapChunkTwenty[10]  = new PalmTree(startXPosition + 52, row);
		row                      = startYPosition + 17;
		treesMapChunkTwenty[11]  = new PalmTree(startXPosition + 43, row);
		treesMapChunkTwenty[12]  = new PalmTree(startXPosition + 44, row);
		treesMapChunkTwenty[13]  = new PalmTree(startXPosition + 48, row);
		treesMapChunkTwenty[14]  = new PalmTree(startXPosition + 52, row);
		treesMapChunkTwenty[15]  = new PalmTree(startXPosition + 56, row);
		treesMapChunkTwenty[16]  = new PalmTree(startXPosition + 60, row);
		treesMapChunkTwenty[17]  = new PalmTree(startXPosition + 67, row);
		row                      = startYPosition + 21;
		treesMapChunkTwenty[18]  = new PalmTree(startXPosition + 32, row);
		treesMapChunkTwenty[19]  = new PalmTree(startXPosition + 33, row);
		treesMapChunkTwenty[20]  = new PalmTree(startXPosition + 37, row);
		treesMapChunkTwenty[21]  = new PalmTree(startXPosition + 38, row);
		treesMapChunkTwenty[22]  = new PalmTree(startXPosition + 45, row);
		treesMapChunkTwenty[23]  = new PalmTree(startXPosition + 46, row);
		treesMapChunkTwenty[24]  = new PalmTree(startXPosition + 50, row);
		treesMapChunkTwenty[25]  = new PalmTree(startXPosition + 55, row);
		treesMapChunkTwenty[26]  = new PalmTree(startXPosition + 63, row);
		row                      = startYPosition + 29;
		treesMapChunkTwenty[27]  = new PalmTree(startXPosition + 40, row);
		treesMapChunkTwenty[28]  = new PalmTree(startXPosition + 41, row);
		treesMapChunkTwenty[29]  = new PalmTree(startXPosition + 42, row);
		treesMapChunkTwenty[30]  = new PalmTree(startXPosition + 43, row);
		treesMapChunkTwenty[31]  = new PalmTree(startXPosition + 44, row);
		treesMapChunkTwenty[32]  = new PalmTree(startXPosition + 54, row);
		treesMapChunkTwenty[33]  = new PalmTree(startXPosition + 55, row);
		treesMapChunkTwenty[34]  = new PalmTree(startXPosition + 56, row);
		treesMapChunkTwenty[35]  = new PalmTree(startXPosition + 57, row);
		treesMapChunkTwenty[36]  = new PalmTree(startXPosition + 58, row);
		row                      = startYPosition + 35;
		treesMapChunkTwenty[37]  = new PalmTree(startXPosition + 31, row);
		treesMapChunkTwenty[38]  = new PalmTree(startXPosition + 34, row);
		treesMapChunkTwenty[39]  = new PalmTree(startXPosition + 37, row);
		treesMapChunkTwenty[40]  = new PalmTree(startXPosition + 46, row);
		treesMapChunkTwenty[41]  = new PalmTree(startXPosition + 47, row);
		treesMapChunkTwenty[42]  = new PalmTree(startXPosition + 48, row);
		treesMapChunkTwenty[43]  = new PalmTree(startXPosition + 60, row);
		treesMapChunkTwenty[44]  = new PalmTree(startXPosition + 61, row);
		treesMapChunkTwenty[45]  = new PalmTree(startXPosition + 62, row);
		row                      = startYPosition + 45;
		treesMapChunkTwenty[46]  = new PalmTree(startXPosition + 35, row);
		treesMapChunkTwenty[47]  = new PalmTree(startXPosition + 45, row);
		treesMapChunkTwenty[48]  = new PalmTree(startXPosition + 55, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkTwenty);
	}
}
