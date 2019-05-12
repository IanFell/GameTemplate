package cutscenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class CutScene {

	// Change this value to render cutscene intro or not.
	private boolean cutSceneShouldRender;

	protected String name;
	protected boolean cutSceneConcluded;
	protected boolean cutSceneIsInProgress;
	protected int timer;

	/**
	 * Constructor.
	 * 
	 * @param String name
	 */
	public CutScene(String name) {
		this.name            = name;
		timer                = 0;
		cutSceneShouldRender = false;
		if (cutSceneShouldRender) {
			setCutSceneValues(false, true);
		} else {
			setCutSceneValues(true, false);
		}
	}

	/**
	 * 
	 * @param boolean isConcluded
	 * @param boolean isInProgress
	 */
	private void setCutSceneValues(boolean isConcluded, boolean isInProgress) {
		cutSceneConcluded    = isConcluded;
		cutSceneIsInProgress = isInProgress;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isCutSceneConcluded() {
		return cutSceneConcluded;
	}

	public void updateCutScene() {
		timer++;
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	public void renderCutScene(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isCutSceneIsInProgress() {
		return cutSceneIsInProgress;
	}
}
