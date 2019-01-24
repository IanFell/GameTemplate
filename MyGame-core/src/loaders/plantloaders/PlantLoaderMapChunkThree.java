package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkThree extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkThree = new Plant[18];
	
	@Override
	public void loadPlants() {
		startXPosition       = GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 5;
		startYPosition       = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START;
		row   		         = startYPosition;
		plantsMapChunkThree[0] = new Plant(startXPosition + 5, row);
		plantsMapChunkThree[1] = new Plant(startXPosition + 6, row);
		plantsMapChunkThree[2] = new Plant(startXPosition + 21, row);
		plantsMapChunkThree[3] = new Plant(startXPosition + 25, row);
		plantsMapChunkThree[4] = new Plant(startXPosition + 35, row);
		plantsMapChunkThree[5] = new Plant(startXPosition + 40, row);
		row   		           = startYPosition + 5;
		plantsMapChunkThree[6] = new Plant(startXPosition + 9, row);
		plantsMapChunkThree[7] = new Plant(startXPosition + 15, row);
		plantsMapChunkThree[8] = new Plant(startXPosition + 45, row);
		plantsMapChunkThree[9] = new Plant(startXPosition + 46, row);
		row   		           = startYPosition + 15;
		plantsMapChunkThree[10] = new Plant(startXPosition + 30, row);
		plantsMapChunkThree[11] = new Plant(startXPosition + 31, row);
		row   		            = startYPosition + 25;
		plantsMapChunkThree[12] = new Plant(startXPosition + 15, row);
		plantsMapChunkThree[13] = new Plant(startXPosition + 45, row);
		row   		            = startYPosition + 35;
		plantsMapChunkThree[14] = new Plant(startXPosition + 15, row);
		plantsMapChunkThree[15] = new Plant(startXPosition + 45, row);
		row   		            = startYPosition + 45;
		plantsMapChunkThree[16] = new Plant(startXPosition + 39, row);
		plantsMapChunkThree[17] = new Plant(startXPosition + 40, row);
		
		addGameObjectsToGameObjectArrayList(plantsMapChunkThree);  
	}
}
