package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyEight extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyEight = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 5;
		placeTreesForAllSandChunk(treesMapChunkThirtyEight, startXPosition, rowFiveStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkThirtyEight);
	}
}
