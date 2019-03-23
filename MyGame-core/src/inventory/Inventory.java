package inventory;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import gameobjects.GameObject;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Inventory {

	private ArrayList <GameObject> inventory;
	private boolean inventoryIsEquipped;

	/**
	 * Constructor.
	 */
	public Inventory() {
		inventory           = new ArrayList<GameObject>();
		inventoryIsEquipped = false;
		inventory.clear();
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
		for (int i = 0; i < inventory.size(); i++) {
			inventory.get(i).setX(x);
			inventory.get(i).setY(y);
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
		if (inventory.size() > 0) {
			if (inventoryIsEquipped) {
				inventory.get(0).renderObject(batch, shapeRenderer, imageLoader);
			}
		}
	}
}
