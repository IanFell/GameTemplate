package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFiftyThree extends MapChunkPlantLoader {
	
	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkFiftyThree() {
		plants = new Plant[6];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 	       = startYPosition + 39;
		plants[0]      = new Plant(startXPosition, row);
		row 		   = startYPosition + 35;
		plants[1]      = new Plant(startXPosition + 10, row);
		row 		   = startYPosition + 30;
		plants[2]      = new Plant(startXPosition + 20, row);
		plants[3]      = new Plant(startXPosition + 25, row);
		row 		   = startYPosition + 30;
		plants[4]      = new Plant(startXPosition + 35, row);
		row 		   = startYPosition + 33;
		plants[5]      = new Plant(startXPosition + 40, row);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
