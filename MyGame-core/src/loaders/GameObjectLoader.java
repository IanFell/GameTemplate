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
	 * Creates our game objects.
	 * 
	 * @param MyGame myGame
	 */
	public void createObjects(MyGame myGame) {
		player = myGame.gameObjectFactory.getObject("player");
	}
	
	/**
	 * Initializes our game objects.
	 * 
	 * @param ImageLoader imageLoader
	 */
	public void init(ImageLoader imageLoader) {
		player.init(imageLoader);
	}
}
