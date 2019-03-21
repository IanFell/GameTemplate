package loaders.lighthouseloader;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.LightHouse;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class LightHouseLoader {

	public static LightHouse lightHouse;

	/**
	 * 
	 * @param GameObject lighthouse
	 */
	protected void addGameObjectsToGameObjectArrayList(GameObject lighthouse) {
		GameObjectLoader.gameObjectList.add(lighthouse);
	}

	public void loadLightHouse() {
		lightHouse = new LightHouse(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 39, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + 9
				);
		GameObjectLoader.gameObjectList.add(lightHouse);
	}
}
