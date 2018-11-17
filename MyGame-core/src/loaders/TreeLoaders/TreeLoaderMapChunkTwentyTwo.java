package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyTwo extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentyTwo = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 5;
		placeTreesForAllSandChunk(treesMapChunkTwentyTwo, startXPosition, rowThreeStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkTwentyTwo);
	}
}
