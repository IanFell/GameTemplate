package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtySeven extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourtySeven = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 6;
		placeTreesForAllSandChunk(treesMapChunkFourtySeven, startXPosition, rowSixStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkFourtySeven);
	}
}
