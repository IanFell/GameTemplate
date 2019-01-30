package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkEleven extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkEleven = new Plant[6];

	@Override
	public void loadPlants() {
		startXPosition          = GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 1;
		startYPosition          = GameAttributeHelper.CHUNK_TWO_Y_POSITION_START;
		row   		            = startYPosition;
		plantsMapChunkEleven[0] = new Plant(startXPosition + 21, row);
		plantsMapChunkEleven[1] = new Plant(startXPosition + 22, row);
		row   		            = startYPosition + 10;
		plantsMapChunkEleven[2] = new Plant(startXPosition + 30, row);
		plantsMapChunkEleven[3] = new Plant(startXPosition + 40, row);
		row   		            = startYPosition + 15;
		plantsMapChunkEleven[4] = new Plant(startXPosition + 43, row);
		plantsMapChunkEleven[5] = new Plant(startXPosition + 44, row);

		addGameObjectsToGameObjectArrayList(plantsMapChunkEleven);  
	}
}
