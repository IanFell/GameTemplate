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

	public static boolean screenIsShaking = false;

	private float durationOfScreenShakeInMilliseconds;

	private float elapsedScreenShakeTime;

	private float randomScreenShakeAngle;

	/**
	 * The starting radius for the shake. 
	 * The larger the radius, the large the shaking effect.
	 */
	private float radius;

	/**
	 * Start the screen shaking with a given power and duration.
	 *
	 * @param float radius 
	 * @param float duration 
	 */
	public void shake(float radius , float duration) {
		elapsedScreenShakeTime              = 0;
		durationOfScreenShakeInMilliseconds = duration / 1000f;
		this.radius                         = radius;
		randomScreenShakeAngle              = RandomNumberGenerator.random.nextFloat() % 360f;
		screenIsShaking                     = true;
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
		if((elapsedScreenShakeTime < durationOfScreenShakeInMilliseconds)) {
			System.out.println("Screen is shaking!");
			// Calculate the shake based on the remaining radius.
			radius                 *= 0.9f; // Diminish radius each frame
			randomScreenShakeAngle += (150 + RandomNumberGenerator.random.nextFloat() % 60f);
			float x                = (float) (Math.sin(randomScreenShakeAngle) * radius);
			float y                = (float) (Math.cos(randomScreenShakeAngle) * radius);
			camera.translate(-x, y);

			// Increase the elapsed time by the delta provided.
			elapsedScreenShakeTime += delta;
		} 
	}
}
