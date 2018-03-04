package factories;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Enemy;
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
	 * @param string objectType
	 * @return mixed
	 */
	public GameObject getObject(String objectType) {
		if (objectType == null) {
			return null;
		}
		if (objectType.equalsIgnoreCase("player")) {
			return new Player();
		}
		if (objectType.equalsIgnoreCase("enemy")) {
			return new Enemy();
		}
		return null;
	}
}
