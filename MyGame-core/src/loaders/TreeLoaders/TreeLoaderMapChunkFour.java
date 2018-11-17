package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFour extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFour = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 204;
		placeTreesForAllSandChunk(treesMapChunkFour, startXPosition, rowOneStartPosition);
		addGameObjectsToGameObjectArrayList();
	}
	
	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkFour.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkFour[i]);
		}
	}
}
