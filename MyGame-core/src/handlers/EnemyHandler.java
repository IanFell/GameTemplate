package handlers;

import com.mygdx.mygame.MyGame;

import gameobjects.stationarygameobjects.buildings.EnemyHut;
import gameobjects.weapons.LegendSword;
import gameobjects.weapons.Weapon;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import maps.MapHandler;
import spawners.EnemySpawner;
import towns.Town;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class EnemyHandler {

	public EnemySpawner[] enemySpawner = new EnemySpawner[7];

	// Use enemy huts to mask enemy spawning.
	public EnemyHut[] enemyHut = new EnemyHut[7];

	/**
	 * 
	 * @param ImageLoader imageLoader
	 */
	public void init(ImageLoader imageLoader) {
		enemySpawner[Town.MEXICO_BEACH] = new EnemySpawner(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 48, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 12.5f, 
				"Mexico Beach"
				);
		enemySpawner[Town.PORT_ST_JOE] = new EnemySpawner(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 5, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 5, 
				"Port St Joe"
				);
		enemySpawner[Town.THE_POINT] = new EnemySpawner(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 30, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START - 10, 
				"The Point"
				);
		enemySpawner[Town.WEWA] = new EnemySpawner(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 50, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 12, 
				"Wewa"
				);
		enemySpawner[Town.APALACHICOLA] = new EnemySpawner(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 25, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 50, 
				"Apalachicola"
				);
		enemySpawner[Town.ST_GEORGE] = new EnemySpawner(
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 15, 
				GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START - 8, 
				"St George"
				);
		enemySpawner[Town.CAPE_SAN_BLAS] = new EnemySpawner(
				GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 3, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 12, 
				"Cape San Blas"
				);

		for (int i = 0; i < enemyHut.length; i++) {
			enemyHut[i]= new EnemyHut(0, 0, 4, 4, imageLoader.slaveHut);
			GameObjectLoader.gameObjectList.add(enemyHut[i]);
		}

		enemyHut[Town.MEXICO_BEACH].setX(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 47);
		enemyHut[Town.MEXICO_BEACH].setY(GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 13);
		enemyHut[Town.PORT_ST_JOE].setX(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 2.5f);
		enemyHut[Town.PORT_ST_JOE].setY(GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 3);
		enemyHut[Town.THE_POINT].setX(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 30);
		enemyHut[Town.THE_POINT].setY(GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START - 10);
		enemyHut[Town.WEWA].setX(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 50);
		enemyHut[Town.WEWA].setY(GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 13);
		enemyHut[Town.APALACHICOLA].setX(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 24);
		enemyHut[Town.APALACHICOLA].setY(GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 50);
		enemyHut[Town.ST_GEORGE].setX(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 15);
		enemyHut[Town.ST_GEORGE].setY(GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START - 8);
		enemyHut[Town.CAPE_SAN_BLAS].setX(GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 3);
		enemyHut[Town.CAPE_SAN_BLAS].setY(GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 12);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateEnemies(MyGame myGame, MapHandler mapHandler) {
		for (int i = 0; i < enemySpawner.length; i++) {
			enemySpawner[i].updateEnemies(myGame, mapHandler);
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param LegenSword legendSword
	 */
	public void checkWeaponCollision(MyGame myGame, LegendSword legendSword) {
		for (int i = 0; i < enemySpawner.length; i++) {
			if (enemySpawner[i].enemies != null) {
				for (int k = 0; k < enemySpawner[i].enemies.size(); k++) {
					CollisionHandler.checkIfWeaponHasCollidedWithEnemy(enemySpawner[i].enemies.get(k), legendSword);
				}
			}
		}
	}

	/**
	 * 
	 * @param MyGame myGame
	 * @param Weapon weapon
	 */
	public void checkProjectileCollision(MyGame myGame, Weapon weapon) {
		for (int i = 0; i < enemySpawner.length; i++) {
			if (enemySpawner[i].enemies != null) {
				for (int k = 0; k < enemySpawner[i].enemies.size(); k++) {
					CollisionHandler.checkIfProjectileHasCollidedWithEnemy(enemySpawner[i].enemies.get(k), weapon);
				}
			}
		}
	}
}
