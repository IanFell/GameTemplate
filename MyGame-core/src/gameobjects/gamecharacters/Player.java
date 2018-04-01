package gameobjects.gamecharacters;

import com.badlogic.gdx.math.Circle;

import helpers.GamePlayHelper;

/**
 * Player object.
 * 
 * @author Fabulous Fellini
 *
 */
public class Player extends GameCharacter {
	
	/**
	 * Constructor.
	 */
	public Player() {
		this.x        = GamePlayHelper.setObjectXPositionInMiddleOfScreen(this);
		this.y        = GamePlayHelper.setObjectYPositionInMiddleOfScreen(this);
		this.radius   = characterSize;
		this.circle   = new Circle(x, y, radius);
		this.shapeRenderer.setColor(1, 1, 1, 1);
	}
	
	/**
	 * Available directions player can travel.  
	 * Because of the GameObjectFactory, these variables
	 * get set in the GameObject class rather than Player class.
	 */
	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_UP    = 2;
	public static final int DIRECTION_DOWN  = 3;
}
