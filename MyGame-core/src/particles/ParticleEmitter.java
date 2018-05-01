package particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.ColorHelper;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;
import physics.LightHandler;

/**
 * Loads and draw particle effects.  
 * For instance, this class contains three sets of Particle arrays and draws fire:
 * 	-Particle array one   = red
 *  -Particle array two   = yellow
 *  -Particle array three = orange
 *  
 * @author Fabulous Fellini
 *
 */
public class ParticleEmitter extends GameObject {
	
	/**
	 * Array of red particles.
	 */
	private Particle redParticles[] = new Particle[100];
	
	/**
	 * Array of yellow particles.
	 */
	private Particle yellowParticles[] = new Particle[75];
	
	/**
	 * Array of orange particles.
	 */
	private Particle orangeParticles[] = new Particle[75];
	
	/**
	 * Type of particle.  This represents different colors basically.
	 */
	private String particleType;
	
	/**
	 * 
	 * @param float  x
	 * @param float  y
	 * @param float  width
	 * @param float  height
	 * @param String particleType
	 * @param MyGame myGame
	 */
	public ParticleEmitter(float x, float y, float width, float height, String particleType, MyGame myGame) {
		this.x            = x;
		this.y            = y;
		this.width        = width;
		this.height       = height;
		this.particleType = particleType;
		createParticles("Red", redParticles, 150, myGame);
		createParticles("Yellow", yellowParticles, 100, myGame);
		createParticles("Orange", orangeParticles, 100, myGame);
	}
	
	/**
	 * Creates particles for particle emitter.
	 * 
	 * @param String  particleType
	 * @param Paticle particles
	 * @param int     size
	 * @param MyGame  myGame
	 */
	private void createParticles(String particleType, Particle[] particles, int size, MyGame myGame) {
		float emitterWidth  = x + width;
		float emitterHeight = y + height;
		float particleSize  = 0.07f;
		float startX;
		float startY;
		float lifeSpan;
		for (int i = 0; i < particles.length; i++) {
			startX          = RandomNumberGenerator.generateRandomInteger((int) (emitterWidth));
			startY          = RandomNumberGenerator.generateRandomInteger((int) (emitterHeight)); 
			lifeSpan        = RandomNumberGenerator.generateRandomInteger(size);
			Color color = new Color();
			if (particleType.equalsIgnoreCase("Red")) {
				color = ColorHelper.RED;
			} else if (particleType.equalsIgnoreCase("Yellow")) {
				color = ColorHelper.YELLOW;
			} else if (particleType.equalsIgnoreCase("Orange")) {
				color = ColorHelper.ORANGE;
			}
			particles[i] = new Particle(startX, startY, particleSize, particleSize, lifeSpan, color, myGame);
		}
	}
	
	/**
	 * 
	 * @param ShapeRenderer shapeRenderer
	 * @param String        particleType
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	public void renderParticleEmitter(
			ShapeRenderer shapeRenderer, 
			String particleType, 
			SpriteBatch batch, 
			ImageLoader imageLoader
			) {
		drawFire(shapeRenderer, particleType, batch, imageLoader);
	}
	
	/**
	 * Draws fire particle effects.
	 * 
	 * @param ShapeRenderer shapeRenderer
	 * @param String        particleType
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	private void drawFire(
			ShapeRenderer shapeRenderer, 
			String particleType, 
			SpriteBatch batch, 
			ImageLoader imageLoader
			) {
		if (particleType.equalsIgnoreCase("Red")) {
			for (int i = 0; i < redParticles.length; i++) {
				redParticles[i].renderObject(batch, shapeRenderer, imageLoader);
			}
		}
		if (particleType.equalsIgnoreCase("Yellow")) {
			for (int i = 0; i < yellowParticles.length; i++) {
				yellowParticles[i].renderObject(batch, shapeRenderer, imageLoader);
			}
		}
		if (particleType.equalsIgnoreCase("Orange")) {
			for (int i = 0; i < orangeParticles.length; i++) {
				orangeParticles[i].renderObject(batch, shapeRenderer, imageLoader);
			}
		}
	}
	
	/**
	 * 
	 * @param MyGame       myGame
	 * @param LightHandler lightHandler
	 */
	public void updateParticleEmitter(MyGame myGame, LightHandler lightHandler) {
		if (particleType.equalsIgnoreCase("Red")) {
			for (int i = 0; i < redParticles.length; i++) {
				redParticles[i].updateParticles(this);
			}
		}
		if (particleType.equalsIgnoreCase("Yellow")) {
			for (int i = 0; i < yellowParticles.length; i++) {
				yellowParticles[i].updateParticles(this);
			}
		}
		if (particleType.equalsIgnoreCase("Orange")) {
			for (int i = 0; i < orangeParticles.length; i++) {
				orangeParticles[i].updateParticles(this);
			}
		}
	}
}
