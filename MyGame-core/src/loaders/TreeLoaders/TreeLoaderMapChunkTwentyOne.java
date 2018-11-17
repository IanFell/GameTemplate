package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyOne extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentyOne = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 4;
		placeTreesForAllSandChunk(treesMapChunkTwentyOne, startXPosition, rowThreeStartPosition);
		addGameObjectsToGameObjectArrayList();
	}

	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkTwentyOne.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkTwentyOne[i]);
		}
	}
}
