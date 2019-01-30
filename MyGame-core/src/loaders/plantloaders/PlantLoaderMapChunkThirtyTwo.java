package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkThirtyTwo extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkThirtyTwo = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkThirtyTwo, 
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START, 
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkThirtyTwo);
	}
}
