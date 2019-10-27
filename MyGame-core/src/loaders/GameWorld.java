package loaders;

import com.mygdx.mygame.MyGame;

import loaders.chestloader.ChestLoader;
import loaders.dockloader.DockLoader;
import loaders.fireloader.FireLoader;
import loaders.lighthouseloader.LightHouseLoader;
import loaders.pigglywigglyloader.PigglyWigglyLoader;
import loaders.plantloaders.PlantLoader;
import loaders.rawbarloader.RawBarLoader;
import loaders.rockloader.RockLoader;
import loaders.signloader.SignLoader;
import loaders.teepeeloader.TeePeeLoader;
import loaders.treeloaders.DrSuessTreeLoader;
import loaders.treeloaders.TreeLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class GameWorld {

	private TreeLoader treeLoader;
	private DrSuessTreeLoader drSuessTreeLoader;
	private PlantLoader plantLoader;
	private ChestLoader chestLoader;
	private TeePeeLoader teePeeLoader;
	private RawBarLoader rawBarLoader;
	private LightHouseLoader lightHouseLoader;
	private FireLoader fireLoader;
	private PigglyWigglyLoader pigglyWigglyLoader;
	private RockLoader rockLoader;
	private SignLoader signLoader;
	private DockLoader dockLoader;

	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public GameWorld(MyGame myGame) {
		treeLoader         = new TreeLoader();
		drSuessTreeLoader  = new DrSuessTreeLoader();
		plantLoader        = new PlantLoader();
		chestLoader        = new ChestLoader();
		teePeeLoader       = new TeePeeLoader();
		rawBarLoader       = new RawBarLoader();
		lightHouseLoader   = new LightHouseLoader();
		fireLoader         = new FireLoader();
		pigglyWigglyLoader = new PigglyWigglyLoader();
		rockLoader         = new RockLoader();
		signLoader         = new SignLoader();
		dockLoader         = new DockLoader();
		loadGameWorld(myGame);
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	private void loadGameWorld(MyGame myGame) {
		treeLoader.loadTrees();
		drSuessTreeLoader.loadTrees();
		plantLoader.loadPlants();
		rockLoader.loadRocks();
		chestLoader.loadChests();
		teePeeLoader.loadTeePees(myGame);
		rawBarLoader.loadRawBar(myGame);
		lightHouseLoader.loadLightHouse(myGame);
		fireLoader.loadFire();
		pigglyWigglyLoader.loadPigglyWiggly(myGame);
		signLoader.loadSigns();
		dockLoader.loadDocks(myGame);
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
		for (int i = 0; i< FireLoader.fires.length; i++) {
			FireLoader.fires[i].updateObject(myGame, mapHandler);
		}
		RawBarLoader.rawbar.updateObject(myGame, mapHandler);
		PigglyWigglyLoader.pigglyWiggly.updateObject(myGame, mapHandler);
	}
}
