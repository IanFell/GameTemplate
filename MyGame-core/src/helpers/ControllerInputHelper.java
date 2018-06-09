package helpers;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;

/**
 * Contains helper methods for controller input.
 * 
 * @author Fabulous Fellini
 *
 */
public class ControllerInputHelper {

	/**
	 * Returns name of first gamepad found.
	 * 
	 * @return String
	 */
	public static String getControllerName() {
		if(Controllers.getControllers().size == 0) {
			return "No controller found";
		}
		return Controllers.getControllers().get(0).getName();
	}

	/**
	 * Returns the first gamepad found.
	 * 
	 * @return Controller
	 */
	public static Controller getFirstController() {
		return Controllers.getControllers().first();
	}
}
