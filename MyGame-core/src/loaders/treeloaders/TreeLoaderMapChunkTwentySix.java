package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentySix extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentySix = new PalmTree[16];
	
	@Override
	public void loadTrees() {
		startXPosition		         = GameAttributeHelper.CHUNK_TWO_X_POSITION_START;
		startYPosition               = GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START;
		row 				         = startYPosition;
		treesMapChunkTwentySix[0]    = new PalmTree(startXPosition, row);
		treesMapChunkTwentySix[1]    = new PalmTree(startXPosition + 1, row);
		treesMapChunkTwentySix[2]    = new PalmTree(startXPosition + 2, row);
		treesMapChunkTwentySix[3]    = new PalmTree(startXPosition + 10, row);
		treesMapChunkTwentySix[4]    = new PalmTree(startXPosition + 15, row);
		row 				         = startYPosition + 5;
		treesMapChunkTwentySix[5]    = new PalmTree(startXPosition + 5, row);
		treesMapChunkTwentySix[6]    = new PalmTree(startXPosition + 8, row);
		row 				         = startYPosition + 15;
		treesMapChunkTwentySix[7]    = new PalmTree(startXPosition + 9, row);
		treesMapChunkTwentySix[8]    = new PalmTree(startXPosition + 10, row);
		treesMapChunkTwentySix[9]    = new PalmTree(startXPosition + 11, row);
		row 				         = startYPosition + 25;
		treesMapChunkTwentySix[10]   = new PalmTree(startXPosition + 12, row);
		treesMapChunkTwentySix[11]   = new PalmTree(startXPosition + 17, row);
		row 				         = startYPosition + 35;
		treesMapChunkTwentySix[12]   = new PalmTree(startXPosition + 12, row);
		treesMapChunkTwentySix[13]   = new PalmTree(startXPosition + 17, row);
		row 				         = startYPosition + 45;
		treesMapChunkTwentySix[14]   = new PalmTree(startXPosition + 25, row);
		treesMapChunkTwentySix[15]   = new PalmTree(startXPosition + 30, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkTwentySix);
	}
}
