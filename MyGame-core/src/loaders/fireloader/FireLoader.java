package loaders.fireloader;

import gameobjects.GameObject;
import helpers.GameAttributeHelper;
import loaders.ClassObjectLoader;
import physics.Lighting.Fire;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class FireLoader extends ClassObjectLoader {

	public static GameObject[] fires = new GameObject[7];

	// Are there logs under the fire?
	private boolean hasLogs = true;

	public void loadFire() {
		float fireWidth  = 0.5f;
		float fireHeight = 1.5f;
		fires[0] = new Fire(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 51, 
				6,
				fireWidth,
				fireHeight,
				"Mexico Beach",
				hasLogs
				);
		fires[1] = new Fire(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 67, 
				7,
				fireWidth,
				fireHeight,
				"Wewa",
				hasLogs
				);
		fires[2] = new Fire(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 19, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 2,
				fireWidth,
				fireHeight,
				"Port St Joe",
				hasLogs
				);
		fires[3] = new Fire(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 32f, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + 3,
				fireWidth,
				fireHeight,
				"Cape San Blas",
				hasLogs
				);
		fires[4] = new Fire(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 52, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 26,
				fireWidth,
				fireHeight,
				"Apalachicola",
				hasLogs
				);
		fires[5] = new Fire(
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 2, 
				GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START + 2,
				fireWidth,
				fireHeight,
				"St George",
				hasLogs
				);
		fires[6] = new Fire(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 40.8f, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START - 3.5f,
				fireWidth,
				fireHeight,
				"Light House",
				!hasLogs
				);

		addGameObjectsToGameObjectArrayList(fires);
	}
}
