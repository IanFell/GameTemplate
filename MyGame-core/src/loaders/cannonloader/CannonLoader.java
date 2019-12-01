package loaders.cannonloader;

import java.util.ArrayList;

import com.mygdx.mygame.MyGame;

import gameobjects.weapons.Bullet;
import gameobjects.weapons.Cannon;
import helpers.GameAttributeHelper;
import helpers.RandomNumberGenerator;
import loaders.ClassObjectLoader;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class CannonLoader extends ClassObjectLoader {

	public static Cannon[] cannons = new Cannon[500];

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void loadCannons(MyGame myGame) {
		for (int i = 0; i < cannons.length; i++) {
			int random = RandomNumberGenerator.generateRandomInteger(100);
			int direction = Cannon.DIRECTION_LEFT;
			if (random < 50) {
				direction = Cannon.DIRECTION_RIGHT;
			}
			cannons[i] = new Cannon(
					RandomNumberGenerator.generateRandomInteger(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 60), 
					RandomNumberGenerator.generateRandomInteger(GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START + 50),
					direction
					);
		}
		/*
		cannons[0] = new Cannon(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 65, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 7,
				Cannon.DIRECTION_LEFT
				);
		cannons[1] = new Cannon(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 67, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 10,
				Cannon.DIRECTION_LEFT
				);
		cannons[2] = new Cannon(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 63, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 30,
				Cannon.DIRECTION_RIGHT
				);
		cannons[3] = new Cannon(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 104, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 70,
				Cannon.DIRECTION_RIGHT
				);
		cannons[4] = new Cannon(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 20, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 6,
				Cannon.DIRECTION_LEFT
				);
		cannons[5] = new Cannon(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 30, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 15,
				Cannon.DIRECTION_LEFT
				);
		cannons[6] = new Cannon(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 100, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 30,
				Cannon.DIRECTION_RIGHT
				);
		cannons[7] = new Cannon(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 60, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 45,
				Cannon.DIRECTION_LEFT
				);
				*/
		addGameObjectsToGameObjectArrayList(cannons);
	}
}
