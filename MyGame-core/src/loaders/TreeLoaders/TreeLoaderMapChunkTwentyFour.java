package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyFour extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentyFour = new NatureObject[140];

	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 7;
		placeTreesForAllSandChunk(treesMapChunkTwentyFour, startXPosition, rowThreeStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkTwentyFour);
	}
}
