package loaders.rockloader;

import java.util.ArrayList;

import gameobjects.GameObject;
import gameobjects.nature.Rock;
import helpers.GameAttributeHelper;
import helpers.RandomNumberGenerator;
import loaders.ClassObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class RockLoader extends ClassObjectLoader {

	private final int AMOUNT_OF_ROCKS = 300;

	public static ArrayList <GameObject> rocks = new ArrayList <GameObject>();

	public void loadRocks() {
		for (int i = 0; i < AMOUNT_OF_ROCKS; i++) {
			addRandomlyPlacedRock();
		}
		addGameObjectsToGameObjectArrayList(rocks);
	}

	private void addRandomlyPlacedRock() {
		int startX = RandomNumberGenerator.generateRandomInteger(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60);
		int startY = RandomNumberGenerator.generateRandomInteger(GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START + 50);
		rocks.add(new Rock(startX, startY));
	}
}
