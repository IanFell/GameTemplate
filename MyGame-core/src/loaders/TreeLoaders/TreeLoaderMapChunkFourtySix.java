package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtySix extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourtySix = new PalmTree[140];
	
	@Override
	public void loadTrees() {
		placeTreesForAllSandChunk(
				treesMapChunkFourtySix, 
				GameAttributeHelper.CHUNK_SIX_X_POSITION_START, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(treesMapChunkFourtySix);
	}
}
