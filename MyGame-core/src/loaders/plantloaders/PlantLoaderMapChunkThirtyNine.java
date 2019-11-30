package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkThirtyNine extends MapChunkPlantLoader {
	
	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkThirtyNine() {
		plants = new Plant[15];
	}

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plants, 
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
