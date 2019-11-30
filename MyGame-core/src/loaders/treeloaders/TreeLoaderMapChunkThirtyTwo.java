package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkThirtyTwo extends MapChunkTreeLoader {
	
	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkThirtyTwo() {
		trees = new PalmTree[140];
	}

	@Override
	public void loadTrees() {
		placeTreesForAllSandChunk(
				trees, 
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START, 
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
