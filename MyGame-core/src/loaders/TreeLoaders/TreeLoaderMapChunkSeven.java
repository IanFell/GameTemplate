package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkSeven extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkSeven = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 408;
		placeTreesForAllSandChunk(treesMapChunkSeven, startXPosition, rowOneStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkSeven);
	}
}
