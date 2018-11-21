package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyThree extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFiftyThree = new NatureObject[6];
	
	@Override
	public void loadTrees() {
		startXPosition             = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition             = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				       = startYPosition + 30;
		treesMapChunkFiftyThree[0] = new NatureObject(startXPosition + 10, row);
		treesMapChunkFiftyThree[1] = new NatureObject(startXPosition + 30, row);
		treesMapChunkFiftyThree[2] = new NatureObject(startXPosition + 50, row);
		row 				       = startYPosition + 37;
		treesMapChunkFiftyThree[3] = new NatureObject(startXPosition + 20, row);
		treesMapChunkFiftyThree[4] = new NatureObject(startXPosition + 30, row);
		treesMapChunkFiftyThree[5] = new NatureObject(startXPosition + 50, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFiftyThree);
	}
}
