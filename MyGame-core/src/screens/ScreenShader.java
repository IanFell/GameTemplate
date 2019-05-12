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
		int colorValue = 0;
		shapeRenderer.setColor(new Color(colorValue, colorValue, colorValue, transparencyTransitionValue));
		/**
		 * Use these variables because if we just use regular width and height,
		 * the screen shader gets offset when player moves.
		 * 
		 * This is now done with putting a shader on top of every tile when it's night time
		 * so game objects are more visible.
		 */
		/*
		int xyOffset          = 1;
		int widthHeightOffset = 2;
		shapeRenderer.rect(
				camera.position.x - getViewportWidth() / denominatorOffset - xyOffset, 
				camera.position.y - verticalHeight / denominatorOffset - xyOffset, 
				camera.viewportWidth + widthHeightOffset, 
				camera.viewportHeight + widthHeightOffset
				);
		 */
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
