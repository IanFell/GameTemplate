package inventory;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.gamecharacters.PlayerOne;
import gameobjects.weapons.LegendSword;
import loaders.ImageLoader;
import maps.MapHandler;
import physics.Lighting.Fire;
import screens.Screens;
import ui.InventoryUi;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Inventory extends Screens {

	public static boolean mouseIsClickingOnInventoryObject;
	public static Rectangle rectangle;
	public static boolean playClickSound;
	private Fire fire;
	public ArrayList <GameObject> inventory;
	public static boolean inventoryIsEquipped;
	public static boolean allInventoryShouldBeRendered;
	public static int currentlySelectedInventoryObject;
	private static InventoryUi inventoryUi;
	public static boolean inventoryHasStartedCollection = false;

	/**
	 * Constructor.
	 * 
	 * @param MyGame myGame
	 */
	public Inventory(final MyGame myGame) {
		super(myGame);
		inventory                        = new ArrayList<GameObject>();
		inventoryIsEquipped              = false;
		allInventoryShouldBeRendered     = false;
		currentlySelectedInventoryObject = 0;
		rectangle                        = new Rectangle(0, 0, 4, 4);
		mouseIsClickingOnInventoryObject = false;
		fire                             = new Fire(0, 0, 0, 0, "Inventory", false);
		playClickSound                   = false;
		inventoryUi                      = new InventoryUi(myGame);
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
	 * @param float      x
	 * @param float      y
	 * @param MapHandler mapHandler
	 */
	public void updateInventory(float x, float y, MapHandler mapHandler) {
		// Set all inventory to follow player.
		float xPosition = 0;
		float yPosition = 0;
		int objectType = 0;
		//System.out.println(myGame.getGameObject(Player.PLAYER_ONE).getInventory().inventory.size());
		if (inventory.get(currentlySelectedInventoryObject) instanceof LegendSword) {
			objectType = 0;
		} else {
			objectType = 1;
		}
		if (inventory.size() >= 0) {
			for (int i = 0; i < inventory.size(); i++) {

				//if (object instanceof LegendSword) {
				if (objectType == 0) {
					updateSword(i, xPosition, yPosition, x, y);
				}
				else {
					updateGun(i, xPosition, yPosition, x, y);
				}
				if (Inventory.allInventoryShouldBeRendered) {
					fire.updateObject(myGame, mapHandler);
				}
			}
		}
		System.out.println(inventory.get(currentlySelectedInventoryObject) instanceof LegendSword);
	}

	private void updateGun(int selectedInventory, float xPosition, float yPosition, float x, float y) {
		float inventoryHeight = inventory.get(selectedInventory).getHeight();
		
				switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
				case Player.DIRECTION_RIGHT:
					xPosition = x + 1;
					yPosition = y - 1f;
					break;
				case Player.DIRECTION_LEFT:
					xPosition = x - 4.0f;
					yPosition = y - 1f;
					break;
				case Player.DIRECTION_DOWN:
					xPosition = x - 1f;
					yPosition = y + inventoryHeight;
					break;
				case Player.DIRECTION_UP:
					xPosition = x - 2f;
					yPosition = y - inventoryHeight - 4;
					break;
				}
			
		inventory.get(selectedInventory).setX(xPosition);
		inventory.get(selectedInventory).setY(yPosition);
	}

	private void updateSword(int selectedInventory, float xPosition, float yPosition, float x, float y) {
		float inventoryHeight = inventory.get(selectedInventory).getHeight();
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
				switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
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
			if (Player.isInWater) {
				switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
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
				switch (PlayerOne.playerDirections.get(PlayerOne.playerDirections.size() - 1)) {
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
		inventory.get(selectedInventory).setX(xPosition);
		inventory.get(selectedInventory).setY(yPosition);
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
		inventoryUi.renderInventoryUi(
				batch, 
				shapeRenderer, 
				imageLoader, 
				inventory, 
				inventoryIsEquipped, 
				currentlySelectedInventoryObject, 
				allInventoryShouldBeRendered,
				fire,
				mouseIsClickingOnInventoryObject,
				rectangle
				);
	}
}