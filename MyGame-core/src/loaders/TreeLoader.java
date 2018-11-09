package loaders;

import loaders.TreeLoaders.TreeLoaderMapChunkThirtyEight;
import loaders.TreeLoaders.TreeLoaderMapChunkThirtySeven;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoader extends GameObjectLoader {
	
	private TreeLoaderMapChunkThirtySeven treeLoaderMapChunkThirtySeven;
	private TreeLoaderMapChunkThirtyEight treeLoaderMapChunkThirtyEight;
	
	/**
	 * Constructor.
	 */
	public TreeLoader() {
		treeLoaderMapChunkThirtySeven = new TreeLoaderMapChunkThirtySeven();
		treeLoaderMapChunkThirtyEight = new TreeLoaderMapChunkThirtyEight();
	}
	
	protected void loadTrees() {
		treeLoaderMapChunkThirtySeven.loadTrees();
		treeLoaderMapChunkThirtyEight.loadTrees();
	}
}
