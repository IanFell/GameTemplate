package loaders;

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
	
	/*
	 * Constructor.
	 */
	public GameWorld() {
		treeLoader  = new TreeLoader();
		plantLoader = new PlantLoader();
		loadGameWorld();
	}
	
	private void loadGameWorld() {
		treeLoader.loadTrees();
		plantLoader.loadPlants();
	}
}
