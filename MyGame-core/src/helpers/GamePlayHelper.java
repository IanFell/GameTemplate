package helpers;

import java.util.ArrayList;
import java.util.Collections;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.GameObject;
import loaders.ImageLoader;
import screens.GameScreen;

/**
 * Contains methods to help with game play.
 * 
 * @author Fabulous Fellini
 *
 */
public class GamePlayHelper  {

	private final static float SCREEN_BOUND_OFFSET = 21.0f;

	/**
	 * 
	 * @param GameObject gameObject
	 * @return int
	 */
	public static float setObjectXPositionInMiddleOfScreen(GameObject gameObject) {
		return (GameAttributeHelper.SCREEN_WIDTH / 2) - (gameObject.getWidth() / 2);
	}

	/**
	 * 
	 * @param GameObject gameObject
	 * @return int
	 */
	public static float setObjectYPositionInMiddleOfScreen(GameObject gameObject) {
		return (GameAttributeHelper.SCREEN_HEIGHT / 2) - (gameObject.getHeight() / 2);	
	}

	/**
	 * Render objects based on their y-axis sort order to simulate depth.
	 * 
	 * @param ArrayList     gameObjectList
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	public static void sortAndRenderObjectsInYPositionOrder(
			ArrayList<GameObject> gameObjectList,
			SpriteBatch batch,
			ImageLoader imageLoader
			) {
		Collections.sort(gameObjectList);
		for (int i = 0; i < gameObjectList.size(); i++) {
			if (gameObjectIsWithinScreenBounds(gameObjectList.get(i))) {
				gameObjectList.get(i).renderObject(batch, imageLoader);
			}
		}
	}

	/**
	 * Determines if game object is rendering bounds.
	 * 
	 * @param GameObject gameObject
	 * @return boolean
	 */
	public static boolean gameObjectIsWithinScreenBounds(GameObject gameObject) {
		float cameraXPosition   = GameScreen.camera.position.x;
		float cameraYPosition   = GameScreen.camera.position.y;
		float playerXPosition   = gameObject.getX();
		float playerYPosition   = gameObject.getY();
		if (
				playerXPosition < cameraXPosition + SCREEN_BOUND_OFFSET &&
				playerXPosition > cameraXPosition - SCREEN_BOUND_OFFSET &&
				playerYPosition < cameraYPosition + SCREEN_BOUND_OFFSET &&
				playerYPosition > cameraYPosition - SCREEN_BOUND_OFFSET
				) {
			return true;
		}
		return false;
	}
}
