package loaders.tradingpostloader;

import com.mygdx.mygame.MyGame;

import gameobjects.stationarygameobjects.buildings.TradingPost;
import helpers.GameAttributeHelper;
import loaders.BuildingLoader;
import loaders.GameObjectLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class TradingPostLoader extends BuildingLoader {

	public static TradingPost tradingPost;

	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public void loadTradingPost(MyGame myGame) {
		tradingPost = new TradingPost(
				GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 48, 
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START - 65,
				BUILDING_WIDTH,
				BUILDING_HEIGHT,
				myGame.imageLoader.tradingPost
				);
		GameObjectLoader.gameObjectList.add(tradingPost);
	}
}
