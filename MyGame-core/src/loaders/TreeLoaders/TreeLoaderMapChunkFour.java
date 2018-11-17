package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFour extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFour = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 204;
		placeTreesForAllSandChunk(treesMapChunkFour, startXPosition, rowOneStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkFour);
	}
}
