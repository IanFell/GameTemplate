package loaders;

import java.util.ArrayList;

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

	/**
	 * 
	 * @param ArrayList <GameObject> object
	 */
	protected void addGameObjectsToGameObjectArrayList(ArrayList <GameObject> object) {
		for (int i = 0; i < object.size(); i++) {
			GameObjectLoader.gameObjectList.add((GameObject) object.get(i));
		}
	}
}
