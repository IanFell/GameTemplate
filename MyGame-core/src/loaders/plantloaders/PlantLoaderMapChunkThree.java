package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkThree extends MapChunkPlantLoader {

	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkThree() {
		plants = new Plant[18];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_THREE_X_POSITION_START + 5;
		startYPosition = GameAttributeHelper.CHUNK_ONE_Y_POSITION_START;
		row   		   = startYPosition;
		plants[0]      = new Plant(startXPosition + 5, row);
		plants[1]      = new Plant(startXPosition + 6, row);
		plants[2]      = new Plant(startXPosition + 21, row);
		plants[3]      = new Plant(startXPosition + 25, row);
		plants[4]      = new Plant(startXPosition + 35, row);
		plants[5]      = new Plant(startXPosition + 40, row);
		row   	       = startYPosition + 5;
		plants[6]      = new Plant(startXPosition + 9, row);
		plants[7]      = new Plant(startXPosition + 15, row);
		plants[8]      = new Plant(startXPosition + 45, row);
		plants[9]      = new Plant(startXPosition + 46, row);
		row   		   = startYPosition + 15;
		plants[10]     = new Plant(startXPosition + 30, row);
		plants[11]     = new Plant(startXPosition + 31, row);
		row   		   = startYPosition + 25;
		plants[12]     = new Plant(startXPosition + 15, row);
		plants[13]     = new Plant(startXPosition + 45, row);
		row   		   = startYPosition + 35;
		plants[14]     = new Plant(startXPosition + 15, row);
		plants[15]     = new Plant(startXPosition + 45, row);
		row   		   = startYPosition + 45;
		plants[16]     = new Plant(startXPosition + 39, row);
		plants[17]     = new Plant(startXPosition + 40, row);
		addGameObjectsToGameObjectArrayList(plants);  
	}
}
