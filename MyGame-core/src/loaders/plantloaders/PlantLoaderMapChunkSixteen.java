package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkSixteen extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkSixteen = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkSixteen, 
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START, 
				GameAttributeHelper.CHUNK_TWO_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkSixteen);
	}
}
