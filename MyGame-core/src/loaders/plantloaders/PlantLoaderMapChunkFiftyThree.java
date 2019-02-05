package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFiftyThree extends MapChunkPlantLoader {
	public GameObject[] PlantLoaderMapChunkFiftyThree = new Plant[6];

	@Override
	public void loadPlants() {
		startXPosition		             = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition		             = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				             = startYPosition + 39;
		PlantLoaderMapChunkFiftyThree[0] = new Plant(startXPosition, row);
		row 				             = startYPosition + 35;
		PlantLoaderMapChunkFiftyThree[1] = new Plant(startXPosition + 10, row);
		row 				             = startYPosition + 30;
		PlantLoaderMapChunkFiftyThree[2] = new Plant(startXPosition + 20, row);
		PlantLoaderMapChunkFiftyThree[3] = new Plant(startXPosition + 25, row);
		row 				             = startYPosition + 30;
		PlantLoaderMapChunkFiftyThree[4] = new Plant(startXPosition + 35, row);
		row 				             = startYPosition + 33;
		PlantLoaderMapChunkFiftyThree[5] = new Plant(startXPosition + 40, row);

		addGameObjectsToGameObjectArrayList(PlantLoaderMapChunkFiftyThree);
	}
}
