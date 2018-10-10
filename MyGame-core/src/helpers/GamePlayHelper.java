package helpers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * Contains methods to help with game play.
 * Currently this class is unused but I don't want to get rid of it just yet, just in case.
 * 
 * @author Fabulous Fellini
 *
 */
public class GamePlayHelper {

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
	 * Render objects based on their y-axis position vs player y-axis position.
	 * If player Y is behind object Y, render player first. 
	 * If player Y is in front of object Y, render object first.
	 * 
	 * @param ArrayList gameObjectList
	 * @param SpriteBatch batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader imageLoader
	 * @param MyGame myGame
	 * @param GameObject playerOne
	 * @param GameObject playerTwo
	 * @param GameObject playerThree
	 */
	public static void sortAndRenderObjectsInYPositionOrder(
			ArrayList<GameObject> gameObjectList,
			SpriteBatch batch,
			ShapeRenderer shapeRenderer,
			ImageLoader imageLoader,
			MyGame myGame,
			GameObject playerOne,
			GameObject playerTwo,
			GameObject playerThree
			) {

		float playerX           = playerOne.getX();
		float playerY           = playerOne.getY();
		float playerYPlusHeight = playerOne.getY() + playerOne.getHeight();
		float drawDistance      = 9; 

		for (int i = 0; i < gameObjectList.size(); i++) {

			float gameObjectXPosition = gameObjectList.get(i).getX();
			float gameObjectYPosition = gameObjectList.get(i).getY();

			// If player position is within bounds to draw.
			if (playerPositionIsWithinBoundsToDraw(
					playerX, playerY, 
					gameObjectXPosition, 
					gameObjectYPosition, 
					drawDistance,
					gameObjectList.get(i).getHeight(),
					gameObjectList.get(i).getWidth()
					)) {
				if (playerYPlusHeight < gameObjectYPosition)  {
					// Render players behind object.
					System.out.println("Player is behing Object " + i);
					playerOne.renderObject(batch, shapeRenderer, imageLoader);
					playerTwo.renderObject(batch, shapeRenderer, imageLoader);
					playerThree.renderObject(batch, shapeRenderer, imageLoader);
					gameObjectList.get(i).renderObject(batch, shapeRenderer, imageLoader);
				} else {
					// Render players in front of object.
					System.out.println("Player is in front of Object " + i);
					gameObjectList.get(i).renderObject(batch, shapeRenderer, imageLoader);
					playerOne.renderObject(batch, shapeRenderer, imageLoader);
					playerTwo.renderObject(batch, shapeRenderer, imageLoader);
					playerThree.renderObject(batch, shapeRenderer, imageLoader);
				}
			} 
		}
	}

	/**
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
	private static boolean playerPositionIsWithinBoundsToDraw(
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
