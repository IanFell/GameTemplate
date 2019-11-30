package gameobjects.nature;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import handlers.AnimationHandler;
import loaders.ImageLoader;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Flower extends NatureObject {

	/**
	 * Constructor.
	 * 
	 * @param int x
	 * @param int y
	 */
	public Flower(int x, int y) {
		super(x, y);
		this.width   = 2;
		this.height  = 1;
		textureAtlas = new TextureAtlas(Gdx.files.internal("artwork/nature/flowers.atlas"));
		animation    = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_FLOWER, textureAtlas.getRegions());
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		updateElapsedTime();
		AnimationHandler.renderAnimation(
				batch, 
				elapsedTime, 
				animation, 
				x, 
				y, 
				width, 
				height,
				imageLoader, 
				AnimationHandler.OBJECT_TYPE_FLOWER
				);
	}
}
