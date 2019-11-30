package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFiftyFour extends MapChunkPlantLoader {

	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkFiftyFour() {
		plants = new Plant[13];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_SIX_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row            = startYPosition;
		plants[0]      = new Plant(startXPosition, row);
		plants[1]      = new Plant(startXPosition + 20, row);
		plants[2]      = new Plant(startXPosition + 40, row);
		row 		   = startYPosition + 5;
		plants[3]      = new Plant(startXPosition + 15, row);
		plants[4]      = new Plant(startXPosition + 16, row);
		row 	       = startYPosition + 15;
		plants[5]      = new Plant(startXPosition + 5, row);
		plants[6]      = new Plant(startXPosition + 30, row);
		plants[7]      = new Plant(startXPosition + 45, row);
		row 		   = startYPosition + 30;
		plants[8]      = new Plant(startXPosition + 15, row);
		plants[9]      = new Plant(startXPosition + 50, row);
		plants[10]     = new Plant(startXPosition + 51, row);
		row 				             = startYPosition + 35;
		plants[11]     = new Plant(startXPosition + 25, row);
		plants[12]     = new Plant(startXPosition + 35, row);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
