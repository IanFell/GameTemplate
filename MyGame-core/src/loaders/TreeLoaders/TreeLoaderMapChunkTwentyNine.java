package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyNine extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentyNine = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 4;
		placeTreesForAllSandChunk(treesMapChunkTwentyNine, startXPosition, rowFourStartPosition);
		addGameObjectsToGameObjectArrayList();
	}
	
	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkTwentyNine.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkTwentyNine[i]);
		}
	}
}
