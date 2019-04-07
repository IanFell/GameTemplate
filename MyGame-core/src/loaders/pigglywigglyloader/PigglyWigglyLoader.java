package loaders.pigglywigglyloader;

import gameobjects.stationarygameobjects.PigglyWiggly;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;

public class PigglyWigglyLoader {
	
	public static PigglyWiggly pigglyWiggly;
	
	public void loadPigglyWiggly() {
		pigglyWiggly = new PigglyWiggly(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 1, 
				GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 6
				);
		GameObjectLoader.gameObjectList.add(pigglyWiggly);
	}

}
