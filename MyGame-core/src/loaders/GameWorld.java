package loaders;

import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;
import loaders.chestloader.ChestLoader;
import loaders.enemyloader.EnemyLoader;
import loaders.fireloader.FireLoader;
import loaders.lighthouseloader.LightHouseLoader;
import loaders.pigglywigglyloader.PigglyWigglyLoader;
import loaders.plantloaders.PlantLoader;
import loaders.rawbarloader.RawBarLoader;
import loaders.teepeeloader.TeePeeLoader;
import loaders.treeloaders.DrSuessTreeLoader;
import loaders.treeloaders.TreeLoader;
import maps.MapHandler;
import spawners.EnemySpawner;

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
	//private EnemyLoader enemyLoader;
	//private static EnemySpawner enemySpawner;
	//private EnemySpawner enemySpawner;

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
		//enemyLoader        = new EnemyLoader();
		//enemySpawner = new EnemySpawner(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 48, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 12.5f, null);
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
		chestLoader.loadChests();
		teePeeLoader.loadTeePees(myGame);
		rawBarLoader.loadRawBar(myGame);
		lightHouseLoader.loadLightHouse(myGame);
		fireLoader.loadFire();
		pigglyWigglyLoader.loadPigglyWiggly(myGame);
		//enemyLoader.loadEnemies(myGame);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public static void updateGameWorld(MyGame myGame, MapHandler mapHandler) {
		//for (int i = 0; i< EnemyLoader.enemies.length; i++) {
		//	EnemyLoader.enemies[i].updateObject(myGame, mapHandler);
		//}
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
		PigglyWigglyLoader.pigglyWiggly.updateObject(myGame, mapHandler);
		
		//enemySpawner.updateEnemies(myGame, mapHandler);
	}
}
