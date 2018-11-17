package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtySeven extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourtySeven = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 6;
		placeTreesForAllSandChunk(treesMapChunkFourtySeven, startXPosition, rowSixStartPosition);
		addGameObjectsToGameObjectArrayList();
	}

	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkFourtySeven.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkFourtySeven[i]);
		}
	}
}
