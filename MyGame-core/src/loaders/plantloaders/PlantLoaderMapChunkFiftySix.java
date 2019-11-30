package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFiftySix extends MapChunkPlantLoader {

	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkFiftySix() {
		plants = new Plant[20];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 	       = startYPosition;
		plants[0]      = new Plant(startXPosition + 1, row);
		plants[1]      = new Plant(startXPosition + 2, row);
		plants[2]      = new Plant(startXPosition + 3, row);
		plants[3]      = new Plant(startXPosition + 4, row);
		row 		   = startYPosition + 5;
		plants[4]      = new Plant(startXPosition + 11, row);
		plants[5]      = new Plant(startXPosition + 12, row);
		plants[6]      = new Plant(startXPosition + 13, row);
		plants[7]      = new Plant(startXPosition + 20, row);
		row 		   = startYPosition + 10;
		plants[8]      = new Plant(startXPosition + 21, row);
		plants[9]      = new Plant(startXPosition + 22, row);
		plants[10]     = new Plant(startXPosition + 23, row);
		plants[11]     = new Plant(startXPosition + 25, row);
		row 		   = startYPosition + 7;
		plants[12]     = new Plant(startXPosition + 31, row);
		plants[13]     = new Plant(startXPosition + 32, row);
		plants[14]     = new Plant(startXPosition + 33, row);
		plants[15]     = new Plant(startXPosition + 34, row);
		row 		   = startYPosition + 5;
		plants[16]     = new Plant(startXPosition + 41, row);
		plants[17]     = new Plant(startXPosition + 42, row);
		plants[18]     = new Plant(startXPosition + 43, row);
		plants[19]     = new Plant(startXPosition + 44, row);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
