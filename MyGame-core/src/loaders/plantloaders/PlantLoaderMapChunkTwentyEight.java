package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwentyEight extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkTwentyEight = new Plant[8];

	@Override
	public void loadPlants() {
		startXPosition		         = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition               = GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START;
		row 				         = startYPosition + 2;
		plantsMapChunkTwentyEight[0] = new Plant(startXPosition + 22, row);
		plantsMapChunkTwentyEight[1] = new Plant(startXPosition + 23, row);
		plantsMapChunkTwentyEight[2] = new Plant(startXPosition + 45, row);
		row 				         = startYPosition + 12;
		plantsMapChunkTwentyEight[3] = new Plant(startXPosition + 37, row);
		plantsMapChunkTwentyEight[4] = new Plant(startXPosition + 40, row);
		plantsMapChunkTwentyEight[5] = new Plant(startXPosition + 55, row);
		row 				         = startYPosition + 35;
		plantsMapChunkTwentyEight[6] = new Plant(startXPosition + 60, row);
		plantsMapChunkTwentyEight[7] = new Plant(startXPosition + 61, row);

		addGameObjectsToGameObjectArrayList(plantsMapChunkTwentyEight);
	}
}
