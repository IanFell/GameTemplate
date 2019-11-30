package loaders.cannonballloader;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.weapons.CannonBall;
import helpers.GameAttributeHelper;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class CannonBallLoader {

	private static ArrayList <CannonBall> cannonballs = new ArrayList<CannonBall>();

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public static void updateCannonBalls(MyGame myGame, MapHandler mapHandler) {
		if (cannonballs.size() > 0) {
			for (int i = 0; i < cannonballs.size(); i++) {
				cannonballs.get(i).updateObject(myGame, mapHandler);
				//if (timer > CANNONBALL_LIFE_SPAN) {
				//	cannonballs.remove(i);
				//}
			}
		}
		//timer++;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	public static void renderCannonBalls(SpriteBatch batch, ImageLoader imageLoader) {
		if (cannonballs.size() > 0) {
			for (int i = 0; i < cannonballs.size(); i++) {
				cannonballs.get(i).renderObject(batch, imageLoader);
			}
		}
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public static void createCannonBall(MyGame myGame) {
		cannonballs.add(new CannonBall(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 30, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 10)
				);
		//timer = 0;

	}
}
