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

	public final static int OBJECT_TYPE_PLAYER    = 0;
	public final static int OBJECT_TYPE_ENEMY     = 1;
	public final static int OBJECT_TYPE_EXPLOSION = 2;
	public final static int OBJECT_TYPE_FIRE      = 3;
	public final static int OBJECT_TYPE_LOOT      = 4;
	public static final int OBJECT_TYPE_FLOWER    = 5;
	public static final int OBJECT_TYPE_BIRD      = 6;

	public final static float ANIMATION_SPEED_PLAYER              = 7/15f;
	public final static float ANIMATION_SPEED_PLAYER_DESCEND_JUMP = 1/15f;
	public final static float ANIMATION_SPEED_ENEMY               = 7/15f;
	public final static float ANIMATION_SPEED_EXPLOSIOIN          = 1/15f;
	public final static float ANIMATION_SPEED_FIRE                = 1/15f;
	public final static float ANIMATION_SPEED_LOOT                = 4/15f;
	public final static float ANIMATION_SPEED_FLOWER              = 5/15f;
	public final static float ANIMATION_SPEED_BIRD                = 4/15f;


	/**
	 * 
	 * @param SpriteBatch               batch
	 * @param flat                      elapsedTime
	 * @param Animation <TextureRegion> animation
	 * @param float					    x
	 * @param float 					y
	 * @param float   					width
	 * @param float                     height
	 * @param ImageLoader               imageLoader
	 * @param int                       objectType
	 */
	public static void renderAnimation(
			SpriteBatch batch, 
			float elapsedTime, 
			Animation <TextureRegion> animation, 
			float x, 
			float y, 
			float width,
			float height,
			ImageLoader imageLoader,
			int objectType
			) {
		batch.draw( 
				animation.getKeyFrame(elapsedTime, true),  
				x,  
				y, 
				width, 
				-height
				);


		if (objectType == OBJECT_TYPE_PLAYER) {
			// If player is swimming, mask him with a water tile below his head.
			if (Player.isInWater) {
				batch.draw(imageLoader.waterTileOne, x, y, width, -height / 2);
				/**
				 * If it is night time, draw a transparant black shader over the tile.
				 * If we don't do this, the overlapping water tile will not be tinted.
				 */
				if (!NightAndDayCycle.isDayTime()) {
					batch.draw(Tile.nightTimeTexture, x, y, width, -height);
				}
			}
		}
	}
}
