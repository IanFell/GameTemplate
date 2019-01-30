package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwelve extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkTwelve = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkTwelve, 
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START, 
				GameAttributeHelper.CHUNK_TWO_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkTwelve);
	}
}
