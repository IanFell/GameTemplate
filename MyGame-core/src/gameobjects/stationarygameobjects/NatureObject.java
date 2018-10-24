package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class NatureObject extends GameObject {

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public NatureObject(int x, int y) {
		this.x      = x;
		this.y      = y;
		this.width  = 1;
		this.height = 2;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param GameObject  player
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.palmTree, x, y, width, -height);
	}
}
