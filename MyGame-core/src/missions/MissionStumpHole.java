package missions;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.Bird;
import gameobjects.GameObject;
import gameobjects.nature.Stump;
import helpers.GameAttributeHelper;
import loaders.ImageLoader;
import maps.MapHandler;
import screens.GameScreen;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionStumpHole extends Mission {

	private Bird bird;

	public static boolean missionIsActive = false;

	public static ArrayList <GameObject> stumps = new ArrayList <GameObject>();

	private final int AMOUNT_OF_STUMPS = 13;

	/**
	 * Constructor.
	 */
	public MissionStumpHole() {
		// Place bird on last stump of row one of stumps.
		bird = new Bird(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 5f, 
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 32.5f
				);
		loadStumps();
	}

	private void loadStumps() {
		float startX = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 24.5f;
		int startY = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 45;
		for (int i = 0; i < AMOUNT_OF_STUMPS; i++) {
			stumps.add(new Stump((int) startX, startY));
			startX += 2;
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	@Override
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		if (missionIsActive) {

			// Draw background.
			batch.draw(
					imageLoader.whiteSquare, 
					GameScreen.camera.position.x - GameScreen.camera.viewportWidth / 2, 
					GameScreen.camera.position.y + GameScreen.camera.viewportHeight / 2,
					GameScreen.camera.viewportWidth, 
					-GameScreen.camera.viewportHeight
					);

			for (int i = 0; i < stumps.size(); i++) {
				stumps.get(i).renderObject(batch, imageLoader);
			}
		} else {
			bird.renderObject(batch, imageLoader);
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateMission(MyGame myGame, MapHandler mapHandler) {
		for (int i = 0; i < stumps.size(); i++) {
			stumps.get(i).updateObject(myGame, mapHandler);
		}
	}
}
