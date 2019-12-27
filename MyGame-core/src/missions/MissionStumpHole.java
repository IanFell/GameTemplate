package missions;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.Bird;
import helpers.GameAttributeHelper;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class MissionStumpHole extends Mission {

	private Bird bird;

	/**
	 * Constructor.
	 */
	public MissionStumpHole() {
		// Place bird on last stump of row one of stumps.
		bird = new Bird(
				GameAttributeHelper.CHUNK_FOUR_X_POSITION_START + 5f, 
				GameAttributeHelper.CHUNK_SEVEN_Y_POSITION_START + 32.5f
				);
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 * @param MyGame      myGame
	 */
	@Override
	public void renderMission(SpriteBatch batch, ImageLoader imageLoader, MyGame myGame) {
		bird.renderObject(batch, imageLoader);
	}
}
