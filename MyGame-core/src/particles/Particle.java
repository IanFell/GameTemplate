package particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
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
	 * ShapeRenderer to draw particles.
	 */
	private ShapeRenderer shapeRenderer = new ShapeRenderer();
	
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
	 * @param float x
	 * @param float y
	 * @param float width
	 * @param float height
	 * @param float lifeSpan
	 * @param Color color
	 */
	public Particle(float x, float y, float width, float height, float lifeSpan, Color color) {
		this.x         = x;
		this.y         = y;
		this.width     = width;
		this.height    = height;
		this.lifeSpan  = lifeSpan;
		this.isAlive   = true;
		this.color     = color;
		this.dx        = RandomNumberGenerator.random.nextInt(3);
		this.dy        = RandomNumberGenerator.random.nextInt(3);
		this.shapeRenderer.setColor(this.color);
	}
	
	@Override
	public void draw(SpriteBatch batch) {}
	
	/**
	 * 
	 * @param SpriteBatch batch
	 */
	
	public void drawParticle(SpriteBatch batch) {
		if (isAlive) {
			shapeRenderer.begin(ShapeType.Filled);
			shapeRenderer.rect(x, y, width, height);
			shapeRenderer.end();
		}
	}
	
	/**
	 * 
	 * @param ParticleEmitter particleEmitter
	 */
	public void updateParticles(ParticleEmitter particleEmitter) {
		if (isAlive) {
			// If lifeSpan is not over, increase life and move particle up.
			if (life < lifeSpan) {
				life += 2;
				y += dy;
				
				// If particle is past the point of no return, move it to the side, depending on which side it's on.
				int move = RandomNumberGenerator.random.nextInt(100);
				if (move < 25) {
					if (y > (particleEmitter.getY() + particleEmitter.getHeight()) / 2) {
						if (x < (particleEmitter.getX() + particleEmitter.getWidth()) / 2) {
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
			int startX = RandomNumberGenerator.random.nextInt((int) (particleEmitter.getX() + particleEmitter.getWidth()));
			x          = startX;
			y          = particleEmitter.getY();
			life       = 0;
		}
	}
}
