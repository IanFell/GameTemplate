package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyTwo extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentyTwo = new PalmTree[140];
	
	@Override
	public void loadTrees() {
		placeTreesForAllSandChunk(
				treesMapChunkTwentyTwo, 
				GameAttributeHelper.CHUNK_SIX_X_POSITION_START, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(treesMapChunkTwentyTwo);
	}
}
