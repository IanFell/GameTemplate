package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFiftySix extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFiftySix = new NatureObject[14];
	
	@Override
	public void loadTrees() {
		startXPosition            = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START;
		startYPosition            = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				      = startYPosition;
		treesMapChunkFiftySix[0]  = new NatureObject(startXPosition + 5, row);
		treesMapChunkFiftySix[1]  = new NatureObject(startXPosition + 10, row);
		treesMapChunkFiftySix[2]  = new NatureObject(startXPosition + 15, row);
		treesMapChunkFiftySix[3]  = new NatureObject(startXPosition + 20, row);
		treesMapChunkFiftySix[4]  = new NatureObject(startXPosition + 25, row);
		treesMapChunkFiftySix[5]  = new NatureObject(startXPosition + 30, row);
		treesMapChunkFiftySix[6]  = new NatureObject(startXPosition + 35, row);
		row 				      = startYPosition + 5;
		treesMapChunkFiftySix[7]  = new NatureObject(startXPosition + 7, row);
		row 				      = startYPosition + 6;
		treesMapChunkFiftySix[8]  = new NatureObject(startXPosition + 17, row);
		treesMapChunkFiftySix[9]  = new NatureObject(startXPosition + 18, row);
		treesMapChunkFiftySix[10] = new NatureObject(startXPosition + 19, row);
		row 				      = startYPosition + 7;
		treesMapChunkFiftySix[11] = new NatureObject(startXPosition + 27, row);
		treesMapChunkFiftySix[12] = new NatureObject(startXPosition + 28, row);
		treesMapChunkFiftySix[13] = new NatureObject(startXPosition + 29, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkFiftySix);
	}
}
