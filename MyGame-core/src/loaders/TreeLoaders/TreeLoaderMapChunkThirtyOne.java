package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyOne extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyOne = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 6;
		placeTreesForAllSandChunk(treesMapChunkThirtyOne, startXPosition, rowFourStartPosition);
		addGameObjectsToGameObjectArrayList();
	}

	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkThirtyOne.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkThirtyOne[i]);
		}
	}
}
