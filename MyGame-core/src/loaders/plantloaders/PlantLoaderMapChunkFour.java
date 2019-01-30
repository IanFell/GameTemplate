package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFour extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkFour = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkFour, 
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkFour);
	}

}
