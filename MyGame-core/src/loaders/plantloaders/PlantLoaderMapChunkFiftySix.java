package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFiftySix extends MapChunkPlantLoader {
	public GameObject[] plantLoaderMapChunkFiftySix = new Plant[20];

	@Override
	public void loadPlants() {
		startXPosition		            = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START;
		startYPosition		            = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				            = startYPosition;
		plantLoaderMapChunkFiftySix[0]  = new Plant(startXPosition + 1, row);
		plantLoaderMapChunkFiftySix[1]  = new Plant(startXPosition + 2, row);
		plantLoaderMapChunkFiftySix[2]  = new Plant(startXPosition + 3, row);
		plantLoaderMapChunkFiftySix[3]  = new Plant(startXPosition + 4, row);
		row 				            = startYPosition + 5;
		plantLoaderMapChunkFiftySix[4]  = new Plant(startXPosition + 11, row);
		plantLoaderMapChunkFiftySix[5]  = new Plant(startXPosition + 12, row);
		plantLoaderMapChunkFiftySix[6]  = new Plant(startXPosition + 13, row);
		plantLoaderMapChunkFiftySix[7]  = new Plant(startXPosition + 20, row);
		row 				            = startYPosition + 10;
		plantLoaderMapChunkFiftySix[8]  = new Plant(startXPosition + 21, row);
		plantLoaderMapChunkFiftySix[9]  = new Plant(startXPosition + 22, row);
		plantLoaderMapChunkFiftySix[10] = new Plant(startXPosition + 23, row);
		plantLoaderMapChunkFiftySix[11] = new Plant(startXPosition + 25, row);
		row 				            = startYPosition + 7;
		plantLoaderMapChunkFiftySix[12] = new Plant(startXPosition + 31, row);
		plantLoaderMapChunkFiftySix[13] = new Plant(startXPosition + 32, row);
		plantLoaderMapChunkFiftySix[14] = new Plant(startXPosition + 33, row);
		plantLoaderMapChunkFiftySix[15] = new Plant(startXPosition + 34, row);
		row 				            = startYPosition + 5;
		plantLoaderMapChunkFiftySix[16] = new Plant(startXPosition + 41, row);
		plantLoaderMapChunkFiftySix[17] = new Plant(startXPosition + 42, row);
		plantLoaderMapChunkFiftySix[18] = new Plant(startXPosition + 43, row);
		plantLoaderMapChunkFiftySix[19] = new Plant(startXPosition + 44, row);

		addGameObjectsToGameObjectArrayList(plantLoaderMapChunkFiftySix);
	}
}
