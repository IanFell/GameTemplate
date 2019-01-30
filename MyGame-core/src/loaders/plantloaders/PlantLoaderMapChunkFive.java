package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFive extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkFive = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkFive, 
				GameAttributeHelper.CHUNK_FIVE_X_POSITION_START, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkFive);
	}
}
