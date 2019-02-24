package loaders;

import loaders.chestloader.ChestLoader;
import loaders.plantloaders.PlantLoader;
import loaders.teepeeloader.TeePeeLoader;
import loaders.treeloaders.TreeLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class GameWorld {

	private TreeLoader treeLoader;
	private PlantLoader plantLoader;
	private ChestLoader chestLoader;
	private TeePeeLoader teePeeLoader;

	/*
	 * Constructor.
	 */
	public GameWorld() {
		treeLoader   = new TreeLoader();
		plantLoader  = new PlantLoader();
		chestLoader  = new ChestLoader();
		teePeeLoader = new TeePeeLoader();
		loadGameWorld();
	}

	private void loadGameWorld() {
		treeLoader.loadTrees();
		plantLoader.loadPlants();
		chestLoader.loadChests();
		teePeeLoader.loadTeePees();
	}
}
