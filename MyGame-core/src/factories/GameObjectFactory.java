package factories;

import gameobjects.GameObject;
import gameobjects.StationaryGameObjects.GamePlayObject;
import gameobjects.StationaryGameObjects.NatureObject;
import gameobjects.gamecharacters.Player;

/**
 * Factory to create our game objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameObjectFactory {

	/**
	 * Creates our game objects.
	 * 
	 * @param string  objectType
	 * @return GameObject
	 */
	public GameObject getObject(String objectType, int x, int y) {
		if (objectType == null) {
			return null;
		}
		if (objectType.equalsIgnoreCase("player")) {
			return new Player();
		}
		if (objectType.equalsIgnoreCase("tree")) {
			return new NatureObject(x, y);
		}
		if (objectType.equalsIgnoreCase("chest")) {
			return new GamePlayObject();
		}
		return null;
	}
}
