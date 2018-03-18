package gameobjects.gamecharacters;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import gameobjects.GameObject;

public class GameCharacter extends GameObject {
	
	/**
	 * Size of character.
	 */
	protected int characterSize = 16;
	
	/**
	 * Radius for our collision detection circle.
	 */
	protected int radius;
	
	/**
	 * ShapeRenderer to draw our characters's circle / hit box / display, etc.
	 */
	protected ShapeRenderer shapeRenderer = new ShapeRenderer();
	
	/**
	 * @param SpriteBatch batch
	 */
	@Override
	public void draw(SpriteBatch batch) {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.circle(x, y, radius);
		shapeRenderer.end();
	}

	/**
	 * Moves object to the left or right.
	 * 
	 * @param float distance
	 */
	@Override
	public void translateX(float distance) {
		x += distance;
	}
	
	/**
	 * Moves object up or down.
	 * 
	 * @param float distance
	 */
	@Override
	public void translateY(float distance) {
		y += distance;
	}
	
	@Override
	public void updateGameObject() {}
}
