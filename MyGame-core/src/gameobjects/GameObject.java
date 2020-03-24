package gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import interfaces.GameObjectInterface;
import inventory.Inventory;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * Class to hold and handle common elements for all game objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameObject extends Sprite implements GameObjectInterface, Comparable<GameObject> {

	/**
	 * Used to ensure the correct object is returned in getGameObject() method.
	 */
	public static final int PLAYER_ONE   = 1;
	public static final int PLAYER_TWO   = 2;
	public static final int PLAYER_THREE = 3;
	public static final int TREE         = 4;
	public static final int PLANT        = 5;
	public static final int CHEST_OPEN   = 6;
	public static final int CHEST_CLOSED = 7;

	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_UP    = 2;
	public static final int DIRECTION_DOWN  = 3;

	protected float x;
	protected float y;
	protected float width;
	protected float height;

	/**
	 * Animation variables.
	 */
	protected TextureAtlas textureAtlas;
	protected Animation <TextureRegion> animation;
	protected float elapsedTime = 0;

	/**
	 * Rectangle to deal with collisions.
	 */
	public Rectangle rectangle = new Rectangle();

	/**
	 * Direction game objects can travel in.
	 * If left arrow is pressed, we can think of this as 'direction = player.MovingLeftConstant'.
	 */
	public static int direction;

	protected boolean playSound;

	/**
	 * Game object x-axis speed value.
	 */
	public float dx;

	/**
	 * Game object y-axis speed value.
	 */
	public float dy;

	/**
	 * Used for Mission Legend of the Seven Swords.
	 */
	public boolean hasBeenCollected;

	public Inventory inventory;

	/**
	 * Constructor.
	 */
	public GameObject() {}

	public void updateElapsedTime() {
		elapsedTime += Gdx.graphics.getDeltaTime();
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void init(MyGame myGame) {}

	/**
	 * Move object along the X axis.
	 * 
	 * @param float distance
	 */
	public void translateX(float distance) {}

	/**
	 * Move object along the Y axis.
	 * 
	 * @param float distance
	 */
	public void translateY(float distance) {}

	/**
	 * 
	 * @return int
	 */
	public static int getDirection() {
		return direction;
	}

	/**
	 * 
	 * @param int direction
	 */
	public void setDirection(int direction) {
		GameObject.direction = direction;
	}

	/**
	 * 
	 * @return Inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateObject(MyGame myGame, MapHandler mapHandler) {}

	/**
	 * Stops object from moving on screen, mostly from collisions with hard game objects.
	 * 
	 * @param int direction
	 */
	public void stopScrolling(int direction) {}

	/**
	 * 
	 * @return float
	 */
	public float getX() {
		return x;
	}

	/**
	 * 
	 * @param float x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * 
	 * @return float
	 */
	public float getY() {
		return y;
	}

	/**
	 * 
	 * @param float y
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * 
	 * @return float
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * 
	 * @param float width
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * 
	 * @return float
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * 
	 * @param float height
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * 
	 * @return float
	 */
	public float getDx() {
		return dx;
	}

	/**
	 * 
	 * @param float dx
	 */
	public void setDx(float dx) {
		this.dx = dx;
	}

	/**
	 * 
	 * @return float
	 */
	public float getDy() {
		return dy;
	}

	/**
	 * 
	 * @param float dy
	 */
	public void setDy(float dy) {
		this.dy = dy;
	}

	/**
	 * Compares y values with this instance and some other object in gameObject array
	 * in order to determine rendering order (to simulate depth of objects).
	 * 
	 * @param GameObject gameObject
	 */
	@Override
	public int compareTo(GameObject gameObject) {
		return Float.compare(getY(), gameObject.getY());
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean getPlaySound() {
		return playSound;
	}

	/**
	 * 
	 * @param boolean playSound
	 */
	public void setPlaySound(boolean playSound) {
		this.playSound = playSound;
	}

	/**
	 * 
	 * @param boolean isClosed
	 */
	public void setClosed(boolean isClosed) {}

	/**
	 * 
	 * @return int
	 */
	public float getHealth() {
		return 0;
	}

	/**
	 * 
	 * @param float health
	 */
	public void setHealth(float health) {}

	public String convertPlayerLootToString() {
		return null;
	}

	public String convertPlayerRumToString() {
		return null;
	}

	/**
	 * 
	 * @param boolean bounceBackValue
	 */
	public void setBounceBack(boolean bounceBackValue) {}

	/**
	 * 
	 * @return int
	 */
	public int getPlayerLoot() {
		return 0;
	}

	/**
	 * 
	 * @param int loot
	 */
	public void updatePlayerLoot(int loot) {}

	/**
	 * 
	 * @param boolean hasBeenCollected
	 */
	public void setHasBeenCollected(boolean hasBeenCollected) {
		this.hasBeenCollected = hasBeenCollected;
	}

	/**
	 * This method makes collectibles grow after they are collected.
	 * Some collectibles include:
	 *     - hearts
	 *     - rum
	 */
	protected void grow() {
		int doubleGrowth = 2;
		float growValue  = 0.2f;
		x -= growValue;
		y -= growValue;
		width  += growValue * doubleGrowth;
		height += growValue * doubleGrowth;
	}
}
