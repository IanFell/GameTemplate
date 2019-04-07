package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import loaders.ImageLoader;

public class PigglyWiggly extends GamePlayObject {

	public PigglyWiggly(int x, int y) {
		super(x, y);
		this.width       = 7;
		this.height      = 6;
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
		batch.draw(imageLoader.pigglywiggly, x, y, width, -height);
	}

}
