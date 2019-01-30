package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwentyNine extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkTwentyNine = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkTwentyNine, 
				GameAttributeHelper.CHUNK_FIVE_X_POSITION_START, 
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkTwentyNine);
	}
}
