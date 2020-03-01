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

		dx = -0.1f;
		if (direction == DIRECTION_RIGHT) {
			dx = -dx;
		}
	}

	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		x += dx;

		if (x < GameAttributeHelper.CHUNK_TWO_X_POSITION_START + 43) {
			dx = -dx;
		} else if (x > GameAttributeHelper.CHUNK_EIGHT_X_POSITION_START + 62) {
			dx = - dx;
		}

		direction = DIRECTION_RIGHT;
		if (dx < 0) {
			direction = DIRECTION_LEFT;
		}
	}
}
