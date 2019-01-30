package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwentySix extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkTwentySix = new Plant[8];

	@Override
	public void loadPlants() {
		startXPosition		         = GameAttributeHelper.CHUNK_TWO_X_POSITION_START;
		startYPosition               = GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START;
		row 				         = startYPosition;
		plantsMapChunkTwentySix[0]   = new Plant(startXPosition + 3, row);
		plantsMapChunkTwentySix[1]   = new Plant(startXPosition + 13, row);
		row 				         = startYPosition + 10;
		plantsMapChunkTwentySix[2]   = new Plant(startXPosition + 5, row);
		plantsMapChunkTwentySix[3]   = new Plant(startXPosition + 15, row);
		row 				         = startYPosition + 30;
		plantsMapChunkTwentySix[4]   = new Plant(startXPosition + 10, row);
		plantsMapChunkTwentySix[5]   = new Plant(startXPosition + 11, row);
		row 				         = startYPosition + 40;
		plantsMapChunkTwentySix[6]   = new Plant(startXPosition + 20, row);
		plantsMapChunkTwentySix[7]   = new Plant(startXPosition + 28, row);

		addGameObjectsToGameObjectArrayList(plantsMapChunkTwentySix);
	}
}
