package loaders.signloader;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.Sign;
import helpers.GameAttributeHelper;
import loaders.ClassObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class SignLoader extends ClassObjectLoader {

	public static GameObject[] signs = new GameObject[14];

	public void loadSigns() {
		signs[0]  = new Sign("Mexico Beach", GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 37, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 3);
		signs[1]  = new Sign("Mexico Beach", GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 60, GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 15);
		signs[2]  = new Sign("Wewa", GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 42, 13);
		signs[3]  = new Sign("Wewa", GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 58, 28);
		signs[4]  = new Sign("Apalachicola", GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 32, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 20);
		signs[5]  = new Sign("Apalachicola", GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 20, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 43);
		signs[6]  = new Sign("St George", GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 5, GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START + 3);
		signs[7]  = new Sign("St George", GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START - 18, GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START - 13);
		signs[8]  = new Sign("Cape San Blas", GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 31, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START - 33);
		signs[9]  = new Sign("Cape San Blas", GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 54, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START - 70);
		signs[10] = new Sign("The Point", GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 11, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START - 111);
		signs[11] = new Sign("The Point", GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 4, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START - 86);
		signs[12] = new Sign("Port St Joe", GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 22, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START + 3);
		signs[13] = new Sign("Port St Joe", GameAttributeHelper.CHUNK_FOUR_X_POSITION_START - 1, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 20);
		addGameObjectsToGameObjectArrayList(signs);
	}
}
