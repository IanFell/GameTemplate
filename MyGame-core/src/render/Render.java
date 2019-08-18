package render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Class to hold rendering objects and perform rendering actions.
 * 
 * @author Fabulous Fellini
 *
 */
public class Render {

	public SpriteBatch batch;

	//public ShapeRenderer shapeRenderer;

	public void init() {
		batch         = new SpriteBatch();
		//shapeRenderer = new ShapeRenderer();
	}

	public void dispose() {
		batch.dispose();
		//shapeRenderer.dispose();
	}
}
