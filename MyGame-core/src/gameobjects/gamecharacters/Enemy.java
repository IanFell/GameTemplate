package gameobjects.gamecharacters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.Lighting.Fire;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Enemy extends GameObject {
	
	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_UP    = 2;
	public static final int DIRECTION_DOWN  = 3;
	
	public int direction;
	
	private Rectangle attackBoundary;

	// How long fire animation plays after enemy has been killed.
	private final int MAX_DEATH_ANIMATION_VALUE = 100;

	private Texture texture;
	private int timer;
	private Fire fire;
	public static  boolean playSound;
	public  boolean dead;
	public  float enemySpeedX;
	public  float enemySpeedY;

	/**
	 * Constructor.
	 * 
	 * @param float   x
	 * @param float   y
	 * @param int     width
	 * @param int     height
	 * @param Texture texture
	 */
	public Enemy(float x, float y, int width, int height, Texture texture, int direction) {
		this.x           = x;
		this.y           = y;
		this.width       = width;
		this.height      = height;
		this.texture     = texture;
		rectangle.width  = width;
		rectangle.height = height;
		timer            = 0;
		fire             = new Fire(0, 0, width, height, null, false);
		playSound        = false;
		dead             = false;
		enemySpeedX       = 0.05f;
		enemySpeedY = 0;
		this.direction = direction;
		// The height of the rectangle is to reflect attackBoundary if player is below enemy.
		attackBoundary = new Rectangle(x, y, 3, 4);
	}
	
	public int getEnemyDirection() {
		return direction;
	}

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
		if (!dead) {
			batch.draw(texture, x, y, width, -height);
			//batch.draw(imageLoader.whiteSquare, attackBoundary.x, attackBoundary.y, attackBoundary.width, attackBoundary.height);
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
		rectangle.x = x;
		rectangle.y = y;
		attackBoundary.x = x - 1;
		attackBoundary.y = y - 2;
		
		// Make sure dead fire animation doesn't move around.
		if (!dead) {
			executeAI(myGame);
		}
		
		fire.updateObject(myGame, mapHandler);
		if (dead) {
			//if (timer < MAX_DEATH_ANIMATION_VALUE) {
				timer++;
			//}
			fire.setX(x);
			fire.setY(y);
		}
	}
	
	private void executeAI(MyGame myGame) {
		
		
		
		if (attackBoundary.overlaps(PlayerController.getCurrentPlayer(myGame).rectangle)) {
			attackPlayer(myGame);
		} else {
			pathFind(myGame);
			if (enemySpeedX == 0 && enemySpeedY == 0) {
				switch(direction) {
				case DIRECTION_LEFT:
					enemySpeedX = 0.05f;
					enemySpeedY = 0;
					direction = DIRECTION_RIGHT;
				break;
				case DIRECTION_RIGHT:
					enemySpeedX = -0.05f;
					enemySpeedY = 0;
					direction = DIRECTION_LEFT;
					break;
				case DIRECTION_UP:
					enemySpeedX = 0;
					enemySpeedY = 0.05f;
					direction = DIRECTION_DOWN;
					break;
				case DIRECTION_DOWN:
					enemySpeedX = 0;
					enemySpeedY = -0.05f;
					direction = DIRECTION_DOWN;
					break;
				}
			}
		}
	}
	
	private void attackPlayer(MyGame myGame) {
		float playerX = PlayerController.getCurrentPlayer(myGame).getX();
		float playerY = PlayerController.getCurrentPlayer(myGame).getY();
		//int attackBoundary = 1;
		
		
			
			enemySpeedX = 0;
			enemySpeedY = 0;
		
		/*
		if (playerX - x < attackBoundary //||
				//x - playerX < attackBoundary
				) {
			enemySpeedX = 0;
			enemySpeedY = 0;
		}*/
	}
	
	/**
	 * Collisions with tiles are located in the MapRenderer class.
	 */
	private void pathFind(MyGame myGame) {
		x += enemySpeedX;
		y += enemySpeedY;
		int changeDirection = RandomNumberGenerator.generateRandomInteger(100);
		if (changeDirection > 90) {
			changeDirection(myGame);
		}
	}
	
	private void changeDirection(MyGame myGame) {
		if (direction == DIRECTION_LEFT || direction == DIRECTION_RIGHT) {
			if (y < PlayerController.getCurrentPlayer(myGame).getY()) {
				enemySpeedX = 0;
				enemySpeedY = 0.05f;
				direction = DIRECTION_DOWN;
			} else {
				enemySpeedX = 0;
				enemySpeedY = -0.05f;
				direction = DIRECTION_UP;
			}
		} else {
			if (x < PlayerController.getCurrentPlayer(myGame).getX()) {
				enemySpeedX = 0.05f;
				enemySpeedY = 0;
				direction = DIRECTION_RIGHT;
			} else {
				enemySpeedX = -0.05f;
				enemySpeedY = 0;
				direction = DIRECTION_LEFT;
			}
		}
	}
}
