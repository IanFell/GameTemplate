package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtyEight extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourtyEight = new PalmTree[8];
	
	@Override
	public void loadTrees() {
		startXPosition              = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START;
		startYPosition              = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row 				        = startYPosition + 5;
		treesMapChunkFourtyEight[0] = new PalmTree(startXPosition + 2, row);
		treesMapChunkFourtyEight[1] = new PalmTree(startXPosition + 6, row);
		treesMapChunkFourtyEight[2] = new PalmTree(startXPosition + 10, row);
		treesMapChunkFourtyEight[3] = new PalmTree(startXPosition + 16, row);
		treesMapChunkFourtyEight[4] = new PalmTree(startXPosition + 20, row);
		treesMapChunkFourtyEight[5] = new PalmTree(startXPosition + 30, row);
		treesMapChunkFourtyEight[6] = new PalmTree(startXPosition + 40, row);
		treesMapChunkFourtyEight[7] = new PalmTree(startXPosition + 41, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFourtyEight);
	}
}
