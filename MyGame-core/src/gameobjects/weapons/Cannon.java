package gameobjects.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import helpers.GamePlayHelper;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;
import loaders.cannonballloader.CannonBallLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Cannon extends Weapon {
	
	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;

	private int timer = 0;
	
	// When timer reaches above this value, cannon will fire.
	private double timeToShoot = 50;
	
	private int direction;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 */
	public Cannon(float x, float y, int direction) {
		super(x, y);
		int size       = 3;
		this.width     = size;
		this.height    = size;
		this.direction = direction;
		//timeToShoot    = RandomNumberGenerator.generateRandomDouble(50, 100);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		if (timer > timeToShoot) {
			if (GamePlayHelper.gameObjectIsWithinScreenBounds(this)) {
				CannonBallLoader.createCannonBall(this);
			}
			timer = 0;
		}
		timer++;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		Texture texture = imageLoader.cannonLeft;
		if (direction == DIRECTION_RIGHT) {
			texture = imageLoader.cannonRight;
		}
		batch.draw(
				texture, 
				x, 
				y, 
				width, 
				-height
				);
	}

	/**
	 * 
	 * @return int
	 */
	public int getCannonDirection() {
		return direction;
	}
}
