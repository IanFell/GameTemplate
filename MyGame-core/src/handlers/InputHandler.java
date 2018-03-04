package handlers;

import com.mygdx.mygame.MyGame;

import helpers.ControllerInputHelper;
import input.computer.Keyboard;
import input.computer.Mouse;
import input.controllers.ControllerInput;
import input.controllers.LogitechF310;
import input.controllers.XBox360Pad;

/**
 * Handles all input, whether that be computer or game pads.
 * 
 * @author Fabulous Fellini
 *
 */
public class InputHandler {
	
	/**
	 * Keyboard input.
	 */
	private Keyboard keyboard = new Keyboard();
	
	/**
	 * Mouse input.
	 */
	private Mouse mouse = new Mouse();
	
	/**
	 * GamePads.  This can be any gamepad, as it will
	 * be instantiated after we grab the controller's name.
	 */
	private ControllerInput controllerInput;
	
	/**
	 * Initialize input.  First we get the name of the first controller found.
	 * Then we use the name to instantiate a certain type of controller.
	 */
	public void init() {
		String controllerName = ControllerInputHelper.getControllerName();
		System.out.println(controllerName + " found.");
		
		// Instantiate correct controller based off controller name.
		if (controllerName.contains("Logitech")) {
			controllerInput = new LogitechF310();
		}
		if (controllerName.contains("Xbox") && controllerName.contains("360")) {
			controllerInput = new XBox360Pad();
		}
		
		// If we have found a controller, initialize it.
		if (controllerInput != null) {
			controllerInput.init();
		}
	}
	
	/**
	 * Handles all input in game.
	 * 
	 * @param MyGame myGame
	 */
	public void handleInput(MyGame myGame) {
		// Handle controller input if controller exists.
		if (controllerInput != null) {
			controllerInput.handleInput();
		}
		keyboard.handleInput(myGame);
		mouse.handleInput(myGame);
	}
}
