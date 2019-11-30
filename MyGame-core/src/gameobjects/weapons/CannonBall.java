package gameobjects.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class CannonBall extends Weapon {

	private int timer = 0;

	private int size = 1;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 */
	public CannonBall(float x, float y) {
		super(x, y);
		dx = 1;
		dy = -0.5f;
	}

	/**
	 * 
	 * @param MyGame     myGamet
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		x += dx;
		y += dy;
		timer++;
		handleCannonBallPhysics();
	}

	private void handleCannonBallPhysics() {
		if (dx > 0) {
			dx -= .04f;
			if (timer < 2) {
				dy -= .01f;
			} else {
				dy += .04f;
			}
		} else {
			dx = 0;
			dy = 0;
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.whiteSquare,
				x, 
				y,
				size,
				size
				);
	}
}
