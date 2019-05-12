package physics.Weather;

import gameobjects.GameObject;

/**
 * Handles day and night cycle.  
 *  
 * @author Fabulous Fellini
 *
 */
public class NightAndDayCycle extends GameObject {

	public static boolean isDayTime = true;

	/**
	 * This value is used in the Screens class.
	 * It changes between 0 and 1 in order to change from 
	 * 	blue (day), to
	 * 	black (night),
	 * 	and back again, 
	 * 	and repeat the cycle.
	 */
	public float dayNightCycleValue = 1;

	/**
	 * How fast day/night cycle happens.
	 */
	private float slowTransition           = 0.0002f;
	private float fastTransition           = 0.02f;
	private float dayNightCycleSpeedChange = fastTransition;

	/**
	 * Used as a sort of timer, to determine when to change from day to night and back.
	 */
	private int colorChangeIncrementValue = 0;

	/**
	 * Used with colorChangeIncrementValue.
	 * If colorChangeIncrementValue is greater than this variable, 
	 * we change from day to night, or night to day.
	 */
	private float duration = 10;

	/**
	 * Changes background color from blue to black, or black to blue, depending on time of day.
	 */
	public void performDayAndNightCycle() {
		colorChangeIncrementValue++;
		int colorChangeIncrementResetValue = 0;
		if (isDayTime) {
			if (dayNightCycleValue > colorChangeIncrementResetValue) {
				if (colorChangeIncrementValue >= duration) {
					dayNightCycleValue -= dayNightCycleSpeedChange;
					colorChangeIncrementValue = colorChangeIncrementResetValue;
				}
			} else {
				isDayTime = !isDayTime;
			}
		} else {
			if (dayNightCycleValue < 1) {  
				if (colorChangeIncrementValue >= duration) {
					dayNightCycleValue += dayNightCycleSpeedChange;
					colorChangeIncrementValue = colorChangeIncrementResetValue;
				}
			} else {
				isDayTime = !isDayTime;
			}
		}
	}

	/**
	 * 
	 * @return boolean
	 */
	public static boolean isDayTime() {
		return isDayTime;
	}
}
