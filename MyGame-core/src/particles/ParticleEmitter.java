package particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.ColorHelper;
import helpers.RandomNumberGenerator;;

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
	
	private MyGame myGame;
	
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
		this.myGame       = myGame;
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
		float particleSize  = 0.1f;
		float startX;
		float startY;
		float lifeSpan;
		Color color;
		for (int i = 0; i < particles.length; i++) {
			startX          = RandomNumberGenerator.generateRandomNumber((int) (emitterWidth));
			startY          = RandomNumberGenerator.generateRandomNumber((int) (emitterHeight)); 
			lifeSpan        = RandomNumberGenerator.generateRandomNumber(size);
			if (particleType.equalsIgnoreCase("Red")) {
				color = ColorHelper.RED;
			} else if (particleType.equalsIgnoreCase("Yellow")) {
				color = ColorHelper.YELLOW;
			} else {
				color = ColorHelper.ORANGE;
			}
			particles[i] = new Particle(startX, startY, particleSize, particleSize, lifeSpan, color, myGame);
		}
	}
	
	/**
	 * 
	 * @param ShapeRenderer shapeRenderer
	 * @param ParticleType  particleType
	 */
	public void drawParticleEmitter(ShapeRenderer shapeRenderer, String particleType) {
		drawFire(shapeRenderer, particleType);
	}
	
	/**
	 * Draws fire particle effects.
	 * 
	 * @param ShapeRenderer shapeRenderer
	 * @param String        particleType
	 */
	private void drawFire(ShapeRenderer shapeRenderer, String particleType) {
		if (particleType.equalsIgnoreCase("Red")) {
			for (int i = 0; i < redParticles.length; i++) {
				redParticles[i].draw(shapeRenderer);
			}
		}
		if (particleType.equalsIgnoreCase("Yellow")) {
			for (int i = 0; i < yellowParticles.length; i++) {
				yellowParticles[i].draw(shapeRenderer);
			}
		}
		if (particleType.equalsIgnoreCase("Orange")) {
			for (int i = 0; i < orangeParticles.length; i++) {
				orangeParticles[i].draw(shapeRenderer);
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
