package gameobjects.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.mygame.MyGame;

import gameobjects.gamecharacters.Player;
import handlers.AnimationHandler;
import handlers.CollisionHandler;
import inventory.Inventory;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class BirdWeapon extends Weapon {

	public static boolean birdIsAttacking = false;

	private TextureAtlas textureAtlasLeft;
	private TextureAtlas textureAtlasRight;

	private Animation <TextureRegion> animationLeft;
	private Animation <TextureRegion> animationRight;

	private int direction;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 */
	public BirdWeapon(float x, float y) {
		super(x, y);
		int size          = 1;
		this.width        = size;
		this.height       = size;
		rectangle.width   = width;
		rectangle.height  = height;
		hasBeenCollected  = false;
		textureAtlasLeft  = new TextureAtlas(Gdx.files.internal("artwork/animals/birdLeft.atlas"));
		textureAtlasRight = new TextureAtlas(Gdx.files.internal("artwork/animals/birdRight.atlas"));
		animationLeft     = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_BIRD, textureAtlasLeft.getRegions());
		animationRight    = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_BIRD, textureAtlasRight.getRegions());
		direction         = Player.direction;
		hasBeenCollected  = false;
		dx                = 0;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		direction = Player.direction;
		x += dx;
		rectangle.x = x;
		rectangle.y = y;

		if (birdIsAttacking) {
			dx += 1;
		} else {
			dx = 0;
		}

		if (!hasBeenCollected) {
			CollisionHandler.checkIfPlayerHasCollidedWithBirdWeapon(myGame.getGameObject(Player.PLAYER_ONE), this);
		} else {
			// Bird can kill enemies even if he is just sitting on the player's shoulder.
			myGame.gameScreen.enemyHandler.checkProjectileCollision(myGame, this);
			myGame.gameScreen.gruntHandler.checkProjectileCollision(myGame, this);
		}
	}

	/**
	 * 
	 * @param SpriteBatch  batch
	 * @param ImageLoader  imageLoader
	 * @param MyGame       myGame
	 */
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		updateElapsedTime();
		Animation <TextureRegion> animation = animationLeft;
		if (direction == Player.DIRECTION_RIGHT) {
			animation = animationRight;
		}

		if (!hasBeenCollected) {
			AnimationHandler.renderAnimation(
					batch, 
					elapsedTime, 
					animation, 
					x, 
					y, 
					width, 
					height,
					imageLoader, 
					AnimationHandler.OBJECT_TYPE_BIRD
					);
		} else if ((myGame.getGameObject(Player.PLAYER_ONE).getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) == this && Inventory.inventoryIsEquipped) || Inventory.allInventoryShouldBeRendered) {
			if (Inventory.allInventoryShouldBeRendered) {
				// Force bird to face right if inventory is open.
				AnimationHandler.renderAnimation(
						batch, 
						elapsedTime, 
						animationRight, 
						x, 
						y, 
						width, 
						height,
						imageLoader, 
						AnimationHandler.OBJECT_TYPE_BIRD
						);
			} else {
				AnimationHandler.renderAnimation(
						batch, 
						elapsedTime, 
						animation, 
						x, 
						y, 
						width, 
						height,
						imageLoader, 
						AnimationHandler.OBJECT_TYPE_BIRD
						);
			}
			//renderHitBox(batch, imageLoader);
		}
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	private void renderHitBox(SpriteBatch batch, ImageLoader imageLoader) {
		batch.draw(imageLoader.whiteSquare, rectangle.x, rectangle.y, rectangle.width, -rectangle.height);
	}
}
