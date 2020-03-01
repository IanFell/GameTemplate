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
			animation = walkLeftAnimation;
			break;
		case Player.DIRECTION_RIGHT:
			animation = walkRightAnimation;
			break;
		case Player.DIRECTION_UP:
			animation = walkUpAnimation;
			break;
		case Player.DIRECTION_DOWN:
			animation = walkDownAnimation;
			break;
		}
		return animation;
	}
}
