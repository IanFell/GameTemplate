package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import physics.Weather.NightAndDayCycle;

/**
 * Puts a dark shading over the screen to simulate darkness.
 * 
 * @author Fabulous Fellini
 *
 */
public class ScreenShader extends Screens {

	private float transparencyMin = 0f;
	private float transparencyMax = 0.7f;

	/**
	 * Variable that holds transparency value between min and max.
	 */
	private float transparencyTransitionValue = 0f;

	/**
	 * 
	 * @param MyGame myGame
	 */
	public ScreenShader(MyGame myGame) {
		super(myGame);
	}

	/**
	 * Use enable blend to shade the screen transparently to simulate darkness.
	 * 
	 * @param ShapeRenderer shapeRenderer
	 */
	public void renderObject(ShapeRenderer shapeRenderer) {
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		shapeRenderer.setColor(new Color(0, 0, 0, transparencyTransitionValue));
		int position  = -100;
		int dimension = 500;
		shapeRenderer.rect(position, position, dimension, dimension);
	}

	public void updateObject() {
		if (NightAndDayCycle.isDayTime()) {
			transitionToDay();
		} else {
			transitionToNight();
		}
	}

	private void transitionToNight() {
		if (transparencyTransitionValue < transparencyMax) {
			transparencyTransitionValue += .01f;
		}
	}

	private void transitionToDay() {
		if (transparencyTransitionValue > transparencyMin) {
			transparencyTransitionValue -= .01f;
		}
	}
}
