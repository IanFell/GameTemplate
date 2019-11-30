package gameobjects.nature;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.GameObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class NatureObject extends GameObject {

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public NatureObject(int x, int y) {
		this.x      = x;
		this.y      = y;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param Texture     texture
	 */
	protected void renderNatureObject(SpriteBatch batch, Texture texture) {
		batch.draw(texture, x, y, width, -height);
	}
}
