package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwentyEight extends MapChunkPlantLoader {

	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkTwentyEight() {
		plants = new Plant[8];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START;
		row 		   = startYPosition + 2;
		plants[0]      = new Plant(startXPosition + 22, row);
		plants[1]      = new Plant(startXPosition + 23, row);
		plants[2]      = new Plant(startXPosition + 45, row);
		row 		   = startYPosition + 12;
		plants[3]      = new Plant(startXPosition + 37, row);
		plants[4]      = new Plant(startXPosition + 40, row);
		plants[5]      = new Plant(startXPosition + 55, row);
		row 		   = startYPosition + 35;
		plants[6]      = new Plant(startXPosition + 60, row);
		plants[7]      = new Plant(startXPosition + 61, row);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
