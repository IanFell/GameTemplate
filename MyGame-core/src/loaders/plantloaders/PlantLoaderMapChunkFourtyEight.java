package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFourtyEight extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkFourtyEight = new Plant[2];

	@Override
	public void loadPlants() {
		startXPosition		         = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START;
		startYPosition		         = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row 				         = startYPosition + 10;
		plantsMapChunkFourtyEight[0] = new Plant(startXPosition + 5, row);
		row 				         = startYPosition + 30;
		plantsMapChunkFourtyEight[1] = new Plant(startXPosition + 10, row);

		addGameObjectsToGameObjectArrayList(plantsMapChunkFourtyEight);
	}
}
