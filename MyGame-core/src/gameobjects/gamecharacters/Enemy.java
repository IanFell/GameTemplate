package gameobjects.gamecharacters;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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
		this.x      = GamePlayHelper.setObjectXPositionInMiddleOfScreen(this) + 200;
		this.y      = GamePlayHelper.setObjectYPositionInMiddleOfScreen(this) + 100;
		this.radius = characterSize;
		this.circle = new Circle(x, y, radius);
	}
	
	/**
	 * @param ShapeRenderer shapeRenderer
	 */
	@Override
	public void draw(ShapeRenderer shapeRenderer) {
		shapeRenderer.setColor(0, 0, 1, 1);
		shapeRenderer.circle(x, y, radius);
	}
	
	@Override
	public void updateGameObject() {
		circle.x = x;
		circle.y = y;
	}
}
