package helpers;

import java.util.ArrayList;
import java.util.Collections;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * Contains methods to help with game play.
 * Currently this class is unused but I don't want to get rid of it just yet, just in case.
 * 
 * @author Fabulous Fellini
 *
 */
public class GamePlayHelper  {

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
	 * @param ArrayList gameObjectList
	 * @param SpriteBatch batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader imageLoader
	 */
	public static void sortAndRenderObjectsInYPositionOrder(
			ArrayList<GameObject> gameObjectList,
			SpriteBatch batch,
			ShapeRenderer shapeRenderer,
			ImageLoader imageLoader
			) {
		Collections.sort(gameObjectList);
		for (int i = 0; i < gameObjectList.size(); i++) {
			if (playerPositionIsWithinBoundsToDrawToRenderGameObjects(
					gameObjectList.get(0).getX(), 
					gameObjectList.get(0).getY(), 
					gameObjectList.get(i).getX(), 
					gameObjectList.get(i).getY(), 
					9,
					gameObjectList.get(i).getHeight(),
					gameObjectList.get(i).getWidth()
					)) {
				gameObjectList.get(i).renderObject(batch, shapeRenderer, imageLoader);
			}
		}
	}

	/**
	 * Determines whether to render game objects based on player one's position.
	 * 
	 * @param float playerX
	 * @param float playerY
	 * @param float gameObjectXPosition
	 * @param float gameObjectYPosition
	 * @param float drawDistance
	 * @param float gameObjectHeight
	 * @param float gameObjectWidth
	 * @return boolean
	 */
	private static boolean playerPositionIsWithinBoundsToDrawToRenderGameObjects(
			float playerX, 
			float playerY, 
			float gameObjectXPosition, 
			float gameObjectYPosition,
			float drawDistance,
			float gameObjectHeight,
			float gameObjectWidth
			) {
		if (
				playerY > gameObjectYPosition - drawDistance &&
				playerY < gameObjectYPosition - gameObjectHeight + drawDistance &&
				playerX > gameObjectXPosition - drawDistance &&
				playerX < gameObjectXPosition + gameObjectWidth + drawDistance
				) { 
			return true;
		}
		return false;
	}
}
