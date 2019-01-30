package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkThirteen extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkThirteen = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkThirteen, 
				GameAttributeHelper.CHUNK_FIVE_X_POSITION_START, 
				GameAttributeHelper.CHUNK_TWO_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkThirteen);
	}
}
