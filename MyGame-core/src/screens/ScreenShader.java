package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import helpers.ColorHelper;

/**
 * TODO Currently this blocks other shape rendered objects such as the particle emitters.
 * TODO It is due to the gl.blend function in GameScreen.render().
 * 
 * Puts a dark shading over the screen to simulate darkness.
 * 
 * @author Fabulous Fellini
 *
 */
public class ScreenShader extends Screens {

	/**
	 * 
	 * @param MyGame myGame
	 */
	public ScreenShader(MyGame myGame) {
		super(myGame);
	}
	
	/**
	 * Use enable blend to shade the scree transparently to simulate darkness.
	 * 
	 * @param ShapeRenderer shapeRenderer
	 */
	public void renderObject(ShapeRenderer shapeRenderer) {
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		shapeRenderer.setColor(ColorHelper.NIGHT_TIME_BLACK);
		shapeRenderer.rect(0, 0, 100, 100);
	}
}
