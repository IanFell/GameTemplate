package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwenty extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkTwenty = new Plant[6];

	@Override
	public void loadPlants() {
		startXPosition          = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition          = GameAttributeHelper.CHUNK_THREE_Y_POSITION_START;
		row   		            = startYPosition + 8;
		plantsMapChunkTwenty[0] = new Plant(startXPosition + 30, row);
		plantsMapChunkTwenty[1] = new Plant(startXPosition + 31, row);
		row   		            = startYPosition + 25;
		plantsMapChunkTwenty[2] = new Plant(startXPosition + 29, row);
		plantsMapChunkTwenty[3] = new Plant(startXPosition + 50, row);
		row   		            = startYPosition + 40;
		plantsMapChunkTwenty[4] = new Plant(startXPosition + 38, row);
		plantsMapChunkTwenty[5] = new Plant(startXPosition + 50, row);

		addGameObjectsToGameObjectArrayList(plantsMapChunkTwenty);  
	}
}
