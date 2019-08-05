package gameobjects.stationarygameobjects;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import maps.MapHandler;

/**
 * GamePlayObjects represent objects that will interact with the player,
 * such as a chest or a key.
 * 
 * @author Fabulous Fellini
 *
 */
public class GamePlayObject extends GameObject {

	protected int objectSize = 1;

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public GamePlayObject(int x, int y) {
		this.x                  = x;
		this.y                  = y;
		this.width              = objectSize;
		this.height             = objectSize;
		this.rectangle.x        = x;
		this.rectangle.y        = y;
		this.rectangle.width    = objectSize;
		this.rectangle.height   = objectSize;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		rectangle.x = x;
		// Compensate for having to flip the texture on the y-axis.
		rectangle.y = y - height;
	}
}
