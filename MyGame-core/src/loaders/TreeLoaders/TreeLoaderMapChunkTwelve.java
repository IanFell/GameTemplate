package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

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
		addGameObjectsToGameObjectArrayList();
	}
	
	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkTwelve.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkTwelve[i]);
		}
	}

}
