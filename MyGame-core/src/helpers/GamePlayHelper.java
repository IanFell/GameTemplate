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
	 * gameObjectList[0, 1, 2] = playerOne, playerTwo, playerThree.
	 * If player Y is behind object Y, render player first. 
	 * If player Y is in front of object Y, render object first.
	 * 
	 * @param ArrayList     gameObjectList
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	public static void sortAndRenderObjectsInYPositionOrder(
			ArrayList<GameObject> gameObjectList,
			SpriteBatch batch,
			ShapeRenderer shapeRenderer,
			ImageLoader imageLoader,
			MyGame myGame
			) {
		for (int i = 0; i < gameObjectList.size(); i++) {
			if (i > 0) {
				float playerX           = myGame.getGameObject(GameObject.PLAYER_ONE).getX();
				float playerY           = myGame.getGameObject(GameObject.PLAYER_ONE).getY();
				float playerYPlusHeight = myGame.getGameObject(GameObject.PLAYER_ONE).getY() + myGame.getGameObject(GameObject.PLAYER_ONE).getHeight();
				float objectPosition    = gameObjectList.get(i).getY();
				float drawDistance      = 9;

				// If player y-axis position is within bounds to draw.
				if (
						playerY > gameObjectList.get(i).getY() - drawDistance &&
						playerY < gameObjectList.get(i).getY() - gameObjectList.get(i).getHeight() + drawDistance &&
						playerX > gameObjectList.get(i).getX() - drawDistance &&
						playerX < gameObjectList.get(i).getX() + gameObjectList.get(i).getWidth() + drawDistance
						) {
					if (playerYPlusHeight < objectPosition)  {
						// Render players behind object.
						System.out.println("Player is behing Object " + i);
						gameObjectList.get(0).renderObject(batch, shapeRenderer, imageLoader);
						gameObjectList.get(1).renderObject(batch, shapeRenderer, imageLoader);
						gameObjectList.get(2).renderObject(batch, shapeRenderer, imageLoader);
						// If player x-axis position is within bounds to draw and behind object.
						if (
								playerX > gameObjectList.get(i).getX() - drawDistance &&
								playerX < gameObjectList.get(i).getX() + gameObjectList.get(i).getWidth() + drawDistance
								) {
							gameObjectList.get(i).renderObject(batch, shapeRenderer, imageLoader);
						}
					} else {
						System.out.println("Player is in front of Object " + i);
						// If player x-axis position is within bounds to draw and in front of object.
						if (
								playerX > gameObjectList.get(i).getX() - drawDistance &&
								playerX < gameObjectList.get(i).getX() + gameObjectList.get(i).getWidth() + drawDistance
								) {
							gameObjectList.get(i).renderObject(batch, shapeRenderer, imageLoader);
						}
						gameObjectList.get(0).renderObject(batch, shapeRenderer, imageLoader);
						gameObjectList.get(1).renderObject(batch, shapeRenderer, imageLoader);
						gameObjectList.get(2).renderObject(batch, shapeRenderer, imageLoader);
					}
				}
			}
		}
	}
}
