package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFourtySeven extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkFourtySeven = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkFourtySeven, 
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkFourtySeven);
	}
}
