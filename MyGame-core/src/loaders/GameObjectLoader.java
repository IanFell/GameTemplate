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

	public GameObject playerOne;
	public GameObject playerTwo;
	public GameObject playerThree;
	public GameObject tree;

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void createObjects(MyGame myGame) {
		playerOne   = myGame.gameObjectFactory.getObject("player");
		playerTwo   = myGame.gameObjectFactory.getObject("player");
		playerThree = myGame.gameObjectFactory.getObject("player");
		tree        = myGame.gameObjectFactory.getObject("tree");
	}
}
