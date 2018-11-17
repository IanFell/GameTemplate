package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkSeven extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkSeven = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 408;
		placeTreesForAllSandChunk(treesMapChunkSeven, startXPosition, rowOneStartPosition);
		addGameObjectsToGameObjectArrayList();
	}
	
	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkSeven.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkSeven[i]);
		}
	}

}
