package physics.Lighting;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Fire extends GameObject {

	private int timer = 0;

	private String location;

	private boolean hasLogs;

	public Fire(float x, float y, int width, int height, String location, boolean hasLogs) {
		this.x                = x;
		this.y                = y;
		this.width            = width;
		this.height           = height;
		this.location         = location;
		this.hasLogs          = hasLogs;
		this.rectangle.x      = x;
		this.rectangle.y      = y;
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
		timer++;
		if (timer > 20) {
			timer = 1;
		}
		/*
		CollisionHandler.checkIfPlayerHasCollidedWithFire(
				myGame.getGameObject(GameObject.PLAYER_ONE),
				this
				);*/
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (timer > 0) {
			batch.draw(imageLoader.fireOne, x, y, width, -height);
		}
		if (timer > 2) {
			batch.draw(imageLoader.fireTwo, x, y, width, -height);
		}
		if (timer > 4) {
			batch.draw(imageLoader.fireThree, x, y, width, -height);
		}
		if (timer > 6) {
			batch.draw(imageLoader.fireFour, x, y, width, -height);
		}
		if (timer > 8) {
			batch.draw(imageLoader.fireFive, x, y, width, -height);
		}
		if (timer > 10) {
			batch.draw(imageLoader.fireSix, x, y, width, -height);
		}
		if (timer > 12) {
			batch.draw(imageLoader.fireSeven, x, y, width, -height);
		}
		if (timer > 14) {
			batch.draw(imageLoader.fireEight, x, y, width, -height);
		}
		if (timer > 16) {
			batch.draw(imageLoader.fireNine, x, y, width, -height);
		}
		if (timer > 18) {
			batch.draw(imageLoader.fireTen, x, y, width, -height);
		}
		if (hasLogs) {
			batch.draw(imageLoader.logs, x, y, width, -height);
		}
	}
}
