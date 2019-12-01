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

	public static final int CANNONBALL_MAX_EXPLOSION_VALUE = 10;

	private int shootingTimer  = 0;

	public static int explosionTimer;

	private int size = 1;

	private Explosion explosion;
	
	private boolean cannonBallHasHitPlayer = false;
	
	private int direction;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 */
	public CannonBall(float x, float y, int direction) {
		super(x, y);
		dx               = 1;
		dy               = -0.5f;
		explosionTimer   = 0;
		this.width       = size;
		this.height      = size;
		rectangle.width  = width;
		rectangle.height = height;
		this.direction   = direction;
	}

	/**
	 * 
	 * @param boolean cannonBallHasHitPlayer
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
		// Ensure cannon ball shoots in the correct direction.
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
		handleExplosion(myGame, mapHandler);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	private void handleExplosion(MyGame myGame, MapHandler mapHandler) {
		if (dx <= 0) {
			if (explosion == null) {
				explosion = new Explosion(x - 0.5f, y + 2);
			} else {
				explosion.updateObject(myGame, mapHandler);
				explosionTimer++;
			}
		}
	}

	private void handleCannonBallPhysics() {
		if (dx > 0) {
			dx -= .04f;
			if (shootingTimer < 2) {
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
		if (explosion != null) {
			explosion.renderExplosion(batch, imageLoader);
		}
	}
}
