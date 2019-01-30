package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkEight extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkEight = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkEight, 
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkEight);
	}
}
