package screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

/**
 * Overlays the screen with a black square and fades out.
 * This makes transition between screens much smoother.
 * Everything is static because this screen will only be
 * instantiated upon the loading of a new screen, therefore 
 * it is not in scope of any screen classes.
 * 
 * @author Fabulous Fellini
 *
 */
public class TransitionScreen extends Screens {

	/**
	 * Represents if transition screen has completely faded from black to transparent.
	 */
	private static boolean transitionScreenIsComplete = false;

	/**
	 * This is the representation for the alpha value for transparency.
	 */
	private static float transparencyIncrement = 1;

	/**
	 * 
	 * @param MyGame myGame
	 */
	public TransitionScreen(MyGame myGame) {
		super(myGame);
	}

	/**
	 * 
	 * @param ShapeRenderer shapeRenderer
	 */
	public void renderObject(ShapeRenderer shapeRenderer) {
		shapeRenderer.setColor(new Color(0, 0, 0, transparencyIncrement));
		shapeRenderer.rect(
				camera.position.x - viewportWidth / denominatorOffset, 
				camera.position.y - verticalHeight / denominatorOffset, 
				camera.viewportWidth, 
				camera.viewportHeight
				);
	}

	/**
	 * If transition is not yet complete, increase transparency.
	 */
	public static void updateObject() {
		transparencyIncrement -= 0.01f;

		if (transparencyIncrement < 0) {
			transitionScreenIsComplete = !transitionScreenIsComplete;
		}
	}

	/**
	 * 
	 * @return boolean
	 */
	public static boolean isTransitionScreenIsComplete() {
		return transitionScreenIsComplete;
	}
}
