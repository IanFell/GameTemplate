package gameobjects.gamecharacters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.ImageLoader;
import maps.MapEditor;
import physics.CollisionHandler;

/**
 * Player object.
 * 
 * @author Fabulous Fellini
 *
 */
public class Player extends GameObject {
	
	/**
	 * Boolean to check whether player should stop moving upon collisions.
	 */
	public static boolean playerShouldStopMoving = false;
	
	/**
	 * Size of character.
	 */
	protected int characterSize = 1;

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
		this.x           = 5;
		this.y           = 10;
		this.width       = characterSize;
		this.height      = characterSize;
		rectangle.width  = width;
		rectangle.height = height;
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
		rectangle.x = x;
		rectangle.y = y;
		CollisionHandler.checkIfPlayerHasCollidedWithASolidTile(myGame, mapEditor);
	}
	
	/**
	 * Moves player back 1 on the x, y axis depending on which direction player is going, 
	 * then stops it.  This is used when a player interacts with a solid tile.
	 * 
	 * @param int direction
	 */
	public void stopScrolling(int direction) {
		float bounceBackAmountUponPlayerTileCollision = 0.1f;
		switch (direction) {
			case Player.DIRECTION_LEFT:
				x += bounceBackAmountUponPlayerTileCollision;
				break;
			case Player.DIRECTION_RIGHT:
				x -= bounceBackAmountUponPlayerTileCollision;
				break;
			case Player.DIRECTION_UP:
				y += bounceBackAmountUponPlayerTileCollision;
				break;
			case Player.DIRECTION_DOWN:
				y -= bounceBackAmountUponPlayerTileCollision;
				break;
		}
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

	/**
	 * Moves object along the x axis.
	 * 
	 * @param float distance
	 */
	@Override
	public void translateX(float distance) {
		x += distance;
	}
	
	/**
	 * Moves object along the y axis.
	 * 
	 * @param float distance
	 */
	@Override
	public void translateY(float distance) {
		y += distance;
	}
	
}
