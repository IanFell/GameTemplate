package screens;

import com.badlogic.gdx.graphics.OrthographicCamera;

import helpers.RandomNumberGenerator;

/**
 * Performs screenshake.
 * 
 * @author Fabulous Fellini
 *
 */
public class ScreenShake {
	
	/**
	 * Keeps track whether screen is shaking.
	 */
	public static boolean screenIsShaking = false;
	
	/**
	 * Duration of screenshake in milliseconds.
	 */
	private float duration;
	
	/**
	 * How much screenshake time has elapsed.
	 */
	private float elapsed;
	
	/**
	 * Used to randomize screenshake.
	 */
	private float randomAngle;
	
	/**
	 * The starting radius for the shake. 
	 * The larger the radius, the large the shaking effect.
	 */
	private float radius;
	
	/**
	 * Start the screen shaking with a given power and duration
	 *
	 * @param float radius 
	 * @param float duration 
	 */
	public void shake(float radius , float duration) {
	    this.elapsed     = 0;
	    this.duration    = duration / 1000f;
	    this.radius      = radius ;
	    this.randomAngle = RandomNumberGenerator.random.nextFloat() % 360f;
	    screenIsShaking  = true;
	}
	 
	/**
	 * Updates the shake and the camera.
	 * This must be called prior to camera.update().
	 * 
	 * @param float              delta
	 * @param OrthographicCamera camera
	 */
	public void update(float delta, OrthographicCamera camera) {
		Screens.saveCameraCoordinatesBeforeScreenShake();
		
	    // Only shake when required.
	    if((elapsed < duration)) {
	    	System.out.println("Screen is shaking!");
	        // Calculate the shake based on the remaining radius.
	        radius      *= 0.9f; // Diminish radius each frame
	        randomAngle += (150 + RandomNumberGenerator.random.nextFloat() % 60f);
	        float x     = (float) (Math.sin(randomAngle) * radius);
	        float y     = (float) (Math.cos(randomAngle) * radius);
	        camera.translate(-x, y);
	 
	        // Increase the elapsed time by the delta provided.
	        elapsed += delta;
	    } 
	}
}
