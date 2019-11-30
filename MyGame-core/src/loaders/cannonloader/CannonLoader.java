package loaders.cannonloader;

import com.mygdx.mygame.MyGame;

import gameobjects.weapons.Cannon;
import helpers.GameAttributeHelper;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class CannonLoader {

	public static Cannon cannon;

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void loadCannons(MyGame myGame) {
		cannon = new Cannon(
				GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 30, 
				GameAttributeHelper.CHUNK_ONE_Y_POSITION_START + 10
				);
		GameObjectLoader.gameObjectList.add(cannon);
	}
}
