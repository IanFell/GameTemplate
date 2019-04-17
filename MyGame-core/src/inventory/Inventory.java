package inventory;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.gamecharacters.PlayerTwo;
import loaders.ImageLoader;

import screens.GameScreen;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Inventory {

	public static final int GUN = 0;
	public static final int LEGEND_SWORD = 1;

	public ArrayList <GameObject> inventory;
	public static boolean inventoryIsEquipped;
	public static boolean allInventoryShouldBeRendered;
	public static int currentlySelectedInventoryObject;

	/**
	 * Constructor.
	 */
	public Inventory() {
		inventory                        = new ArrayList<GameObject>();
		inventoryIsEquipped              = false;
		allInventoryShouldBeRendered     = false;
		currentlySelectedInventoryObject = 0;
		inventory.clear();
	}

	/**
	 * 
	 * @param boolean shouldRenderAllInventory
	 */
	public void setAllInventoryShouldBeRendered(boolean shouldRenderAllInventory) {
		allInventoryShouldBeRendered = shouldRenderAllInventory;
	}

	/**
	 * 
	 * @param GameObject object
	 */
	public void addObjectToInventory(GameObject object) {
		inventory.add(object);
	}

	/**
	 * 
	 * @param float x
	 * @param float y
	 */
	public void updateInventory(float x, float y) {
		// Set all inventory to follow player.
		float xPosition = 0;
		float yPosition = 0;
		for (int i = 0; i < inventory.size(); i++) {
			float inventoryHeight = inventory.get(i).getHeight();
			if (Player.playerIsPerformingAttack) {
				if (Player.isInWater) {
					switch (Player.direction) {
					case Player.DIRECTION_RIGHT:
						xPosition = x + 4;
						yPosition = y - 0.5f;
						break;
					case Player.DIRECTION_LEFT:
						xPosition = x - 4.5f;
						yPosition = y - 0.5f;
						break;
					case Player.DIRECTION_DOWN:
						xPosition = x - 0.3f;
						yPosition = y + inventoryHeight + 2;
						break;
					case Player.DIRECTION_UP:
						xPosition = x - 0.3f;
						yPosition = y - inventoryHeight - 3;
						break;
					}
				} else {
					switch (PlayerTwo.playerDirections.get(PlayerTwo.playerTwoXPositions.size() - 5)) {
					case Player.DIRECTION_RIGHT:
						xPosition = x + 4;
						yPosition = y - 1.5f;
						break;
					case Player.DIRECTION_LEFT:
						xPosition = x - 4.5f;
						yPosition = y - 1.5f;
						break;
					case Player.DIRECTION_DOWN:
						xPosition = x - 0.3f;
						yPosition = y + inventoryHeight + 1;
						break;
					case Player.DIRECTION_UP:
						xPosition = x - 0.3f;
						yPosition = y - inventoryHeight - 4;
						break;
					}
				}
			} else {
				/**
				 * I don't know why this works the best.  If we just switch based off
				 * Player.direction, it takes the third player's direction, therefore the
				 * weapon doesn't move until the third player's direction is set which looks weird
				 * because it needs to move with the first player.
				 */
				if (Player.isInWater) {
					switch (PlayerTwo.playerDirections.get(PlayerTwo.playerTwoXPositions.size() - 5)) {
					case Player.DIRECTION_RIGHT:
						xPosition = x + 3;
						yPosition = y - 0.5f;
						break;
					case Player.DIRECTION_LEFT:
						xPosition = x - 3.5f;
						yPosition = y - 0.5f;
						break;
					case Player.DIRECTION_DOWN:
						xPosition = x - 0.3f;
						yPosition = y + inventoryHeight + 1;
						break;
					case Player.DIRECTION_UP:
						xPosition = x - 0.3f;
						yPosition = y - inventoryHeight - 2;
						break;
					}
				} else {
					switch (PlayerTwo.playerDirections.get(PlayerTwo.playerTwoXPositions.size() - 5)) {
					case Player.DIRECTION_RIGHT:
						xPosition = x + 3;
						yPosition = y - 1.5f;
						break;
					case Player.DIRECTION_LEFT:
						xPosition = x - 3.5f;
						yPosition = y - 1.5f;
						break;
					case Player.DIRECTION_DOWN:
						xPosition = x - 0.3f;
						yPosition = y + inventoryHeight;
						break;
					case Player.DIRECTION_UP:
						xPosition = x - 0.3f;
						yPosition = y - inventoryHeight - 3;
						break;
					}
				}
			}
			inventory.get(i).setX(xPosition);
			inventory.get(i).setY(yPosition);
		}
	}

	/**
	 * 
	 * @param boolean isEquipped
	 */
	public void setInventoryIsEquipped(boolean isEquipped) {
		inventoryIsEquipped = isEquipped;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean getInventoryIsEquipped() {
		return inventoryIsEquipped;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	public void renderInventory(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		System.out.println("Inventory size: " + inventory.size());
		System.out.println("Currently Selected Inventory: " + Inventory.currentlySelectedInventoryObject);
		if (inventory.size() > 0) {
			if (inventoryIsEquipped) {
				inventory.get(currentlySelectedInventoryObject).renderObject(batch, shapeRenderer, imageLoader);
			}
		}
		if (allInventoryShouldBeRendered) {
			renderInventoryDisplay(batch, shapeRenderer, imageLoader);
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	public void renderInventoryDisplay(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		float x = GameScreen.camera.position.x - GameScreen.cameraWidth / 2;
		float y = GameScreen.camera.position.y;
		if (inventory.size() > 0) {
			for (int i = 0; i < inventory.size(); i++) {
				inventory.get(i).setX(x);
				inventory.get(i).setY(y);
				inventory.get(i).renderObject(batch, shapeRenderer, imageLoader);
				x += 2;
			}
		}
	}
}