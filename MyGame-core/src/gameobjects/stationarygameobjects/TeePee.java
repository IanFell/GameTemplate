package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TeePee extends GamePlayObject {

	private String name;

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public TeePee(int x, int y, String name) {
		super(x, y);
		this.width  = 3;
		this.height = 4;
		this.name = name;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.teePee, x, y, width, -height);
	}
}
