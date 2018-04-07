package render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Class to hold rendering objects and perform rendering actions.
 * 
 * @author Fabulous Fellini
 *
 */
public class Render {
	
	/**
	 * Sprite batch.
	 */
	public SpriteBatch batch;
	
	/**
	 * ShapeRenderer.
	 */
	public ShapeRenderer shapeRenderer;
	
	/**
	 * Initialize renderer.
	 */
	public void init() {
		batch         = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
	}
	
	/**
	 * Dispose of renderer.
	 */
	public void dispose() {
		batch.dispose();
		shapeRenderer.dispose();
	}
}
