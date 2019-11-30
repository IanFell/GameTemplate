package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFiftyOne extends MapChunkPlantLoader {

	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkFiftyOne() {
		plants = new Plant[6];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_THREE_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 	       = startYPosition + 10;
		plants[0]      = new Plant(startXPosition + 29, row);
		row 	       = startYPosition + 11;
		plants[1]      = new Plant(startXPosition + 30, row);
		row 	       = startYPosition + 35;
		plants[2]      = new Plant(startXPosition + 37, row - 5);
		plants[3]      = new Plant(startXPosition + 45, row);
		row 	       = startYPosition + 45;
		plants[4]      = new Plant(startXPosition + 40, row - 5);
		plants[5]      = new Plant(startXPosition + 45, row);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
