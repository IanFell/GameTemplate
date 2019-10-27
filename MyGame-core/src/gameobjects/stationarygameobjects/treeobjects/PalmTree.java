package gameobjects.stationarygameobjects.treeobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.stationarygameobjects.NatureObject;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PalmTree extends NatureObject {
	
	private int randomTree;
	private float randomHeight;

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public PalmTree(int x, int y) {
		super(x, y);
		this.width   = 2;
		this.height  = 4;
		this.x       = x - 0.5f;
		randomTree   = RandomNumberGenerator.generateRandomInteger(2);
		randomHeight = (float) RandomNumberGenerator.generateRandomDouble(2, height + 3);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		if (randomTree < 1) {
			batch.draw(imageLoader.palmTree, x, y, width, -height);
		} else {
			batch.draw(imageLoader.palmTreeThree, x + 1.5f, y, width / 2 + 0.7f, -randomHeight);
		}
	}
}
