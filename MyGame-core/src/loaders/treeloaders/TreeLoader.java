package loaders.treeloaders;

import loaders.GameObjectLoader;

/**
 * Instantiate, load, and place all trees.
 * 
 * @author Fabulous Fellini
 *
 */
public class TreeLoader extends GameObjectLoader {
	private TreeLoaderMapChunkTwo treeLoaderMapChunkTwo;
	private TreeLoaderMapChunkThree treeLoaderMapChunkThree;
	private TreeLoaderMapChunkFour treeLoaderMapChunkFour;
	private TreeLoaderMapChunkFive treeLoaderMapChunkFive;
	private TreeLoaderMapChunkSix treeLoaderMapChunkSix;
	private TreeLoaderMapChunkSeven treeLoaderMapChunkSeven;
	private TreeLoaderMapChunkEight treeLoaderMapChunkEight;
	private TreeLoaderMapChunkEleven treeLoaderMapChunkEleven;
	private TreeLoaderMapChunkTwelve treeLoaderMapChunkTwelve;
	private TreeLoaderMapChunkThirteen treeLoaderMapChunkThirteen;
	private TreeLoaderMapChunkFourteen treeLoaderMapChunkFourteen;
	private TreeLoaderMapChunkFifteen treeLoaderMapChunkFifteen;
	private TreeLoaderMapChunkSixteen treeLoaderMapChunkSixteen;
	private TreeLoaderMapChunkEighteen treeLoaderMapChunkEighteen;
	private TreeLoaderMapChunkTwenty treeLoaderMapChunkTwenty;
	private TreeLoaderMapChunkTwentyOne treeLoaderMapChunkTwentyOne;
	private TreeLoaderMapChunkTwentyTwo treeLoaderMapChunkTwentyTwo;
	private TreeLoaderMapChunkTwentyThree treeLoaderMapChunkTwentyThree;
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
	private TreeLoaderMapChunkThirtyNine treeLoaderMapChunkThirtyNine;
	private TreeLoaderMapChunkFourty treeLoaderMapChunkFourty;
	private TreeLoaderMapChunkFourtyThree treeLoaderMapChunkFourtyThree;
	private TreeLoaderMapChunkFourtyFive treeLoaderMapChunkFourtyFive;
	private TreeLoaderMapChunkFourtySix treeLoaderMapChunkFourtySix;
	private TreeLoaderMapChunkFourtySeven treeLoaderMapChunkFourtySeven;
	private TreeLoaderMapChunkFourtyEight treeLoaderMapChunkFourtyEight;
	private TreeLoaderMapChunkFiftyOne treeLoaderMapChunkFiftyOne;
	private TreeLoaderMapChunkFiftyTwo treeLoaderMapChunkFiftyTwo;
	private TreeLoaderMapChunkFiftyThree treeLoaderMapChunkFiftyThree;
	private TreeLoaderMapChunkFiftyFour treeLoaderMapChunkFiftyFour;
	private TreeLoaderMapChunkFiftyFive treeLoaderMapChunkFiftyFive;
	private TreeLoaderMapChunkFiftySix treeLoaderMapChunkFiftySix;
	
	/**
	 * Constructor.
	 */
	public TreeLoader() {
		treeLoaderMapChunkTwo         = new TreeLoaderMapChunkTwo();
		treeLoaderMapChunkThree       = new TreeLoaderMapChunkThree();
		treeLoaderMapChunkFour        = new TreeLoaderMapChunkFour();
		treeLoaderMapChunkFive        = new TreeLoaderMapChunkFive();
		treeLoaderMapChunkSix         = new TreeLoaderMapChunkSix();
		treeLoaderMapChunkSeven       = new TreeLoaderMapChunkSeven();
		treeLoaderMapChunkEight       = new TreeLoaderMapChunkEight();
		treeLoaderMapChunkEleven      = new TreeLoaderMapChunkEleven();
		treeLoaderMapChunkTwelve      = new TreeLoaderMapChunkTwelve();
		treeLoaderMapChunkThirteen    = new TreeLoaderMapChunkThirteen();
		treeLoaderMapChunkFourteen    = new TreeLoaderMapChunkFourteen();
		treeLoaderMapChunkFifteen     = new TreeLoaderMapChunkFifteen();
		treeLoaderMapChunkSixteen     = new TreeLoaderMapChunkSixteen();
		treeLoaderMapChunkEighteen    = new TreeLoaderMapChunkEighteen();
		treeLoaderMapChunkTwenty      = new TreeLoaderMapChunkTwenty();
		treeLoaderMapChunkTwentyOne   = new TreeLoaderMapChunkTwentyOne();
		treeLoaderMapChunkTwentyTwo   = new TreeLoaderMapChunkTwentyTwo();
		treeLoaderMapChunkTwentyThree = new TreeLoaderMapChunkTwentyThree();
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
		treeLoaderMapChunkThirtyNine  = new TreeLoaderMapChunkThirtyNine();
		treeLoaderMapChunkFourty      = new TreeLoaderMapChunkFourty();
		treeLoaderMapChunkFourtyThree = new TreeLoaderMapChunkFourtyThree();
		treeLoaderMapChunkFourtyFive  = new TreeLoaderMapChunkFourtyFive();
		treeLoaderMapChunkFourtySix   = new TreeLoaderMapChunkFourtySix();
		treeLoaderMapChunkFourtySeven = new TreeLoaderMapChunkFourtySeven();
		treeLoaderMapChunkFourtyEight = new TreeLoaderMapChunkFourtyEight();
		treeLoaderMapChunkFiftyOne    = new TreeLoaderMapChunkFiftyOne();
		treeLoaderMapChunkFiftyTwo    = new TreeLoaderMapChunkFiftyTwo();
		treeLoaderMapChunkFiftyThree  = new TreeLoaderMapChunkFiftyThree();
		treeLoaderMapChunkFiftyFour   = new TreeLoaderMapChunkFiftyFour();
		treeLoaderMapChunkFiftyFive   = new TreeLoaderMapChunkFiftyFive();
		treeLoaderMapChunkFiftySix    = new TreeLoaderMapChunkFiftySix();
		loadTrees();
	}
	
	public void loadTrees() {
		treeLoaderMapChunkTwo.loadTrees();
		treeLoaderMapChunkThree.loadTrees();
		treeLoaderMapChunkFour.loadTrees();
		treeLoaderMapChunkFive.loadTrees();
		treeLoaderMapChunkSix.loadTrees();
		treeLoaderMapChunkSeven.loadTrees();
		treeLoaderMapChunkEight.loadTrees();
		treeLoaderMapChunkEleven.loadTrees();
		treeLoaderMapChunkTwelve.loadTrees();
		treeLoaderMapChunkThirteen.loadTrees();
		treeLoaderMapChunkFourteen.loadTrees();
		treeLoaderMapChunkFifteen.loadTrees();
		treeLoaderMapChunkSixteen.loadTrees();
		treeLoaderMapChunkEighteen.loadTrees();
		treeLoaderMapChunkTwenty.loadTrees();
		treeLoaderMapChunkTwentyOne.loadTrees();
		treeLoaderMapChunkTwentyTwo.loadTrees();
		treeLoaderMapChunkTwentyThree.loadTrees();
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
		treeLoaderMapChunkThirtyNine.loadTrees();
		treeLoaderMapChunkFourty.loadTrees();
		treeLoaderMapChunkFourtyThree.loadTrees();
		treeLoaderMapChunkFourtyFive.loadTrees();
		treeLoaderMapChunkFourtySix.loadTrees();
		treeLoaderMapChunkFourtySeven.loadTrees();
		treeLoaderMapChunkFourtyEight.loadTrees();
		treeLoaderMapChunkFiftyOne.loadTrees();
		treeLoaderMapChunkFiftyTwo.loadTrees();
		treeLoaderMapChunkFiftyThree.loadTrees();
		treeLoaderMapChunkFiftyFour.loadTrees();
		treeLoaderMapChunkFiftyFive.loadTrees();
		treeLoaderMapChunkFiftySix.loadTrees();
	}
}
