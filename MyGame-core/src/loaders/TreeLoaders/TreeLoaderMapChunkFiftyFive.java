package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyFive extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFiftyFive = new NatureObject[18];
	
	@Override
	public void loadTrees() {
		startXPosition             = GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START;
		startYPosition             = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				       = startYPosition;
		treesMapChunkFiftyFive[0]  = new NatureObject(startXPosition, row);
		row 				       = startYPosition + 1;
		treesMapChunkFiftyFive[1]  = new NatureObject(startXPosition, row);
		row 				       = startYPosition + 2;
		treesMapChunkFiftyFive[2]  = new NatureObject(startXPosition, row);
		row 				       = startYPosition + 3;
		treesMapChunkFiftyFive[3]  = new NatureObject(startXPosition, row);
		row 				       = startYPosition + 4;
		treesMapChunkFiftyFive[4]  = new NatureObject(startXPosition, row);
		treesMapChunkFiftyFive[5]  = new NatureObject(startXPosition + 6, row);
		treesMapChunkFiftyFive[6]  = new NatureObject(startXPosition + 14, row);
		treesMapChunkFiftyFive[7]  = new NatureObject(startXPosition + 24, row);
		treesMapChunkFiftyFive[8]  = new NatureObject(startXPosition + 44, row);
		row 				       = startYPosition + 10;
		treesMapChunkFiftyFive[9]  = new NatureObject(startXPosition, row);
		treesMapChunkFiftyFive[10] = new NatureObject(startXPosition + 18, row);
		treesMapChunkFiftyFive[11] = new NatureObject(startXPosition + 19, row);
		row 				       = startYPosition + 11;
		treesMapChunkFiftyFive[12] = new NatureObject(startXPosition + 20, row);
		treesMapChunkFiftyFive[13] = new NatureObject(startXPosition + 21, row);
		treesMapChunkFiftyFive[14] = new NatureObject(startXPosition + 22, row);
		row 				       = startYPosition + 20;
		treesMapChunkFiftyFive[15] = new NatureObject(startXPosition + 30, row);
		treesMapChunkFiftyFive[16] = new NatureObject(startXPosition + 31, row);
		treesMapChunkFiftyFive[17] = new NatureObject(startXPosition + 32, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFiftyFive);
	}
}
