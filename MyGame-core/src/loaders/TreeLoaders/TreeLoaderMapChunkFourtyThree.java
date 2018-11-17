package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtyThree extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourtyThree = new NatureObject[7];

	@Override
	protected void loadTrees() {
		startXPosition		        = chunkWidth * 2;
		row 				        = rowSixStartPosition + 15;
		treesMapChunkFourtyThree[0] = new NatureObject(startXPosition + 5, row);
		row 				        = rowSixStartPosition + 20;
		treesMapChunkFourtyThree[1] = new NatureObject(startXPosition + 5, row);
		row 				        = rowSixStartPosition + 25;
		treesMapChunkFourtyThree[2] = new NatureObject(startXPosition + 5, row);
		row 				        = rowSixStartPosition + 30;
		treesMapChunkFourtyThree[3] = new NatureObject(startXPosition + 5, row);
		row 				        = rowSixStartPosition + 35;
		treesMapChunkFourtyThree[4] = new NatureObject(startXPosition + 10, row);
		row 				        = rowSixStartPosition + 40;
		treesMapChunkFourtyThree[5] = new NatureObject(startXPosition + 10, row);
		row 				        = rowSixStartPosition + 45;
		treesMapChunkFourtyThree[6] = new NatureObject(startXPosition + 20, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFourtyThree);
	}
}
