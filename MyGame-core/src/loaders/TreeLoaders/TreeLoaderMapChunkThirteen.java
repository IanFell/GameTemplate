package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirteen extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirteen = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 272;
		placeTreesForAllSandChunk(treesMapChunkThirteen, startXPosition, rowTwoStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkThirteen);
	}
}
