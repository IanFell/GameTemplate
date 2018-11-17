package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyTwo extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyTwo = new NatureObject[140];

	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 7;
		placeTreesForAllSandChunk(treesMapChunkThirtyTwo, startXPosition, rowFourStartPosition);
		addGameObjectsToGameObjectArrayList();
	}
	
	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkThirtyTwo.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkThirtyTwo[i]);
		}
	}
}
