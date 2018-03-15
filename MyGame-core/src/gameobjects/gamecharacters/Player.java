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
}
