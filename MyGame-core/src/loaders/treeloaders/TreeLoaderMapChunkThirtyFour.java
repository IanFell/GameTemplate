package loaders.treeloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyFour extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyFour = new PalmTree[4];
	
	@Override
	public void loadTrees() {
		startXPosition		        = GameAttributeHelper.CHUNK_TWO_X_POSITION_START;
		startYPosition              = GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START;
		row 				        = startYPosition;
		treesMapChunkThirtyFour[0]  = new PalmTree(startXPosition + 27, row);
		treesMapChunkThirtyFour[1]  = new PalmTree(startXPosition + 36, row);
		row 				        = startYPosition + 25;
		treesMapChunkThirtyFour[2]  = new PalmTree(startXPosition + 39, row);
		treesMapChunkThirtyFour[3]  = new PalmTree(startXPosition + 46, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkThirtyFour);
	}
}
