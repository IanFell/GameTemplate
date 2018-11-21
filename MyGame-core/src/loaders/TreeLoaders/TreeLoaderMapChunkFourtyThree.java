package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourtyThree extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourtyThree = new NatureObject[7];

	@Override
	protected void loadTrees() {
		startXPosition		        = GameAttributeHelper.CHUNK_THREE_X_POSITION_START;
		startYPosition		        = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row 				        = startYPosition + 15;
		treesMapChunkFourtyThree[0] = new NatureObject(startXPosition + 5, row);
		row 				        = startYPosition + 20;
		treesMapChunkFourtyThree[1] = new NatureObject(startXPosition + 5, row);
		row 				        = startYPosition + 25;
		treesMapChunkFourtyThree[2] = new NatureObject(startXPosition + 5, row);
		row 				        = startYPosition + 30;
		treesMapChunkFourtyThree[3] = new NatureObject(startXPosition + 5, row);
		row 				        = startYPosition + 35;
		treesMapChunkFourtyThree[4] = new NatureObject(startXPosition + 10, row);
		row 				        = startYPosition + 40;
		treesMapChunkFourtyThree[5] = new NatureObject(startXPosition + 10, row);
		row 				        = startYPosition + 45;
		treesMapChunkFourtyThree[6] = new NatureObject(startXPosition + 20, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFourtyThree);
	}
}
