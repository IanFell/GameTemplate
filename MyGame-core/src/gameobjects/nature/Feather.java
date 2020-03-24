package gameobjects.nature;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import handlers.CollisionHandler;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;
import maps.MapHandler;
import missions.MissionStumpHole;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Feather extends NatureObject {

	public static boolean playSound = false;

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public Feather(int x, int y) {
		super(x, y);
		int size         = 1;
		this.width       = size;
		this.height      = size;
		rectangle.width  = width;
		rectangle.height = height;

		this.dx = (float) RandomNumberGenerator.generateRandomDouble(0, 1.5f);
		this.dy = (float) RandomNumberGenerator.generateRandomDouble(0.1f, 0.07f);

		// Make feather either fly left or right.
		int dxDirection = RandomNumberGenerator.generateRandomInteger(100);
		if (dxDirection < dxDirection / 2) {
			dx = -dx;
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		renderNatureObject(batch, imageLoader.feather);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		rectangle.x = x;
		rectangle.y = y;
		x += dx;
		y += dy;

		// Slow down dx with time so it appears feather slows down after it's dropped.
		if (dx > 0) {
			dx -= .02;
		}

		CollisionHandler.checkIfPlayerHasCollidedWithFeather(MissionStumpHole.player, this);
	}
}
