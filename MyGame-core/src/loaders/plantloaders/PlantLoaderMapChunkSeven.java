package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkSeven extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkSeven = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkSeven, 
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkSeven);
	}
}
