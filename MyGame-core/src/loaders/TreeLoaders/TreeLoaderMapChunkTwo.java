package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwo extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwo = new NatureObject[45];
	
	@Override
	public void loadTrees() {
		int startXPosition   = 100;
		int row   		     = rowOneStartPosition;
		treesMapChunkTwo[0]  = new NatureObject(startXPosition + 2, row);
		treesMapChunkTwo[1]  = new NatureObject(startXPosition + 3, row);
		treesMapChunkTwo[2]  = new NatureObject(startXPosition + 4, row);
		treesMapChunkTwo[3]  = new NatureObject(startXPosition + 5, row);
		treesMapChunkTwo[4]  = new NatureObject(startXPosition + 6, row);
		treesMapChunkTwo[5]  = new NatureObject(startXPosition + 12, row);
		treesMapChunkTwo[6]  = new NatureObject(startXPosition + 13, row);
		treesMapChunkTwo[7]  = new NatureObject(startXPosition + 14, row);
		treesMapChunkTwo[8]  = new NatureObject(startXPosition + 15, row);
		treesMapChunkTwo[9]  = new NatureObject(startXPosition + 16, row);
		treesMapChunkTwo[10] = new NatureObject(startXPosition + 23, row);
		treesMapChunkTwo[11] = new NatureObject(startXPosition + 24, row);
		treesMapChunkTwo[12] = new NatureObject(startXPosition + 25, row);
		treesMapChunkTwo[13] = new NatureObject(startXPosition + 26, row);
		treesMapChunkTwo[14] = new NatureObject(startXPosition + 27, row);
		treesMapChunkTwo[15] = new NatureObject(startXPosition + 33, row);
		treesMapChunkTwo[16] = new NatureObject(startXPosition + 34, row);
		treesMapChunkTwo[17] = new NatureObject(startXPosition + 35, row);
		row                  = rowOneStartPosition + 3;
		treesMapChunkTwo[18] = new NatureObject(startXPosition + 7, row);
		treesMapChunkTwo[19] = new NatureObject(startXPosition + 8, row);
		treesMapChunkTwo[20] = new NatureObject(startXPosition + 9, row);
		treesMapChunkTwo[21] = new NatureObject(startXPosition + 10, row);
		treesMapChunkTwo[22] = new NatureObject(startXPosition + 11, row);
		treesMapChunkTwo[23] = new NatureObject(startXPosition + 33, row);
		treesMapChunkTwo[24] = new NatureObject(startXPosition + 34, row);
		treesMapChunkTwo[25] = new NatureObject(startXPosition + 35, row);
		row                  = rowOneStartPosition + 6;
		treesMapChunkTwo[26] = new NatureObject(startXPosition + 16, row);
		treesMapChunkTwo[27] = new NatureObject(startXPosition + 26, row);
		treesMapChunkTwo[28] = new NatureObject(startXPosition + 32, row);
		row                  = rowOneStartPosition + 9;
		treesMapChunkTwo[29] = new NatureObject(startXPosition + 22, row);
		treesMapChunkTwo[30] = new NatureObject(startXPosition + 32, row);
		treesMapChunkTwo[31] = new NatureObject(startXPosition + 35, row);
		row                  = rowOneStartPosition + 13;
		treesMapChunkTwo[32] = new NatureObject(startXPosition + 18, row);
		treesMapChunkTwo[33] = new NatureObject(startXPosition + 19, row);
		treesMapChunkTwo[34] = new NatureObject(startXPosition + 22, row);
		treesMapChunkTwo[35] = new NatureObject(startXPosition + 23, row);
		treesMapChunkTwo[36] = new NatureObject(startXPosition + 30, row);
		row                  = rowOneStartPosition + 18;
		treesMapChunkTwo[37] = new NatureObject(startXPosition + 30, row);
		treesMapChunkTwo[38] = new NatureObject(startXPosition + 31, row);
		treesMapChunkTwo[39] = new NatureObject(startXPosition + 32, row);
		row                  = rowOneStartPosition + 22;
		treesMapChunkTwo[40] = new NatureObject(startXPosition + 34, row);
		treesMapChunkTwo[41] = new NatureObject(startXPosition + 35, row);
		row                  =  + 26;
		treesMapChunkTwo[42] = new NatureObject(startXPosition + 30, row);
		treesMapChunkTwo[43] = new NatureObject(startXPosition + 34, row);
		row                  = rowOneStartPosition + 30;
		treesMapChunkTwo[44] = new NatureObject(startXPosition + 35, row);
	
		addGameObjectsToGameObjectArrayList();
	}
	
	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkTwo.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkTwo[i]);
		}
	}
}
