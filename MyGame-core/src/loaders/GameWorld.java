package loaders;

import com.mygdx.mygame.MyGame;

import loaders.cannonloader.CannonLoader;
import loaders.chestloader.ChestLoader;
import loaders.dockloader.DockLoader;
import loaders.fireloader.FireLoader;
import loaders.flowerloader.FlowerLoader;
import loaders.lighthouseloader.LightHouseLoader;
import loaders.pigglywigglyloader.PigglyWigglyLoader;
import loaders.plantloaders.PlantLoader;
import loaders.rawbarloader.RawBarLoader;
import loaders.rockloader.RockLoader;
import loaders.signloader.SignLoader;
import loaders.teepeeloader.TeePeeLoader;
import loaders.tradingpostloader.TradingPostLoader;
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
	private TradingPostLoader tradingPostLoader;
	private LightHouseLoader lightHouseLoader;
	private FireLoader fireLoader;
	private PigglyWigglyLoader pigglyWigglyLoader;
	private RockLoader rockLoader;
	private FlowerLoader flowerLoader;
	private SignLoader signLoader;
	private DockLoader dockLoader;
	private CannonLoader cannonLoader;

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
		flowerLoader       = new FlowerLoader();
		signLoader         = new SignLoader();
		dockLoader         = new DockLoader();
		tradingPostLoader  = new TradingPostLoader();
		cannonLoader       = new CannonLoader();
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
		flowerLoader.loadFlowers();
		chestLoader.loadChests();
		teePeeLoader.loadTeePees(myGame);
		rawBarLoader.loadRawBar(myGame);
		lightHouseLoader.loadLightHouse(myGame);
		fireLoader.loadFire();
		pigglyWigglyLoader.loadPigglyWiggly(myGame);
		signLoader.loadSigns();
		dockLoader.loadDocks(myGame);
		tradingPostLoader.loadTradingPost(myGame);
		cannonLoader.loadCannons(myGame);
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
		TradingPostLoader.tradingPost.updateObject(myGame, mapHandler);
		CannonLoader.cannon.updateObject(myGame, mapHandler);
	}
}
