package input.controllers;

import gameobjects.GameObject;

/**
 * XBox 360 GamePad.
 * 
 * @author Fabulous Fellini
 *
 */
public class XBox360Pad extends ControllerInput
{
	/**
	 * Trigger axis.
	 */
	private int AXIS_LEFT_TRIGGER;
	private int AXIS_RIGHT_TRIGGER;

	/**
	 * Dead zone for triggers.  
	 * Trigger is not considered pressed unless its pressed over this amount.
	 */
	private float triggerDeadZone = 0.5f;

	public XBox360Pad() {
		this.BUTTON_X           = 2;
		this.BUTTON_Y           = 3;
		this.BUTTON_A           = 0;
		this.BUTTON_B           = 1;
		this.BUTTON_BACK        = 6;
		this.BUTTON_START       = 7;
		this.BUTTON_LB          = 4;
		this.BUTTON_L3          = 8;
		this.BUTTON_RB          = 5;
		this.BUTTON_R3          = 9;
		this.AXIS_LEFT_X        = 1; // -1 is left | +1 is right
		this.AXIS_LEFT_Y        = 0; // -1 is up | +1 is down
		this.AXIS_LEFT_TRIGGER  = 4; // value 0 to 1f
		this.AXIS_RIGHT_X       = 3; // -1 is left | +1 is right
		this.AXIS_RIGHT_Y       = 2; // -1 is up | +1 is down
		this.AXIS_RIGHT_TRIGGER = 4; // value 0 to -1f
	}

	/**
	 * Polls controller for LB, RB, LT, RT.
	 * 
	 * @param GameObject player
	 */
	@Override
	protected void pollTriggers(GameObject player) {
		super.pollTriggers(player);
		if(controller.getAxis(AXIS_LEFT_TRIGGER) > triggerDeadZone) {
			System.out.print("LEFT TRIGGER pressed \n");
		}
		if(controller.getAxis(AXIS_RIGHT_TRIGGER) < -triggerDeadZone) {
			System.out.print("RIGHT TRIGGER pressed \n");
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
		if(controller.getButton(BUTTON_Y)) {
			System.out.print("Y button pressed \n");
		}
		if(controller.getButton(BUTTON_A)) {
			System.out.print("A button pressed \n");
		}
		if(controller.getButton(BUTTON_B)) {
			System.out.print("B button pressed \n");
		}
	}
}
