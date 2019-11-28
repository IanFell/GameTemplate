package physics.Lighting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import gameobjects.GameObject;
import handlers.AnimationHandler;
import loaders.ImageLoader;

/**
 * Extend GameObject to use x and y.
 * 
 * @author Fabulous Fellini
 *
 */
public class Explosion extends GameObject {

	private int explosionSize = 2;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 */
	public Explosion(float x, float y) {
		this.x       = x;
		this.y       = y;
		textureAtlas = new TextureAtlas(Gdx.files.internal("artwork/effects/explosion/explosion.atlas"));
		animation    = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_EXPLOSIOIN, textureAtlas.getRegions());
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	public void renderExplosion(SpriteBatch batch, ImageLoader imageLoader) {
		elapsedTime += Gdx.graphics.getDeltaTime();
		AnimationHandler.renderAnimation(
				batch, 
				elapsedTime, 
				animation, 
				x, 
				y, 
				explosionSize, 
				imageLoader, 
				AnimationHandler.OBJECT_TYPE_EXPLOSION
				);
	}
}
