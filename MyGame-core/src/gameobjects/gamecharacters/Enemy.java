package gameobjects.gamecharacters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import handlers.AnimationHandler;
import handlers.CollisionHandler;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.Lighting.Fire;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Enemy extends GameCharacter {

	public int direction;

	private Rectangle attackBoundary;

	// How long fire animation plays after enemy has been killed.
	public final static int MAX_DEATH_ANIMATION_VALUE = 100;

	public final static int DAMAGE_INFLICTED = -1;

	private Fire fire;
	private boolean dead;
	private boolean willAttack;
	private float speed;
	private int stoppedValue = 0;
	
	public static boolean playDeathSound = false;

	/**
	 * Constructor.
	 * 
	 * @param float   x
	 * @param float   y
	 * @param int     width
	 * @param int     height
	 * @param int     direction
	 */
	public Enemy(float x, float y, int width, int height, int direction) {
		this.x           = x;
		this.y           = y;
		this.width       = width;
		this.height      = height;
		this.direction   = direction;
		dx               = stoppedValue;
		dy               = stoppedValue;
		speed            = 0.05f;
		rectangle.width  = width;
		rectangle.height = height;
		playSound        = false;
		dead             = false;
		// The height of the rectangle is to reflect attackBoundary if player is below enemy.
		attackBoundary = new Rectangle(x, y, 3, 4);

		// Enemy will either attack player, or get within attackBoundary and stop.
		willAttack = false;
		int randomAttackValue = RandomNumberGenerator.generateRandomInteger(2);
		if (randomAttackValue < 1) {
			willAttack = true;
		}
		fire = new Fire(0, 0, 0.5f, 1.5f, "Enemy", false);

		walkDownTexture          = new TextureAtlas(Gdx.files.internal("enemyDown.atlas"));
		walkUpTexture            = new TextureAtlas(Gdx.files.internal("enemyUp.atlas"));
		walkRightTexture         = new TextureAtlas(Gdx.files.internal("enemyRight.atlas"));
		walkLeftTexture          = new TextureAtlas(Gdx.files.internal("enemyLeft.atlas"));

		float animationSpeed     = 7/15f;
		walkDownAnimation        = new Animation <TextureRegion> (animationSpeed, walkDownTexture.getRegions());
		walkUpAnimation          = new Animation <TextureRegion> (animationSpeed, walkUpTexture.getRegions());
		walkRightAnimation       = new Animation <TextureRegion> (animationSpeed, walkRightTexture.getRegions());
		walkLeftAnimation        = new Animation <TextureRegion> (animationSpeed, walkLeftTexture.getRegions());
	}

	@Override
	public void moveRight(float speed) {
		setX(getX() + speed);
		setEnemyDirection(Enemy.DIRECTION_RIGHT);
		setDx(-getDx());
	}

	/**
	 * 
	 * @param float speed
	 */
	@Override
	public void moveLeft(float speed) {
		setX(getX() - speed);
		setEnemyDirection(Enemy.DIRECTION_LEFT);
		setDx(-getDx());
	}

	/**
	 * 
	 * @param float speed
	 */
	@Override
	public void moveDown(float speed) {
		setY(getY() + speed * 2);
		setEnemyDirection(Enemy.DIRECTION_DOWN);
		setDy(-getDy());
	}

	/**
	 * 
	 * @param float speed
	 */
	@Override
	public void moveUp(float speed) {
		setY(getY() - speed * 2);
		setEnemyDirection(Enemy.DIRECTION_UP);
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
	 * @return direction
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
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		elapsedTime += Gdx.graphics.getDeltaTime();
		int playerSize = 1;
		if (!dead) {
			//batch.draw(texture, x, y, width, -height);
			AnimationHandler.renderAnimation(batch, elapsedTime, getCurrentAnimation(), x, y, playerSize);
			// Uncomment to debug attackBoundary.
			//batch.draw(imageLoader.whiteSquare, attackBoundary.x, attackBoundary.y, attackBoundary.width, attackBoundary.height);
			// Uncomment to draw enemy hit box.
			//batch.draw(imageLoader.whiteSquare, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		} else {
			if (timer < MAX_DEATH_ANIMATION_VALUE) {
				fire.renderObject(batch, shapeRenderer, imageLoader);
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

		fire.updateObject(myGame, mapHandler);
		if (dead) {
			timer++;
			fire.setX(x);
			fire.setY(y);
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
		if (willAttack) {
			if (x < PlayerController.getCurrentPlayer(myGame).getX()) {
				dx = speed;
			} else if (x > PlayerController.getCurrentPlayer(myGame).getX()) {
				dx = -speed;
			}
			if (y < PlayerController.getCurrentPlayer(myGame).getY()) {
				dy = speed;
			} else if (y > PlayerController.getCurrentPlayer(myGame).getY()) {
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
				dx = stoppedValue;
				dy = speed;
				direction = DIRECTION_DOWN;
			} else {
				dx = stoppedValue;
				dy = -speed;
				direction = DIRECTION_UP;
			}
		} else {
			if (x < PlayerController.getCurrentPlayer(myGame).getX()) {
				dx = speed;
				dy = stoppedValue;
				direction = DIRECTION_RIGHT;
			} else {
				dx = -speed;
				dy = stoppedValue;
				direction = DIRECTION_LEFT;
			}
		}
	}
}
