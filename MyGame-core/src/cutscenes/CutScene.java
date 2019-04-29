package cutscenes;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import loaders.ImageLoader;

public class CutScene {
	
	private String name;
	protected boolean cutSceneConcluded;
	protected boolean cutSceneIsInProgress;
	protected int timer;
	
	public CutScene(String name) {
		this.name = name;
		cutSceneConcluded = false;
		cutSceneIsInProgress = true;
		timer = 0;
	}
	
	public boolean isCutSceneConcluded() {
		return cutSceneConcluded;
	}

	public void updateCutScene() {
		timer++;
	}
	
	public void renderCutScene(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader){}

	public boolean isCutSceneIsInProgress() {
		return cutSceneIsInProgress;
	}

}
