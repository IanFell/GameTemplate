package particles;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
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

	private ArrayList <DustParticle> particles = new ArrayList<DustParticle>();

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
				particles.add(new DustParticle(0, 0, particleSize, particleSize, lifeSpan, myGame, dx, dy));
			}
		}
		if (particles != null) {
			for (int i = 0; i < particles.size(); i++) {
				particles.get(i).updateParticle(myGame);
				if (!particles.get(i).isAlive()) {
					particles.remove(i);
				}
			}
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (particles != null) {
			for (int i = 0; i < particles.size(); i++) {
				particles.get(i).renderObject(batch, shapeRenderer, imageLoader);
			}
		}
	}
}
