package loaders.TreeLoaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.NatureObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkFourty extends MapChunkTreeLoader {
	public GameObject[] treesMapChunkFourty = new NatureObject[140];
	
	@Override
	public void loadTrees() {
		startXPosition = chunkWidth * 7;
		placeTreesForAllSandChunk(treesMapChunkFourty, startXPosition, rowFiveStartPosition);
		addGameObjectsToGameObjectArrayList(treesMapChunkFourty);
	}
}
