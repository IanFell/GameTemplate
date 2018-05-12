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
	public GameObject tree;
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	public void createObjects(MyGame myGame) {
		player = myGame.gameObjectFactory.getObject("player");
		tree   = myGame.gameObjectFactory.getObject("tree");
	}
}
