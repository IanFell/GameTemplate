package loaders.dockloader;

import com.mygdx.mygame.MyGame;

import gameobjects.stationarygameobjects.buildings.Dock;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class DockLoader {
	
	public static Dock mexicoBeachDock;
	public static Dock thePointDock;
	public static Dock stGeorgeDock;
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	public void loadDocks(MyGame myGame) {
		int dockSize = 5;
		mexicoBeachDock = new Dock(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 31, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 5,
				dockSize,
				dockSize,
				myGame.imageLoader.dockLeft
				);
		
		thePointDock = new Dock(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 6, 
				GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START - 112,
				dockSize,
				dockSize,
				myGame.imageLoader.dockLeft
				);
		
		stGeorgeDock = new Dock(
				GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START + 14, 
				GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START + 2,
				dockSize,
				dockSize,
				myGame.imageLoader.dockRight
				);
		
		GameObjectLoader.gameObjectList.add(mexicoBeachDock);
		GameObjectLoader.gameObjectList.add(thePointDock);
		GameObjectLoader.gameObjectList.add(stGeorgeDock);
	}
}
