package maps;

import java.awt.Point;

import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;

/**
 * Locates player within game world in order to transfer coordinates onto UI map.
 * 
 * @author Fabulous Fellini
 *
 */
public class MapLocationFinder {

	private static float x              = 0;
	private static float y              = 0;
	private static float xChunk         = 0;
	private static float yChunk         = 0;
	private static Point playerLocation = new Point(0, 0);

	/**
	 * This method will take the player and find his coordinates in order to tranfer
	 * these values to the map UI.
	 * 
	 * @param Player player
	 */
	public static Point getPlayerLocationOnMap(Player player) {
		playerLocation.x = (int) getPlayerChunkPositionX(player);
		playerLocation.y = (int) getPlayerChunkPositionY(player);
		//System.out.println("Player position:" + x + ", " + y);
		return playerLocation;

	}

	/**
	 * 
	 * @param Player player
	 * @return player
	 */
	private static float getPlayerChunkPositionX(Player player) {
		// Find player x position.
		x = player.getX();
		if (x > GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START) {
			xChunk = 8;
		} else if (x > GameAttributeHelper.CHUNK_SEVEN_X_POSITION_START) {
			xChunk = 7;
		} else if (x > GameAttributeHelper.CHUNK_SIX_X_POSITION_START) {
			xChunk = 6;
		} else if (x > GameAttributeHelper.CHUNK_FIVE_X_POSITION_START) {
			xChunk = 5;
		} else if (x > GameAttributeHelper.CHUNK_FOUR_X_POSITION_START) {
			xChunk = 4;
		} else if (x > GameAttributeHelper.CHUNK_THREE_X_POSITION_START) {
			xChunk = 3;
		} else if (x > GameAttributeHelper.CHUNK_TWO_X_POSITION_START) {
			xChunk = 2;
		} else if (x > GameAttributeHelper.CHUNK_ONE_X_POSITION_START) {
			xChunk = 1;
		}
		return xChunk;
	}

	/**
	 * 
	 * @param Player player
	 * @return player
	 */
	private static float getPlayerChunkPositionY(Player player) {
		// Find player x position.
		y = player.getY();
		if (y > GameAttributeHelper.CHUNK_EIGHT_Y_POSITION_START) {
			yChunk = 8;
		} else if (y > GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START) {
			yChunk = 7;
		} else if (y > GameAttributeHelper.CHUNK_SIX_Y_POSITION_START) {
			yChunk = 6;
		} else if (y > GameAttributeHelper.CHUNK_FIVE_Y_POSITION_START) {
			yChunk = 5;
		} else if (y > GameAttributeHelper.CHUNK_FOUR_Y_POSITION_START) {
			yChunk = 4;
		} else if (y > GameAttributeHelper.CHUNK_THREE_Y_POSITION_START) {
			yChunk = 3;
		} else if (y > GameAttributeHelper.CHUNK_TWO_Y_POSITION_START) {
			yChunk = 2;
		} else if (y > GameAttributeHelper.CHUNK_ONE_Y_POSITION_START) {
			yChunk = 1;
		}
		return yChunk;
	}
}
