package loaders;

import loaders.TreeLoaders.TreeLoaderMapChunkThirty;
import loaders.TreeLoaders.TreeLoaderMapChunkThirtyEight;
import loaders.TreeLoaders.TreeLoaderMapChunkThirtyFour;
import loaders.TreeLoaders.TreeLoaderMapChunkThirtyOne;
import loaders.TreeLoaders.TreeLoaderMapChunkThirtySeven;
import loaders.TreeLoaders.TreeLoaderMapChunkThirtyTwo;
import loaders.TreeLoaders.TreeLoaderMapChunkTwentyEight;
import loaders.TreeLoaders.TreeLoaderMapChunkTwentyFour;
import loaders.TreeLoaders.TreeLoaderMapChunkTwentyNine;
import loaders.TreeLoaders.TreeLoaderMapChunkTwentySix;
import loaders.TreeLoaders.TreeLoaderMapChunkTwentyTwo;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoader extends GameObjectLoader {
	private TreeLoaderMapChunkTwentyTwo treeLoaderMapChunkTwentyTwo;
	private TreeLoaderMapChunkTwentyFour treeLoaderMapChunkTwentyFour;
	private TreeLoaderMapChunkTwentySix treeLoaderMapChunkTwentySix;
	private TreeLoaderMapChunkTwentyEight treeLoaderMapChunkTwentyEight;
	private TreeLoaderMapChunkTwentyNine treeLoaderMapChunkTwentyNine;
	private TreeLoaderMapChunkThirty treeLoaderMapChunkThirty;
	private TreeLoaderMapChunkThirtyOne treeLoaderMapChunkThirtyOne;
	private TreeLoaderMapChunkThirtyTwo treeLoaderMapChunkThirtyTwo;
	private TreeLoaderMapChunkThirtyFour treeLoaderMapChunkThirtyFour;
	private TreeLoaderMapChunkThirtySeven treeLoaderMapChunkThirtySeven;
	private TreeLoaderMapChunkThirtyEight treeLoaderMapChunkThirtyEight;
	
	/**
	 * Constructor.
	 */
	public TreeLoader() {
		treeLoaderMapChunkTwentyTwo   = new TreeLoaderMapChunkTwentyTwo();
		treeLoaderMapChunkTwentyFour  = new TreeLoaderMapChunkTwentyFour();
		treeLoaderMapChunkTwentySix   = new TreeLoaderMapChunkTwentySix();
		treeLoaderMapChunkTwentyEight = new TreeLoaderMapChunkTwentyEight();
		treeLoaderMapChunkTwentyNine  = new TreeLoaderMapChunkTwentyNine();
		treeLoaderMapChunkThirty      = new TreeLoaderMapChunkThirty();
		treeLoaderMapChunkThirtyOne   = new TreeLoaderMapChunkThirtyOne();
		treeLoaderMapChunkThirtyTwo   = new TreeLoaderMapChunkThirtyTwo();
		treeLoaderMapChunkThirtyFour  = new TreeLoaderMapChunkThirtyFour();
		treeLoaderMapChunkThirtySeven = new TreeLoaderMapChunkThirtySeven();
		treeLoaderMapChunkThirtyEight = new TreeLoaderMapChunkThirtyEight();
	}
	
	protected void loadTrees() {
		treeLoaderMapChunkTwentyTwo.loadTrees();
		treeLoaderMapChunkTwentyFour.loadTrees();
		treeLoaderMapChunkTwentySix.loadTrees();
		treeLoaderMapChunkTwentyEight.loadTrees();
		treeLoaderMapChunkTwentyNine.loadTrees();
		treeLoaderMapChunkThirty.loadTrees();
		treeLoaderMapChunkThirtyOne.loadTrees();
		treeLoaderMapChunkThirtyTwo.loadTrees();
		treeLoaderMapChunkThirtyFour.loadTrees();
		treeLoaderMapChunkThirtySeven.loadTrees();
		treeLoaderMapChunkThirtyEight.loadTrees();
	}
}
