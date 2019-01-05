package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyNine extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentyNine = new PalmTree[140];
	
	@Override
	public void loadTrees() {
		placeTreesForAllSandChunk(
				treesMapChunkTwentyNine,
				GameAttributeHelper.CHUNK_FIVE_X_POSITION_START,
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(treesMapChunkTwentyNine);
	}
}
