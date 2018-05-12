package gameobjects.StationaryGameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class NatureObject extends GameObject {
	
	/**
	 * Constructor.
	 */
	public NatureObject() {
		this.x      = 4;
		this.y      = 5;
		this.width  = 2;
		this.height = 4;
	}
	
	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param GameObject  player
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.tree, x, y, width, -height);
	}

}
