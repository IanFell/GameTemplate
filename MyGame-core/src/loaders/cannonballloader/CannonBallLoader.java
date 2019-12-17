package loaders.cannonballloader;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.weapons.Cannon;
import gameobjects.weapons.CannonBall;
import loaders.ClassObjectLoader;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class CannonBallLoader extends ClassObjectLoader {

	public static ArrayList <CannonBall> cannonballs = new ArrayList<CannonBall>();

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public static void updateCannonBalls(MyGame myGame, MapHandler mapHandler) {
		if (cannonballs.size() > 0) {
			for (int i = 0; i < cannonballs.size(); i++) {
				cannonballs.get(i).updateObject(myGame, mapHandler);
				if (CannonBall.explosionLandTimer > CannonBall.MAX_EXPLOSION_VALUE) {
					cannonballs.remove(i);
				}
			}
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
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
	 * @param Cannon cannon
	 */ 
	public static void createCannonBall(Cannon cannon) {
		if (cannon.getCannonDirection() == Cannon.DIRECTION_RIGHT) {
			cannonballs.add(new CannonBall(cannon.getX() + 1, cannon.getY() - 3, Cannon.DIRECTION_RIGHT));
		} else {
			cannonballs.add(new CannonBall(cannon.getX() + 1, cannon.getY() - 3, Cannon.DIRECTION_LEFT));
		}
	}
}
