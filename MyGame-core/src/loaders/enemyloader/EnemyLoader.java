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

	public Enemy enemy;

	/**
	 * 
	 * @param MyGame myGame
	 */
	public Enemy loadEnemy(MyGame myGame, float x, float y, int direction) {
		enemy = new Enemy(
				x, 
				y,
				1,
				1,
				myGame.imageLoader.enemy,
				direction
				);
		//GameObjectLoader.gameObjectList.add(enemy);
		return enemy;
	}
}
