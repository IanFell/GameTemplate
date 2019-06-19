package controllers;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.GameObjectLoader;

/**
 * Determines current player.
 * 
 * @author Fabulous Fellini
 *
 */
public class PlayerController {

	/**
	 * Returns player the user is currently controlling.
	 * 
	 * @param MyGame myGame
	 * @return GameObject
	 */
	public static GameObject getCurrentPlayer(MyGame myGame) {
		if (GameObjectLoader.gameObjectList.contains(myGame.getGameObject(GameObject.PLAYER_ONE))) {
			return myGame.getGameObject(GameObject.PLAYER_ONE);
		} else if (
				!GameObjectLoader.gameObjectList.contains(myGame.getGameObject(GameObject.PLAYER_ONE)) &&
				GameObjectLoader.gameObjectList.contains(myGame.getGameObject(GameObject.PLAYER_TWO))
				) {
			return myGame.getGameObject(GameObject.PLAYER_TWO);
		} 
		return myGame.getGameObject(GameObject.PLAYER_THREE);
	}
}
