package particles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.ColorHelper;
import helpers.RandomNumberGenerator;

/**
 * Loads and draw particle effects.  
 * For instance, this class contains three sets of Particle arrays and draws fire:
 * 	-Particle array one   = red
 *  -Particle array two   = yellow
 *  -Particle array three = orange
 *  \
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
	 */
	public ParticleEmitter(float x, float y, float width, float height, String particleType) {
		this.x            = x;
		this.y            = y;
		this.width        = width;
		this.height       = height;
		this.particleType = particleType;
		
		float emitterWidth  = x + width;
		float emitterHeight = y + height;
		float particleSize  = 1.0f;
		if (this.particleType.equalsIgnoreCase("Red")) {
			for (int i = 0; i < redParticles.length; i++) {
				float startX    = RandomNumberGenerator.generateRandomNumber((int) (emitterWidth));
				float startY    = RandomNumberGenerator.generateRandomNumber((int) (emitterHeight)); 
				float lifeSpan  = RandomNumberGenerator.generateRandomNumber(150);
				redParticles[i] = new Particle(startX, startY, particleSize, particleSize, lifeSpan, ColorHelper.RED);
			}
		}
		if (this.particleType.equalsIgnoreCase("Yellow")) {
			for (int i = 0; i < yellowParticles.length; i++) {
				float startX       = RandomNumberGenerator.generateRandomNumber((int) (emitterWidth));
				float startY       = RandomNumberGenerator.generateRandomNumber((int) (emitterHeight)); 
				float lifeSpan     = RandomNumberGenerator.generateRandomNumber(100);
				yellowParticles[i] = new Particle(startX, startY, particleSize, particleSize, lifeSpan, ColorHelper.YELLOW);
			}
		}
		if (this.particleType.equalsIgnoreCase("Orange")) {
			for (int i = 0; i < orangeParticles.length; i++) {
				float startX       = RandomNumberGenerator.generateRandomNumber((int) (emitterWidth));
				float startY       = RandomNumberGenerator.generateRandomNumber((int) (emitterHeight)); 
				float lifeSpan     = RandomNumberGenerator.generateRandomNumber(100);
				orangeParticles[i] = new Particle(startX, startY, particleSize, particleSize, lifeSpan, ColorHelper.ORANGE);
			}
		}
	}
	
	/**
	 * 
	 * @param SpriteBatch  batch
	 * @param ParticleType particleType
	 */
	public void drawParticleEmitter(SpriteBatch batch, String particleType) {
		drawFire(batch, particleType);
	}
	
	/**
	 * Draws fire particle effects.
	 * 
	 * @param SpriteBatch batch
	 * @param String      particleType
	 */
	private void drawFire(SpriteBatch batch, String particleType) {
		if (particleType.equalsIgnoreCase("Red")) {
			for (int i = 0; i < redParticles.length; i++) {
				redParticles[i].draw(batch);
			}
		}
		if (particleType.equalsIgnoreCase("Yellow")) {
			for (int i = 0; i < yellowParticles.length; i++) {
				yellowParticles[i].draw(batch);
			}
		}
		if (particleType.equalsIgnoreCase("Orange")) {
			for (int i = 0; i < orangeParticles.length; i++) {
				orangeParticles[i].draw(batch);
			}
		}
	}
	
	/**
	 * 
	 * @param MyGame myGame
	 */
	public void updateParticleEmitter(MyGame myGame) {	
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
