package helpers;

import java.util.Random;

/**
 * Used to generate all random numbers throughout all classes.
 * 
 * @author Fabulous Fellini
 *
 */
public class RandomNumberGenerator {

	/**
	 * Used for all random numbers that need to be generated.
	 */
	public static Random random = new Random();

	/**
	 * Return random integer based between 0 and nextInt.
	 * 
	 * @param int nextInt
	 * @return int
	 */
	public static int generateRandomInteger(int nextInt) {
		return random.nextInt(nextInt);
	}

	/**
	 * Return random double based between min and max.
	 * 
	 * @param double min
	 * @param dboule max
	 * @return double
	 */
	public static double generateRandomDouble(double min, double max) {
		return min + Math.random() * (max - min);
	}
}
