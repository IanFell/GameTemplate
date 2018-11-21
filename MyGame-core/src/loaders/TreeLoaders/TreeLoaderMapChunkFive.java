package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFive extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFive = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		placeTreesForAllSandChunk(
				treesMapChunkFive, 
				GameAttributeHelper.CHUNK_FIVE_X_POSITION_START, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(treesMapChunkFive);
	}
}
