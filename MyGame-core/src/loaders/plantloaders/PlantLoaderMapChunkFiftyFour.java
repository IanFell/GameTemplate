package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFiftyFour extends MapChunkPlantLoader {
	public GameObject[] plantLoaderMapChunkFiftyFour = new Plant[13];

	@Override
	public void loadPlants() {
		startXPosition		             = GameAttributeHelper.CHUNK_SIX_X_POSITION_START;
		startYPosition		             = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				             = startYPosition;
		plantLoaderMapChunkFiftyFour[0]  = new Plant(startXPosition, row);
		plantLoaderMapChunkFiftyFour[1]  = new Plant(startXPosition + 20, row);
		plantLoaderMapChunkFiftyFour[2]  = new Plant(startXPosition + 40, row);
		row 				             = startYPosition + 5;
		plantLoaderMapChunkFiftyFour[3]  = new Plant(startXPosition + 15, row);
		plantLoaderMapChunkFiftyFour[4]  = new Plant(startXPosition + 16, row);
		row 				             = startYPosition + 15;
		plantLoaderMapChunkFiftyFour[5]  = new Plant(startXPosition + 5, row);
		plantLoaderMapChunkFiftyFour[6]  = new Plant(startXPosition + 30, row);
		plantLoaderMapChunkFiftyFour[7]  = new Plant(startXPosition + 45, row);
		row 				             = startYPosition + 30;
		plantLoaderMapChunkFiftyFour[8]  = new Plant(startXPosition + 15, row);
		plantLoaderMapChunkFiftyFour[9]  = new Plant(startXPosition + 50, row);
		plantLoaderMapChunkFiftyFour[10] = new Plant(startXPosition + 51, row);
		row 				             = startYPosition + 35;
		plantLoaderMapChunkFiftyFour[11] = new Plant(startXPosition + 25, row);
		plantLoaderMapChunkFiftyFour[12] = new Plant(startXPosition + 35, row);

		addGameObjectsToGameObjectArrayList(plantLoaderMapChunkFiftyFour);
	}
}
