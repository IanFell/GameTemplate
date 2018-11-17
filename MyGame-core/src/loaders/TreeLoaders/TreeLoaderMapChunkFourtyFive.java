package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtyFive extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourtyFive = new NatureObject[34];
	
	@Override
	protected void loadTrees() {
		startXPosition		        = chunkWidth * 4;
		row 				        = rowSixStartPosition + 10;
		treesMapChunkFourtyFive[0]  = new NatureObject(startXPosition + 29, row);
		treesMapChunkFourtyFive[1]  = new NatureObject(startXPosition + 30, row);
		treesMapChunkFourtyFive[2]  = new NatureObject(startXPosition + 31, row);
		treesMapChunkFourtyFive[3]  = new NatureObject(startXPosition + 32, row);
		row 				        = rowSixStartPosition + 15;
		treesMapChunkFourtyFive[4]  = new NatureObject(startXPosition + 34, row);
		treesMapChunkFourtyFive[5]  = new NatureObject(startXPosition + 35, row);
		treesMapChunkFourtyFive[6]  = new NatureObject(startXPosition + 36, row);
		treesMapChunkFourtyFive[7]  = new NatureObject(startXPosition + 50, row);
		treesMapChunkFourtyFive[8]  = new NatureObject(startXPosition + 51, row);
		treesMapChunkFourtyFive[9]  = new NatureObject(startXPosition + 52, row);
		treesMapChunkFourtyFive[10] = new NatureObject(startXPosition + 60, row);
		treesMapChunkFourtyFive[11] = new NatureObject(startXPosition + 61, row);
		treesMapChunkFourtyFive[12] = new NatureObject(startXPosition + 62, row);
		row 				        = rowSixStartPosition + 25;
		treesMapChunkFourtyFive[13] = new NatureObject(startXPosition + 40, row);
		treesMapChunkFourtyFive[14] = new NatureObject(startXPosition + 41, row);
		treesMapChunkFourtyFive[15] = new NatureObject(startXPosition + 42, row);
		treesMapChunkFourtyFive[16] = new NatureObject(startXPosition + 62, row);
		treesMapChunkFourtyFive[17] = new NatureObject(startXPosition + 63, row);
		row 				        = rowSixStartPosition + 26;
		treesMapChunkFourtyFive[18] = new NatureObject(startXPosition + 40, row);
		row 				        = rowSixStartPosition + 27;
		treesMapChunkFourtyFive[19] = new NatureObject(startXPosition + 40, row);
		treesMapChunkFourtyFive[20] = new NatureObject(startXPosition + 41, row);
		treesMapChunkFourtyFive[21] = new NatureObject(startXPosition + 42, row);
		row 				        = rowSixStartPosition + 37;
		treesMapChunkFourtyFive[22] = new NatureObject(startXPosition + 45, row);
		treesMapChunkFourtyFive[23] = new NatureObject(startXPosition + 46, row);
		treesMapChunkFourtyFive[24] = new NatureObject(startXPosition + 47, row);
		treesMapChunkFourtyFive[25] = new NatureObject(startXPosition + 59, row);
		treesMapChunkFourtyFive[26] = new NatureObject(startXPosition + 60, row);
		treesMapChunkFourtyFive[27] = new NatureObject(startXPosition + 61, row);
		row 				        = rowSixStartPosition + 42;
		treesMapChunkFourtyFive[28] = new NatureObject(startXPosition + 50, row);
		treesMapChunkFourtyFive[29] = new NatureObject(startXPosition + 51, row);
		row 				        = rowSixStartPosition + 47;
		treesMapChunkFourtyFive[30] = new NatureObject(startXPosition + 55, row);
		treesMapChunkFourtyFive[31] = new NatureObject(startXPosition + 56, row);
		treesMapChunkFourtyFive[32] = new NatureObject(startXPosition + 63, row);
		treesMapChunkFourtyFive[33] = new NatureObject(startXPosition + 64, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFourtyFive);
	}
}
