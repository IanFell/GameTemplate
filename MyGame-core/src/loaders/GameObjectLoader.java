package loaders;

import java.util.ArrayList;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;

/**
 * Creates game objects and initializes them.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameObjectLoader {

	public GameObject playerOne;
	public GameObject playerTwo;
	public GameObject playerThree;
	public GameObject chest;
	public GameWorld gameWorld;

	/**
	 * This holds all game objects, for the purpose of drawing order.
	 */
	public static ArrayList <GameObject> gameObjectList = new ArrayList<GameObject>();

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void createObjects(MyGame myGame) {
		playerOne   = myGame.gameObjectFactory.getObject("playerOne", 0, 0);
		playerTwo   = myGame.gameObjectFactory.getObject("playerTwo", 0, 0);
		playerThree = myGame.gameObjectFactory.getObject("playerThree", 0, 0);
		// GameWorld does not load tiles.
		gameWorld   = new GameWorld();
		chest       = myGame.gameObjectFactory.getObject("chest", 0, 0);
		addGameObjectsToGameObjectArrayList();
	}

	private void addGameObjectsToGameObjectArrayList() {
		gameObjectList.add(playerOne);
		gameObjectList.add(playerTwo);
		gameObjectList.add(playerThree);
		gameObjectList.add(chest);
	}
}
