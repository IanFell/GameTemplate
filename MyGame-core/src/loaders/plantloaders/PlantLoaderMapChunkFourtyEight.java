package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFourtyEight extends MapChunkPlantLoader {
	
	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkFourtyEight() {
		plants = new Plant[2];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row 	       = startYPosition + 10;
		plants[0]      = new Plant(startXPosition + 5, row);
		row            = startYPosition + 30;
		plants[1]      = new Plant(startXPosition + 10, row);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
