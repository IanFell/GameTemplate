package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtyThree extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourtyThree = new PalmTree[7];

	@Override
	protected void loadTrees() {
		startXPosition		        = GameAttributeHelper.CHUNK_THREE_X_POSITION_START;
		startYPosition		        = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row 				        = startYPosition + 15;
		treesMapChunkFourtyThree[0] = new PalmTree(startXPosition + 5, row);
		row 				        = startYPosition + 20;
		treesMapChunkFourtyThree[1] = new PalmTree(startXPosition + 5, row);
		row 				        = startYPosition + 25;
		treesMapChunkFourtyThree[2] = new PalmTree(startXPosition + 5, row);
		row 				        = startYPosition + 30;
		treesMapChunkFourtyThree[3] = new PalmTree(startXPosition + 5, row);
		row 				        = startYPosition + 35;
		treesMapChunkFourtyThree[4] = new PalmTree(startXPosition + 10, row);
		row 				        = startYPosition + 40;
		treesMapChunkFourtyThree[5] = new PalmTree(startXPosition + 10, row);
		row 				        = startYPosition + 45;
		treesMapChunkFourtyThree[6] = new PalmTree(startXPosition + 20, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFourtyThree);
	}
}
