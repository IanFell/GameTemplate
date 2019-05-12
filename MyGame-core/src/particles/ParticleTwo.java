package particles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import helpers.RandomNumberGenerator;
import loaders.ImageLoader;

public class ParticleTwo extends GameObject {
	
	/**
	 * Represents how long particle will live.  This is randomly set upon instantiation.
	 */
	private float lifeSpan;

	private boolean isAlive;
	
	private Texture texture;
	
	private boolean setPosition;
	
	private float initialDx;
	private float initialDy;

	/**
	 * Represents how much time has passed in particle's life.
	 */
	private float life = 0;
	
	public ParticleTwo(float x, float y, float width, float height, float lifeSpan, MyGame myGame, float dx, float dy) {
		this.x        = x;
		this.y        = y;
		this.width    = width;
		this.height   = height;
		this.lifeSpan = lifeSpan;
		this.isAlive  = true;
		this.dx       = dx;
		this.dy       = 0;
		initialDx = dx;
		initialDy = dy;
		setPosition   = true;
		//this.texture  = myGame.imageLoader.whiteSquare;
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
			int imageChooser = RandomNumberGenerator.generateRandomInteger(3);
			Texture texture = null;
			switch (imageChooser) {
			case 0:
				texture = imageLoader.dustParticleOne;
				break;
			case 1:
				texture = imageLoader.dustParticleTwo;
				break;
			case 2:
				texture = imageLoader.dustParticleThree;
				break;
			}
			/*
			if (imageChooser < 3) {
				texture = imageLoader.dustParticleOne;
			} else if (imageChooser < 2) {
				texture = imageLoader.dustParticleTwo;
			} else {
				texture = imageLoader.dustParticleThree;
			}*/
				batch.draw(
						texture,
						x, 
						y,
						width,
						height
						);
		}
	}
	
	public void updateParticle(MyGame myGame) {
		if (setPosition) {
			x = PlayerController.getCurrentPlayer(myGame).getX();
			y = PlayerController.getCurrentPlayer(myGame).getY();
			setPosition = false;
		}
		
		switch(Player.getDirection()) {
		case Player.DIRECTION_LEFT:
			initialDx = -dx;
			dy = 0;
			break;
		case Player.DIRECTION_RIGHT:
			initialDx = dx;
			dy = 0;
			break;
		}
		x -= initialDx;
		y -= initialDy;
		
		if (isAlive) {
			life++;
			if (life > lifeSpan) {
				isAlive = false;
			}
		}
	}

	public boolean isAlive() {
		return isAlive;
	}
}
