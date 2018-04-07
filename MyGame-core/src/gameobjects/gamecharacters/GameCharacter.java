package gameobjects.gamecharacters;

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
	 * Moves object along the X axis.
	 * 
	 * @param float distance
	 */
	@Override
	public void translateX(float distance) {
		x += distance;
	}
	
	/**
	 * Moves object along the Y axis.
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
