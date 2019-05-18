package particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import helpers.ColorHelper;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;
import physics.Lighting.LightHandler;

/**
 *  
 * @author Fabulous Fellini
 *
 */
public class CloudParticleEmitter extends GameObject {

	private CloudParticle redParticles[]    = new CloudParticle[2000];
	private CloudParticle yellowParticles[] = new CloudParticle[350];
	private CloudParticle orangeParticles[] = new CloudParticle[350];

	/**
	 * Basically represents different colors.
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
	public CloudParticleEmitter(float x, float y, float width, float height, String particleType, MyGame myGame) {
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
	 * 
	 * @param String  particleType
	 * @param Paticle particles
	 * @param int     size
	 * @param MyGame  myGame
	 */
	private void createParticles(String particleType, CloudParticle[] particles, int size, MyGame myGame) {
		float emitterWidth  = x + width;
		float emitterHeight = y + height;
		float particleSize  = 0.04f;
		float startX;
		float startY;
		float lifeSpan;
		for (int i = 0; i < particles.length; i++) {
			startX      = RandomNumberGenerator.generateRandomInteger((int) (emitterWidth));
			startY      = RandomNumberGenerator.generateRandomInteger((int) (emitterHeight)); 
			lifeSpan    = RandomNumberGenerator.generateRandomInteger(size);
			Color color = new Color();
			if (particleType.equalsIgnoreCase("Red")) {
				color = ColorHelper.RED;
			} else if (particleType.equalsIgnoreCase("Yellow")) {
				color = ColorHelper.RED_ORANGE;
			} else if (particleType.equalsIgnoreCase("Orange")) {
				color = ColorHelper.ORANGE;
			}
			particles[i] = new CloudParticle(startX, startY, particleSize, particleSize, lifeSpan, color, myGame);
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
	 * This draws three different particle emitters.
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
				//redParticles[i].renderObject(batch, shapeRenderer, imageLoader);
				batch.draw(imageLoader.whiteSquare, x, y, width, -height);
			}
		}
		if (particleType.equalsIgnoreCase("Yellow")) {
			for (int i = 0; i < yellowParticles.length; i++) {
				//yellowParticles[i].renderObject(batch, shapeRenderer, imageLoader);
				batch.draw(imageLoader.rawbar, x, y, width, -height);
			}
		}
		if (particleType.equalsIgnoreCase("Orange")) {
			for (int i = 0; i < orangeParticles.length; i++) {
				//orangeParticles[i].renderObject(batch, shapeRenderer, imageLoader);
				batch.draw(imageLoader.rawbar, x, y, width, -height);
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

	/**
	 * 
	 * @param MyGame myGame
	 */
	public static void initializeParticleEmitters(MyGame myGame) {
		//int particleStartX   = 1;
		//float particleStaryY = 1;
		//float particleSize   = 0.1f;
		/*
		GameScreen.particleEmitterRed     = new ParticleEmitter(particleStartX, particleStaryY, particleSize, particleSize, "Red", myGame);
		GameScreen.particleEmitterYellow  = new ParticleEmitter(particleStartX, particleStaryY, particleSize, particleSize, "Yellow", myGame);
		GameScreen.particleEmitterOrange  = new ParticleEmitter(particleStartX, particleStaryY, particleSize, particleSize, "Orange", myGame);
		GameScreen.particleEmitterRed.setX(GameScreen.particleEmitterRed.getX());
		GameScreen.particleEmitterYellow.setX(GameScreen.particleEmitterYellow.getX());
		GameScreen.particleEmitterOrange.setX(GameScreen.particleEmitterOrange.getX());
		GameScreen.particleEmitterRed.setY(GameScreen.particleEmitterRed.getY());
		GameScreen.particleEmitterYellow.setY(GameScreen.particleEmitterYellow.getY());
		GameScreen.particleEmitterOrange.setY(GameScreen.particleEmitterOrange.getY());*/
	}

	/**
	 * 
	 * @param MyGame       myGame
	 * @param LightHandler lightHandler
	 */
	public static void updateParticleEmitters(MyGame myGame, LightHandler lightHandler) {
		//GameScreen.particleEmitterRed.updateParticleEmitter(myGame, lightHandler);
		//GameScreen.particleEmitterYellow.updateParticleEmitter(myGame, lightHandler);
		//GameScreen.particleEmitterOrange.updateParticleEmitter(myGame, lightHandler);
	}

	/**
	 * 
	 * @param MyGame        myGame
	 * @param ShapeRenderer shapeRenderer
	 */
	public static void renderParticleEmitters(MyGame myGame, ShapeRenderer shapeRenderer) {
		//GameScreen.particleEmitterRed.renderParticleEmitter(shapeRenderer, "Red", myGame.renderer.batch, myGame.imageLoader);
		//GameScreen.particleEmitterYellow.renderParticleEmitter(shapeRenderer, "Yellow", myGame.renderer.batch, myGame.imageLoader);
		//GameScreen.particleEmitterOrange.renderParticleEmitter(shapeRenderer, "Orange", myGame.renderer.batch, myGame.imageLoader);
	}
}