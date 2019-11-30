package handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import loaders.ImageLoader;
import loaders.bulletloader.BulletLoader;
import loaders.cannonballloader.CannonBallLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class WeaponHandler {

	public static int WEAPON_SWORD = 0;
	public static int WEAPON_GUN   = 1;

	/**
	 * Constructor.
	 */
	public WeaponHandler() {}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public static void updateWeapons(MyGame myGame, MapHandler mapHandler) {
		BulletLoader.updateBullets(myGame, mapHandler);
		CannonBallLoader.updateCannonBalls(myGame, mapHandler);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	public static void renderWeapons(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {	
		BulletLoader.renderBullets(batch, imageLoader);
		CannonBallLoader.renderCannonBalls(batch, imageLoader);
	}
}
