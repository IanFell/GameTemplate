package physics.Lighting;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import loaders.ImageLoader;

/**
 * Handles game shadows.
 * 
 * @author Fabulous Felini
 *
 */
public class ShadowHandler extends AbstractLightingHandler {

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param GameObject  player
	 */
	@Override
	public void renderLighting(SpriteBatch batch, ImageLoader imageLoader, GameObject player) {
		float offset = 0.5f;
		batch.draw(imageLoader.shadow, player.getX(), player.getY() + offset, width, height);
		handleShadowSizeDuringPlayerJump(player);
	}
	
	/**
	 * This method currently does not do anything.  The above render method needs to reflect
	 * the shadow's y position for this method to work correctly.
	 * 
	 * @param GameObject player
	 */
	private void handleShadowSizeDuringPlayerJump(GameObject player) {
		float sizeAndMovementValue = 0.01f;
		float shadowOffsetValue    = 5 + 0.02f;
		if (Player.jumpingAction == Player.ASCENDING_JUMP) {
			//width  -= sizeAndMovementValue;
			//height -= sizeAndMovementValue;
			y      += sizeAndMovementValue;
			// Shadows behave differently if player is facing down.
			if (player.getDirection() == Player.DIRECTION_DOWN) {
				y += sizeAndMovementValue * shadowOffsetValue;
			}
		} else if (Player.jumpingAction == Player.DESCENDING_JUMP) {
			//width  += sizeAndMovementValue;
			//height += sizeAndMovementValue;
			y      -= sizeAndMovementValue;
			// Shadows behave differently if player is facing down.
			if (player.getDirection() == Player.DIRECTION_DOWN) {
				y -= sizeAndMovementValue * shadowOffsetValue;
			}
		} else {
			// If player has completed jump and is on ground.
			//float originalValue = 1;  
			//width               = originalValue;
			//height              = originalValue;
			// To get code back to how it was, uncomment everything above,
			// comment below line out, and change render to be player.getY() + offset.
			//y = player.getY() + 0.5f;
		}
	}
}

