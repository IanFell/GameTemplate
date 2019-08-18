package particles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.gamecharacters.Player;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class DustParticle extends Particle {

	private boolean setPosition;

	private float initialDx;
	private float initialDy;

	/**
	 * Constructor.
	 * 
	 * @param float  x
	 * @param float  y
	 * @param float  width
	 * @param float  height
	 * @param float  lifeSpan
	 * @param MyGame myGame
	 * @param float  dx
	 * @param float  dy
	 */
	public DustParticle(float x, float y, float width, float height, float lifeSpan, MyGame myGame, float dx, float dy) {
		super(x, y, width, height, lifeSpan);
		this.dx     = dx;
		this.dy     = 0;
		initialDx   = dx;
		initialDy   = dy;
		setPosition = true;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		if (isAlive) {
			int imageChooser = RandomNumberGenerator.generateRandomInteger(3);
			Texture texture = null;
			switch (imageChooser) {
			case 0:
				texture = imageLoader.dustParticleOne;
				break;
			case 1:
				texture = imageLoader.dustParticleTwo;
				break;
			case 2:
				texture = imageLoader.dustParticleThree;
				break;
			}
			batch.draw(
					texture,
					x, 
					y,
					width,
					height
					);
		}
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void updateParticle(MyGame myGame) {
		if (setPosition) {
			x = PlayerController.getCurrentPlayer(myGame).getX();
			y = PlayerController.getCurrentPlayer(myGame).getY();
			setPosition = false;
		}

		switch(Player.getDirection()) {
		case Player.DIRECTION_LEFT:
			initialDx = -dx;
			dy = 0;
			break;
		case Player.DIRECTION_RIGHT:
			initialDx = dx;
			dy = 0;
			break;
		}
		x -= initialDx;
		y -= initialDy;

		if (isAlive) {
			life++;
			if (life > lifeSpan) {
				isAlive = false;
			}
		}
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isAlive() {
		return isAlive;
	}
}
