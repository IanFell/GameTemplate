package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkSix extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkSix = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkSix, 
				GameAttributeHelper.CHUNK_SIX_X_POSITION_START, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkSix);
	}
}
