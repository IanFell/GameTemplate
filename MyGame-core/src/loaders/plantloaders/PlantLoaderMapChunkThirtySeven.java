package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkThirtySeven extends MapChunkPlantLoader {

	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkThirtySeven() {
		plants = new Plant[20];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START;
		row 		   = startYPosition + 4;
		plants[0]      = new Plant(startXPosition + 8, row);
		plants[1]      = new Plant(startXPosition + 16, row);
		plants[2]      = new Plant(startXPosition + 45, row);
		row            = startYPosition + 6;
		plants[3]      = new Plant(startXPosition, row);
		plants[4]      = new Plant(startXPosition + 1, row);
		plants[5]      = new Plant(startXPosition + 2, row);
		plants[6]      = new Plant(startXPosition + 38, row);
		plants[7]      = new Plant(startXPosition + 39, row);
		plants[8]      = new Plant(startXPosition + 52, row);
		row 		   = startYPosition + 15;
		plants[9]      = new Plant(startXPosition + 5, row);
		plants[10]     = new Plant(startXPosition + 14, row);
		plants[11]     = new Plant(startXPosition + 21, row);
		plants[12]     = new Plant(startXPosition + 35, row);
		plants[13]     = new Plant(startXPosition + 52, row);
		row 		   = startYPosition + 35;
		plants[14]     = new Plant(startXPosition + 40, row);
		plants[15]     = new Plant(startXPosition + 41, row);
		plants[16]     = new Plant(startXPosition + 42, row);
		row            = startYPosition + 45;
		plants[17]     = new Plant(startXPosition + 30, row);
		plants[18]     = new Plant(startXPosition + 31, row);
		plants[19]     = new Plant(startXPosition + 37, row);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
