package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwenty extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwenty = new NatureObject[49];

	@Override
	public void loadTrees() {
		startXPosition		     = chunkWidth * 3;
		row                      = rowThreeStartPosition + 5;
		treesMapChunkTwenty[0]   = new NatureObject(startXPosition + 25, row);
		treesMapChunkTwenty[1]   = new NatureObject(startXPosition + 40, row);
		treesMapChunkTwenty[2]   = new NatureObject(startXPosition + 41, row);
		treesMapChunkTwenty[3]   = new NatureObject(startXPosition + 42, row);
		treesMapChunkTwenty[4]   = new NatureObject(startXPosition + 52, row);
		treesMapChunkTwenty[5]   = new NatureObject(startXPosition + 53, row);
		treesMapChunkTwenty[6]   = new NatureObject(startXPosition + 54, row);
		row                      = rowThreeStartPosition + 13;
		treesMapChunkTwenty[7]   = new NatureObject(startXPosition + 34, row);
		treesMapChunkTwenty[8]   = new NatureObject(startXPosition + 35, row);
		treesMapChunkTwenty[9]   = new NatureObject(startXPosition + 51, row);
		treesMapChunkTwenty[10]  = new NatureObject(startXPosition + 52, row);
		row                      = rowThreeStartPosition + 17;
		treesMapChunkTwenty[11]  = new NatureObject(startXPosition + 43, row);
		treesMapChunkTwenty[12]  = new NatureObject(startXPosition + 44, row);
		treesMapChunkTwenty[13]  = new NatureObject(startXPosition + 48, row);
		treesMapChunkTwenty[14]  = new NatureObject(startXPosition + 52, row);
		treesMapChunkTwenty[15]  = new NatureObject(startXPosition + 56, row);
		treesMapChunkTwenty[16]  = new NatureObject(startXPosition + 60, row);
		treesMapChunkTwenty[17]  = new NatureObject(startXPosition + 67, row);
		row                      = rowThreeStartPosition + 21;
		treesMapChunkTwenty[18]  = new NatureObject(startXPosition + 32, row);
		treesMapChunkTwenty[19]  = new NatureObject(startXPosition + 33, row);
		treesMapChunkTwenty[20]  = new NatureObject(startXPosition + 37, row);
		treesMapChunkTwenty[21]  = new NatureObject(startXPosition + 38, row);
		treesMapChunkTwenty[22]  = new NatureObject(startXPosition + 45, row);
		treesMapChunkTwenty[23]  = new NatureObject(startXPosition + 46, row);
		treesMapChunkTwenty[24]  = new NatureObject(startXPosition + 50, row);
		treesMapChunkTwenty[25]  = new NatureObject(startXPosition + 55, row);
		treesMapChunkTwenty[26]  = new NatureObject(startXPosition + 63, row);
		row                      = rowThreeStartPosition + 29;
		treesMapChunkTwenty[27]  = new NatureObject(startXPosition + 40, row);
		treesMapChunkTwenty[28]  = new NatureObject(startXPosition + 41, row);
		treesMapChunkTwenty[29]  = new NatureObject(startXPosition + 42, row);
		treesMapChunkTwenty[30]  = new NatureObject(startXPosition + 43, row);
		treesMapChunkTwenty[31]  = new NatureObject(startXPosition + 44, row);
		treesMapChunkTwenty[32]  = new NatureObject(startXPosition + 54, row);
		treesMapChunkTwenty[33]  = new NatureObject(startXPosition + 55, row);
		treesMapChunkTwenty[34]  = new NatureObject(startXPosition + 56, row);
		treesMapChunkTwenty[35]  = new NatureObject(startXPosition + 57, row);
		treesMapChunkTwenty[36]  = new NatureObject(startXPosition + 58, row);
		row                      = rowThreeStartPosition + 35;
		treesMapChunkTwenty[37]  = new NatureObject(startXPosition + 31, row);
		treesMapChunkTwenty[38]  = new NatureObject(startXPosition + 34, row);
		treesMapChunkTwenty[39]  = new NatureObject(startXPosition + 37, row);
		treesMapChunkTwenty[40]  = new NatureObject(startXPosition + 46, row);
		treesMapChunkTwenty[41]  = new NatureObject(startXPosition + 47, row);
		treesMapChunkTwenty[42]  = new NatureObject(startXPosition + 48, row);
		treesMapChunkTwenty[43]  = new NatureObject(startXPosition + 60, row);
		treesMapChunkTwenty[44]  = new NatureObject(startXPosition + 61, row);
		treesMapChunkTwenty[45]  = new NatureObject(startXPosition + 62, row);
		row                      = rowThreeStartPosition + 45;
		treesMapChunkTwenty[46]  = new NatureObject(startXPosition + 35, row);
		treesMapChunkTwenty[47]  = new NatureObject(startXPosition + 45, row);
		treesMapChunkTwenty[48]  = new NatureObject(startXPosition + 55, row);
		
		addGameObjectsToGameObjectArrayList();
	}

	@Override
	protected void addGameObjectsToGameObjectArrayList() {
		for (int i = 0; i < treesMapChunkTwenty.length; i++) {
			GameObjectLoader.gameObjectList.add(treesMapChunkTwenty[i]);
		}
	}
}
