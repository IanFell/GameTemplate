package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftyFour extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFiftyFour = new NatureObject[17];
	
	@Override
	public void loadTrees() {
		startXPosition             = GameAttributeHelper.CHUNK_SIX_X_POSITION_START;
		startYPosition             = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				       = startYPosition + 10;
		treesMapChunkFiftyFour[0]  = new NatureObject(startXPosition + 10, row);
		treesMapChunkFiftyFour[1]  = new NatureObject(startXPosition + 11, row);
		treesMapChunkFiftyFour[2]  = new NatureObject(startXPosition + 30, row);
		treesMapChunkFiftyFour[3]  = new NatureObject(startXPosition + 31, row);
		treesMapChunkFiftyFour[4]  = new NatureObject(startXPosition + 45, row);
		row 				       = startYPosition + 25;
		treesMapChunkFiftyFour[5]  = new NatureObject(startXPosition + 19, row);
		treesMapChunkFiftyFour[6]  = new NatureObject(startXPosition + 20, row);
		treesMapChunkFiftyFour[7]  = new NatureObject(startXPosition + 21, row);
		treesMapChunkFiftyFour[8]  = new NatureObject(startXPosition + 22, row);
		treesMapChunkFiftyFour[9]  = new NatureObject(startXPosition + 23, row);
		treesMapChunkFiftyFour[10] = new NatureObject(startXPosition + 39, row);
		treesMapChunkFiftyFour[11] = new NatureObject(startXPosition + 40, row);
		treesMapChunkFiftyFour[12] = new NatureObject(startXPosition + 41, row);
		treesMapChunkFiftyFour[13] = new NatureObject(startXPosition + 42, row);
		treesMapChunkFiftyFour[14] = new NatureObject(startXPosition + 43, row);
		row 				       = startYPosition + 40;
		treesMapChunkFiftyFour[15] = new NatureObject(startXPosition + 55, row);
		treesMapChunkFiftyFour[16] = new NatureObject(startXPosition + 56, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFiftyFour);
	}
}
