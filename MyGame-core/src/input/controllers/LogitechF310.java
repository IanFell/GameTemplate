package input.controllers;

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
	 
	/**
	 * Constructor.
	 */
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
	    
	    this.AXIS_LEFT_X  = 3; //-1 is left | +1 is right
	    this.AXIS_LEFT_Y  = 2; //-1 is up | +1 is down
	    this.AXIS_RIGHT_X = 1; //-1 is left | +1 is right
	    this.AXIS_RIGHT_Y = 0; //-1 is up | +1 is down
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
		}
	}
}
