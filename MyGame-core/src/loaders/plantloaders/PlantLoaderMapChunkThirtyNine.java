package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkThirtyNine extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkThirtyNine = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkThirtyNine, 
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkThirtyNine);
	}
}
