package loaders.enemyloader;

import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Enemy;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class EnemyLoader {

	public static Enemy enemy;

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void loadEnemy(MyGame myGame) {
		enemy = new Enemy(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 45, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 10,
				1,
				1,
				myGame.imageLoader.enemy
				);
		GameObjectLoader.gameObjectList.add(enemy);
	}
}
