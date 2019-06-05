package ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class HealthUi {

	private final int MAX_HEARTS_TO_DISPLAY_ON_SCREEN = 80;

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 * @param MyGame        myGame
	 */
	public void renderHealthUi(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader, MyGame myGame) {
		int xIncrement       = 0;
		int yIncrement       = 0;
		GameObject player    = PlayerController.getCurrentPlayer(myGame);
		int size             = 1;
		int topRightCorner   = 26;
		int bottomRightCorer = 40;
		int bottomLeftCorner = 66;

		// Render the hearts in a square around the perimeter of the screen, starting from the top left.
		for (int i = 0; i < player.getHealth(); i++) {
			if (i < topRightCorner) {
				xIncrement++;
			} else if (i < bottomRightCorer) {
				yIncrement++;
			} else if (i < bottomLeftCorner)  {
				xIncrement--;
			} else {
				yIncrement--;
			}
			batch.draw(
					imageLoader.heart,
					player.getX() - 13.5f + xIncrement,
					player.getY() - 6.5f + yIncrement,
					size, 
					-size
					);
			// If we wrap around, reset and wrap again.
			if (i >= MAX_HEARTS_TO_DISPLAY_ON_SCREEN) {
				xIncrement = 0;
				yIncrement = 0;
			}
		}
	}
}
