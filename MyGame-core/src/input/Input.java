package input;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Rectangle;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import inventory.Inventory;
import physics.Lighting.Fire;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Input extends ApplicationAdapter {

	/**
	 * Inventory buttons reside here because it is easier to translate mouse to world coordinates.
	 */
	protected static int maxNumberOfInventoryObjects   = 12;
	protected Rectangle[] inventoryButtons             = new Rectangle[maxNumberOfInventoryObjects];
	public static boolean[] inventoryButtonIsPressed   = new boolean[maxNumberOfInventoryObjects];

	protected int yStartPositionTopRow;
	protected int yStartPositionBottomRow;
	protected int xStartPositionColumnOne;
	protected int xStartPositionColumnTwo;
	protected int xStartPositionColumnThree;
	protected int xStartPositionColumnFour;
	protected int xStartPositionColumnFive;
	protected int xStartPositionColumnSix;

	/**
	 * Constructor.
	 */
	public Input() {
		for (int i = 0; i < inventoryButtons.length; i++) {
			inventoryButtons[i] = new Rectangle(0, 0, 0, 0);
			inventoryButtonIsPressed[i] = false;

			// Full screen coordinates.
			inventoryButtons[i].width   = 200;
			inventoryButtons[i].height  = 185;
			// Phone screen coordinates.
			//inventoryButtons[i].width   = 90;
			//inventoryButtons[i].height  = 125;
		}

		// Full screen button positions.
		yStartPositionTopRow      = 245;
		yStartPositionBottomRow   = 470;
		xStartPositionColumnOne   = 90;
		xStartPositionColumnTwo   = 305;
		xStartPositionColumnThree = 495;
		xStartPositionColumnFour  = 695;
		xStartPositionColumnFive  = 900;
		xStartPositionColumnSix   = 1095;

		// Phone screen button positions.
		/*
		int yStartPositionTopRow      = 95;
		int yStartPositionBottomRow   = 240;
		int xStartPositionColumnOne   = 65;
		int xStartPositionColumnTwo   = 165;
		int xStartPositionColumnThree = 250;
		int xStartPositionColumnFour  = 350;
		int xStartPositionColumnFive  = 440;
		int xStartPositionColumnSix   = 530; */

		inventoryButtons[0].x      = xStartPositionColumnOne;
		inventoryButtons[0].y      = yStartPositionTopRow;

		inventoryButtons[1].x      = xStartPositionColumnTwo;
		inventoryButtons[1].y      = yStartPositionTopRow;

		inventoryButtons[2].x      = xStartPositionColumnThree;
		inventoryButtons[2].y      = yStartPositionTopRow;

		inventoryButtons[3].x      = xStartPositionColumnFour;
		inventoryButtons[3].y      = yStartPositionTopRow;

		inventoryButtons[4].x      = xStartPositionColumnFive;
		inventoryButtons[4].y      = yStartPositionTopRow;

		inventoryButtons[5].x      = xStartPositionColumnSix;
		inventoryButtons[5].y      = yStartPositionTopRow;

		inventoryButtons[6].x      = xStartPositionColumnOne;
		inventoryButtons[6].y      = yStartPositionBottomRow;

		inventoryButtons[7].x      = xStartPositionColumnTwo;
		inventoryButtons[7].y      = yStartPositionBottomRow;

		inventoryButtons[8].x      = xStartPositionColumnThree;
		inventoryButtons[8].y      = yStartPositionBottomRow;

		inventoryButtons[9].x      = xStartPositionColumnFour;
		inventoryButtons[9].y      = yStartPositionBottomRow;

		inventoryButtons[10].x      = xStartPositionColumnFive;
		inventoryButtons[10].y      = yStartPositionBottomRow;

		inventoryButtons[11].x      = xStartPositionColumnSix;
		inventoryButtons[11].y      = yStartPositionBottomRow;
	}

	/**
	 * 
	 * @param int        element
	 * @param GameObject player
	 */
	protected void selectAlternateInventoryObject(int element, GameObject player) {
		inventoryButtonIsPressed[element]          = true;
		Inventory.mouseIsClickingOnInventoryObject = true;
		Inventory.currentlySelectedInventoryObject = element;
		((Player) player).getInventory().setInventoryIsEquipped(true);
		Inventory.playClickSound                   = true;
		Fire.playSound                             = true;
	}
}
