package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * GamePlayObjects represent objects that will interact with the player,
 * such as a chest or a key.
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
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(imageLoader.chest, x, y, width, -height);
	}
}
