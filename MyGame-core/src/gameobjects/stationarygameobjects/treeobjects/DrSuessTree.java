package gameobjects.stationarygameobjects.treeobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import gameobjects.stationarygameobjects.NatureObject;
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
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.drSuessTree, x, y, width, -height);
	}
}
