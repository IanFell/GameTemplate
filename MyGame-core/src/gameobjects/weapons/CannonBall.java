package gameobjects.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Player;
import handlers.CollisionHandler;
import loaders.ImageLoader;
import maps.MapHandler;
import missions.MissionRawBar;
import physics.Lighting.Explosion;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class CannonBall extends Weapon {

	/**
	 * These variables are used to check when to play SFX when cannon ball lands and explodes.
	 * If the player is within this boundary, they will hear the SFX.
	 */
	private Rectangle attackBoundary;
	private int attackBoundarySize = 20;

	public static final int MAX_EXPLOSION_VALUE = 20;

	private final int CANNON_BALL_EXPLOSION_SIZE = 1;

	/**
	 * Cannon ball shoots upwards, and shootingTimer starts.
	 * When shootingTimer hits this value, cannon ball begins to fall.
	 */
	private final int MAX_VALUE_BEFORE_FALL = 2;

	private int shootingTimer = 0;

	public static int explosionLandTimer;
	public static int explosionBlastTimer;

	private float shadowX;
	private float shadowY;

	private int size = 1;

	private Explosion explosionLand;
	private Explosion explosionBlast;

	private boolean cannonBallHasHitPlayer = false;

	private int direction;

	private boolean playLandSound;

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
		shadowX             = x;
		shadowY             = y - 1;
		playLandSound       = false;
		attackBoundary      = new Rectangle(x, y, attackBoundarySize, attackBoundarySize);
	}

	/**
	 * 
	 * @return boolen
	 */
	public boolean isPlayLandSound() {
		return playLandSound;
	}

	/**
	 * 
	 * @param boolean playLandSound
	 */
	public void setPlayLandSound(boolean playLandSound) {
		this.playLandSound = playLandSound;
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

	public Rectangle getAttackBoundary() {
		return attackBoundary;
	}

	/**
	 * 
	 * @param MyGame     myGamet
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);

		attackBoundary.x = x - attackBoundarySize / 2;
		attackBoundary.y = y - attackBoundarySize / 2;

		// Ensure cannon ball shoots in the correct direction.  It will always shoot left or right.
		if (direction == DIRECTION_LEFT) {
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

		/**
		 * Update shadow to only follow the x-axis, because cannon balls are only shot horizontally.
		 * Cannon balls shoot up and fall down, so keeping the shadow on the same x-axis looks real.
		 */
		shadowX = x;
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
			if (direction == DIRECTION_RIGHT) {
				explosionBlast = new Explosion(x + width / 2, y + height / 2, CANNON_BALL_EXPLOSION_SIZE);
			} else {
				explosionBlast = new Explosion(x + width / 2 - 2, y + height / 2, CANNON_BALL_EXPLOSION_SIZE);
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
				explosionLand = new Explosion(x - 0.5f, y + 2, CANNON_BALL_EXPLOSION_SIZE);
				playLandSound = true;
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
		// Don't execute this is we are in the raw bar mission.
		if (!MissionRawBar.missionIsActive) {
			if (explosionLand == null) {
				batch.draw(
						imageLoader.shadow,
						shadowX, 
						shadowY,
						size,
						size
						);
				batch.draw(
						imageLoader.cannonBall,
						x, 
						y,
						size,
						size
						);
				//renderAttackBoundary(batch, imageLoader);
			}
			if (explosionLand != null) {
				explosionLand.renderExplosion(batch, imageLoader);
			}
			if (explosionBlast != null && explosionBlastTimer < MAX_EXPLOSION_VALUE) {
				explosionBlast.renderExplosion(batch, imageLoader);
			}
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	private void renderAttackBoundary(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.whiteSquare,
				attackBoundary.x, 
				attackBoundary.y,
				attackBoundary.width,
				attackBoundary.height
				);
	}
}
