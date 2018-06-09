package handlers;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Handles sprite animations.
 * 
 * @author Fabulous Fellini
 *
 */
public class AnimationHandler {

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
			float size
			) {
		batch.draw( 
				animation.getKeyFrame(elapsedTime, true),  
				x,  
				y + 1, 
				size, 
				-size
				);
	}

}
