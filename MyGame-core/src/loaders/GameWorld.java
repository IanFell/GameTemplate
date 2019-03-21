package loaders;

import com.mygdx.mygame.MyGame;

import loaders.chestloader.ChestLoader;
import loaders.fireloader.FireLoader;
import loaders.lighthouseloader.LightHouseLoader;
import loaders.plantloaders.PlantLoader;
import loaders.rawbarloader.RawBarLoader;
import loaders.teepeeloader.TeePeeLoader;
import loaders.treeloaders.TreeLoader;
import maps.MapHandler;

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
	private RawBarLoader rawBarLoader;
	private LightHouseLoader lightHouseLoader;
	private FireLoader fireLoader;

	/*
	 * Constructor.
	 */
	public GameWorld() {
		treeLoader       = new TreeLoader();
		plantLoader      = new PlantLoader();
		chestLoader      = new ChestLoader();
		teePeeLoader     = new TeePeeLoader();
		rawBarLoader     = new RawBarLoader();
		lightHouseLoader = new LightHouseLoader();
		fireLoader       = new FireLoader();
		loadGameWorld();
	}

	private void loadGameWorld() {
		treeLoader.loadTrees();
		plantLoader.loadPlants();
		chestLoader.loadChests();
		teePeeLoader.loadTeePees();
		rawBarLoader.loadRawBar();
		lightHouseLoader.loadLightHouse();
		fireLoader.loadFire();
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public static void updateGameWorld(MyGame myGame, MapHandler mapHandler) {
		for (int i = 0; i< ChestLoader.chests.length; i++) {
			ChestLoader.chests[i].updateObject(myGame, mapHandler);
		}
		for (int i = 0; i< TeePeeLoader.teePees.length; i++) {
			TeePeeLoader.teePees[i].updateObject(myGame, mapHandler);
		}
		for (int i = 0; i< FireLoader.fires.length; i++) {
			FireLoader.fires[i].updateObject(myGame, mapHandler);
		}
		RawBarLoader.rawbar.updateObject(myGame, mapHandler);
	}
}
