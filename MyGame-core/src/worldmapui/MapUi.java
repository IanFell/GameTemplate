package worldmapui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
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
	
	private float playerX = 0;
	private float playerY = 0;

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
		playerX = PlayerController.getCurrentPlayer(myGame).getX();
		playerY = PlayerController.getCurrentPlayer(myGame).getY();
		updatePlayerLocationIcon();
	}
	
	private void updatePlayerLocationIcon() {
		determineIfPlayerIsInTown();
	}
	
	private void determineIfPlayerIsInTown() {
		
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	public void renderWorldMapUi(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (mapShouldBeRendered) {
			int borderShrinkOffset = 1;
			batch.draw(
					imageLoader.worldMapFake,
					camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset,
					(camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight,
					camera.viewportWidth - borderShrinkOffset * 2, 
					-camera.viewportHeight
					);
			// Make player location icon flash.
			if (timer < 12) {
				renderPlayerLocationOnMap(batch, shapeRenderer, imageLoader);
			}
		}
	}
	
	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	private void renderPlayerLocationOnMap(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.whiteSquare,
				playerX,
				playerY,
				1, 
				1
				);
	}
}
