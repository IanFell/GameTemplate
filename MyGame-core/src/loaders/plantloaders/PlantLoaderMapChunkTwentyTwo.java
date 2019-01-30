package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwentyTwo extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkTwentyTwo = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkTwentyTwo, 
				GameAttributeHelper.CHUNK_SIX_X_POSITION_START, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkTwentyTwo);
	}
}
