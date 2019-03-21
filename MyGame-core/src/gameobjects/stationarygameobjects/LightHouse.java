package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class LightHouse extends GamePlayObject {

	/**
	 * 
	 * @param int x
	 * @param int y
	 */
	public LightHouse(int x, int y) {
		super(x, y);
		this.width       = 4;
		this.height      = 15;
		this.rectangle.x = width;
		this.rectangle.y = height;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.lightHouse, x, y, width, -height);
	}
}
