package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourteen extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourteen = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 340;
		placeTreesForAllSandChunk(treesMapChunkFourteen, startXPosition, rowTwoStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkFourteen);
	}
}
