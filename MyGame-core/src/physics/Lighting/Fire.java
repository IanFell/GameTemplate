package physics.Lighting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.ImageLoader;

public class Fire extends GameObject {
	
	private int timer = 0;
	
	public Fire(int x, int y, int width, int height) {
		this.x               = x;
		this.y               = y;
		this.width           = width;
		this.height          = height;
	}
	
	public void updateFire(MyGame myGame) {
		timer++;
		if (timer > 20) {
			timer = 0;
		}
	}
	
	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shaperender
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		if (timer > 0) {
			batch.draw(imageLoader.fireOne, x, y, width, -height);
		}
		if (timer > 5) {
			batch.draw(imageLoader.fireThree, x, y, width, -height);
		}
		if (timer > 10) {
			batch.draw(imageLoader.fireTwo, x, y, width, -height);
		}
		if (timer > 15) {
			batch.draw(imageLoader.fireFour, x, y, width, -height);
		}
	}

}
