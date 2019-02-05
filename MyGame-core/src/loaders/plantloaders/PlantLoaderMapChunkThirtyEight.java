package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkThirtyEight extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkThirtyEight = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkThirtyEight, 
				GameAttributeHelper.CHUNK_SIX_X_POSITION_START, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkThirtyEight);
	}
}
