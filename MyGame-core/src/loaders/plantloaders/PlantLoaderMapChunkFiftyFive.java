package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFiftyFive extends MapChunkPlantLoader {
	public GameObject[] plantLoaderMapChunkFiftyFive = new Plant[20];

	@Override
	public void loadPlants() {
		startXPosition		             = GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START;
		startYPosition		             = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				             = startYPosition;
		plantLoaderMapChunkFiftyFive[0]  = new Plant(startXPosition + 1, row);
		plantLoaderMapChunkFiftyFive[1]  = new Plant(startXPosition + 2, row);
		plantLoaderMapChunkFiftyFive[2]  = new Plant(startXPosition + 3, row);
		plantLoaderMapChunkFiftyFive[3]  = new Plant(startXPosition + 4, row);
		row 				             = startYPosition + 5;
		plantLoaderMapChunkFiftyFive[4]  = new Plant(startXPosition + 11, row);
		plantLoaderMapChunkFiftyFive[5]  = new Plant(startXPosition + 12, row);
		plantLoaderMapChunkFiftyFive[6]  = new Plant(startXPosition + 13, row);
		plantLoaderMapChunkFiftyFive[7]  = new Plant(startXPosition + 14, row);
		row 				             = startYPosition + 10;
		plantLoaderMapChunkFiftyFive[8]  = new Plant(startXPosition + 21, row);
		plantLoaderMapChunkFiftyFive[9]  = new Plant(startXPosition + 22, row);
		plantLoaderMapChunkFiftyFive[10] = new Plant(startXPosition + 23, row);
		plantLoaderMapChunkFiftyFive[11] = new Plant(startXPosition + 24, row);
		row 				             = startYPosition + 15;
		plantLoaderMapChunkFiftyFive[12] = new Plant(startXPosition + 31, row);
		plantLoaderMapChunkFiftyFive[13] = new Plant(startXPosition + 32, row);
		plantLoaderMapChunkFiftyFive[14] = new Plant(startXPosition + 33, row);
		plantLoaderMapChunkFiftyFive[15] = new Plant(startXPosition + 34, row);
		row 				             = startYPosition + 20;
		plantLoaderMapChunkFiftyFive[16] = new Plant(startXPosition + 41, row);
		plantLoaderMapChunkFiftyFive[17] = new Plant(startXPosition + 42, row);
		plantLoaderMapChunkFiftyFive[18] = new Plant(startXPosition + 43, row);
		plantLoaderMapChunkFiftyFive[19] = new Plant(startXPosition + 44, row);

		addGameObjectsToGameObjectArrayList(plantLoaderMapChunkFiftyFive);
	}
}
