package handlers;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import gameobjects.gamecharacters.Player;
import loaders.ImageLoader;
import physics.Weather.NightAndDayCycle;
import tiles.Tile;

/**
 * Handles sprite animations.
 * 
 * @author Fabulous Fellini
 *
 */
public class AnimationHandler {

	public final static int OBJECT_TYPE_PLAYER = 0;
	public final static int OBJECT_TYPE_ENEMY  = 1;

	/**
	 * y + 1 is used because we need to flip the sprite batch vertically.  
	 * When we do this, player is offset by 1 on the y axis so we need to compensate.
	 * We flip the y axis by making the height negative.
	 * 
	 * @param SpriteBatch               batch
	 * @param flat                      elapsedTime
	 * @param Animation <TextureRegion> animation
	 * @param float					    x
	 * @param float 					y
	 * @param float   					size
	 */
	public static void renderAnimation(
			SpriteBatch batch, 
			float elapsedTime, 
			Animation <TextureRegion> animation, 
			float x, 
			float y, 
			float size,
			ImageLoader imageLoader,
			int objectType
			) {
		batch.draw( 
				animation.getKeyFrame(elapsedTime, true),  
				x,  
				y, 
				size, 
				-size * 2
				);


		if (objectType == OBJECT_TYPE_PLAYER) {
			// If player is swimming, mask him with a water tile below his head.
			if (Player.isInWater) {
				batch.draw(imageLoader.waterTileOne, x, y, size, -size);
				// If it is night time, draw a transparant black shader over the tile.
				if (!NightAndDayCycle.isDayTime()) {
					batch.draw(Tile.nightTimeTexture, x, y, size, -size);
				}
			}
		}
	}
}
