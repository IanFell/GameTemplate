package worldmapui;

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
	 */
	public void renderWorldMapUi(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader, MyGame myGame) {
		if (mapShouldBeRendered) {
			int borderShrinkOffset = 1;
			Texture texture = null;
			
			// Make map look like player location is flashing.
			// This is the "unflashed" map.
			if (timer < 12) {
				texture = imageLoader.worldMapFake;
			} else {
				// This is the "flashed" map.
				if (myGame.gameScreen.mexicoBeach.isInTown) {
					texture = imageLoader.worldMapMexicoBeach;
				} else if (myGame.gameScreen.portStJoe.isInTown) {
					texture = imageLoader.worldMapPortStJoe;
				}
				
				
				else {
					texture = imageLoader.worldMapFake;
				}
			}
			batch.draw(
					texture,
					camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset,
					(camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight,
					camera.viewportWidth - borderShrinkOffset * 2, 
					-camera.viewportHeight
					);
		}
	}
}
