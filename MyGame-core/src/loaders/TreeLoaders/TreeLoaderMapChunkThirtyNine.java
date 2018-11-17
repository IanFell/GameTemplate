package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyNine extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyNine = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 6;
		placeTreesForAllSandChunk(treesMapChunkThirtyNine, startXPosition, rowFiveStartPosition);
		addGameObjectsToGameObjectArrayList();
	}

	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkThirtyNine.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkThirtyNine[i]);
		}
	}
}
