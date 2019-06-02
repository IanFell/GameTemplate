package gameobjects.gamecharacters;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import gameobjects.GameObject;

/**
 * This is the parent of:
 * 	- Players
 * 	- Enemies
 * 
 * @author Fabulous Fellini
 *
 */
public class GameCharacter extends GameObject {

	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_UP    = 2;
	public static final int DIRECTION_DOWN  = 3;

	/**
	 * Textures to go with animations.
	 */
	protected TextureAtlas walkDownTexture;
	protected TextureAtlas walkUpTexture;
	protected TextureAtlas walkRightTexture;
	protected TextureAtlas walkLeftTexture;

	/**
	 * Available animations for player object.
	 */
	protected Animation <TextureRegion> walkDownAnimation;
	protected Animation <TextureRegion> walkUpAnimation;
	protected Animation <TextureRegion> walkRightAnimation;
	protected Animation <TextureRegion> walkLeftAnimation;

	/**
	 * Current animation being used in game.
	 */
	protected Animation <TextureRegion> currentAnimation;

	/**
	 * Used for animation speed.
	 */
	protected float elapsedTime = 0;

	// Generic timer used for various tasks depending on class.
	protected int timer = 0;

	public void moveRight(float speed) {}
	public void moveLeft(float speed) {}
	public void moveUp(float speed) {}
	public void moveDown(float speed) {}

	/**
	 * Returns current animation depending on which direction player is facing.
	 * 
	 * @return Animation <TextureRegion>
	 */
	protected Animation <TextureRegion> getCurrentAnimation() {
		switch (direction) {
		case Player.DIRECTION_LEFT:
			currentAnimation = walkLeftAnimation;
			break;
		case Player.DIRECTION_RIGHT:
			currentAnimation = walkRightAnimation;
			break;
		case Player.DIRECTION_UP:
			currentAnimation = walkUpAnimation;
			break;
		case Player.DIRECTION_DOWN:
			currentAnimation = walkDownAnimation;
			break;
		}
		return currentAnimation;
	}
}
