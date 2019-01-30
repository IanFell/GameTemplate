package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFourteen extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkFourteen = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkFourteen, 
				GameAttributeHelper.CHUNK_SIX_X_POSITION_START, 
				GameAttributeHelper.CHUNK_TWO_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkFourteen);
	}
}
