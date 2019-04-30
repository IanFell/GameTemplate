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
		cutSceneConcluded    = false;
		cutSceneIsInProgress = true;
		timer                = 0;
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
