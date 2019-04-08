package gameobjects.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.gamecharacters.Player;
import loaders.ImageLoader;
import loaders.bulletloader.BulletLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Gun extends Weapon {
	
	public static boolean playerIsEquippedWithGun = false;

	/**
	 * 
	 * @param float x
	 * @param float y
	 */
	public Gun(float x, float y) {
		super(x, y);
		this.width            = 0.5f;
		this.height           = 0.5f;
		this.rectangle.width  = width;
		this.rectangle.height = height;
	}
	
	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		
		float leftRightOffset = 0.5f;
		switch (Player.direction) {
		case Player.DIRECTION_LEFT:
			x = PlayerController.getCurrentPlayer(myGame).getX() - leftRightOffset;
			y = PlayerController.getCurrentPlayer(myGame).getY() - leftRightOffset;
			break;
		case Player.DIRECTION_RIGHT:
			x = PlayerController.getCurrentPlayer(myGame).getX() + leftRightOffset;
			y = PlayerController.getCurrentPlayer(myGame).getY() - leftRightOffset;
			break;
		case Player.DIRECTION_UP:
			x = PlayerController.getCurrentPlayer(myGame).getX();
			y = PlayerController.getCurrentPlayer(myGame).getY() - 1.5f;
			break;
		case Player.DIRECTION_DOWN:
			x = PlayerController.getCurrentPlayer(myGame).getX();
			y = PlayerController.getCurrentPlayer(myGame).getY();
			break;
		}
		this.rectangle.x = x;
		this.rectangle.y = y;
		BulletLoader.updateBullets(myGame, mapHandler);
	}
	
	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (playerIsEquippedWithGun) {
			batch.draw(
					imageLoader.whiteSquare,
					x, 
					y,
					width,
					height
					);
			BulletLoader.renderBullets(batch, shapeRenderer, imageLoader);
		}
	}
}
