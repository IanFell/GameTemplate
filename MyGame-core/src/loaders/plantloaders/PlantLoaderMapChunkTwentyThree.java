package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwentyThree extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkTwentyThree = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkTwentyThree, 
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkTwentyThree);
	}
}
