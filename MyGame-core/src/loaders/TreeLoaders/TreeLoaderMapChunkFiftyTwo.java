package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyTwo extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFiftyTwo = new NatureObject[10];
	
	@Override
	public void loadTrees() {
		startXPosition            = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition            = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				      = startYPosition + 30;
		treesMapChunkFiftyTwo[0]  = new NatureObject(startXPosition + 57, row);
		treesMapChunkFiftyTwo[1]  = new NatureObject(startXPosition + 58, row);
		treesMapChunkFiftyTwo[2]  = new NatureObject(startXPosition + 59, row);
		row 				      = startYPosition + 40;
		treesMapChunkFiftyTwo[3]  = new NatureObject(startXPosition + 57, row);
		treesMapChunkFiftyTwo[4]  = new NatureObject(startXPosition + 58, row);
		treesMapChunkFiftyTwo[5]  = new NatureObject(startXPosition + 59, row);
		row 				      = startYPosition + 44;
		treesMapChunkFiftyTwo[6]  = new NatureObject(startXPosition + 5, row);
		treesMapChunkFiftyTwo[7]  = new NatureObject(startXPosition + 6, row);
		row 				      = startYPosition + 48;
		treesMapChunkFiftyTwo[8]  = new NatureObject(startXPosition + 15, row);
		treesMapChunkFiftyTwo[9]  = new NatureObject(startXPosition + 16, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFiftyTwo);
	}
}
