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
	 * Return random number based between 0 and nextInt.
	 * 
	 * @param int nextInt
	 * @return int
	 */
	public static int generateRandomNumber(int nextInt) {
		return random.nextInt(nextInt);
	}
}
