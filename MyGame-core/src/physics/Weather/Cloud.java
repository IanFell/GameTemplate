package physics.Weather;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import helpers.ColorHelper;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;
import particles.CloudParticle;
import screens.GameScreen;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Cloud extends GameObject {

	public CloudParticle particle;

	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 * @param float  x
	 * @param float  y
	 * @param float  width
	 * @param float  height
	 */
	public Cloud(MyGame myGame, float x, float y, float width, float height) {
		this.x        = x;
		this.y        = y;
		this.width    = width;
		this.height   = height;
		this.dx       = -.05f;
		this.particle = new CloudParticle(
				x, 
				y, 
				width, 
				height, 
				0, 
				Color.WHITE, 
				myGame
				);
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 * @param int           shape
	 */
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader, int shape) {
		shapeRenderer.setColor(ColorHelper.CLOUD_COLOR);
		if (shape % 2 == 0) {
			shapeRenderer.ellipse(x, y, width, height);
		} else {
			shapeRenderer.rect(x, y, width, height);
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param GameScreen gameScreen
	 */
	public void updateObject(MyGame myGame, GameScreen gameScreen) {
		x += dx; 
		if (x < myGame.getGameObject(Player.PLAYER_ONE).getX() - 10) {
			x = myGame.getGameObject(Player.PLAYER_ONE).getX() + 12;

			for (int i = 0; i < 250; i++) {
				gameScreen.getWeatherHandler().cloud[i].setY(
						(float) RandomNumberGenerator.generateRandomDouble(
								myGame.gameObjectLoader.playerOne.getY() + 2, 
								myGame.gameObjectLoader.playerOne.getY() + 2.5)
						);

				gameScreen.getWeatherHandler().cloud2[i].setY(
						(float) RandomNumberGenerator.generateRandomDouble(
								myGame.gameObjectLoader.playerOne.getY() -1, 
								myGame.gameObjectLoader.playerOne.getY() -1.5)
						);

				gameScreen.getWeatherHandler().cloud3[i].setY(
						(float) RandomNumberGenerator.generateRandomDouble(
								myGame.gameObjectLoader.playerOne.getY() -1.5, 
								myGame.gameObjectLoader.playerOne.getY() -2)
						);

				gameScreen.getWeatherHandler().cloud4[i].setY(
						(float) RandomNumberGenerator.generateRandomDouble(
								myGame.gameObjectLoader.playerOne.getY() -3.5, 
								myGame.gameObjectLoader.playerOne.getY() -4)
						);
			}
		}
	}
}
