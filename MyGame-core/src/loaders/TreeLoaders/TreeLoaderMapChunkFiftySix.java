package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftySix extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFiftySix = new PalmTree[14];
	
	@Override
	public void loadTrees() {
		startXPosition            = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START;
		startYPosition            = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				      = startYPosition;
		treesMapChunkFiftySix[0]  = new PalmTree(startXPosition + 5, row);
		treesMapChunkFiftySix[1]  = new PalmTree(startXPosition + 10, row);
		treesMapChunkFiftySix[2]  = new PalmTree(startXPosition + 15, row);
		treesMapChunkFiftySix[3]  = new PalmTree(startXPosition + 20, row);
		treesMapChunkFiftySix[4]  = new PalmTree(startXPosition + 25, row);
		treesMapChunkFiftySix[5]  = new PalmTree(startXPosition + 30, row);
		treesMapChunkFiftySix[6]  = new PalmTree(startXPosition + 35, row);
		row 				      = startYPosition + 5;
		treesMapChunkFiftySix[7]  = new PalmTree(startXPosition + 7, row);
		row 				      = startYPosition + 6;
		treesMapChunkFiftySix[8]  = new PalmTree(startXPosition + 17, row);
		treesMapChunkFiftySix[9]  = new PalmTree(startXPosition + 18, row);
		treesMapChunkFiftySix[10] = new PalmTree(startXPosition + 19, row);
		row 				      = startYPosition + 7;
		treesMapChunkFiftySix[11] = new PalmTree(startXPosition + 27, row);
		treesMapChunkFiftySix[12] = new PalmTree(startXPosition + 28, row);
		treesMapChunkFiftySix[13] = new PalmTree(startXPosition + 29, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFiftySix);
	}
}
