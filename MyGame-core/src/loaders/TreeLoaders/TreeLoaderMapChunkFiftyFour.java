package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyFour extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFiftyFour = new PalmTree[17];
	
	@Override
	public void loadTrees() {
		startXPosition             = GameAttributeHelper.CHUNK_SIX_X_POSITION_START;
		startYPosition             = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				       = startYPosition + 10;
		treesMapChunkFiftyFour[0]  = new PalmTree(startXPosition + 10, row);
		treesMapChunkFiftyFour[1]  = new PalmTree(startXPosition + 11, row);
		treesMapChunkFiftyFour[2]  = new PalmTree(startXPosition + 30, row);
		treesMapChunkFiftyFour[3]  = new PalmTree(startXPosition + 31, row);
		treesMapChunkFiftyFour[4]  = new PalmTree(startXPosition + 45, row);
		row 				       = startYPosition + 25;
		treesMapChunkFiftyFour[5]  = new PalmTree(startXPosition + 19, row);
		treesMapChunkFiftyFour[6]  = new PalmTree(startXPosition + 20, row);
		treesMapChunkFiftyFour[7]  = new PalmTree(startXPosition + 21, row);
		treesMapChunkFiftyFour[8]  = new PalmTree(startXPosition + 22, row);
		treesMapChunkFiftyFour[9]  = new PalmTree(startXPosition + 23, row);
		treesMapChunkFiftyFour[10] = new PalmTree(startXPosition + 39, row);
		treesMapChunkFiftyFour[11] = new PalmTree(startXPosition + 40, row);
		treesMapChunkFiftyFour[12] = new PalmTree(startXPosition + 41, row);
		treesMapChunkFiftyFour[13] = new PalmTree(startXPosition + 42, row);
		treesMapChunkFiftyFour[14] = new PalmTree(startXPosition + 43, row);
		row 				       = startYPosition + 40;
		treesMapChunkFiftyFour[15] = new PalmTree(startXPosition + 55, row);
		treesMapChunkFiftyFour[16] = new PalmTree(startXPosition + 56, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFiftyFour);
	}
}
