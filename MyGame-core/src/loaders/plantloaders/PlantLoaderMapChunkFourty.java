package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFourty extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkFourty = new Plant[15];

	@Override
	public void loadPlants() {
		placePlantsForAllSandChunk(
				plantsMapChunkFourty, 
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START
				);
		addGameObjectsToGameObjectArrayList(plantsMapChunkFourty);
	}
}
