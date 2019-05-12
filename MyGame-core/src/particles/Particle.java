package particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;

/**
 * Individual particles.  
 * The class ParticleEmitter is how these are instantiated.
 * 
 * @author Fabulous Fellini
 *
 */
public class Particle extends GameObject {

	/**
	 * Represents how long particle will live.  This is randomly set upon instantiation.
	 */
	private float lifeSpan;

	private boolean isAlive;

	/**
	 * Represents how much time has passed in particle's life.
	 */
	private float life = 0;

	private Color color;

	/**
	 * 
	 * @param float  x
	 * @param float  y
	 * @param float  width
	 * @param float  height
	 * @param float  lifeSpan
	 * @param Color  color
	 * @param MyGame myGame
	 */
	public Particle(float x, float y, float width, float height, float lifeSpan, Color color, MyGame myGame) {
		this.x        = x;
		this.y        = y;
		this.width    = width;
		this.height   = height;
		this.lifeSpan = lifeSpan;
		this.isAlive  = true;
		this.color    = color;
		this.dx       = 0.03f;
		this.dy       = 0.1f;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (isAlive) {
			shapeRenderer.setColor(this.color);
			shapeRenderer.rect(x, y, width, height);
		}
	}

	/**
	 * 
	 * @param ParticleEmitter particleEmitter
	 */
	public void updateParticles(ParticleEmitter particleEmitter) {
		float particleEmitterXPosition = particleEmitter.getX();
		float particleEmitterYPosition = particleEmitter.getY();
		float particleEmitterLength    = particleEmitterXPosition + particleEmitter.getWidth();
		float particleEmitterHeight    = particleEmitterYPosition + particleEmitter.getHeight();
		if (isAlive) {
			// If lifeSpan is not over, increase life and move particle up.
			if (life < lifeSpan) {
				life += 3;
				// Make dy value appear more random.
				dy = changeDyValue(dy);
				y -= dy;

				// If particle is past the point of no return, move it to the side, depending on which side it's on.
				int move = RandomNumberGenerator.generateRandomInteger(100);
				if (move < 25) {
					int middlePointOfParticleEmitter = 2;
					if (y > (particleEmitterYPosition + particleEmitter.getHeight()) / middlePointOfParticleEmitter) {
						if (x < (particleEmitterLength) / middlePointOfParticleEmitter) {
							x += dx;
						} else {
							x -= dx;
						}
					}
				}
			} else {
				// If particle older than lifeSpan, kill it.
				isAlive = !isAlive;
			}
		} else {
			// If particle is dead, respawn it with new life in a random location based off particleEmitter's location.
			isAlive = true;
			life    = 0;
			x       = (float) RandomNumberGenerator.generateRandomDouble(
					particleEmitterXPosition, 
					particleEmitterLength
					);
			y          = (float) RandomNumberGenerator.generateRandomDouble(
					particleEmitterYPosition, 
					particleEmitterHeight
					);
		}
	}

	/**
	 * Changes value of dy variable to make particles appear to move more randomly.
	 * 
	 * @param float dy
	 * @return float
	 */
	private float changeDyValue(float dy) {
		float dySpeedFast   = 0.1f;
		float dySpeedMedium = 0.2f;
		if (dy == dySpeedFast) {
			dy = dySpeedMedium;
		} else if (dy == dySpeedMedium) {
			dy = 0.05f;
		} else if (dy == 0.5f) {
			dy = dySpeedFast;
		}
		return dy;
	}
}