package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import helpers.GameAttributeHelper;
import loaders.ImageLoader;

public class TeePee extends GamePlayObject {
	
	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public TeePee(int x, int y) {
		super(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 35, 5);
		this.width = 3;
		this.height = 4;
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
