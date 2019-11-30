package loaders.flowerloader;

import java.util.ArrayList;

import gameobjects.GameObject;
import gameobjects.nature.Flower;
import helpers.GameAttributeHelper;
import helpers.RandomNumberGenerator;
import loaders.ClassObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class FlowerLoader extends ClassObjectLoader {

	private final int AMOUNT_OF_FLOWERS = 300;

	public static ArrayList <GameObject> flowers = new ArrayList <GameObject>();

	public void loadFlowers() {
		for (int i = 0; i < AMOUNT_OF_FLOWERS; i++) {
			addRandomlyPlacedFlower();
		}
		addGameObjectsToGameObjectArrayList(flowers);
	}

	private void addRandomlyPlacedFlower() {
		int startX = RandomNumberGenerator.generateRandomInteger(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60);
		int startY = RandomNumberGenerator.generateRandomInteger(GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START + 50);
		flowers.add(new Flower(startX, startY));
	}
}
