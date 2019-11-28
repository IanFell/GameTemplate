package physics.Lighting;

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
public class Explosion {
	
	private float x;
	private float y;
	
	private TextureAtlas textureAtlas;
	
	private Animation <TextureRegion> animation;
	
	/**
	 * Used for animation speed.
	 */
	private float elapsedTime = 0;
	
	private float animationSpeed = 1/15f;
	
	public Explosion(float x, float y) {
		this.x = x;
		this.y = y;
		textureAtlas = new TextureAtlas(Gdx.files.internal("artwork/effects/explosion/explosion.atlas"));
		animation = new Animation <TextureRegion> (animationSpeed, textureAtlas.getRegions());
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
				5, 
				imageLoader, 
				AnimationHandler.OBJECT_TYPE_EXPLOSION
				);
	}
}
