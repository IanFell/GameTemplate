package gameobjects.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Knight;
import gameobjects.gamecharacters.Player;
import loaders.ImageLoader;
import loaders.cannonballloader.CannonBallLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Cannon extends Weapon {

	// Used to determine when to shoot cannons.
	private int timer = 0;

	// When timer reaches above this value, cannon will fire.
	private int timeToShoot = 50;

	private int direction;

	// Only fire cannon balls if player is within these bounds.
	private Rectangle attackBoundary = new Rectangle();

	private boolean playBlastSound;

	public Knight knight;

	/*
	 * 
	 * @return Rectangle attackBoundary
	 */
	public Rectangle getAttackBoundary() {
		return attackBoundary;
	}

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 * @param int   direction
	 */
	public Cannon(float x, float y, int direction) {
		super(x, y);
		int size              = 4;
		this.width            = size;
		this.height           = size;
		this.direction        = direction; 
		attackBoundary.x      = x - 25;
		attackBoundary.y      = y - 25;
		attackBoundary.width  = 50;
		attackBoundary.height = 50;
		playBlastSound        = false;
		int knightSize        = 1;
		if (direction == DIRECTION_LEFT) {
			knight = new Knight(x + 2.5f, y - knightSize * 2, knightSize, knightSize, direction);
		} else {
			knight = new Knight(x + 0.5f, y - knightSize * 2, knightSize, knightSize, direction);
		}
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isPlayBlastSound() {
		return playBlastSound;
	}

	/**
	 * 
	 * @param boolean playBlastSound
	 */
	public void setPlayBlastSound(boolean playBlastSound) {
		this.playBlastSound = playBlastSound;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		if (timer > timeToShoot) {
			if (attackBoundary.overlaps(myGame.getGameObject(Player.PLAYER_ONE).rectangle)) {
				CannonBallLoader.createCannonBall(this);
				timer          = 0;
				playBlastSound = true;
			}
		}
		timer++;

		// Update knight for collisions with player.
		knight.updateObject(myGame, mapHandler);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		Texture cannonTexture = imageLoader.cannonLeft;
		if (direction == DIRECTION_RIGHT) {
			cannonTexture = imageLoader.cannonRight;
		}
		batch.draw(
				cannonTexture, 
				x, 
				y, 
				width, 
				-height
				);
		if (!knight.isDead()) {
			knight.renderObject(batch, imageLoader);
		}
	}

	/**
	 * 
	 * @return int
	 */
	public int getCannonDirection() {
		return direction;
	}
}
