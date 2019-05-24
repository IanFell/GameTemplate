package worldmapui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import input.computer.Mouse;
import loaders.ImageLoader;
import screens.Screens;

public class MapUi extends Screens {
	
	public static boolean mapShouldBeRendered;
	
	public MapUi(final MyGame myGame) {
		super(myGame);
		mapShouldBeRendered = false;
	}

	public boolean isMapShouldBeRendered() {
		return mapShouldBeRendered;
	}

	public void setMapShouldBeRendered(boolean mapShouldBeRendered) {
		this.mapShouldBeRendered = mapShouldBeRendered;
	}
	
	public void renderWorldMap(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (mapShouldBeRendered) {
		int borderShrinkOffset = 1;
		batch.draw(
				imageLoader.worldMapReal,
				camera.position.x - getViewportWidth() / denominatorOffset + borderShrinkOffset,
				(camera.position.y - verticalHeight / denominatorOffset) + camera.viewportHeight,
				camera.viewportWidth - borderShrinkOffset * 2, 
				-camera.viewportHeight
				);
	}
	}
}
