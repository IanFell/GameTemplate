package loaders.cannonloader;

import com.mygdx.mygame.MyGame;

import gameobjects.weapons.Cannon;
import helpers.GameAttributeHelper;
import helpers.RandomNumberGenerator;
import loaders.ClassObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class CannonLoader extends ClassObjectLoader {

	public static Cannon[] cannons = new Cannon[20];

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void loadCannons(MyGame myGame) {
		for (int i = 0; i < cannons.length; i++) {
			/**
			 * Create a cannon facing a random direction, either left or right.
			 * Place them randomly, as they can be on the ocean for now.
			 */
			int random    = RandomNumberGenerator.generateRandomInteger(100);
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
		addGameObjectsToGameObjectArrayList(cannons);
	}
}
