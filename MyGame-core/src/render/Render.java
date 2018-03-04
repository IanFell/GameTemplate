package render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
	 * Initialize renderer.
	 */
	public void init() {
		batch = new SpriteBatch();
	}
	
	/**
	 * Dispose of batch.
	 */
	public void dispose() {
		batch.dispose();
	}
}
