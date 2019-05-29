package input.controllers;

import gameobjects.gamecharacters.Player;

/**
 * Logitech F310 GamePad.
 * 
 * @author Fabulous Fellini
 *
 */
public class LogitechF310 extends ControllerInput
{
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
	}

	/**
	 * Polls controller for LB, RB, LT, RT.
	 */
	@Override
	protected void pollTriggers() {
		super.pollTriggers();
		if(controller.getButton(BUTTON_LT)) {
			System.out.print("LT button pressed \n");	
		} 
		if(controller.getButton(BUTTON_RT)) {
			System.out.print("RT button pressed \n");
			Player.playerIsPerformingAttack = true;
		} else {
			//Player.playerIsPerformingAttack = false;
		}
	}

	/**
	 * Polls controller for A, B, X, and Y.
	 */
	@Override
	protected void pollMainFourButtons() {
		super.pollMainFourButtons();
		if(controller.getButton(BUTTON_Y)) {
			System.out.print("Y button pressed \n");
		}
		if(controller.getButton(BUTTON_A)) {
			System.out.print("A button pressed \n");
			Player.isJumping = true;
		}
		if(controller.getButton(BUTTON_B)) {
			System.out.print("B button pressed \n");
		}
	}
}
