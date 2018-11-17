package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFive extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFive = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 272;
		placeTreesForAllSandChunk(treesMapChunkFive, startXPosition, rowOneStartPosition);
		addGameObjectsToGameObjectArrayList();
	}
	
	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkFive.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkFive[i]);
		}
	}

}
