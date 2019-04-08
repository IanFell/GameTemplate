package handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.weapons.Gun;
import loaders.GameObjectLoader;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class WeaponHandler {

	public static Gun gun ;

	/**
	 * Constructor.
	 */
	public WeaponHandler() {
		gun = new Gun(0, 0);
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void init(MyGame myGame) {
		GameObjectLoader.gameObjectList.add(gun);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public static void updateWeapons(MyGame myGame, MapHandler mapHandler) {
		gun.updateObject(myGame, mapHandler);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	public static void renderWeapons(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		gun.renderObject(batch, shapeRenderer, imageLoader);
	}
}
