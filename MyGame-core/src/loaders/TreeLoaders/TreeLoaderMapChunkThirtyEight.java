package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyEight extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyEight = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 5;
		placeTreesForAllSandChunk(treesMapChunkThirtyEight, startXPosition, rowFiveStartPosition);
		addGameObjectsToGameObjectArrayList();
	}
	
	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkThirtyEight.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkThirtyEight[i]);
		}
	}
}
