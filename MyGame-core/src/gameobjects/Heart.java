package gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import handlers.CollisionHandler;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Heart extends GameObject {
	
	public static final int HEALTH = 1;
	
	public static boolean playSound = false;
	
	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public Heart(int x, int y) {
		this.x           = x;
		this.y           = y;
		int size         = 1;
		this.width       = size;
		this.height      = size;
		rectangle.x      = x;
		rectangle.y      = y;
		rectangle.width  = size;
		rectangle.height = size;
		hasBeenCollected = false;
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
					imageLoader.heart,
					x,
					y,
					width,
					-height
					);
		//renderHitBox(batch, shapeRenderer, imageLoader);
	}
	
	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	private void renderHitBox(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.whiteSquare,
				rectangle.x,
				rectangle.y,
				rectangle.width,
				-rectangle.height
				);
	}
	
	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		rectangle.x = x;
		rectangle.y = y;
		if (!hasBeenCollected) {
			CollisionHandler.checkIfPlayerCollidedWithHeart(PlayerController.getCurrentPlayer(myGame), this);
		} else {
			grow();
		}
	}
	
	private void grow() {
		int doubleGrowth = 2;
		float growValue  = 0.2f;
		x -= growValue;
		y -= growValue;
		width  += growValue * doubleGrowth;
		height += growValue * doubleGrowth;
	}

	/**
	 * 
	 * @param boolean hasBeenCollected
	 */
	public void setHasBeenCollected(boolean hasBeenCollected) {
		this.hasBeenCollected = hasBeenCollected;
	}
}
