package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkEight extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkEight = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 476;
		placeTreesForAllSandChunk(treesMapChunkEight, startXPosition, rowOneStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkEight);
	}
}
