package input.controllers;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import gameobjects.weapons.MagicPearl;
import inventory.Inventory;
import missions.MissionRawBar;

/**
 * Logitech F310 GamePad.
 * 
 * @author Fabulous Fellini
 *
 */
public class LogitechF310 extends ControllerInput {

	/**
	 * Trigger buttons.
	 */
	protected int BUTTON_LT;
	protected int BUTTON_RT;

	/**
	 * Constructor.
	 */
	public LogitechF310() {
		super();
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
	}

	/**
	 * Polls controller for LB, RB, LT, RT.
	 * 
	 * @param GameObject player
	 */
	@Override
	protected void pollTriggers(GameObject player) {
		super.pollTriggers(player);
		if(controller.getButton(BUTTON_LT)) {} 
		if(controller.getButton(BUTTON_RT)) {
			Player.playerIsPerformingAttack = true;

			if (player.getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) instanceof MagicPearl) {
				MagicPearl.isAttacking     = true;
				MagicPearl.isMovingForward = true;
			}
		} else {
			if (Inventory.inventoryIsEquipped) {
				if (player.getInventory().inventory.get(Inventory.currentlySelectedInventoryObject) instanceof MagicPearl) {
					MagicPearl.hasReachedPeakDistance = true;
					MagicPearl.isMovingForward        = false;
					MagicPearl.isMovingBackward       = true;
				}
			}
		}
	}

	/**
	 * Polls controller for A, B, X, and Y.
	 * 
	 * @param GameObject player
	 */
	@Override
	protected void pollMainFourButtons(GameObject player) {
		super.pollMainFourButtons(player);
		if(controller.getButton(BUTTON_Y)) {}
		if(controller.getButton(BUTTON_A)) {
			/*
			 * A button will initially select the first inventory object.
			 * Player can cycle through inventory after this using D-Pad.
			 */
			if (Inventory.allInventoryShouldBeRendered) {
				selectAlternateInventoryObject(
						Inventory.currentlySelectedInventoryObject, 
						player
						);
			} else {
				if (!MissionRawBar.introHasCompleted && MissionRawBar.missionIsActive) {
					MissionRawBar.introHasCompleted = true;
				} else {
					// Only allow player to jump if UI is not open.
					Player.isJumping = true;
				}
			}
		} else {
			if (Inventory.allInventoryShouldBeRendered) {
				Inventory.mouseIsClickingOnInventoryObject = false;
				for (int i = 0; i < inventoryButtonIsPressed.length; i++) {
					inventoryButtonIsPressed[0] = false;
				}
			}
		}

		if(controller.getButton(BUTTON_B)) {} 
	}
}
