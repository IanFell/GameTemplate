package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyThree extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentyThree = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 6;
		placeTreesForAllSandChunk(treesMapChunkTwentyThree, startXPosition, rowThreeStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkTwentyThree);
	}
}
