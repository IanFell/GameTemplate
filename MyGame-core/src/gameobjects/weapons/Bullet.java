package gameobjects.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.PlayerOne;
import handlers.CollisionHandler;
import handlers.GiantHandler;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Bullet extends Weapon {

	/**
	 * Constructor. 
	 * 
	 * @param float x
	 * @param float y
	 */
	public Bullet(float x, float y) {
		super(x, y);
	}

	/**
	 * 
	 * @param MyGame     myGamet
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		this.rectangle.x      = x;
		this.rectangle.y      = y;
		this.rectangle.width  = width;
		this.rectangle.height = height;
		float bulletSpeed     = 1;
		float bulletSizeLong  = 0.5f;
		float bulletSizeShort = 0.2f;
		switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
		case DIRECTION_LEFT:
			dx          = -bulletSpeed;
			dy          = 0;
			this.width  = bulletSizeLong;
			this.height = bulletSizeShort;
			break;
		case DIRECTION_RIGHT:
			dx          = bulletSpeed;
			dy          = 0;
			this.width  = bulletSizeLong;
			this.height = bulletSizeShort;
			break;
		case DIRECTION_UP:
			dx          = 0;
			dy          = -bulletSpeed;
			this.width  = bulletSizeShort;
			this.height = bulletSizeLong;
			break;
		case DIRECTION_DOWN:
			dx          = 0;
			dy          = bulletSpeed;
			this.width  = bulletSizeShort;
			this.height = bulletSizeLong;
			break;
		}
		x += dx;
		y += dy;

		myGame.gameScreen.enemyHandler.checkProjectileCollision(myGame, this);
		myGame.gameScreen.gruntHandler.checkProjectileCollision(myGame, this);
		for (int i = 0; i < GiantHandler.giants.length; i++) {
			CollisionHandler.checkIfProjectileHasCollidedWithEnemy(GiantHandler.giants[i], this);
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.whiteSquare,
				x, 
				y,
				width,
				height
				);
	}
}
