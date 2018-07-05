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
public class GamePlayObject extends GameObject {
	
	/**
	 * Constructor.
	 */
	public GamePlayObject() {
		this.x      = 15;
		this.y      = 8;
		this.width  = 4;
		this.height = 2;
	}
	
	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param GameObject  player
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.chest, x, y, width, -height);
	}
}
