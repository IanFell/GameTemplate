package loaders;

import gameobjects.GameObject;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class ClassObjectLoader {
	
	/**
	 * 
	 * @param GameObject[] object
	 */
	protected void addGameObjectsToGameObjectArrayList(GameObject[] object) {
		for (int i = 0; i < object.length; i++) {
			GameObjectLoader.gameObjectList.add(object[i]);
		}
	}
}
