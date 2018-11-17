package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkEight extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkEight = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 476;
		placeTreesForAllSandChunk(treesMapChunkEight, startXPosition, rowOneStartPosition);
		addGameObjectsToGameObjectArrayList();
	}

	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkEight.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkEight[i]);
		}
	}
}
