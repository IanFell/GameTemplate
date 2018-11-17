package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyOne extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentyOne = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 4;
		placeTreesForAllSandChunk(treesMapChunkTwentyOne, startXPosition, rowThreeStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkTwentyOne);
	}
}
