package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyEight extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkTwentyEight = new NatureObject[14];
	
	@Override
	public void loadTrees() {
		startXPosition		         = chunkWidth * 3;
		row 				         = rowFourStartPosition;
		treesMapChunkTwentyEight[0]  = new NatureObject(startXPosition + 17, row);
		treesMapChunkTwentyEight[1]  = new NatureObject(startXPosition + 28, row);
		treesMapChunkTwentyEight[2]  = new NatureObject(startXPosition + 40, row);
		treesMapChunkTwentyEight[3]  = new NatureObject(startXPosition + 41, row);
		row 				         = rowFourStartPosition + 10;
		treesMapChunkTwentyEight[4]  = new NatureObject(startXPosition + 30, row);
		treesMapChunkTwentyEight[5]  = new NatureObject(startXPosition + 35, row);
		treesMapChunkTwentyEight[6]  = new NatureObject(startXPosition + 36, row);
		treesMapChunkTwentyEight[7]  = new NatureObject(startXPosition + 50, row);
		treesMapChunkTwentyEight[8]  = new NatureObject(startXPosition + 51, row);
		row 				         = rowFourStartPosition + 20;
		treesMapChunkTwentyEight[9]  = new NatureObject(startXPosition + 39, row);
		treesMapChunkTwentyEight[10] = new NatureObject(startXPosition + 40, row);
		treesMapChunkTwentyEight[11] = new NatureObject(startXPosition + 41, row);
		treesMapChunkTwentyEight[12] = new NatureObject(startXPosition + 50, row);
		treesMapChunkTwentyEight[13] = new NatureObject(startXPosition + 51, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkTwentyEight);
	}
}
