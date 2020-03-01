package gameobjects.gamecharacters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import handlers.CollisionHandler;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * This is the guy shooting the cannons.
 * 
 * @author Fabulous Fellini
 *
 */
public class Knight extends Enemy {

	private final int RESPAWN_MAX_TIMER_VALUE = 100;

	private int respawnTimer = 0;

	public boolean soundHasBeenPlayed;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 * @param float width
	 * @param float height
	 * @param int   direction
	 */
	public Knight(float x, float y, float width, float height, int direction) {
		super(x, y, width, height, direction);
		rectangle.x        = x;
		rectangle.y        = y;
		rectangle.width    = width;
		rectangle.height   = height;
		soundHasBeenPlayed = false;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		if (dead) {
			respawnTimer++;
			if (!soundHasBeenPlayed) {
				playSound          = true;
				soundHasBeenPlayed = true;
			}
			if (respawnTimer > RESPAWN_MAX_TIMER_VALUE) {
				dead               = false;
				respawnTimer       = 0;
				soundHasBeenPlayed = false;
			}
		} else {
			CollisionHandler.checkIfEnemyHasCollidedWithPlayer(this, (Player) myGame.getGameObject(Player.PLAYER_ONE));
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		if (direction == DIRECTION_LEFT) {
			batch.draw(
					imageLoader.knightLeft, 
					x, 
					y, 
					width, 
					-height
					);
		} else {
			batch.draw(
					imageLoader.knightRight, 
					x, 
					y, 
					width, 
					-height
					);
		}
	}
}
