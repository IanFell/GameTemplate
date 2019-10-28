package gameobjects.weapons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.gamecharacters.PlayerOne;
import handlers.CollisionHandler;
import inventory.Inventory;
import loaders.ImageLoader;
import maps.MapHandler;
import missions.MissionRawBar;
import screens.GameScreen;
import ui.MapUi;

/**
 * This weapon acts like a boomerang.
 * 
 * @author Fabulous Fellini
 *
 */
public class MagicPearl extends Weapon {

	public static boolean isAttacking;
	public static boolean hasReachedPeakDistance;
	public static boolean isMovingForward;
	public static boolean isMovingBackward;

	// This hitbox is bigger than the object to ensure player catches it upon return.
	private Rectangle collisionWithPlayerUponReturnHitbox;
	
	public static boolean playCollectionSound = false;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 */
	public MagicPearl(float x, float y) {
		super(x, y);
		int size                            = 1;
		this.width                          = size;
		this.height                         = size;
		collisionWithPlayerUponReturnHitbox = new Rectangle(0, 0, width + 2, height + 2);
		rectangle.width                     = width;
		rectangle.height                    = height;
		hasBeenCollected                    = false;
		isAttacking                         = false;
		hasReachedPeakDistance              = false;
		isMovingForward                     = false;
		isMovingBackward                    = false;
		dx                                  = 0;
		dy                                  = 0;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		if (MissionRawBar.rawBarMissionComplete) {
			collisionWithPlayerUponReturnHitbox.x = x - 1;
			collisionWithPlayerUponReturnHitbox.y = y - 1;
			rectangle.x                           = x;
			rectangle.y                           = y;

			if (!hasBeenCollected) {
				CollisionHandler.checkIfPlayerHasCollidedWithMagicPearl(myGame.getGameObject(Player.PLAYER_ONE), this);
			} else {
				// Player has just thrown pearl.
				if (isAttacking && isMovingForward) {
					myGame.gameScreen.enemyHandler.checkProjectileCollision(myGame, this);
					switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
					case Player.DIRECTION_RIGHT:
						dx = 1;
						dy = 0;
						x += dx;
						y += dy;
						break;
					case Player.DIRECTION_LEFT:
						dx = 1;
						dy = 0;
						x -= dx;
						y += dy;
						break;
					case Player.DIRECTION_DOWN:
						dx = 0;
						dy = 1;
						x += dx;
						y += dy;
						break;
					case Player.DIRECTION_UP:
						dx = 0;
						dy = 1;
						x += dx;
						y -= dy;
						break;
					}	
				} else if (hasReachedPeakDistance && isMovingBackward) {
					// Pearl has reached it's peak and is moving back towards player. 
					switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
					case Player.DIRECTION_RIGHT:
						dx = 1;
						dy = 0;
						x -= dx;
						y += dy;
						break;
					case Player.DIRECTION_LEFT:
						dx = 1;
						dy = 0;
						x += dx;
						y += dy;
						break;
					case Player.DIRECTION_DOWN:
						dx = 0;
						dy = 1;
						x += dx;
						y -= dy;
						break;
					case Player.DIRECTION_UP:
						dx = 0;
						dy = 1;
						x += dx;
						y += dy;
						break;
					}	

					// Pearl has returned to player.  Get it ready to throw again.
					if (collisionWithPlayerUponReturnHitbox.overlaps(myGame.getGameObject(Player.PLAYER_ONE).rectangle)) {
						isAttacking      = false;
						isMovingBackward = false;
						isMovingForward  = false;
					}
				}
			}
		}
	}
	
	/**
	 * Determines if game object is rendering bounds.
	 * 
	 * @param GameObject gameObject
	 * @return boolean
	 */
	public static boolean gameObjectIsWithinScreenBounds(GameObject gameObject) {
		float cameraXPosition   = GameScreen.camera.position.x;
		float cameraYPosition   = GameScreen.camera.position.y;
		float playerXPosition   = gameObject.getX();
		float playerYPosition   = gameObject.getY();
		float screenBoundOffset = 17.0f;
		if (
				playerXPosition < cameraXPosition + screenBoundOffset &&
				playerXPosition > cameraXPosition - screenBoundOffset &&
				playerYPosition < cameraYPosition + screenBoundOffset &&
				playerYPosition > cameraYPosition - screenBoundOffset
				) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param SpriteBatch  batch
	 * @param ImageLoader  imageLoader
	 * @param MyGame       myGame
	 */
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		if (MissionRawBar.rawBarMissionComplete && gameObjectIsWithinScreenBounds(this)) {
			if (!hasBeenCollected && !MapUi.mapShouldBeRendered) {
				batch.draw(
						imageLoader.oyster, 
						x, 
						y, 
						width, 
						-height
						);
			} else if ((myGame.getGameObject(Player.PLAYER_ONE).getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) == this && Inventory.inventoryIsEquipped) || Inventory.allInventoryShouldBeRendered) {
				batch.draw(
						imageLoader.oyster, 
						x, 
						y, 
						width, 
						-height
						);
			}
		}
	}
}
