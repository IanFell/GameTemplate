package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwelve extends MapChunkPlantLoader {
	
	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkTwelve() {
		plants = new Plant[15];
	}

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plants, 
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START, 
				GameAttributeHelper.CHUNK_TWO_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
