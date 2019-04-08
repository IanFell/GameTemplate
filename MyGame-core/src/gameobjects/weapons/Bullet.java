package gameobjects.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Player;
import loaders.ImageLoader;
import loaders.chestloader.ChestLoader;
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
		this.damageInflicted = Weapon.DAMAGE_INFLICTED_BULLET;
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
		switch (Player.direction) {
		case Player.DIRECTION_LEFT:
			dx          = -bulletSpeed;
			dy          = 0;
			this.width  = bulletSizeLong;
			this.height = bulletSizeShort;
			break;
		case Player.DIRECTION_RIGHT:
			dx          = bulletSpeed;
			dy          = 0;
			this.width  = bulletSizeLong;
			this.height = bulletSizeShort;
			break;
		case Player.DIRECTION_UP:
			dx          = 0;
			dy          = -bulletSpeed;
			this.width  = bulletSizeShort;
			this.height = bulletSizeLong;
			break;
		case Player.DIRECTION_DOWN:
			dx          = 0;
			dy          = bulletSpeed;
			this.width  = bulletSizeShort;
			this.height = bulletSizeLong;
			break;
		}
		x += dx;
		y += dy;
		
		checkIfWeaponHasCollidedWithObject(ChestLoader.chests, this);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.whiteSquare,
				x, 
				y,
				width,
				height
				);
	}
}
