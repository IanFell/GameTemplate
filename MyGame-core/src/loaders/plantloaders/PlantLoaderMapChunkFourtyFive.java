package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFourtyFive extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkFourtyFive = new Plant[7];

	@Override
	public void loadPlants() {
		startXPosition		        = GameAttributeHelper.CHUNK_FIVE_X_POSITION_START;
		startYPosition		        = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row 				        = startYPosition + 10;
		plantsMapChunkFourtyFive[0] = new Plant(startXPosition + 41, row);
		plantsMapChunkFourtyFive[1] = new Plant(startXPosition + 42, row);
		plantsMapChunkFourtyFive[2] = new Plant(startXPosition + 43, row);
		row 				        = startYPosition + 17;
		plantsMapChunkFourtyFive[3] = new Plant(startXPosition + 47, row);
		plantsMapChunkFourtyFive[4] = new Plant(startXPosition + 48, row);
		row 				        = startYPosition + 30;
		plantsMapChunkFourtyFive[5] = new Plant(startXPosition + 40, row);
		plantsMapChunkFourtyFive[6] = new Plant(startXPosition + 50, row);

		addGameObjectsToGameObjectArrayList(plantsMapChunkFourtyFive);
	}
}
