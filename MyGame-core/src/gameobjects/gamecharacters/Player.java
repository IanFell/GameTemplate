package gameobjects.gamecharacters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import loaders.ImageLoader;
import maps.MapEditor;

/**
 * Player object.
 * 
 * @author Fabulous Fellini
 *
 */
public class Player extends GameCharacter {
	
	/**
	 * Available directions player can travel.  
	 */
	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_UP    = 2;
	public static final int DIRECTION_DOWN  = 3;
	
	/**
	 * Constructor.
	 */
	public Player() {
		this.x      = 5;
		this.y      = 10;
		this.width  = characterSize;
		this.height = characterSize;
	}
	
	/**
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	@Override
	public void updateObject(MyGame myGame, MapEditor mapEditor) {
		x += dx;
		y += dy;
	}
	
	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.playerSprite, 
				x, 
				y, 
				width, 
				height
				);
	}
}
