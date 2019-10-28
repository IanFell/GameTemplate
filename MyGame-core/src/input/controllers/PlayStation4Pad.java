package input.controllers;

import gameobjects.GameObject;

/**
 * PlayStation4 GamePad.
 * 
 * @author Fabulous Fellini
 *
 */
public class PlayStation4Pad extends ControllerInput {
	private int BUTTON_SQUARE;
	private int BUTTON_TRIANGLE;
	private int BUTTON_CIRCLE;
	private int BUTTON_L2;
	private int BUTTON_R2;
	private int BUTTON_SHARE;
	private int BUTTON_OPTIONS;
	private int BUTTON_L1;
	private int BUTTON_R1;
	private int BUTTON_PLAYSTATION;
	private int BUTTON_HUGE_CENTER;

	public PlayStation4Pad() {
		this.BUTTON_X           = 1;
		this.BUTTON_SQUARE      = 0;
		this.BUTTON_TRIANGLE    = 3;
		this.BUTTON_CIRCLE      = 2;
		this.BUTTON_L2          = 6;
		this.BUTTON_R2          = 7;
		this.BUTTON_SHARE       = 8;
		this.BUTTON_OPTIONS     = 9;
		this.BUTTON_L3          = 10;
		this.BUTTON_R3          = 11;
		this.BUTTON_L1          = 4;
		this.BUTTON_R1          = 5;
		this.BUTTON_PLAYSTATION = 12;
		this.BUTTON_HUGE_CENTER = 13;
		this.AXIS_LEFT_X        = 3; // -1 is left | +1 is right
		this.AXIS_LEFT_Y        = 2; // -1 is up | +1 is down
		this.AXIS_RIGHT_X       = 1; // -1 is left | +1 is right
		this.AXIS_RIGHT_Y       = 0; // -1 is up | +1 is down
	}

	/**
	 * Polls controller for options/share buttons.
	 */
	@Override
	protected void pollStartSection() {
		if(controller.getButton(BUTTON_SHARE)) {
			System.out.print("SHARE button pressed \n");
		}
		if(controller.getButton(BUTTON_OPTIONS)) {
			System.out.print("OPTIONS button pressed \n");
		}
		if(controller.getButton(BUTTON_PLAYSTATION)) {
			System.out.print("PLAYSTATION button pressed \n");
		}
		if(controller.getButton(BUTTON_HUGE_CENTER)) {
			System.out.print("HUGE CENTER button pressed \n");
		}
	}

	/**
	 * Polls controller for X, Square, Triangle, and Circle.
	 * 
	 * @param GameObject player
	 */
	@Override
	protected void pollMainFourButtons(GameObject player) {
		super.pollMainFourButtons(player);
		if(controller.getButton(BUTTON_TRIANGLE)) {
			System.out.print("Triangle button pressed \n");
		}
		if(controller.getButton(BUTTON_SQUARE)) {
			System.out.print("Square button pressed \n");
		}
		if(controller.getButton(BUTTON_CIRCLE)) {
			System.out.print("Circle button pressed \n");
		}
	}

	/**
	 * Polls controller for L1, R1, L2, R2.  
	 * This method is overridden differently for different 
	 * controllers because the triggers are registered differently.
	 * 
	 * @param GameObject player
	 */
	@Override
	protected void pollTriggers(GameObject player) {
		if(controller.getButton(BUTTON_L1)) {
			System.out.print("L1 button pressed \n");
		}
		if(controller.getButton(BUTTON_R1)) {
			System.out.print("R1 button pressed \n");
		}
		if(controller.getButton(BUTTON_L2)) {
			System.out.print("L2 button pressed \n");
		}
		if(controller.getButton(BUTTON_R2)) {
			System.out.print("R2 button pressed \n");
		}
	}
}
