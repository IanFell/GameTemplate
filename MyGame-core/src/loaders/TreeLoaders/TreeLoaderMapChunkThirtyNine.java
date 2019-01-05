package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyNine extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyNine = new PalmTree[140];
	
	@Override
	public void loadTrees() {
		placeTreesForAllSandChunk(
				treesMapChunkThirtyNine, 
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(treesMapChunkThirtyNine);
	}
}
