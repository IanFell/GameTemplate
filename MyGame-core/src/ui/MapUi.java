package ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import loaders.ImageLoader;
import screens.Screens;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MapUi extends Screens {

	public static boolean mapShouldBeRendered;

	// Use this to make player location icon flash.
	private int timer = 0;

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
		if (timer > 25) {
			timer = 0;
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	public void renderWorldMapUi(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader, MyGame myGame) {
		if (mapShouldBeRendered) {
			Texture texture = null;

			// Make map look like player location is flashing.
			// This is the "unflashed" map.
			if (timer < 12) {
				texture = imageLoader.worldMapFake;
			} else {
				// This is the "flashed" map.
				if (myGame.gameScreen.townHandler.getMexicoBeach().isInTown()) {
					texture = imageLoader.worldMapMexicoBeach;
				} else if (myGame.gameScreen.townHandler.getPortStJoe().isInTown()) {
					texture = imageLoader.worldMapPortStJoe;
				} else if (myGame.gameScreen.townHandler.getWewa().isInTown()) {
					texture = imageLoader.worldMapWewa;
				} else if (myGame.gameScreen.townHandler.getApalachicola().isInTown()) {
					texture = imageLoader.worldMapApalachicola;
				} else if (myGame.gameScreen.townHandler.getStGeorge().isInTown()) {
					texture = imageLoader.worldMapStGeorge;
				} else if (myGame.gameScreen.townHandler.getThePoint().isInTown()) {
					texture = imageLoader.worldMapThePoint;
				} else if (myGame.gameScreen.townHandler.getCapeSanBlas().isInTown()) {
					texture = imageLoader.worldMapCapeSanBlas;
				} else {
					// If player is not in town, just draw map with no icon for now.
					texture = imageLoader.worldMapFake;
				}
			}
			batch.draw(
					texture,
					camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset,
					(camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight + 0.5f,
					camera.viewportWidth - borderShrinkOffset * 2, 
					-camera.viewportHeight
					);
			renderUiNavigationBar(imageLoader.mapNavigationBar, batch);
		}
	}
}
