package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkThirtySeven extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkThirtySeven = new Plant[20];

	@Override
	public void loadPlants() {
		startXPosition		          = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition		          = GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START;
		row 				          = startYPosition + 4;
		plantsMapChunkThirtySeven[0]  = new Plant(startXPosition + 8, row);
		plantsMapChunkThirtySeven[1]  = new Plant(startXPosition + 16, row);
		plantsMapChunkThirtySeven[2]  = new Plant(startXPosition + 45, row);
		row 				          = startYPosition + 6;
		plantsMapChunkThirtySeven[3]  = new Plant(startXPosition, row);
		plantsMapChunkThirtySeven[4]  = new Plant(startXPosition + 1, row);
		plantsMapChunkThirtySeven[5]  = new Plant(startXPosition + 2, row);
		plantsMapChunkThirtySeven[6]  = new Plant(startXPosition + 38, row);
		plantsMapChunkThirtySeven[7]  = new Plant(startXPosition + 39, row);
		plantsMapChunkThirtySeven[8]  = new Plant(startXPosition + 52, row);
		row 				          = startYPosition + 15;
		plantsMapChunkThirtySeven[9]  = new Plant(startXPosition + 5, row);
		plantsMapChunkThirtySeven[10] = new Plant(startXPosition + 14, row);
		plantsMapChunkThirtySeven[11] = new Plant(startXPosition + 21, row);
		plantsMapChunkThirtySeven[12] = new Plant(startXPosition + 35, row);
		plantsMapChunkThirtySeven[13] = new Plant(startXPosition + 52, row);
		row 				          = startYPosition + 35;
		plantsMapChunkThirtySeven[14] = new Plant(startXPosition + 40, row);
		plantsMapChunkThirtySeven[15] = new Plant(startXPosition + 41, row);
		plantsMapChunkThirtySeven[16] = new Plant(startXPosition + 42, row);
		row 				          = startYPosition + 45;
		plantsMapChunkThirtySeven[17] = new Plant(startXPosition + 30, row);
		plantsMapChunkThirtySeven[18] = new Plant(startXPosition + 31, row);
		plantsMapChunkThirtySeven[19] = new Plant(startXPosition + 37, row);

		addGameObjectsToGameObjectArrayList(plantsMapChunkThirtySeven);
	}
}
