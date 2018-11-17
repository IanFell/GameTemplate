package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkEighteen extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkEighteen = new NatureObject[9];
	
	@Override
	public void loadTrees() {
		startXPosition		     = chunkWidth;
		row                      = rowThreeStartPosition;
		treesMapChunkEighteen[0] = new NatureObject(startXPosition + 8, row);
		row                      = rowThreeStartPosition + 1;
		treesMapChunkEighteen[1] = new NatureObject(startXPosition + 9, row);
		row                      = rowThreeStartPosition + 12;
		treesMapChunkEighteen[2] = new NatureObject(startXPosition + 9, row);
		row                      = rowThreeStartPosition + 20;
		treesMapChunkEighteen[3] = new NatureObject(startXPosition + 7, row);
		row                      = rowThreeStartPosition + 30;
		treesMapChunkEighteen[4] = new NatureObject(startXPosition + 9, row);
		row                      = rowThreeStartPosition + 37;
		treesMapChunkEighteen[5] = new NatureObject(startXPosition + 1, row);
		treesMapChunkEighteen[6] = new NatureObject(startXPosition + 2, row);
		row                      = rowThreeStartPosition + 42;
		treesMapChunkEighteen[7] = new NatureObject(startXPosition + 3, row);
		treesMapChunkEighteen[8] = new NatureObject(startXPosition + 4, row);
		
		addGameObjectsToGameObjectArrayList();
	}

	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkEighteen.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkEighteen[i]);
		}
	}
}
