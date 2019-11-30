package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFourtyFive extends MapChunkPlantLoader {
	
	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkFourtyFive() {
		plants = new Plant[7];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row            = startYPosition + 10;
		plants[0]      = new Plant(startXPosition + 41, row);
		plants[1]      = new Plant(startXPosition + 42, row);
		plants[2]      = new Plant(startXPosition + 43, row);
		row 		   = startYPosition + 17;
		plants[3]      = new Plant(startXPosition + 47, row);
		plants[4]      = new Plant(startXPosition + 48, row);
		row 		   = startYPosition + 30;
		plants[5]      = new Plant(startXPosition + 40, row);
		plants[6]      = new Plant(startXPosition + 50, row);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
