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
import loaders.quicksandloader.QuickSandLoader;
import loaders.rawbarloader.RawBarLoader;
import loaders.rockloader.RockLoader;
import loaders.signloader.SignLoader;
import loaders.stumploader.StumpLoader;
import loaders.teepeeloader.TeePeeLoader;
import loaders.tradingpostloader.TradingPostLoader;
import loaders.treeloaders.DrSuessTreeLoader;
import loaders.treeloaders.TreeLoader;
import maps.MapHandler;
import missions.MissionStumpHole;

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
	private StumpLoader stumpLoader;
	private QuickSandLoader quickSandLoader;

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
		stumpLoader        = new StumpLoader();
		quickSandLoader    = new QuickSandLoader();
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
		stumpLoader.loadStumps();
		quickSandLoader.loadQuickSand();
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public static void updateGameWorld(MyGame myGame, MapHandler mapHandler) {
		for (int i = 0; i < ChestLoader.chests.length; i++) {
			ChestLoader.chests[i].updateObject(myGame, mapHandler);
		}
		for (int i = 0; i < TeePeeLoader.teePees.length; i++) {
			TeePeeLoader.teePees[i].updateObject(myGame, mapHandler);
		}
		for (int i = 0; i < FireLoader.fires.length; i++) {
			FireLoader.fires[i].updateObject(myGame, mapHandler);
		}
		for (int i = 0; i < FireLoader.fires.length; i++) {
			FireLoader.fires[i].updateObject(myGame, mapHandler);
		}
		for (int i = 0; i < QuickSandLoader.quickSand.length; i++) {
			QuickSandLoader.quickSand[i].updateObject(myGame, mapHandler);
		}

		if (!MissionStumpHole.missionIsActive) {
			for(int i = 0; i < CannonLoader.cannons.length; i++) {	
				CannonLoader.cannons[i].updateObject(myGame, mapHandler);
			}
		}

		/**
		 * Since the stump hole mission is drawn directly over these game world stumps,
		 * do not update game world stumps during stump hole mission.  
		 * This is so stump hole player cannot get stuck on these stumps which will take them above the screen
		 * and soft crash the game.
		 */
		for(int i = 0; i < StumpLoader.stumps.size(); i++) {
			if (!MissionStumpHole.missionIsActive) {
				StumpLoader.stumps.get(i).updateObject(myGame, mapHandler);
			}
		}
		RawBarLoader.rawbar.updateObject(myGame, mapHandler);
		PigglyWigglyLoader.pigglyWiggly.updateObject(myGame, mapHandler);
		TradingPostLoader.tradingPost.updateObject(myGame, mapHandler);
	}
}
