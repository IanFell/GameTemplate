package physics;

import gameobjects.GameObject;

/**
 * Class to handle collisions between game objects.
 * 
 * @author Fabulous Fellini
 *
 */
public class CollisionHandler {
	
	/**
	 * Check collision between two given game objects.
	 * 
	 * @param GameObject gameObjectOne
	 * @param GameObject gameObjectTwo
	 * @return boolean
	 */
	public static boolean twoGameObjectsHaveCollided(GameObject gameObjectOne, GameObject gameObjectTwo) {
		if (gameObjectOne.getCircle().overlaps(gameObjectTwo.getCircle())) {
			return true;
		}
		return false;
	}
}
