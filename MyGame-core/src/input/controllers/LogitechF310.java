package input.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.mygame.MyGame;

import controllers.PlayerController;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import inventory.Inventory;

/**
 * Logitech F310 GamePad.
 * 
 * @author Fabulous Fellini
 *
 */
public class LogitechF310 extends ControllerInput {

	private static int maxNumberOfInventoryObjects   = 12;
	private Rectangle[] inventoryButtons             = new Rectangle[maxNumberOfInventoryObjects];
	public static boolean[] inventoryButtonIsPressed = new boolean[maxNumberOfInventoryObjects];

	/**
	 * Trigger buttons.
	 */
	protected int BUTTON_LT;
	protected int BUTTON_RT;

	public LogitechF310() {
		this.BUTTON_X     = 0;
		this.BUTTON_Y     = 3;
		this.BUTTON_A     = 1;
		this.BUTTON_B     = 2;
		this.BUTTON_BACK  = 8;
		this.BUTTON_START = 9;
		this.BUTTON_LB    = 4;
		this.BUTTON_L3    = 10;
		this.BUTTON_RB    = 5;
		this.BUTTON_R3    = 11;
		this.BUTTON_LT    = 6;
		this.BUTTON_RT    = 7;
		this.AXIS_LEFT_X  = 3; // -1 is left | +1 is right
		this.AXIS_LEFT_Y  = 2; // -1 is up | +1 is down
		this.AXIS_RIGHT_X = 1; // -1 is left | +1 is right
		this.AXIS_RIGHT_Y = 0; // -1 is up | +1 is down

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
		int yStartPositionTopRow      = 245;
		int yStartPositionBottomRow   = 470;
		int xStartPositionColumnOne   = 90;
		int xStartPositionColumnTwo   = 305;
		int xStartPositionColumnThree = 495;
		int xStartPositionColumnFour  = 695;
		int xStartPositionColumnFive  = 900;
		int xStartPositionColumnSix   = 1095;

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
	 * Polls controller for LB, RB, LT, RT.
	 */
	@Override
	protected void pollTriggers() {
		super.pollTriggers();
		if(controller.getButton(BUTTON_LT)) {} 
		if(controller.getButton(BUTTON_RT)) {
			Player.playerIsPerformingAttack = true;
		} 
	}

	/**
	 * Polls controller for A, B, X, and Y.
	 */
	@Override
	protected void pollMainFourButtons(GameObject player) {
		super.pollMainFourButtons(player);
		if(controller.getButton(BUTTON_Y)) {
			/*
			inventoryButtonIsPressed[0]                = false;
			inventoryButtonIsPressed[1]                = true;
			Inventory.mouseIsClickingOnInventoryObject = true;
			Inventory.currentlySelectedInventoryObject = 1;
			((Player) player).getInventory().setInventoryIsEquipped(true);
			Inventory.playClickSound                   = true;
			System.out.println("Inventory Button " + 1 + "pressed");*/
		}
		if(controller.getButton(BUTTON_A)) {
			/*
			 * A button will initially select the first inventory object.
			 * Player can cycle through inventory after this using D-Pad.
			 */
			if (Inventory.allInventoryShouldBeRendered) {
				// Inventory menu buttons.
				inventoryButtonIsPressed[0]                = true;
				Inventory.mouseIsClickingOnInventoryObject = true;
				Inventory.currentlySelectedInventoryObject = 0;
				((Player) player).getInventory().setInventoryIsEquipped(true);
				Inventory.playClickSound                   = true;
			} else {
				// Only allow player to jump if UI is not open.
				Player.isJumping = true;
			}
		} else {
			if (Inventory.allInventoryShouldBeRendered) {
				Inventory.mouseIsClickingOnInventoryObject = false;
				for (int i = 0; i < inventoryButtonIsPressed.length; i++) {
					inventoryButtonIsPressed[0] = false;
				}
			}
		}

		if(controller.getButton(BUTTON_B)) {
			
		} 
	}
}
