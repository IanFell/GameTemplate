package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyTwo extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyTwo = new NatureObject[140];

	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 7;
		placeTreesForAllSandChunk(treesMapChunkThirtyTwo, startXPosition, rowFourStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkThirtyTwo);
	}
}
