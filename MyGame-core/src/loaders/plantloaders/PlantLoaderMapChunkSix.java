package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkSix extends MapChunkPlantLoader {
	
	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkSix() {
		plants = new Plant[15];
	}

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plants, 
				GameAttributeHelper.CHUNK_SIX_X_POSITION_START, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plants);
	}
}
