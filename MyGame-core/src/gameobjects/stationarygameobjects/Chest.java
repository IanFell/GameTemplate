package gameobjects.stationarygameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Player;
import handlers.CollisionHandler;
import loaders.ImageLoader;
import maps.MapHandler;
import missions.MissionChests;
import ui.LocationMarker;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Chest extends GamePlayObject {

	// This is used to show the player where loot is when Mission Chests first begins.
	private LocationMarker locationMarker;

	// How much loot player gets from opening chest.
	public static final int LOOT_VALUE = 5;

	protected float objectSize = 1.5f;

	/**
	 * Signifies whether chest is closed or not.
	 */
	private boolean isClosed;

	/**
	 * When chest has been opened, timer begins.
	 * After one hour, chest will be closed and reset to original values.
	 * timerIsOn will be reset to false until chest is opened again.
	 */
	private boolean timerIsOn = false;

	/**
	 * Time is in seconds.  3600 seconds are in one hour.
	 * Use this variable to reset chest to original values, one hour after it is opened.
	 */
	private int amountOfTimeUntilChestIsResetInSecondsAfterItIsOpened = 3;

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public Chest(int x, int y) {
		super(x, y);
		setChestToOriginalValues();
		this.width       = objectSize;
		this.height      = objectSize;
		rectangle.width  = objectSize;
		rectangle.height = objectSize / 2;
		locationMarker   = new LocationMarker(x + 0.25f, y);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		if (isClosed) {
			batch.draw(imageLoader.chestClosed, x, y, width, -height);

			// Show player where to get loot if Mission Chests is active.  After this, they should know.
			if (locationMarker.timerValuesAreCorrectToFlash() && !MissionChests.missionComplete) {
				locationMarker.renderObject(batch, imageLoader);
			}
			// Uncomment this to draw hit box.
			//batch.draw(imageLoader.whiteSquare, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		} else {
			batch.draw(imageLoader.chestOpen, x, y, width, -height);
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		rectangle.y       = y - height;
		CollisionHandler.checkIfPlayerHasCollidedWithChest(myGame.getGameObject(Player.PLAYER_ONE), this);

		/**
		 * If chest is opened, timerIsOn gets set to true.
		 * This timer runs for one hour, after which it is turned off and chest is reset to it's original values.
		 */
		if(timerIsOn) {
			Timer.schedule(new Task() {
				@Override
				public void run() {
					Timer.instance().clear();
					setChestToOriginalValues();
				}
			}, amountOfTimeUntilChestIsResetInSecondsAfterItIsOpened);
		} 

		if (!MissionChests.missionComplete) {
			locationMarker.updateObject();
		}
	}

	private void setChestToOriginalValues() {
		isClosed  = true;
		playSound = false;
		timerIsOn = false;
	}

	public void setChestValuesAfterCollisionWithPlayer() {
		isClosed  = false;
		playSound = true;
		timerIsOn = true;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isClosed() {
		return isClosed;
	}
}
