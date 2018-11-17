package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtyEight extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourtyEight = new NatureObject[8];
	
	@Override
	public void loadTrees() {
		startXPosition              = chunkWidth * 7;
		row 				        = rowSixStartPosition + 5;
		treesMapChunkFourtyEight[0] = new NatureObject(startXPosition + 2, row);
		treesMapChunkFourtyEight[1] = new NatureObject(startXPosition + 6, row);
		treesMapChunkFourtyEight[2] = new NatureObject(startXPosition + 10, row);
		treesMapChunkFourtyEight[3] = new NatureObject(startXPosition + 16, row);
		treesMapChunkFourtyEight[4] = new NatureObject(startXPosition + 20, row);
		treesMapChunkFourtyEight[5] = new NatureObject(startXPosition + 30, row);
		treesMapChunkFourtyEight[6] = new NatureObject(startXPosition + 40, row);
		treesMapChunkFourtyEight[7] = new NatureObject(startXPosition + 41, row);
		
		addGameObjectsToGameObjectArrayList();
	}

	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkFourtyEight.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkFourtyEight[i]);
		}
	}
}
