package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkTwenty extends MapChunkPlantLoader {

	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkTwenty() {
		plants = new Plant[6];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_FOUR_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_THREE_Y_POSITION_START;
		row   		   = startYPosition + 8;
		plants[0]      = new Plant(startXPosition + 30, row);
		plants[1]      = new Plant(startXPosition + 31, row);
		row   		   = startYPosition + 25;
		plants[2]      = new Plant(startXPosition + 29, row);
		plants[3]      = new Plant(startXPosition + 50, row);
		row   		   = startYPosition + 40;
		plants[4]      = new Plant(startXPosition + 38, row);
		plants[5]      = new Plant(startXPosition + 50, row);
		addGameObjectsToGameObjectArrayList(plants);  
	}
}
