package spawners;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Enemy;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import maps.MapHandler;
import missions.MissionStumpHole;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class EnemySpawner {

	private final int MAX_ENEMIES_ALLOWED_TO_BE_ALIVE_AT_ONCE = 30;

	protected float x;
	protected float y;
	private String name;
	protected int timer;
	public ArrayList <Enemy> enemies = new ArrayList<Enemy>();

	/**
	 * Constructor.
	 * 
	 * @param float  x
	 * @param float  y
	 * @param String name
	 */
	public EnemySpawner(float x, float y, String name) {
		this.x    = x;
		this.y    = y;
		this.name = name;
		timer     = 0;
	}

	/**
	 * 
	 * @param MyGame myGame
	 * @param float  x
	 * @param float  y
	 */
	private void spawnEnemies(MyGame myGame, float x, float y) {
		timer++;
		if (timer > 100) {
			timer         = 0;
			int enemySize = 1;
			Enemy enemy = new Enemy(
					x, 
					y,
					enemySize,
					enemySize,
					Enemy.DIRECTION_UP
					);
			enemies.add(enemy);
			GameObjectLoader.gameObjectList.add(enemy);
		}
	}

	/**
	 * 
	 * @param MyGame    myGame
	 * @param MapHandler mapHandler
	 */
	public void updateEnemies(MyGame myGame, MapHandler mapHandler) {
		// Ensure grunts dont kill player during a mission with a different screen.
		if (!MissionStumpHole.missionIsActive) {
			if (enemies != null) {
				for (int i = 0; i < enemies.size(); i++) {
					enemies.get(i).updateObject(myGame, mapHandler);
					// If enemy is dead and his dead fire animation has ended.
					if (enemies.get(i).isDead() && enemies.get(i).getTimer() >= Enemy.MAX_DEATH_ANIMATION_VALUE) {
						GameObjectLoader.gameObjectList.remove(enemies.get(i));
						enemies.remove(i);
					}
				}
			}
			if (enemies.size() < MAX_ENEMIES_ALLOWED_TO_BE_ALIVE_AT_ONCE) {
				spawnEnemies(myGame, x, y);
			}
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	public void renderEnemies(SpriteBatch batch, ImageLoader imageLoader) {
		if (enemies != null) {
			for (int i = 0; i < enemies.size(); i++) {
				enemies.get(i).renderObject(batch, imageLoader);
			}
		}
	}
}

