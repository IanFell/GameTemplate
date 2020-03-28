package gameobjects.gamecharacters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import handlers.AnimationHandler;
import handlers.CollisionHandler;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.Lighting.Explosion;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Enemy extends GameCharacter {

	public int direction;

	private Rectangle attackBoundary;

	/**
	 * How long explosion animation plays after enemy has been killed.
	 * This is so it wont loop.
	 */
	public final static int MAX_DEATH_ANIMATION_VALUE = 8;

	public final static int DAMAGE_INFLICTED = -1;

	protected Explosion explosion;
	protected boolean dead;
	private boolean willAttack;
	private float speed;
	private int stoppedValue = 0;

	public static boolean playDeathSound = false;

	// Death explosion variable.
	protected boolean explosionShouldBeCreated;
	
	private final int ENEMY_EXPLOSION_SIZE = 2;

	/**
	 * Constructor.
	 * 
	 * @param float   x
	 * @param float   y
	 * @param float   width
	 * @param float   height
	 * @param int     direction
	 */
	public Enemy(float x, float y, float width, float height, int direction) {
		this.x                   = x;
		this.y                   = y;
		this.width               = width;
		this.height              = height;
		this.direction           = direction;
		dx                       = stoppedValue;
		dy                       = stoppedValue;
		speed                    = 0.05f;
		rectangle.width          = width;
		rectangle.height         = height;
		playSound                = false;
		dead                     = false;
		explosionShouldBeCreated = true;
		// The height of the rectangle is to reflect attackBoundary if player is below enemy.
		attackBoundary           = new Rectangle(x, y, 3, 4);

		// Enemy will either attack player, or get within attackBoundary and stop.
		willAttack = false;
		int randomAttackValue = RandomNumberGenerator.generateRandomInteger(2);
		if (randomAttackValue < 1) {
			willAttack = true;
		}

		walkDownTexture  = new TextureAtlas(Gdx.files.internal("artwork/gamecharacters/enemy/enemyDown.atlas"));
		walkUpTexture    = new TextureAtlas(Gdx.files.internal("artwork/gamecharacters/enemy/enemyUp.atlas"));
		walkRightTexture = new TextureAtlas(Gdx.files.internal("artwork/gamecharacters/enemy/enemyRight.atlas"));
		walkLeftTexture  = new TextureAtlas(Gdx.files.internal("artwork/gamecharacters/enemy/enemyLeft.atlas"));

		walkDownAnimation    = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_ENEMY, walkDownTexture.getRegions());
		walkUpAnimation      = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_ENEMY, walkUpTexture.getRegions());
		walkRightAnimation   = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_ENEMY, walkRightTexture.getRegions());
		walkLeftAnimation    = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_ENEMY, walkLeftTexture.getRegions());
	}

	/**
	 * 
	 * @param float speed
	 */
	@Override
	public void moveRight(float speed) {
		setX(getX() + speed);
		setEnemyDirection(DIRECTION_RIGHT);
		setDx(-getDx());
	}

	/**
	 * 
	 * @param float speed
	 */
	@Override
	public void moveLeft(float speed) {
		setX(getX() - speed);
		setEnemyDirection(DIRECTION_LEFT);
		setDx(-getDx());
	}

	/**
	 * 
	 * @param float speed
	 */
	@Override
	public void moveDown(float speed) {
		setY(getY() + speed * 2);
		setEnemyDirection(DIRECTION_DOWN);
		setDy(-getDy());
	}

	/**
	 * 
	 * @param float speed
	 */
	@Override
	public void moveUp(float speed) {
		setY(getY() - speed * 2);
		setEnemyDirection(DIRECTION_UP);
		setDy(-getDy());
	}

	/**
	 * 
	 * @return int
	 */
	public int getTimer() {
		return timer;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isDead() {
		return dead;
	}

	/**
	 * 
	 * @param boolean dead
	 */
	public void setIsDead(boolean dead) {
		this.dead = dead;
	}

	/**
	 * Don't use GameObject.getDirection() because it is associated with the Player direction.  
	 * Currently this is working, so don't change it.
	 * 
	 * @return int
	 */
	public int getEnemyDirection() {
		return direction;
	}

	/**
	 * Don't use GameObject.getDirection() because it is associated with the Player direction.  
	 * Currently this is working, so don't change it.
	 * 
	 * @param int direction
	 */
	public void setEnemyDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param float       width
	 * @param float       height
	 * @param float       shadowY
	 */
	protected void renderEnemyShadow(SpriteBatch batch, ImageLoader imageLoader, float width, float height, float shadowY) {
		batch.draw(imageLoader.shadow, x, shadowY, width, height);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		updateElapsedTime();
		if (!dead) {
			renderEnemyShadow(batch, imageLoader, width, height / 2, y - 0.25f);
			AnimationHandler.renderAnimation(
					batch, 
					elapsedTime, 
					getCurrentAnimation(), 
					x, 
					y, 
					width,
					height,
					imageLoader, 
					AnimationHandler.OBJECT_TYPE_ENEMY
					);
			// Uncomment to debug attackBoundary.
			//batch.draw(imageLoader.whiteSquare, attackBoundary.x, attackBoundary.y, attackBoundary.width, attackBoundary.height);
			// Uncomment to draw enemy hit box.
			//batch.draw(imageLoader.whiteSquare, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		} else {
			if (explosion != null) {
				if (timer < MAX_DEATH_ANIMATION_VALUE) {
					explosion.renderExplosion(batch, imageLoader);
				}
			}
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		rectangle.x      = x;
		rectangle.y      = y - height;
		// attackBoundary is a few pixels around enemy.
		attackBoundary.x = x - 1;
		attackBoundary.y = y - 2;

		// Make sure dead fire animation doesn't move around.
		if (!dead) {
			executeAI(myGame);
		}

		CollisionHandler.checkIfEnemyHasCollidedWithPlayer(this, (Player) PlayerController.getCurrentPlayer(myGame));

		handleDeathExplosion(ENEMY_EXPLOSION_SIZE);
	}

	/**
	 * If enemy is dead, create explosion and start explosion timer.
	 * 
	 * @param int explosionSize
	 */
	protected void handleDeathExplosion(int explosionSize) {
		if (dead) {
			timer++;
			if (explosionShouldBeCreated) {
				explosion                = new Explosion(x, y, explosionSize);
				explosionShouldBeCreated = false;
			}
		}
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	private void executeAI(MyGame myGame) {
		pathFind(myGame);
		if (attackBoundary.overlaps(PlayerController.getCurrentPlayer(myGame).rectangle)) {
			if (willAttack) {
				attackPlayer(myGame);
			} else {
				dx = stoppedValue;
				dy = stoppedValue;
			}
		}
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	private void attackPlayer(MyGame myGame) {
		float playerX = PlayerController.getCurrentPlayer(myGame).getX();
		float playerY = PlayerController.getCurrentPlayer(myGame).getY();
		if (willAttack) {
			if (x < playerX) {
				dx = speed;
			} else if (x > playerX) {
				dx = -speed;
			}
			if (y < playerY) {
				dy = speed;
			} else if (y > playerY) {
				dy = -speed;
			}
		}
	}

	/**
	 * This method just deals with direction.
	 * Collisions with tiles are located in the MapRenderer class.
	 * 
	 * @param MyGame myGame
	 */
	private void pathFind(MyGame myGame) {
		x += dx;
		y += dy;
		int changeDirection = RandomNumberGenerator.generateRandomInteger(100);
		if (changeDirection > 90) {
			changeDirection(myGame);
		}
	}

	/**
	 * This behaves differently than the moveUp(), moveDown(), moveLeft(), and moveRight() methods.
	 * Do not use those methods to move enemy within this method.
	 * 
	 * @param MyGame myGame
	 */
	private void changeDirection(MyGame myGame) {
		if (direction == DIRECTION_LEFT || direction == DIRECTION_RIGHT) {
			if (y < PlayerController.getCurrentPlayer(myGame).getY()) {
				dx        = stoppedValue;
				dy        = speed;
				direction = DIRECTION_DOWN;
			} else {
				dx        = stoppedValue;
				dy        = -speed;
				direction = DIRECTION_UP;
			}
		} else {
			if (x < PlayerController.getCurrentPlayer(myGame).getX()) {
				dx        = speed;
				dy        = stoppedValue;
				direction = DIRECTION_RIGHT;
			} else {
				dx        = -speed;
				dy        = stoppedValue;
				direction = DIRECTION_LEFT;
			}
		}
	}
}
