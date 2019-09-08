package screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import loaders.ImageLoader;

/**
 * Screen for graphical user interface.
 * 
 * @author Fabulous Fellini
 *
 */
public class GuiScreen extends Screens {

	/**
	 * 
	 * @param MyGame myGame
	 */
	public GuiScreen(MyGame myGame) {
		super(myGame);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	public void render(SpriteBatch batch, ImageLoader imageLoader) {
		/*
		float xPosition = 0f;
		float yPosition = 0f;
		// offsetValue is different depending on player speed (land vs water).
		float offsetMovementValue = 0f;
		int offsetYValue          = 15;
		if (Player.playerIsMoving) {
			if (Player.isInWater) {
				offsetMovementValue = Player.PLAYER_SPEED - 0.05f;
			} else {
				offsetMovementValue = Player.PLAYER_SPEED;
			}
			switch (Player.direction) {
			case Player.DIRECTION_RIGHT:
				xPosition = camera.position.x - getViewportWidth() / denominatorOffset - offsetMovementValue;
				yPosition = camera.position.y - verticalHeight / denominatorOffset + offsetYValue;
				break;
			case Player.DIRECTION_LEFT:
				xPosition = camera.position.x - getViewportWidth() / denominatorOffset + offsetMovementValue;
				yPosition = camera.position.y - verticalHeight / denominatorOffset + offsetYValue;
				break;
			case Player.DIRECTION_UP:
				xPosition = camera.position.x - getViewportWidth() / denominatorOffset;
				yPosition = camera.position.y - verticalHeight / denominatorOffset + offsetYValue + offsetMovementValue;
				break;
			case Player.DIRECTION_DOWN:
				xPosition = camera.position.x - getViewportWidth() / denominatorOffset;
				yPosition = camera.position.y - verticalHeight / denominatorOffset + offsetYValue - offsetMovementValue;
				break;
			}
		} else {
			xPosition = camera.position.x - getViewportWidth() / denominatorOffset;
			yPosition = camera.position.y - verticalHeight / denominatorOffset + offsetYValue;
		} */
		/*
		batch.draw(
				imageLoader.ui, 
				xPosition, 
				yPosition, 
				camera.viewportWidth, 
				-camera.viewportHeight
				); */
	}
}
