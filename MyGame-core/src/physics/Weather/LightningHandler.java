package physics.Weather;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.ColorHelper;
import helpers.GameAttributeHelper;
import loaders.ImageLoader;
import maps.MapEditor;

/**
 * Handles in game lightning flashes.
 * 
 * @author Fabulous Fellini
 *
 */
public class LightningHandler extends GameObject {
	
	public boolean lightningBoltShouldBeRendered = false;
	
	
	
	/**
	 * Maximum number of lightning flashes that can happen during one rain cycle.
	 */
	private int maxNumberOfFlashes = 3;
	
	/**
	 * Keeps track of how many flashes have happened in current rain cycle.
	 */
	private int currentNumberOfFlashes = 0;
	
	private boolean lightningShouldBeRendered = false;
	
	/**
	 * Time in millisecondes between lightning flashes.
	 */
	private int timeBetweenFlashes = 15;
	
	/**
	 * Works with timeBetweenFlashes to determine when lightning should flash.
	 */
	private int increment = 0;
	
	/**
	 * Construct.
	 */
	public LightningHandler() {
		this.x      = 0;
		this.y      = 0;
		this.width  = GameAttributeHelper.SCREEN_WIDTH;
		this.height = GameAttributeHelper.SCREEN_HEIGHT;
	}
	
	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (lightningShouldBeRendered) {
			shapeRenderer.setColor(ColorHelper.WHITE);
			shapeRenderer.rect(x, y, width, height);
		}
	}
	
	/**
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	@Override
	public void updateObject(MyGame myGame, MapEditor mapEditor) {
		if (RainHandler.isRaining && currentNumberOfFlashes <= maxNumberOfFlashes) {
			increment++;
			if (increment >= timeBetweenFlashes) {
				increment = 0;
				currentNumberOfFlashes++;
				
				if (currentNumberOfFlashes == 2) {
					timeBetweenFlashes = 50;
				}
			}
		} else {
			currentNumberOfFlashes = 0;
			timeBetweenFlashes     = 15;
		}
	}

	/**
	 * 
	 * @return int
	 */
	public int getCurrentNumberOfFlashes() {
		return currentNumberOfFlashes;
	}
}
