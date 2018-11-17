package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFifteen extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFifteen = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 340 + chunkWidth;
		placeTreesForAllSandChunk(treesMapChunkFifteen, startXPosition, rowTwoStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkFifteen);
	}
}
