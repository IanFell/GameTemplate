package particles;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class DustParticleEmitter extends GameObject {

	private ArrayList <DustParticle> particlesRight = new ArrayList<DustParticle>();
	private ArrayList <DustParticle> particlesLeft  = new ArrayList<DustParticle>();

	private int timer;
	private int spawnParticleValue;
	private int lifeSpan;
	private float particleSize;

	/**
	 * Constructor.
	 */
	public DustParticleEmitter() {
		timer              = 0;
		spawnParticleValue = RandomNumberGenerator.generateRandomInteger(15);
		lifeSpan           = RandomNumberGenerator.generateRandomInteger(10);
		dx                 = (float) RandomNumberGenerator.generateRandomDouble(0, 0.1);
		dy                 = (float) RandomNumberGenerator.generateRandomDouble(0, 0.1);
		particleSize       = 0.05f;
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	public void updateParticles(MyGame myGame) {
		timer++;
		if (timer > spawnParticleValue) {
			if (Player.playerIsMoving) {
				particlesRight.add(new DustParticle(0, 0, particleSize, particleSize, lifeSpan, myGame, dx, dy));
				particlesLeft.add(new DustParticle(0, 0, particleSize, particleSize, lifeSpan, myGame, dx, -dy));
			}
		}
		if (particlesRight != null) {
			for (int i = 0; i < particlesRight.size(); i++) {
				particlesRight.get(i).updateParticle(myGame);
				particlesLeft.get(i).updateParticle(myGame);
				if (!particlesRight.get(i).isAlive()) {
					particlesRight.remove(i);
					particlesLeft.remove(i);
				}
			}
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		int direction = Player.direction;
		if (particlesRight != null && direction == Player.DIRECTION_LEFT || direction == Player.DIRECTION_RIGHT) {
			for (int i = 0; i < particlesRight.size(); i++) {
				particlesRight.get(i).renderObject(batch, imageLoader);
				particlesLeft.get(i).renderObject(batch, imageLoader);
			}
		}
	}
}
