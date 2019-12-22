package gameobjects.gamecharacters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.weapons.Cannon;
import loaders.ImageLoader;

/**
 * This is the guy shooting the cannons.
 * 
 * @author Fabulous Fellini
 *
 */
public class Knight extends Enemy {

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 * @param float width
	 * @param float height
	 * @param int   direction
	 */
	public Knight(float x, float y, float width, float height, int direction) {
		super(x, y, width, height, direction);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		if (direction == Cannon.DIRECTION_LEFT) {
			batch.draw(
					imageLoader.knightLeft, 
					x, 
					y, 
					width, 
					-height
					);
		} else {
			batch.draw(
					imageLoader.knightRight, 
					x, 
					y, 
					width, 
					-height
					);
		}
	}
}
