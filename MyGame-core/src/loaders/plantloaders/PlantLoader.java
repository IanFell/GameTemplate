package loaders.plantloaders;

import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlantLoader extends GameObjectLoader {
	
	private PlantLoaderMapChunkTwo plantLoaderMapChunkTwo;
	private PlantLoaderMapChunkThree plantLoaderMapChunkThree;
	
	public PlantLoader() {
		plantLoaderMapChunkTwo   = new PlantLoaderMapChunkTwo();
		plantLoaderMapChunkThree = new PlantLoaderMapChunkThree();
		loadPlants();
	}
	
	public void loadPlants() {
		plantLoaderMapChunkTwo.loadPlants();
		plantLoaderMapChunkThree.loadPlants();
	}
}
