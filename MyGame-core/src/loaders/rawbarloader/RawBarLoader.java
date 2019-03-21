package loaders.rawbarloader;

import gameobjects.stationarygameobjects.RawBar;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class RawBarLoader {

	public static RawBar rawbar;

	public void loadRawBar() {
		rawbar = new RawBar(
				GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 35, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 38
				);
		GameObjectLoader.gameObjectList.add(rawbar);
	}
}
