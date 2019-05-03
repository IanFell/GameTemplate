package gameobjects.gamecharacters;

import gameobjects.GameObject;

/**
 * This is the parent of:
 * 	- Players
 * 	- Enemies
 * 
 * @author Fabulous Fellini
 *
 */
public class GameCharacter extends GameObject {

	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_UP    = 2;
	public static final int DIRECTION_DOWN  = 3;

	// Generic timer used for various tasks depending on class.
	protected int timer = 0;

	public void moveRight(float speed) {}
	public void moveLeft(float speed) {}
	public void moveUp(float speed) {}
	public void moveDown(float speed) {}
}
