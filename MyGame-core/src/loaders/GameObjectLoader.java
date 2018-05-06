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
	
	public GameObject player;
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	public void createObjects(MyGame myGame) {
		player = myGame.gameObjectFactory.getObject("player");
	}
	
	/**
	 *
	 * @param ImageLoader imageLoader
	 */
	public void init(ImageLoader imageLoader) {
		player.init(imageLoader);
	}
}
