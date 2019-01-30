package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkThirty extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkThirty = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkThirty, 
				GameAttributeHelper.CHUNK_SIX_X_POSITION_START, 
				GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkThirty);
	}
}
