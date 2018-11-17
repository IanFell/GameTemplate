package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourteen extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourteen = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 340;
		placeTreesForAllSandChunk(treesMapChunkFourteen, startXPosition, rowTwoStartPosition);
		addGameObjectsToGameObjectArrayList();
	}

	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkFourteen.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkFourteen[i]);
		}
	}
}
