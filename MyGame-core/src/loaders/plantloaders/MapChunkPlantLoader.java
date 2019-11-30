package loaders.plantloaders;

import gameobjects.GameObject;
import gameobjects.nature.trees.Plant;
import loaders.ClassObjectLoader;
import maps.MapInformationHolder;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MapChunkPlantLoader extends ClassObjectLoader {
	
	protected GameObject[] plants;

	protected int startXPosition;
	protected int startYPosition;
	protected int row;
	protected final int chunkWidth = MapInformationHolder.CHUNK_WIDTH;

	protected void loadPlants() {}

	/**
	 * 
	 * @param GameObject plant
	 * @param int        startXPosition
	 * @param int        rowStartPosition
	 */
	protected void placePlantsForAllSandChunk(GameObject[] plant, int startXPosition, int rowStartPosition) {
		row       = rowStartPosition + 3;
		plant[0]  = new Plant(startXPosition, row);
		plant[1]  = new Plant(startXPosition + 27, row);
		row       = rowStartPosition + 10;
		plant[2]  = new Plant(startXPosition + 5, row);
		plant[3]  = new Plant(startXPosition + 32, row);
		row       = rowStartPosition + 15;
		plant[4]  = new Plant(startXPosition + 8, row);
		plant[5]  = new Plant(startXPosition + 45, row);
		row       = rowStartPosition + 25;
		plant[6]  = new Plant(startXPosition + 9, row);
		plant[7]  = new Plant(startXPosition + 40, row);
		row       = rowStartPosition + 32;
		plant[8]  = new Plant(startXPosition + 10, row);
		plant[9]  = new Plant(startXPosition + 50, row);
		row       = rowStartPosition + 40;
		plant[10] = new Plant(startXPosition + 13, row);
		plant[11] = new Plant(startXPosition + 52, row);
		row       = rowStartPosition + 45;
		plant[12] = new Plant(startXPosition + 9, row);
		plant[13] = new Plant(startXPosition + 32, row);
		plant[14] = new Plant(startXPosition + 33, row);
	}
}
