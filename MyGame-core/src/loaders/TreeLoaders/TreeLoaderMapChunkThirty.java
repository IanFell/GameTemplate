package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirty extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirty = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 5;
		placeTreesForAllSandChunk(treesMapChunkThirty, startXPosition, rowFourStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkThirty);
	}
}
