package loaders.teepeeloader;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.stationarygameobjects.buildings.TeePee;
import helpers.GameAttributeHelper;
import loaders.ClassObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TeePeeLoader extends ClassObjectLoader {

	public static GameObject[] teePees = new GameObject[6];

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void loadTeePees(MyGame myGame) {
		Texture texture = myGame.imageLoader.teePee;
		teePees[0]      = new TeePee(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 49, 5, 3, 4, texture, "Mexico Beach"); 
		teePees[1]      = new TeePee(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 65, 6, 3, 4, texture, "Wewa");  
		teePees[2]      = new TeePee(GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 18, GameAttributeHelper.CHUNK_THREE_Y_POSITION_START - 3, 3, 4, texture,  "Port St Joe");  
		teePees[3]      = new TeePee(GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 30, GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START + 2, 3, 4, texture,  "Cape San Blas");  
		teePees[4]      = new TeePee(GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 50, GameAttributeHelper.CHUNK_SIX_Y_POSITION_START + 25, 3, 4, texture,  "Apalachicola"); 
		teePees[5]      = new TeePee(GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START, GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START + 1, 3, 4, texture,  "St George");
		addGameObjectsToGameObjectArrayList(teePees);
	}
}
