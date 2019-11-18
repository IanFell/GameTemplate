package spawners;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Enemy;
import gameobjects.gamecharacters.Grunt;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class GruntSpawner extends EnemySpawner {

	public ArrayList <Grunt> grunts = new ArrayList<Grunt>();

	/**
	 * Constructor.
	 * 
	 * @param float  x
	 * @param float  y
	 * @param String name
	 */
	public GruntSpawner(float x, float y, String name) {
		super(x, y, name);
	}

	/**
	 * 
	 * @param MyGame myGame
	 * @param float  x
	 * @param float  y
	 */
	private void spawnGrunts(MyGame myGame, float x, float y) {
		timer++;
		if (timer > 100) {
			timer           = 0;
			float gruntSize = 1.0f;
			Grunt grunt = new Grunt(
					x, 
					y,
					gruntSize,
					gruntSize,
					Enemy.DIRECTION_UP
					);
			grunts.add(grunt);
			GameObjectLoader.gameObjectList.add(grunt);
		}
	}

	/**
	 * 
	 * @param MyGame    myGame
	 * @param MapHandler mapHandler
	 */
	public void updateGrunts(MyGame myGame, MapHandler mapHandler) {
		if (grunts != null) {
			for (int i = 0; i < grunts.size(); i++) {
				grunts.get(i).updateObject(myGame, mapHandler);
				// If enemy is dead and his dead fire animation has ended.
				if (grunts.get(i).isDead() && grunts.get(i).getTimer() >= Grunt.MAX_DEATH_ANIMATION_VALUE) {
					GameObjectLoader.gameObjectList.remove(grunts.get(i));
					grunts.remove(i);
				}
			}
		}
		if (grunts.size() < Grunt.MAX_ENEMIES_ALLOWED_TO_BE_ALIVE_AT_ONCE) {
			spawnGrunts(myGame, x, y);
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	public void renderGrunts(SpriteBatch batch, ImageLoader imageLoader) {
		if (grunts != null) {
			for (int i = 0; i < grunts.size(); i++) {
				grunts.get(i).renderObject(batch, imageLoader);
			}
		}
	}
}
