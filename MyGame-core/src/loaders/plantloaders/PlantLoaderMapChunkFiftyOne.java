package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFiftyOne extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkFourtyEight = new Plant[6];

	@Override
	public void loadPlants() {
		startXPosition		         = GameAttributeHelper.CHUNK_THREE_X_POSITION_START;
		startYPosition		         = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				         = startYPosition + 10;
		plantsMapChunkFourtyEight[0] = new Plant(startXPosition + 29, row);
		row 				         = startYPosition + 11;
		plantsMapChunkFourtyEight[1] = new Plant(startXPosition + 30, row);
		row 				         = startYPosition + 35;
		plantsMapChunkFourtyEight[2] = new Plant(startXPosition + 37, row - 5);
		plantsMapChunkFourtyEight[3] = new Plant(startXPosition + 45, row);
		row 				         = startYPosition + 45;
		plantsMapChunkFourtyEight[4] = new Plant(startXPosition + 40, row - 5);
		plantsMapChunkFourtyEight[5] = new Plant(startXPosition + 45, row);

		addGameObjectsToGameObjectArrayList(plantsMapChunkFourtyEight);
	}
}
