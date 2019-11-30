package loaders.plantloaders;

import gameobjects.nature.trees.Plant;
import helpers.GameAttributeHelper;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoaderMapChunkFourtyThree extends MapChunkPlantLoader {

	/**
	 * Constructor.
	 */
	public PlantLoaderMapChunkFourtyThree() {
		plants = new Plant[4];
	}

	@Override
	public void loadPlants() {
		startXPosition = GameAttributeHelper.CHUNK_THREE_X_POSITION_START;
		startYPosition = GameAttributeHelper.CHUNK_SIX_Y_POSITION_START;
		row   		   = startYPosition + 15;
		plants[0]      = new Plant(startXPosition, row);
		row   		   = startYPosition + 21;
		plants[1]      = new Plant(startXPosition + 1, row);
		row   		   = startYPosition + 30;
		plants[2]      = new Plant(startXPosition + 7, row);
		row   		   = startYPosition + 41;
		plants[3]      = new Plant(startXPosition + 16, row);
		addGameObjectsToGameObjectArrayList(plants);  
	}
}
