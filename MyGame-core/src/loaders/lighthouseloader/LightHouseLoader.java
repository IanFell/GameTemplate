package loaders.lighthouseloader;

import com.mygdx.mygame.MyGame;

import gameobjects.stationarygameobjects.buildings.LightHouse;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class LightHouseLoader {

	public static LightHouse lightHouse;

	public void loadLightHouse(MyGame myGame) {
		lightHouse = new LightHouse(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 39, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + 9,
				4,
				15,
				myGame.imageLoader.lightHouse
				);
		GameObjectLoader.gameObjectList.add(lightHouse);
	}
}
