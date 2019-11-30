package gameobjects.nature.trees;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.nature.NatureObject;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class DrSuessTree extends NatureObject {

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public DrSuessTree(int x, int y) {
		super(x, y);
		this.width  = 2;
		this.height = 8;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		renderNatureObject(batch, imageLoader.drSuessTree);
	}
}
