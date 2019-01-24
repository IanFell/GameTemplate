package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtyFive extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourtyFive = new PalmTree[34];
	
	@Override
	protected void loadTrees() {
		startXPosition		        = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition		        = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row 				        = startYPosition + 10;
		treesMapChunkFourtyFive[0]  = new PalmTree(startXPosition + 29, row);
		treesMapChunkFourtyFive[1]  = new PalmTree(startXPosition + 30, row);
		treesMapChunkFourtyFive[2]  = new PalmTree(startXPosition + 31, row);
		treesMapChunkFourtyFive[3]  = new PalmTree(startXPosition + 32, row);
		row 				        = startYPosition + 15;
		treesMapChunkFourtyFive[4]  = new PalmTree(startXPosition + 34, row);
		treesMapChunkFourtyFive[5]  = new PalmTree(startXPosition + 35, row);
		treesMapChunkFourtyFive[6]  = new PalmTree(startXPosition + 36, row);
		treesMapChunkFourtyFive[7]  = new PalmTree(startXPosition + 50, row);
		treesMapChunkFourtyFive[8]  = new PalmTree(startXPosition + 51, row);
		treesMapChunkFourtyFive[9]  = new PalmTree(startXPosition + 52, row);
		treesMapChunkFourtyFive[10] = new PalmTree(startXPosition + 60, row);
		treesMapChunkFourtyFive[11] = new PalmTree(startXPosition + 61, row);
		treesMapChunkFourtyFive[12] = new PalmTree(startXPosition + 62, row);
		row 				        = startYPosition + 25;
		treesMapChunkFourtyFive[13] = new PalmTree(startXPosition + 40, row);
		treesMapChunkFourtyFive[14] = new PalmTree(startXPosition + 41, row);
		treesMapChunkFourtyFive[15] = new PalmTree(startXPosition + 42, row);
		treesMapChunkFourtyFive[16] = new PalmTree(startXPosition + 62, row);
		treesMapChunkFourtyFive[17] = new PalmTree(startXPosition + 63, row);
		row 				        = startYPosition + 26;
		treesMapChunkFourtyFive[18] = new PalmTree(startXPosition + 40, row);
		row 				        = startYPosition + 27;
		treesMapChunkFourtyFive[19] = new PalmTree(startXPosition + 40, row);
		treesMapChunkFourtyFive[20] = new PalmTree(startXPosition + 41, row);
		treesMapChunkFourtyFive[21] = new PalmTree(startXPosition + 42, row);
		row 				        = startYPosition + 37;
		treesMapChunkFourtyFive[22] = new PalmTree(startXPosition + 45, row);
		treesMapChunkFourtyFive[23] = new PalmTree(startXPosition + 46, row);
		treesMapChunkFourtyFive[24] = new PalmTree(startXPosition + 47, row);
		treesMapChunkFourtyFive[25] = new PalmTree(startXPosition + 59, row);
		treesMapChunkFourtyFive[26] = new PalmTree(startXPosition + 60, row);
		treesMapChunkFourtyFive[27] = new PalmTree(startXPosition + 61, row);
		row 				        = startYPosition + 42;
		treesMapChunkFourtyFive[28] = new PalmTree(startXPosition + 50, row);
		treesMapChunkFourtyFive[29] = new PalmTree(startXPosition + 51, row);
		row 				        = startYPosition + 47;
		treesMapChunkFourtyFive[30] = new PalmTree(startXPosition + 55, row);
		treesMapChunkFourtyFive[31] = new PalmTree(startXPosition + 56, row);
		treesMapChunkFourtyFive[32] = new PalmTree(startXPosition + 63, row);
		treesMapChunkFourtyFive[33] = new PalmTree(startXPosition + 64, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFourtyFive);
	}
}
