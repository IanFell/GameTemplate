package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirteen extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirteen = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = 272;
		placeTreesForAllSandChunk(treesMapChunkThirteen, startXPosition, rowTwoStartPosition);
		addGameObjectsToGameObjectArrayList();
	}
	
	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkThirteen.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkThirteen[i]);
		}
	}
}
