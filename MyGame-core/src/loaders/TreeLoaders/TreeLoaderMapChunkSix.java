package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkSix extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkSix = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 340;
		placeTreesForAllSandChunk(treesMapChunkSix, startXPosition, rowOneStartPosition);
		addGameObjectsToGameObjectArrayList();
	}
	
	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkSix.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkSix[i]);
		}
	}
}
