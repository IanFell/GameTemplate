package spawners;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Enemy;
import gameobjects.gamecharacters.Player;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import maps.MapHandler;

public class EnemySpawner {
	
	private final int MAX_ENEMIES_ALLOWED_TO_BE_ALIVE_AT_ONCE = 100;
	
	private float x;
	private float y;
	private String name;
	int timer;
	public ArrayList <Enemy> enemies = new ArrayList<Enemy>();
	
	public EnemySpawner(float x, float y, String name) {
		this.x    = x;
		this.y    = y;
		this.name = name;
		timer     = 0;
	}
	
	private void spawnEnemies(MyGame myGame, float x, float y) {
		timer++;
		if (timer > 100) {
			timer = 0;
			Enemy enemy = new Enemy(
					x, 
					y,
					1,
					1,
					myGame.imageLoader.enemy,
					Enemy.DIRECTION_UP
					);
			enemies.add(enemy);
			GameObjectLoader.gameObjectList.add(enemy);
		}
	}
	
	public void updateEnemies(MyGame myGame, MapHandler mapHandler) {
		if (enemies != null) {
			for (int i = 0; i < enemies.size(); i++) {
				enemies.get(i).updateObject(myGame, mapHandler);
			}
		}
		if (enemies.size() < MAX_ENEMIES_ALLOWED_TO_BE_ALIVE_AT_ONCE) {
			spawnEnemies(myGame, x, y);
		}
	}
	
	public void renderEnemies(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (enemies != null) {
			for (int i = 0; i < enemies.size(); i++) {
				enemies.get(i).renderObject(batch, shapeRenderer, imageLoader);
			}
		}
	}

}

