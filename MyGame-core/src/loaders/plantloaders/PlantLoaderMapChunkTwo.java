package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwo extends MapChunkPlantLoader {

	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkTwo() {
		plants = new Plant[10];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 40;
		startYPosition = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START;
		row   		   = startYPosition;
		plants[0]      = new Plant(startXPosition + 5, row);
		plants[1]      = new Plant(startXPosition + 6, row);
		row   		   = startYPosition + 10;
		plants[2]      = new Plant(startXPosition + 7, row);
		plants[3]      = new Plant(startXPosition + 9, row);
		row   		   = startYPosition + 20;
		plants[4]      = new Plant(startXPosition + 17, row);
		plants[5]      = new Plant(startXPosition + 30, row);
		row   		   = startYPosition + 30;
		plants[6]      = new Plant(startXPosition + 35, row);
		plants[7]      = new Plant(startXPosition + 45, row);
		row   		   = startYPosition + 40;
		plants[8]      = new Plant(startXPosition + 50, row);
		plants[9]      = new Plant(startXPosition + 51, row);
		addGameObjectsToGameObjectArrayList(plants);  
	}
}
