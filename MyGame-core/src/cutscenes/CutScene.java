package cutscenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
	protected boolean selectedCutSceneIsInProgress;
	protected int timer;

	public static boolean anyCutSceneIsInProgress = false;

	/**
	 * Constructor.
	 * 
	 * @param String name
	 */
	public CutScene(String name) {
		this.name = name;
		timer     = 0;
		/**
		 * This has to be false to just start the game with no intro.
		 * It must be true if you start the game with intro.
		 */
		anyCutSceneIsInProgress = true;
		// Change this to render cutscene or not.
		cutSceneShouldRender = true;
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
		cutSceneConcluded            = isConcluded;
		selectedCutSceneIsInProgress = isInProgress;
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
	 * @param ImageLoader   imageLoader
	 */
	public void renderCutScene(SpriteBatch batch, ImageLoader imageLoader) {}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isSelectedCutSceneInProgress() {
		return selectedCutSceneIsInProgress;
	}
}
