package loaders;

import java.util.ArrayList;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.plantloaders.PlantLoader;
import loaders.treeloaders.TreeLoader;

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
	public TreeLoader treeLoader;
	public PlantLoader plantLoader;

	/**
	 * This holds all game objects, for the purpose of drawing order.
	 */
	public static ArrayList <GameObject> gameObjectList = new ArrayList<GameObject>();

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void createObjects(MyGame myGame) {
		playerOne   = myGame.gameObjectFactory.getObject("player", 0, 0);
		playerTwo   = myGame.gameObjectFactory.getObject("player", 0, 0);
		playerThree = myGame.gameObjectFactory.getObject("player", 0, 0);
		treeLoader  = new TreeLoader();
		plantLoader = new PlantLoader();
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
