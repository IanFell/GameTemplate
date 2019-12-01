package gameobjects.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Player;
import handlers.CollisionHandler;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.Lighting.Explosion;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class CannonBall extends Weapon {

	public static final int MAX_EXPLOSION_VALUE = 10;

	/**
	 * Cannon ball shoots upwards, and shootingTimer starts.
	 * When shootingTimer hits this value, cannon ball begins to fall.
	 */
	private final int MAX_VALUE_BEFORE_FALL = 2;

	private int shootingTimer = 0;

	public static int explosionLandTimer;
	public static int explosionBlastTimer;

	private int size = 1;

	private Explosion explosionLand;
	private Explosion explosionBlast;

	private boolean cannonBallHasHitPlayer = false;

	private int direction;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 * @param int   direction
	 */
	public CannonBall(float x, float y, int direction) {
		super(x, y);
		dx                  = 1;
		dy                  = -0.5f;
		explosionLandTimer  = 0;
		explosionBlastTimer = 0;
		this.width          = size;
		this.height         = size;
		rectangle.width     = width;
		rectangle.height    = height;
		this.direction      = direction;
	}

	/**
	 * 
	 * @param boolean 
	 */
	public void setCannonBallHasHitPlayer(boolean cannonBallHasHitPlayer) {
		this.cannonBallHasHitPlayer = cannonBallHasHitPlayer;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isCannonBallHasHitPlayer() {
		return cannonBallHasHitPlayer;
	}

	/**
	 * 
	 * @param MyGame     myGamet
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);

		// Ensure cannon ball shoots in the correct direction.  It will always shoot left or right.
		if (direction == Cannon.DIRECTION_LEFT) {
			x -= dx;
		} else {
			x += dx;
		}

		y += dy;
		rectangle.x = x;
		rectangle.y = y;
		shootingTimer++;
		handleCannonBallPhysics();
		CollisionHandler.checkIfCannonBallHasCollidedWithPlayer(
				(Player) myGame.getGameObject(Player.PLAYER_ONE), 
				this
				);

		// When cannon ball blasts out of the cannon.
		handleExplosionBlast(myGame, mapHandler);

		// When cannon ball lands on the ground.
		handleExplosionLand(myGame, mapHandler);
	}

	/**
	 * Handles the blast of the cannon ball out of the cannon.
	 * This blast can either happen on the right or left, depending on the direction of the associated cannon.
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	private void handleExplosionBlast(MyGame myGame, MapHandler mapHandler) {
		if (explosionBlast == null) {
			if (direction == Cannon.DIRECTION_RIGHT) {
				explosionBlast = new Explosion(x + width / 2, y + height / 2);
			} else {
				explosionBlast = new Explosion(x + width / 2 - 2, y + height / 2);
			}
		} else {
			explosionBlast.updateObject(myGame, mapHandler);
			explosionBlastTimer++;
		}
	}

	/**
	 * Handles the blast of the landing of the cannon ball on the ground.
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	private void handleExplosionLand(MyGame myGame, MapHandler mapHandler) {
		if (dx <= 0) {
			if (explosionLand == null) {
				explosionLand = new Explosion(x - 0.5f, y + 2);
			} else {
				explosionLand.updateObject(myGame, mapHandler);
				explosionLandTimer++;
			}
		}
	}

	/**
	 * These values can change depending on how we want the cannon ball to behave.
	 */
	private void handleCannonBallPhysics() {
		if (dx > 0) {
			dx -= .04f;
			if (shootingTimer < MAX_VALUE_BEFORE_FALL) {
				dy -= .01f;
			} else {
				dy += .04f;
			}
		} else {
			dx = 0;
			dy = 0;
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.cannonBall,
				x, 
				y,
				size,
				size
				);
		if (explosionLand != null) {
			explosionLand.renderExplosion(batch, imageLoader);
		}
		if (explosionBlast != null && explosionBlastTimer < MAX_EXPLOSION_VALUE) {
			explosionBlast.renderExplosion(batch, imageLoader);
		}
	}
}
