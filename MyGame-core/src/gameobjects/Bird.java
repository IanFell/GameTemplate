package gameobjects;

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
public class Bird extends GameObject {

	private int size = 1;

	private TextureAtlas textureAtlasLeft;
	private TextureAtlas textureAtlasRight;

	private Animation <TextureRegion> animationLeft;
	private Animation <TextureRegion> animationRight;

	private int direction;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 */
	public Bird(float x, float y) {
		this.x            = x;
		this.y            = y;
		this.width        = size;
		this.height       = size;
		textureAtlasLeft  = new TextureAtlas(Gdx.files.internal("artwork/animals/birdLeft.atlas"));
		textureAtlasRight = new TextureAtlas(Gdx.files.internal("artwork/animals/birdRight.atlas"));
		animationLeft     = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_BIRD, textureAtlasLeft.getRegions());
		animationRight    = new Animation <TextureRegion> (AnimationHandler.ANIMATION_SPEED_BIRD, textureAtlasRight.getRegions());
		direction         = DIRECTION_LEFT;
	}

	/**
	 * 
	 * @param SpriteBatch batch
	 * @param ImageLoader imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		updateElapsedTime();
		Animation <TextureRegion> animation = animationLeft;
		if (direction == DIRECTION_RIGHT) {
			animation = animationRight;
		}
		AnimationHandler.renderAnimation(
				batch, 
				elapsedTime, 
				animation, 
				x, 
				y, 
				width, 
				height,
				imageLoader, 
				AnimationHandler.OBJECT_TYPE_BIRD
				);
	}

	/**
	 * 
	 * @param int direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}
}
