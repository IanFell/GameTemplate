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
		if (Player.playerIsMoving) {
			switch (PlayerController.getCurrentPlayer(myGame).getDirection()) {
			case Player.DIRECTION_RIGHT:
				batch.draw(
						imageLoader.ui, 
						camera.position.x - getViewportWidth() / denominatorOffset - Player.PLAYER_SPEED, 
						camera.position.y - verticalHeight / denominatorOffset + 8, 
						camera.viewportWidth, 
						-camera.viewportHeight
						);
				break;
			case Player.DIRECTION_LEFT:
				batch.draw(
						imageLoader.ui, 
						camera.position.x - getViewportWidth() / denominatorOffset + Player.PLAYER_SPEED, 
						camera.position.y - verticalHeight / denominatorOffset + 8, 
						camera.viewportWidth, 
						-camera.viewportHeight
						);
				break;
			case Player.DIRECTION_UP:
				batch.draw(
						imageLoader.ui, 
						camera.position.x - getViewportWidth() / denominatorOffset, 
						camera.position.y - verticalHeight / denominatorOffset + 8 + Player.PLAYER_SPEED, 
						camera.viewportWidth, 
						-camera.viewportHeight
						);
				break;
			case Player.DIRECTION_DOWN:
				batch.draw(
						imageLoader.ui, 
						camera.position.x - getViewportWidth() / denominatorOffset, 
						camera.position.y - verticalHeight / denominatorOffset + 8 - Player.PLAYER_SPEED, 
						camera.viewportWidth, 
						-camera.viewportHeight
						);
				break;
			}
		} else {
			batch.draw(
					imageLoader.ui, 
					camera.position.x - getViewportWidth() / denominatorOffset, 
					camera.position.y - verticalHeight / denominatorOffset + 8, 
					camera.viewportWidth, 
					-camera.viewportHeight
					);
		}
		myGame.renderer.batch.end();
	}
}
