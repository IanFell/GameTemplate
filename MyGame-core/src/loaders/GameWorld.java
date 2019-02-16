package loaders;

import loaders.chestloader.ChestLoader;
import loaders.plantloaders.PlantLoader;
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

	/*
	 * Constructor.
	 */
	public GameWorld() {
		treeLoader  = new TreeLoader();
		plantLoader = new PlantLoader();
		chestLoader = new ChestLoader();
		loadGameWorld();
	}

	private void loadGameWorld() {
		treeLoader.loadTrees();
		plantLoader.loadPlants();
		chestLoader.loadChests();
	}
}
