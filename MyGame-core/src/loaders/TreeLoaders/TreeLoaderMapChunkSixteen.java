package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkSixteen extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkSixteen = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 340 + chunkWidth * 2;
		placeTreesForAllSandChunk(treesMapChunkSixteen, startXPosition, rowTwoStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkSixteen);
	}
}
