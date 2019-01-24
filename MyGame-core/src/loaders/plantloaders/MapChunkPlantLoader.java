package loaders.plantloaders;

import gameobjects.GameObject;
import loaders.GameObjectLoader;
import maps.MapInformationHolder;

public class MapChunkPlantLoader {
	
	protected int startXPosition;
	protected int startYPosition;
	protected int row;
	protected final int chunkWidth = MapInformationHolder.CHUNK_WIDTH;
	
	/**
	 * 
	 * @param GameObject[] plant
	 */
	protected void addGameObjectsToGameObjectArrayList(GameObject[] plant) {
		for (int i = 0; i < plant.length; i++) {
			GameObjectLoader.gameObjectList.add(plant[i]);
		}
	}
	
	protected void loadPlants() {}
	
	/**
	 * 
	 * @param GameObject plant
	 * @param int        startXPosition
	 * @param int        rowStartPosition
	 */
	protected void placePlantsForAllSandChunk(GameObject[] plant, int startXPosition, int rowStartPosition) {}
}
