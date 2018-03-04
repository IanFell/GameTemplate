package loaders;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;

/**
 * Creates are game objects and initializes them.
 * 
 * @author Fabulous Felini
 *
 */
public class GameObjectLoader {
	
	/**
	 * Our player object.
	 */
	public GameObject player;
	
	/**
	 * Our enemy object.
	 */
	public GameObject enemy;
	
	/**
	 * Creates our game objects.
	 * 
	 * @param MyGame myGame
	 */
	public void createObjects(MyGame myGame) {
		player = myGame.gameObjectFactory.getObject("player");
		enemy  = myGame.gameObjectFactory.getObject("enemy");
	}
	
	/**
	 * Initializes our game objects.
	 * 
	 * @param ImageLoader imageLoader
	 */
	public void init(ImageLoader imageLoader) {
		player.init(imageLoader);
		enemy.init(imageLoader);
	}
}
