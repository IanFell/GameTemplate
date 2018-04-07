package particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.RandomNumberGenerator;

/**
 * Individual particles.  
 * The class ParticleEmitter is how these are instantiated.
 * 
 * @author Fabulous Fellini
 *
 */
public class Particle extends GameObject {
	
	/**
	 * Represents how long particle will live.
	 * This is randomly set upon instantiation.
	 */
	private float lifeSpan;
	
	/**
	 * Represents if particle is alive.
	 */
	private boolean isAlive;
	
	/**
	 * Represents how much time has passed in particle's life.
	 */
	private float life = 0;
	
	/**
	 * Particle color.
	 */
	private Color color;
	
	/**
	 * Speed of side to side movement.
	 */
	private float dx;
	
	/**
	 * Speed of up movement.
	 */
	private float dy;
	
	/**
	 * Constructor.
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
		this.x         = x;
		this.y         = y;
		this.width     = width;
		this.height    = height;
		this.lifeSpan  = lifeSpan;
		this.isAlive   = true;
		this.color     = color;
		this.dx        = RandomNumberGenerator.generateRandomNumber(3);
		this.dy        = RandomNumberGenerator.generateRandomNumber(3);
	}
	
	/**
	 * 
	 * @param ShapeRenderer shapeRenderer
	 */
	@Override
	public void draw(ShapeRenderer shapeRenderer) {
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
		float particleEmitterLength    = particleEmitter.getX() + particleEmitter.getWidth();
		float particleEmitterYPosition = particleEmitter.getY();
		if (isAlive) {
			// If lifeSpan is not over, increase life and move particle up.
			if (life < lifeSpan) {
				life += 2;
				y += dy;
				
				// If particle is past the point of no return, move it to the side, depending on which side it's on.
				int move = RandomNumberGenerator.generateRandomNumber(100);
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
			isAlive    = true;
			x          = RandomNumberGenerator.generateRandomNumber((int) (particleEmitterLength));
			y          = particleEmitterYPosition;
			life       = 0;
		}
	}
}
