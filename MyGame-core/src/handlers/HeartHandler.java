package handlers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.Heart;
import helpers.GameAttributeHelper;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;
import maps.MapHandler;
import screens.GameScreen;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class HeartHandler {

	private final int MAX_AMOUNT_HEARTS_ALLOWED = 200;

	private ArrayList <Heart> hearts = new ArrayList<Heart>();

	public void init() {
		for (int i = 0; i < MAX_AMOUNT_HEARTS_ALLOWED; i++) {
			addRandomlyPlacedHeart();
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateHearts(MyGame myGame, MapHandler mapHandler) {
		for (int i = 0; i < hearts.size(); i++) {
			hearts.get(i).updateObject(myGame, mapHandler);
			if (hearts.get(i).getY() + hearts.get(i).getHeight() < 0) {
				hearts.remove(i);
			}
			if (hearts.size() < MAX_AMOUNT_HEARTS_ALLOWED) {
				addRandomlyPlacedHeart();
			}
		}
	}

	private void addRandomlyPlacedHeart() {
		int startX = RandomNumberGenerator.generateRandomInteger(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60);
		int startY = RandomNumberGenerator.generateRandomInteger(GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START + 50);
		hearts.add(new Heart(
				startX, 
				startY
				));
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	public void renderHearts(SpriteBatch batch, ImageLoader imageLoader) {
		for (int i = 0; i < hearts.size(); i++) {
			if (gameObjectIsWithinScreenBounds(hearts.get(i))) {
				hearts.get(i).renderObject(batch, imageLoader);
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
		float screenBoundOffset = 17.0f;
		if (
				playerXPosition < cameraXPosition + screenBoundOffset &&
				playerXPosition > cameraXPosition - screenBoundOffset &&
				playerYPosition < cameraYPosition + screenBoundOffset &&
				playerYPosition > cameraYPosition - screenBoundOffset
				) {
			return true;
		}
		return false;
	}
}
