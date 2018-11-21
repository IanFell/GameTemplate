package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyFour extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentyFour = new NatureObject[140];

	@Override
	public void loadTrees() {
		placeTreesForAllSandChunk(
				treesMapChunkTwentyFour, 
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(treesMapChunkTwentyFour);
	}
}
