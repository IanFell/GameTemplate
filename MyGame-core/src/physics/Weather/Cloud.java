package physics.Weather;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
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
		this.x      = x;
		this.y      = y;
		this.width  = width;
		this.height = height;
		this.dx     = -.05f;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(
				imageLoader.cloud, 
				x, 
				y, 
				width, 
				-height
				);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param GameScreen gameScreen
	 */
	public void updateObject(MyGame myGame, GameScreen gameScreen) {
		x += dx; 
		if (x < myGame.getGameObject(Player.PLAYER_ONE).getX() - 20) {
			x = myGame.getGameObject(Player.PLAYER_ONE).getX() + 18;

			// Reset Y positions of clouds if they are behind the camera so it appears more random.
			for (int i = 0; i < gameScreen.getWeatherHandler().cloud.length; i++) {
				gameScreen.getWeatherHandler().cloud[i].setY(
						(float) RandomNumberGenerator.generateRandomDouble(
								myGame.gameObjectLoader.playerOne.getY() - 10, 
								myGame.gameObjectLoader.playerOne.getY() + 10)
						);

				gameScreen.getWeatherHandler().cloud2[i].setY(
						(float) RandomNumberGenerator.generateRandomDouble(
								myGame.gameObjectLoader.playerOne.getY() - 10, 
								myGame.gameObjectLoader.playerOne.getY() + 10)
						);

				gameScreen.getWeatherHandler().cloud3[i].setY(
						(float) RandomNumberGenerator.generateRandomDouble(
								myGame.gameObjectLoader.playerOne.getY() - 10, 
								myGame.gameObjectLoader.playerOne.getY() + 10)
						);

				gameScreen.getWeatherHandler().cloud4[i].setY(
						(float) RandomNumberGenerator.generateRandomDouble(
								myGame.gameObjectLoader.playerOne.getY() - 10, 
								myGame.gameObjectLoader.playerOne.getY() + 10)
						);
			}
		}
	}
}
