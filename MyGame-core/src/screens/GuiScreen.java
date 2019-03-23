package screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.gamecharacters.Player;
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
		myGame.renderer.batch.begin();
		float xPosition = 0f;
		float yPosition = 0f;
		// offsetValue is different depending on player speed (land vs water).
		float offsetValue = 0f;
		if (Player.playerIsMoving) {
			if (Player.isInWater) {
				offsetValue = Player.PLAYER_SPEED - 0.05f;
			} else {
				offsetValue = Player.PLAYER_SPEED;
			}
			switch (PlayerController.getCurrentPlayer(myGame).getDirection()) {
			case Player.DIRECTION_RIGHT:
				xPosition = camera.position.x - getViewportWidth() / denominatorOffset - offsetValue;
				yPosition = camera.position.y - verticalHeight / denominatorOffset + 8;
				break;
			case Player.DIRECTION_LEFT:
				xPosition = camera.position.x - getViewportWidth() / denominatorOffset + offsetValue;
				yPosition = camera.position.y - verticalHeight / denominatorOffset + 8;
				break;
			case Player.DIRECTION_UP:
				xPosition = camera.position.x - getViewportWidth() / denominatorOffset;
				yPosition = camera.position.y - verticalHeight / denominatorOffset + 8 + offsetValue;
				break;
			case Player.DIRECTION_DOWN:
				xPosition = camera.position.x - getViewportWidth() / denominatorOffset;
				yPosition = camera.position.y - verticalHeight / denominatorOffset + 8 - offsetValue;
				break;
			}
		} else {
			xPosition = camera.position.x - getViewportWidth() / denominatorOffset;
			yPosition = camera.position.y - verticalHeight / denominatorOffset + 8;
		}
		batch.draw(
				imageLoader.ui, 
				xPosition, 
				yPosition, 
				camera.viewportWidth, 
				-camera.viewportHeight
				);
		myGame.renderer.batch.end();
	}
}
