package particles;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;

public class ParticleEmitterTwo extends GameObject {

	private ParticleTwo particle;

	private int timer;
	private int spawnParticleValue;

	//private double lifeSpan;

	private int lifeSpan;

	private float particleSize;


	private ArrayList <ParticleTwo> particles = new ArrayList<ParticleTwo>();

	public ParticleEmitterTwo(MyGame myGame) {
		//particle = new ParticleTwo(0, 0, 1, 1, 20, myGame);
		timer = 0;
		spawnParticleValue = RandomNumberGenerator.generateRandomInteger(25);
		//lifeSpan = RandomNumberGenerator.generateRandomDouble(0.0d, 50.0d);
		lifeSpan = RandomNumberGenerator.generateRandomInteger(10);
		/*
		int ddy = RandomNumberGenerator.generateRandomInteger(2);
		dy = - 0.07f;
		if (ddy < 1) {
			dy = -0.05f;
		} */
		dx = (float) RandomNumberGenerator.generateRandomDouble(0, 0.1);
		dy = (float) RandomNumberGenerator.generateRandomDouble(0, 0.1);
		particleSize = 0.05f;
	}

	public void updateParticles(MyGame myGame) {
		//particle.updateParticle(myGame);
		timer++;
		if (timer > spawnParticleValue) {
			if (Player.playerIsMoving) {
				particles.add(new ParticleTwo(0, 0, particleSize, particleSize, lifeSpan, myGame, dx, dy));
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

	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		//particle.renderObject(batch, shapeRenderer, imageLoader);
		//if (Player.playerIsMoving) {
		if (particles != null) {
			for (int i = 0; i < particles.size(); i++) {
				particles.get(i).renderObject(batch, shapeRenderer, imageLoader);
			}
			//}
		}
	}

}
