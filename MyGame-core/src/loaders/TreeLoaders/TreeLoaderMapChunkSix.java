package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkSix extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkSix = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 340;
		placeTreesForAllSandChunk(treesMapChunkSix, startXPosition, rowOneStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkSix);
	}
}
