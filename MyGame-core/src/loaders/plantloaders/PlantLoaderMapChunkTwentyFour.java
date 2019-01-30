package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwentyFour extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkTwentyFour = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkTwentyFour, 
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkTwentyFour);
	}
}
