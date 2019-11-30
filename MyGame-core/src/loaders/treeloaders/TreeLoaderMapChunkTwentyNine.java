package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkTwentyNine extends MapChunkTreeLoader {
	
	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkTwentyNine() {
		trees = new PalmTree[140];
	}
	
	@Override
	public void loadTrees() {
		placeTreesForAllSandChunk(
				trees,
				GameAttributeHelper.CHUNK_FIVE_X_POSITION_START,
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
