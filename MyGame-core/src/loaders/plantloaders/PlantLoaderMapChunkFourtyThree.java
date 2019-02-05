package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFourtyThree extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkFourtyThree = new Plant[4];

	@Override
	public void loadPlants() {
		startXPosition               = GameAttributeHelper.CHUNK_THREE_X_POSITION_START;
		startYPosition               = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row   		                 = startYPosition + 15;
		plantsMapChunkFourtyThree[0] = new Plant(startXPosition, row);
		row   		                 = startYPosition + 21;
		plantsMapChunkFourtyThree[1] = new Plant(startXPosition + 1, row);
		row   		                 = startYPosition + 30;
		plantsMapChunkFourtyThree[2] = new Plant(startXPosition + 7, row);
		row   		                 = startYPosition + 41;
		plantsMapChunkFourtyThree[3] = new Plant(startXPosition + 16, row);

		addGameObjectsToGameObjectArrayList(plantsMapChunkFourtyThree);  
	}
}
