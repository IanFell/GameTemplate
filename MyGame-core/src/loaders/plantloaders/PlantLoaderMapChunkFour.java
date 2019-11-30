package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFour extends MapChunkPlantLoader {
	
	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkFour() {
		plants = new Plant[15];
	}

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plants, 
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
