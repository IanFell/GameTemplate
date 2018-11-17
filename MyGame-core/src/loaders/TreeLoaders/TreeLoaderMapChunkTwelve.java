package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwelve extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwelve = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 204;
		placeTreesForAllSandChunk(treesMapChunkTwelve, startXPosition, rowTwoStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkTwelve);
	}
}
