package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyTwo extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyTwo = new PalmTree[140];

	@Override
	public void loadTrees() {
		placeTreesForAllSandChunk(
				treesMapChunkThirtyTwo, 
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START, 
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(treesMapChunkThirtyTwo);
	}
}
