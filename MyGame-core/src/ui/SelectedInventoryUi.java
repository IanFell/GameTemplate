package ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import gameobjects.weapons.Gun;
import gameobjects.weapons.LegendSword;
import gameobjects.weapons.MagicPearl;
import inventory.Inventory;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class SelectedInventoryUi {

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 * @param GameObject  player
	 */
	public void renderSelectedInventoryUi(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame, GameObject player) {
		int size = 1;
		batch.draw(
				imageLoader.whiteSquare,
				player.getX() - 12.0f,
				player.getY() + 6.0f,
				size, 
				-size
				);

		// Only display inventory object on screen if it is equpped.
		if (player.getInventory().getInventoryIsEquipped()) {

			// First, create an object and image to hold display of inventory object on in game UI.
			GameObject object = player.getInventory().inventory.get(Inventory.currentlySelectedInventoryObject);
			Texture image     = null;

			// Next, find the inventory object we have selected.
			if (object instanceof Gun) {
				image = imageLoader.gunRight;
			} else if (object instanceof MagicPearl) {
				image = imageLoader.oyster;
			} else if (object instanceof LegendSword) {
				image = imageLoader.legendSwordRainbow;
			}

			// Lastly, draw correct inventory object.
			batch.draw(
					image,
					player.getX() - 12.0f,
					player.getY() + 6.0f,
					size, 
					-size
					);
		}
	}
}
