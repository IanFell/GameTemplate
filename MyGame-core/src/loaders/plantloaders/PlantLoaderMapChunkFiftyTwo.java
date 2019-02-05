package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFiftyTwo extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkFiftyTwo = new Plant[3];

	@Override
	public void loadPlants() {
		startXPosition		         = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition		         = GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START;
		row 				         = startYPosition + 45;
		plantsMapChunkFiftyTwo[0]    = new Plant(startXPosition, row);
		row 				         = startYPosition + 47;
		plantsMapChunkFiftyTwo[1]    = new Plant(startXPosition + 5, row);
		row 				         = startYPosition + 44;
		plantsMapChunkFiftyTwo[2]    = new Plant(startXPosition + 25, row);

		addGameObjectsToGameObjectArrayList(plantsMapChunkFiftyTwo);
	}
}
