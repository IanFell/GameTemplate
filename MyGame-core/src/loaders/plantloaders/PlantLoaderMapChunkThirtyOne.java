package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkThirtyOne extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkThirtyOne = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkThirtyOne, 
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START, 
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkThirtyOne);
	}
}
