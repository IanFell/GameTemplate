package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwentyOne extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkTwentyOne = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkTwentyOne, 
				GameAttributeHelper.CHUNK_FIVE_X_POSITION_START, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkTwentyOne);
	}
}
