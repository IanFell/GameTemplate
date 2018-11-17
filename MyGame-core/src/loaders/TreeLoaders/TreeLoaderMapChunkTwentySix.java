package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentySix extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentySix = new NatureObject[16];
	
	@Override
	public void loadTrees() {
		startXPosition		         = chunkWidth;
		row 				         = rowFourStartPosition;
		treesMapChunkTwentySix[0]    = new NatureObject(startXPosition, row);
		treesMapChunkTwentySix[1]    = new NatureObject(startXPosition + 1, row);
		treesMapChunkTwentySix[2]    = new NatureObject(startXPosition + 2, row);
		treesMapChunkTwentySix[3]    = new NatureObject(startXPosition + 10, row);
		treesMapChunkTwentySix[4]    = new NatureObject(startXPosition + 15, row);
		row 				         = rowFourStartPosition + 5;
		treesMapChunkTwentySix[5]    = new NatureObject(startXPosition + 5, row);
		treesMapChunkTwentySix[6]    = new NatureObject(startXPosition + 8, row);
		row 				         = rowFourStartPosition + 15;
		treesMapChunkTwentySix[7]    = new NatureObject(startXPosition + 9, row);
		treesMapChunkTwentySix[8]    = new NatureObject(startXPosition + 10, row);
		treesMapChunkTwentySix[9]    = new NatureObject(startXPosition + 11, row);
		row 				         = rowFourStartPosition + 25;
		treesMapChunkTwentySix[10]   = new NatureObject(startXPosition + 12, row);
		treesMapChunkTwentySix[11]   = new NatureObject(startXPosition + 17, row);
		row 				         = rowFourStartPosition + 35;
		treesMapChunkTwentySix[12]   = new NatureObject(startXPosition + 12, row);
		treesMapChunkTwentySix[13]   = new NatureObject(startXPosition + 17, row);
		row 				         = rowFourStartPosition + 45;
		treesMapChunkTwentySix[14]   = new NatureObject(startXPosition + 25, row);
		treesMapChunkTwentySix[15]   = new NatureObject(startXPosition + 30, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkTwentySix);
	}
}
