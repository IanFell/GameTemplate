package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourty extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourty = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 7;
		placeTreesForAllSandChunk(treesMapChunkFourty, startXPosition, rowFiveStartPosition);
		addGameObjectsToGameObjectArrayList();
	}

	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkFourty.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkFourty[i]);
		}
	}
}
