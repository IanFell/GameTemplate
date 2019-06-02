package handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.weapons.LegendSword;
import helpers.GameAttributeHelper;
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

	public void init() {
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
	
	public void renderEnemyHut(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		for (int i = 0; i < enemySpawner.length; i++) {
			batch.draw(imageLoader.slaveHut, GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 48, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 12.5f, 4, -4);
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
}
