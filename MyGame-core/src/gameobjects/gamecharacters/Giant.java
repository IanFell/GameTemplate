package gameobjects.gamecharacters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.mygame.MyGame;

import helpers.GameAttributeHelper;
import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class Giant extends Enemy {

	private final float LEFT_BOUNDARY  = GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 43;
	private final float RIGHT_BOUNDARY = GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 62;

	private final float JUMP_TIMER_MAX_VALUE = 50;
	private final float EXECUTE_JUMP_VALUE   = 25;
	private final float PEAK_JUMP_VALUE      = 37.5f;

	private int jumpTimer;

	/**
	 * Constructor.
	 * 
	 * @param float x
	 * @param float y
	 * @param float width
	 * @param float height
	 * @param int   direction
	 */
	public Giant(float x, float y, float width, float height, int direction) {
		super(x, y, width, height, direction);
		walkDownTexture  = new TextureAtlas(Gdx.files.internal("artwork/gamecharacters/grunt/gruntRight.atlas"));
		walkUpTexture    = new TextureAtlas(Gdx.files.internal("artwork/gamecharacters/grunt/gruntLeft.atlas"));
		walkRightTexture = new TextureAtlas(Gdx.files.internal("artwork/gamecharacters/grunt/gruntRight.atlas"));
		walkLeftTexture  = new TextureAtlas(Gdx.files.internal("artwork/gamecharacters/grunt/gruntLeft.atlas"));

		float animationSpeed = 7/15f;
		walkDownAnimation    = new Animation <TextureRegion> (animationSpeed, walkDownTexture.getRegions());
		walkUpAnimation      = new Animation <TextureRegion> (animationSpeed, walkUpTexture.getRegions());
		walkRightAnimation   = new Animation <TextureRegion> (animationSpeed, walkRightTexture.getRegions());
		walkLeftAnimation    = new Animation <TextureRegion> (animationSpeed, walkLeftTexture.getRegions());

		dx = -0.2f;
		if (direction == DIRECTION_RIGHT) {
			dx = -dx;
		}
		dy = 0;

		jumpTimer = 0;
	}

	private void handleJumping() {
		jumpTimer++;
		if (jumpTimer > JUMP_TIMER_MAX_VALUE) {
			jumpTimer = 0;
		}
		// Execute jump.
		if (jumpTimer > EXECUTE_JUMP_VALUE) {
			x += dx;
			y += dy;
		}
		// Come up or down.
		if (jumpTimer > PEAK_JUMP_VALUE) {
			dy = 0.1f;
		} else {
			dy = -0.1f;
		}
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		handleJumping();

		// Handle direction change.
		if (x < LEFT_BOUNDARY) {
			dx = -dx;
		} else if (x > RIGHT_BOUNDARY) {
			dx = - dx;
		}

		direction = DIRECTION_RIGHT;
		if (dx < 0) {
			direction = DIRECTION_LEFT;
		}
	}
}
