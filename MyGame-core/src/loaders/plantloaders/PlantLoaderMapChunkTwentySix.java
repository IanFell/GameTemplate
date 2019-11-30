package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwentySix extends MapChunkPlantLoader {

	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkTwentySix() {
		plants = new Plant[8];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_TWO_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START;
		row 		   = startYPosition;
		plants[0]      = new Plant(startXPosition + 3, row);
		plants[1]      = new Plant(startXPosition + 13, row);
		row 		   = startYPosition + 10;
		plants[2]      = new Plant(startXPosition + 5, row);
		plants[3]      = new Plant(startXPosition + 15, row);
		row 		   = startYPosition + 30;
		plants[4]      = new Plant(startXPosition + 10, row);
		plants[5]      = new Plant(startXPosition + 11, row);
		row 		   = startYPosition + 40;
		plants[6]      = new Plant(startXPosition + 20, row);
		plants[7]      = new Plant(startXPosition + 28, row);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
