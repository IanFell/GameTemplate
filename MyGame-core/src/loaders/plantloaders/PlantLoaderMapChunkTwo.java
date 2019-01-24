package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.treeobjects.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwo extends MapChunkPlantLoader {
	public GameObject[] plantsMapChunkTwo = new Plant[10];

	@Override
	public void loadPlants() {
		startXPosition       = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 40;
		startYPosition       = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START;
		row   		         = startYPosition;
		plantsMapChunkTwo[0] = new Plant(startXPosition + 5, row);
		plantsMapChunkTwo[1] = new Plant(startXPosition + 6, row);
		row   		         = startYPosition + 10;
		plantsMapChunkTwo[2] = new Plant(startXPosition + 7, row);
		plantsMapChunkTwo[3] = new Plant(startXPosition + 9, row);
		row   		         = startYPosition + 20;
		plantsMapChunkTwo[4] = new Plant(startXPosition + 17, row);
		plantsMapChunkTwo[5] = new Plant(startXPosition + 30, row);
		row   		         = startYPosition + 30;
		plantsMapChunkTwo[6] = new Plant(startXPosition + 35, row);
		plantsMapChunkTwo[7] = new Plant(startXPosition + 45, row);
		row   		         = startYPosition + 40;
		plantsMapChunkTwo[8] = new Plant(startXPosition + 50, row);
		plantsMapChunkTwo[9] = new Plant(startXPosition + 51, row);
		
		addGameObjectsToGameObjectArrayList(plantsMapChunkTwo);  
	}
}
