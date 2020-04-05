package handlers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.Rum;
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
public class RumHandler {
	
	public static int rumCount;
	
	private final int MAX_AMOUNT_RUM_ALLOWED = 50;

	private ArrayList <Rum> rum = new ArrayList<Rum>();

	public void init() {
		for (int i = 0; i < MAX_AMOUNT_RUM_ALLOWED; i++) {
			addRandomlyPlacedRum();
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	public void updateRum(MyGame myGame, MapHandler mapHandler) {
		for (int i = 0; i < rum.size(); i++) {
			rum.get(i).updateObject(myGame, mapHandler);
			if (rum.get(i).getY() + rum.get(i).getHeight() < 0) {
				rum.remove(i);
			}
			if (rum.size() < MAX_AMOUNT_RUM_ALLOWED) {
				addRandomlyPlacedRum();
			}
		}
	}

	private void addRandomlyPlacedRum() {
		int startX = RandomNumberGenerator.generateRandomInteger(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60);
		int startY = RandomNumberGenerator.generateRandomInteger(GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START + 50);
		rum.add(new Rum(
				startX, 
				startY
				));
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	public void renderRum(SpriteBatch batch, ImageLoader imageLoader) {
		for (int i = 0; i < rum.size(); i++) {
			if (gameObjectIsWithinScreenBounds(rum.get(i))) {
				rum.get(i).renderObject(batch, imageLoader);
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
