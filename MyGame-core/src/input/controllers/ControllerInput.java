package input.controllers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.PovDirection;

import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import helpers.ControllerInputHelper;
import inventory.Inventory;
import ui.MapUi;

/**
 * Parent class for all GamePads.
 * 
 * @author Cero from JGO - I did change it a little bit to reflect my needs.
 *
 */
public class ControllerInput extends ApplicationAdapter {

	// Make sure inventory button if held down is not being hit infinite times.
	private int clickTimer          = 0;
	private boolean startClickTimer = false;

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
				pollDPad(player);
				pollMainFourButtons();
			}
			pollTriggers();
			pollStartSection();
		}
	}

	/**
	 * Polls controller for A, B, X, and Y.
	 */
	protected void pollMainFourButtons() {
		if(controller.getButton(BUTTON_X)) {
			System.out.print("X button pressed \n");
		}
	}

	/**
	 * Polls controller for LB, RB.  
	 * This method is overridden differently for different 
	 * controllers because the triggers are registered differently.
	 */
	protected void pollTriggers() {
		if(controller.getButton(BUTTON_LB)) {
			System.out.print("LB button pressed \n");
			if (MapUi.mapShouldBeRendered) {
				MapUi.mapShouldBeRendered              = !MapUi.mapShouldBeRendered;
				Inventory.allInventoryShouldBeRendered = true;
			}
		}
		if(controller.getButton(BUTTON_RB)) {
			System.out.print("RB button pressed \n");
			if (Inventory.allInventoryShouldBeRendered) {
				Inventory.allInventoryShouldBeRendered = !Inventory.allInventoryShouldBeRendered;
				MapUi.mapShouldBeRendered              = true;
			}
		}
	}

	/**
	 * Polls controller for DPad.
	 */
	private void pollDPad(GameObject player) {
		float playerSpeed = Player.PLAYER_SPEED;
		int turboSpeed    = 3;
		if(controller.getButton(BUTTON_RB)) {
			System.out.println("Player is using turbo!  Going fast!");
			playerSpeed = Player.PLAYER_SPEED * turboSpeed;
		}
		if (controller.getPov(0) == BUTTON_DPAD_UP) {
			System.out.print("DPAD UP button pressed \n");
			((Player) player).moveUp(playerSpeed);
		} else if (controller.getPov(0) == BUTTON_DPAD_DOWN) {
			System.out.print("DPAD DOWN button pressed \n");
			((Player) player).moveDown(playerSpeed);
		} else if (controller.getPov(0) == BUTTON_DPAD_LEFT) {
			System.out.print("DPAD LEFT button pressed \n");
			((Player) player).moveLeft(playerSpeed);
		} else if (controller.getPov(0) == BUTTON_DPAD_RIGHT) {
			System.out.print("DPAD RIGHT button pressed \n");
			((Player) player).moveRight(playerSpeed);
		}
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

		// Right stick.
		if (stickIsMoved(AXIS_RIGHT_X)) {
			System.out.print("RIGHT STICK X pressed \n");
		}
		if (stickIsMoved(AXIS_RIGHT_Y)) {
			System.out.print("RIGHT STICK Y pressed \n");
		}
		if(controller.getButton(BUTTON_R3)) {
			System.out.print("R3 button pressed \n");
		}
	}

	/**
	 * Polls controller for start, back/select buttons.
	 */
	protected void pollStartSection() {
		if(controller.getButton(BUTTON_BACK)) {
			System.out.print("BACK button pressed \n");
		}
		if(controller.getButton(BUTTON_START)) {
			System.out.print("START button pressed \n");
			if (!startClickTimer) {
				// If we press start and UI is open, close it.
				if (Inventory.allInventoryShouldBeRendered || MapUi.mapShouldBeRendered) {
					Inventory.allInventoryShouldBeRendered = false;
					MapUi.mapShouldBeRendered              = false;
				} else {
					// If we press start and UI is not open, open inventory screen.
					// We can navigate through inventory screen by pressing RB.
					startClickTimer                        = true;
					Inventory.allInventoryShouldBeRendered = !Inventory.allInventoryShouldBeRendered;
				}
			} else {
				// Make sure inventory button is only hit once.
				clickTimer++;
				if (clickTimer > 1) {
					clickTimer      = 0;
					startClickTimer = false;
				}
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
