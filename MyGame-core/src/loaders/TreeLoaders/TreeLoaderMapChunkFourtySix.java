package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtySix extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourtySix = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 5;
		placeTreesForAllSandChunk(treesMapChunkFourtySix, startXPosition, rowSixStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkFourtySix);
	}
}
