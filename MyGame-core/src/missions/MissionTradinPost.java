package missions;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Player;
import gameobjects.stationarygameobjects.buildings.TradingPost;
import handlers.CollisionHandler;
import helpers.GameAttributeHelper;
import loaders.ImageLoader;
import maps.MapHandler;
import ui.LocationMarker;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionTradinPost extends Mission {

	public static boolean locationMarkerHasBeenHit = false;

	/**
	 * Constructor
	 */
	public MissionTradinPost() {
		locationMarker = new LocationMarker(
				GameAttributeHelper.CHUNK_THREE_X_POSITION_START - 45,
				GameAttributeHelper.CHUNK_SIX_Y_POSITION_START - 63
				);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	@Override
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		// Flash location icon so player knows where to go.
		if (locationMarker.timerValuesAreCorrectToFlash() && MissionChests.chestMissionIsComplete && !locationMarkerHasBeenHit) {
			locationMarker.renderObject(batch, imageLoader);
		} 
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateMission(MyGame myGame, MapHandler mapHandler) {
		if (!locationMarkerHasBeenHit) {
			locationMarker.updateObject();
			if (CollisionHandler.playerHasCollidedWithLocationMarker(myGame.getGameObject(Player.PLAYER_ONE), locationMarker)) {
				TradingPost.hasBeenEntered = true;
				locationMarkerHasBeenHit   = true;
			}
		}
	}
}
