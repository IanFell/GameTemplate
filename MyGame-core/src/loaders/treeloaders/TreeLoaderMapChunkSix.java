package loaders.treeloaders;

import gameobjects.nature.trees.PalmTree;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoaderMapChunkSix extends MapChunkTreeLoader {
	
	/**
	 * Constructor.
	 */
	public TreeLoaderMapChunkSix() {
		trees = new PalmTree[140];
	}
	
	@Override
	public void loadTrees() {
		placeTreesForAllSandChunk(
				trees, 
				GameAttributeHelper.CHUNK_SIX_X_POSITION_START, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(trees);
	}
}
