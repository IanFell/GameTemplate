package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyOne extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyOne = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 6;
		placeTreesForAllSandChunk(treesMapChunkThirtyOne, startXPosition, rowFourStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkThirtyOne);
	}
}
