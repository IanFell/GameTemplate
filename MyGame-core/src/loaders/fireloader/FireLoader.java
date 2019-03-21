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
	
	private boolean hasLogs = true;

	public void loadFire() {
		int fireSize = 1;
		fires[0] = new Fire(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 51, 
				6,
				fireSize,
				fireSize,
				"Mexico Beach",
				hasLogs
				);
		fires[1] = new Fire(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 67, 
				7,
				fireSize,
				fireSize,
				"Wewa",
				hasLogs
				);
		fires[2] = new Fire(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 20, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 2,
				fireSize,
				fireSize,
				"Port St Joe",
				hasLogs
				);
		fires[3] = new Fire(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 32f, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + 3,
				fireSize,
				fireSize,
				"Cape San Blas",
				hasLogs
				);
		fires[4] = new Fire(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 52, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 26,
				fireSize,
				fireSize,
				"Apalachicola",
				hasLogs
				);
		fires[5] = new Fire(
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 2, 
				GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START + 2,
				fireSize,
				fireSize,
				"St George",
				hasLogs
				);
		fires[6] = new Fire(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 40.5f, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START - 3.5f,
				fireSize,
				fireSize,
				"Light House",
				!hasLogs
				);
		addGameObjectsToGameObjectArrayList(fires);
	}
}
