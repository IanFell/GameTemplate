package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkEleven extends MapChunkPlantLoader {

	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkEleven() {
		plants = new Plant[6];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 1;
		startYPosition = GameAttributeHelper.CHUNK_TWO_Y_POSITION_START;
		row   		   = startYPosition;
		plants[0]      = new Plant(startXPosition + 21, row);
		plants[1]      = new Plant(startXPosition + 22, row);
		row   		   = startYPosition + 10;
		plants[2]      = new Plant(startXPosition + 30, row);
		plants[3]      = new Plant(startXPosition + 40, row);
		row   		   = startYPosition + 15;
		plants[4]      = new Plant(startXPosition + 43, row);
		plants[5]      = new Plant(startXPosition + 44, row);
		addGameObjectsToGameObjectArrayList(plants);  
	}
}
