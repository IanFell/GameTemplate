package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyNine extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyNine = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 6;
		placeTreesForAllSandChunk(treesMapChunkThirtyNine, startXPosition, rowFiveStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkThirtyNine);
	}
}
