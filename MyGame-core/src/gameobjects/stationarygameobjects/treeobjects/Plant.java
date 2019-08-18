package gameobjects.stationarygameobjects.treeobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.stationarygameobjects.NatureObject;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Plant extends NatureObject {

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public Plant(int x, int y) {
		super(x, y);
		float size  = 1.5f;
		this.width  = size;
		this.height = size;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(imageLoader.plant, x, y + 1, width, -height);
	}
}
