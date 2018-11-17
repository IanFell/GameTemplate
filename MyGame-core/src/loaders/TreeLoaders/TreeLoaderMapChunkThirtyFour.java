package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyFour extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkThirtyFour = new NatureObject[4];
	
	@Override
	public void loadTrees() {
		startXPosition		        = chunkWidth;
		row 				        = rowFiveStartPosition;
		treesMapChunkThirtyFour[0]  = new NatureObject(startXPosition + 27, row);
		treesMapChunkThirtyFour[1]  = new NatureObject(startXPosition + 36, row);
		row 				        = rowFiveStartPosition + 25;
		treesMapChunkThirtyFour[2]  = new NatureObject(startXPosition + 39, row);
		treesMapChunkThirtyFour[3]  = new NatureObject(startXPosition + 46, row);
		
		addGameObjectsToGameObjectArrayList(treesMapChunkThirtyFour);
	}
}
