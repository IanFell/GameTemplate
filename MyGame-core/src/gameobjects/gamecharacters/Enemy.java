package gameobjects.gamecharacters;

import com.badlogic.gdx.math.Circle;

import helpers.GamePlayHelper;

/**
 * Enemy object.
 * 
 * @author Fabulous Fellini
 *
 */
public class Enemy extends GameCharacter {
	
	/**
	 * Constructor.
	 */
	public Enemy() {
		this.x        = GamePlayHelper.setObjectXPositionInMiddleOfScreen(this) + 200;
		this.y        = GamePlayHelper.setObjectYPositionInMiddleOfScreen(this) + 100;
		this.radius   = characterSize;
		this.circle   = new Circle(x, y, radius);
		this.shapeRenderer.setColor(0, 0, 1, 1);
	}
}
