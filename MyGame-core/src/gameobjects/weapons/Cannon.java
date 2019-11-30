package gameobjects.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import loaders.ImageLoader;
import loaders.cannonballloader.CannonBallLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Cannon extends Weapon {

	private int timer = 0;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 */
	public Cannon(float x, float y) {
		super(x, y);
		this.width = 3;
		this.height = 1;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		if (timer > 50) {
			CannonBallLoader.createCannonBall(myGame);
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
		batch.draw(
				imageLoader.blackSquare, 
				x, 
				y, 
				width, 
				height
				);
	}
}
