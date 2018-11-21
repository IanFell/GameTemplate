package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyOne extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFfiftyOne = new NatureObject[12];
	
	@Override
	public void loadTrees() {
		startXPosition             = GameAttributeHelper.CHUNK_TWO_X_POSITION_START;
		startYPosition             = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				       = startYPosition + 10;
		treesMapChunkFfiftyOne[0]  = new NatureObject(startXPosition + 27, row);
		treesMapChunkFfiftyOne[1]  = new NatureObject(startXPosition + 28, row);
		treesMapChunkFfiftyOne[2]  = new NatureObject(startXPosition + 29, row);
		row 				       = startYPosition + 15;
		treesMapChunkFfiftyOne[3]  = new NatureObject(startXPosition + 32, row);
		treesMapChunkFfiftyOne[4]  = new NatureObject(startXPosition + 33, row);
		treesMapChunkFfiftyOne[5]  = new NatureObject(startXPosition + 34, row);
		row 				       = startYPosition + 35;
		treesMapChunkFfiftyOne[6]  = new NatureObject(startXPosition + 32, row);
		treesMapChunkFfiftyOne[7]  = new NatureObject(startXPosition + 33, row);
		treesMapChunkFfiftyOne[8]  = new NatureObject(startXPosition + 34, row);
		row 				       = startYPosition + 45;
		treesMapChunkFfiftyOne[9]  = new NatureObject(startXPosition + 48, row);
		treesMapChunkFfiftyOne[10] = new NatureObject(startXPosition + 53, row);
		treesMapChunkFfiftyOne[11] = new NatureObject(startXPosition + 60, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFfiftyOne);
	}
}
