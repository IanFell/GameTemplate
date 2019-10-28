package input.controllers;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.PovDirection;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import helpers.ControllerInputHelper;
import helpers.GameAttributeHelper;
import input.Input;
import inventory.Inventory;
import missions.MissionRawBar;
import ui.MapUi;

/**
 * Parent class for all GamePads.
 * 
 * @author Cero from JGO - I did change it a little bit to reflect my needs.
 *
 */
public class ControllerInput extends Input {

	// Make sure inventory button if held down is not being hit infinite times.
	private float clickUiTimer      = GameAttributeHelper.TIMER_START_VALUE;
	private int inventoryClickTimer = GameAttributeHelper.TIMER_START_VALUE;

	protected Controller controller;

	/**
	 * Determine whether a controller has been detected.
	 */
	private boolean hasControllers = true;

	protected String controllerName;

	/**
	 * Represents the dead zone for joysticks.  
	 * In the deadzone will register as 0 (non movement).
	 * This is used because controller is very sensitive and we
	 * dont want an accidental movement to trigger.
	 */
	private float deadZone = 0.2f;

	/**
	 * Controller buttons.
	 */
	protected int BUTTON_X;
	protected int BUTTON_Y;
	protected int BUTTON_A;
	protected int BUTTON_B;
	protected int BUTTON_LB;
	protected int BUTTON_L3;
	protected int BUTTON_RB;
	protected int BUTTON_R3;
	protected int BUTTON_BACK;
	protected int BUTTON_START;

	/**
	 * Controller D-Pad.
	 */
	protected PovDirection BUTTON_DPAD_UP    = PovDirection.north;
	protected PovDirection BUTTON_DPAD_DOWN  = PovDirection.south;
	protected PovDirection BUTTON_DPAD_RIGHT = PovDirection.east;
	protected PovDirection BUTTON_DPAD_LEFT  = PovDirection.west;

	/**
	 * Controller sticks.
	 */
	protected int AXIS_LEFT_X;  // -1 is left | +1 is right
	protected int AXIS_LEFT_Y;  // -1 is up | +1 is down
	protected int AXIS_RIGHT_X; // -1 is left | +1 is right
	protected int AXIS_RIGHT_Y; // -1 is up | +1 is down

	/**
	 * If a controller is found, set the name.
	 */
	public void init() {
		if(Controllers.getControllers().size == 0) {
			hasControllers = false;
		} else {
			controller     = ControllerInputHelper.getFirstController();
			controllerName = ControllerInputHelper.getControllerName();
		}
	}

	/**
	 * Handles controller input.
	 * Polling is broken up into sections of buttons for better readability. 
	 * 
	 * @param GameObject player
	 */
	public void handleInput(GameObject player) {
		if (hasControllers) {  
			// Dont poll these if UI is open.
			if (!Inventory.allInventoryShouldBeRendered && !MapUi.mapShouldBeRendered) {
				pollSticks(player);
			}
			pollMainFourButtons(player);
			pollTriggers(player);
			pollStartSection();
			pollDPad(player);
		}
	}

	/**
	 * Polls controller for A, B, X, and Y.
	 * 
	 * @param GameObject player
	 */
	protected void pollMainFourButtons(GameObject player) {
		if(controller.getButton(BUTTON_X)) {}
	}

	/**
	 * Polls controller for LB, RB.  
	 * This method is overridden differently for different 
	 * controllers because the triggers are registered differently.
	 * 
	 * @param GameObject player
	 */
	protected void pollTriggers(GameObject player) {
		if(controller.getButton(BUTTON_LB)) {
			if (MapUi.mapShouldBeRendered) {
				MapUi.mapShouldBeRendered              = !MapUi.mapShouldBeRendered;
				Inventory.allInventoryShouldBeRendered = true;
			}
		}
		if(controller.getButton(BUTTON_RB)) {
			if (Inventory.allInventoryShouldBeRendered) {
				Inventory.allInventoryShouldBeRendered = !Inventory.allInventoryShouldBeRendered;
				MapUi.mapShouldBeRendered              = true;
			}
		}
	}

	/**
	 * Polls controller for DPad.
	 * 
	 * @param GameObject player
	 */
	private void pollDPad(GameObject player) {
		// Use timer so we can't change between inventory objects too quickly.
		inventoryClickTimer++;
		if (inventoryClickTimer > 9) {
			inventoryClickTimer = GameAttributeHelper.TIMER_START_VALUE;
		}

		if (controller.getPov(0) == BUTTON_DPAD_UP) {
			Player.hasTorch = !Player.hasTorch;
		} else if (controller.getPov(0) == BUTTON_DPAD_DOWN) {
		} else if (controller.getPov(0) == BUTTON_DPAD_LEFT) {
			if (Inventory.currentlySelectedInventoryObject > 0) {
				if (inventoryClickTimer > 8) {
					selectAlternateInventoryObject(Inventory.currentlySelectedInventoryObject, false, player);
				}
			}
		} else if (controller.getPov(0) == BUTTON_DPAD_RIGHT) {
			if (Inventory.currentlySelectedInventoryObject < 11) {
				if (inventoryClickTimer > 8) {
					selectAlternateInventoryObject(Inventory.currentlySelectedInventoryObject, true, player);
				}
			}
		}
	}

	/**
	 * This method uses the D-Pad to cycle through inventory, different than the method in the Input class.
	 * 
	 * @param int        currentlySelectedInventory
	 * @param boolean    isAdding
	 * @param GameObject player
	 */
	private void selectAlternateInventoryObject(int currentlySelectedInventory, boolean isAdding, GameObject player) {
		int increment = 1;
		inventoryButtonIsPressed[Inventory.currentlySelectedInventoryObject] = false;
		if (isAdding) {
			inventoryButtonIsPressed[Inventory.currentlySelectedInventoryObject + increment] = true;
			Inventory.currentlySelectedInventoryObject = Inventory.currentlySelectedInventoryObject + increment;
		} else {
			inventoryButtonIsPressed[Inventory.currentlySelectedInventoryObject - increment] = true;
			Inventory.currentlySelectedInventoryObject = Inventory.currentlySelectedInventoryObject - increment;
		}
		Inventory.mouseIsClickingOnInventoryObject = true;
		Inventory.playClickSound                   = true;
		((Player) player).getInventory().setInventoryIsEquipped(true);
	}

	/**
	 * Polls controller for analog sticks.
	 * 
	 * @param GameObject player
	 */
	protected void pollSticks(GameObject player) {
		float playerSpeed = Player.PLAYER_SPEED;
		int turboSpeed    = 3;
		if(controller.getButton(BUTTON_L3)) {
			System.out.print("L3 button pressed \n");
			System.out.println("Player is using turbo!  Going fast!");
			playerSpeed = Player.PLAYER_SPEED * turboSpeed;
		}
		Player.playerIsMoving = false;

		// RawBar Mission uses a different player than normal since it's kind of like a mini game.
		if (MissionRawBar.phasesAreInProgress) {
			if (stickIsMoved(AXIS_LEFT_X)) {
				if (controller.getAxis(AXIS_LEFT_X) < 0) {
					MissionRawBar.playerX -= MissionRawBar.MISSION_RAW_BAR_SPEED;
					player.setDirection(Player.DIRECTION_LEFT);
				} else if (controller.getAxis(AXIS_LEFT_X) > 0) {
					MissionRawBar.playerX += MissionRawBar.MISSION_RAW_BAR_SPEED;
					player.setDirection(Player.DIRECTION_RIGHT);
				} 
			} 
			if (stickIsMoved(AXIS_LEFT_Y)) {
				if (controller.getAxis(AXIS_LEFT_Y) < deadZone) {
					MissionRawBar.playerY -= MissionRawBar.MISSION_RAW_BAR_SPEED;
					player.setDirection(Player.DIRECTION_UP);
				} else if (controller.getAxis(AXIS_LEFT_Y) > deadZone) {
					MissionRawBar.playerY += MissionRawBar.MISSION_RAW_BAR_SPEED;
					player.setDirection(Player.DIRECTION_DOWN);
				} 
			}
		} else {
			// Left stick.
			if (stickIsMoved(AXIS_LEFT_X)) {
				System.out.print("LEFT STICK X pressed \n");
				if (controller.getAxis(AXIS_LEFT_X) < 0) {
					((Player) player).moveLeft(playerSpeed);
				} else if (controller.getAxis(AXIS_LEFT_X) > 0) {
					((Player) player).moveRight(playerSpeed);
				} 
			} 
			if (stickIsMoved(AXIS_LEFT_Y)) {
				System.out.print("LEFT STICK Y pressed \n");
				if (controller.getAxis(AXIS_LEFT_Y) < deadZone) {
					((Player) player).moveUp(playerSpeed);
				} else if (controller.getAxis(AXIS_LEFT_Y) > deadZone) {
					((Player) player).moveDown(playerSpeed);
				} 
			} 
		}

		/**
		 * We don't use the right stick yet, so don't even check it.
		 */
		/*
		if (stickIsMoved(AXIS_RIGHT_X)) {
			System.out.print("RIGHT STICK X pressed \n");
		}
		if (stickIsMoved(AXIS_RIGHT_Y)) {
			System.out.print("RIGHT STICK Y pressed \n");
		}
		if(controller.getButton(BUTTON_R3)) {
			System.out.print("R3 button pressed \n");
		} 
		 */
	}

	/**
	 * Polls controller for start, back/select buttons.
	 */
	protected void pollStartSection() {
		if(controller.getButton(BUTTON_BACK)) {
			System.out.print("BACK button pressed \n");
		}
		if(controller.getButton(BUTTON_START)) {
			// If we press start and UI is open, close it.
			if (clickUiTimer < 1) {
				Inventory.playClickSound = true;
				if (Inventory.allInventoryShouldBeRendered || MapUi.mapShouldBeRendered) {
					Inventory.allInventoryShouldBeRendered = false;
					MapUi.mapShouldBeRendered              = false;
				} else {
					// If we press start and UI is not open, open inventory screen.
					// We can navigate through inventory screen by pressing RB.
					Inventory.allInventoryShouldBeRendered = !Inventory.allInventoryShouldBeRendered;
				}
			}
			clickUiTimer++;
			if (clickUiTimer > 5) {
				clickUiTimer = GameAttributeHelper.TIMER_START_VALUE;
			}
		}
	}

	/**
	 * Determines if either joystick has been moved.
	 * 
	 * @param int axis
	 * @return boolean
	 */
	protected boolean stickIsMoved(int axis) {
		if (controller.getAxis(axis) > deadZone  || controller.getAxis(axis) < -deadZone) {
			return true;
		}
		return false;
	}
}
