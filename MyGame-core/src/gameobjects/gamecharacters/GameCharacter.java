package gameobjects.gamecharacters;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import maps.MapEditor;

/**
 * Parent class for game characters.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameCharacter extends GameObject {
	
	/**
	 * Size of character.
	 */
	protected int characterSize = 1;
	
	/**
	 * Radius for our collision detection circle.
	 */
	protected int radius;

	/**
	 * Moves object along the x axis.
	 * 
	 * @param float distance
	 */
	@Override
	public void translateX(float distance) {
		x += distance;
	}
	
	/**
	 * Moves object along the y axis.
	 * 
	 * @param float distance
	 */
	@Override
	public void translateY(float distance) {
		y += distance;
	}
	
	/**
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	@Override
	public void updateObject(MyGame myGame, MapEditor mapEditor) {}
}
