package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFive extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFive = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 272;
		placeTreesForAllSandChunk(treesMapChunkFive, startXPosition, rowOneStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkFive);
	}
}
