package ui;

import java.awt.Point;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Player;
import loaders.ImageLoader;
import maps.MapLocationFinder;
import screens.Screens;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MapUi extends Screens {

	private Point playerLocation;

	public static boolean mapShouldBeRendered;

	// Use this to make player location icon flash.
	private int timer                 = 0;
	private final int MAX_TIMER_VALUE = 16;

	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public MapUi(final MyGame myGame) {
		super(myGame);
		mapShouldBeRendered = false;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isMapShouldBeRendered() {
		return mapShouldBeRendered;
	}

	public void updateWorldMapUi() {
		timer++;
		if (timer > MAX_TIMER_VALUE) {
			timer = 0;
		}
		playerLocation  = MapLocationFinder.getPlayerLocationOnMap((Player) myGame.getGameObject(Player.PLAYER_ONE));
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	public void renderWorldMapUi(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		if (mapShouldBeRendered) {
			batch.draw(
					imageLoader.worldMapFake,
					camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset,
					(camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight + 0.5f,
					camera.viewportWidth - borderShrinkOffset * 2, 
					-camera.viewportHeight
					);
			renderUiNavigationBar(imageLoader.mapNavigationBar, batch);
			flashPlayerChunkLocation(batch, imageLoader);
		}
	}

	/**
	 * Flashes the player locator in whichever chunk the player currently resides.
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	private void flashPlayerChunkLocation(SpriteBatch batch, ImageLoader imageLoader) {
		float xChunkLocation  = 0;
		float yChunkLocation  = 0;

		// Width and heighth of a chunk represented via UI map.
		int resizeChunkValue  = 8;
		float chunkWidthOnUi  = 23.3f / resizeChunkValue;
		float chunkHeightOnUi = 13.5f / resizeChunkValue;

		float cameraWidthSize = camera.position.x - getViewportWidth();
		float offsetForCamera = 16.4f;

		// Find player's x chunk position.
		switch (playerLocation.x) {
		case 1:
			xChunkLocation = cameraWidthSize + offsetForCamera;
			break;
		case 2:
			xChunkLocation = cameraWidthSize + offsetForCamera + chunkWidthOnUi;
			break;
		case 3:
			xChunkLocation = cameraWidthSize + offsetForCamera + chunkWidthOnUi * 2;
			break;
		case 4:
			xChunkLocation = cameraWidthSize + offsetForCamera + chunkWidthOnUi * 3;
			break;
		case 5:
			xChunkLocation = cameraWidthSize + offsetForCamera + chunkWidthOnUi * 4;
			break;
		case 6:
			xChunkLocation = cameraWidthSize + offsetForCamera + chunkWidthOnUi * 5;
			break;
		case 7:
			xChunkLocation = cameraWidthSize + offsetForCamera + chunkWidthOnUi * 6;
			break;
		case 8:
			xChunkLocation = cameraWidthSize + offsetForCamera + chunkWidthOnUi * 7;
			break;
		}

		// Find player's y chunk position.
		offsetForCamera = 1.2f;
		switch (playerLocation.y) {
		case 1:
			yChunkLocation = camera.position.y - verticalHeight / denominatorOffset + offsetForCamera;
			break;
		case 2:
			yChunkLocation = camera.position.y - verticalHeight / denominatorOffset + offsetForCamera + chunkHeightOnUi;
			break;
		case 3:
			yChunkLocation = camera.position.y - verticalHeight / denominatorOffset + offsetForCamera + chunkHeightOnUi * 2;
			break;
		case 4:
			yChunkLocation = camera.position.y - verticalHeight / denominatorOffset + offsetForCamera + chunkHeightOnUi * 3;
			break;
		case 5:
			yChunkLocation = camera.position.y - verticalHeight / denominatorOffset + offsetForCamera + chunkHeightOnUi * 4;
			break;
		case 6:
			yChunkLocation = camera.position.y - verticalHeight / denominatorOffset + offsetForCamera + chunkHeightOnUi * 5;
			break;
		case 7:
			yChunkLocation = camera.position.y - verticalHeight / denominatorOffset + offsetForCamera + chunkHeightOnUi * 6;
			break;
		case 8:
			yChunkLocation = camera.position.y - verticalHeight / denominatorOffset + offsetForCamera + chunkHeightOnUi * 7;
			break;
		}
		
		if (timer < MAX_TIMER_VALUE / 2) {
			int locationOffset = 2;
			int resizeValue    = 2;
			batch.draw(imageLoader.locationSkull, 
					xChunkLocation + locationOffset,
					yChunkLocation + locationOffset, 
					chunkWidthOnUi / resizeValue, 
					-chunkHeightOnUi / resizeValue
					);
		}
	}
}
