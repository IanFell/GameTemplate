package loaders.rawbarloader;

import com.mygdx.mygame.MyGame;

import gameobjects.stationarygameobjects.buildings.RawBar;
import helpers.GameAttributeHelper;
import loaders.BuildingLoader;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class RawBarLoader extends BuildingLoader {

	public static RawBar rawbar;

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void loadRawBar(MyGame myGame) {
		rawbar = new RawBar(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 35, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 38,
				BUILDING_WIDTH,
				BUILDING_HEIGHT,
				myGame.imageLoader.rawbar
				);
		GameObjectLoader.gameObjectList.add(rawbar);
	}
}
