package gameobjects.gamecharacters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import handlers.AnimationHandler;
import loaders.ImageLoader;
import maps.MapEditor;
import physics.CollisionHandler;

/**
 * Player object.
 * 
 * @author Fabulous Fellini
 *
 */
public class Player extends GameObject {
	
	/**
	 * Available directions player can travel.  
	 */
	public static final int DIRECTION_LEFT  = 0;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_UP    = 2;
	public static final int DIRECTION_DOWN  = 3;
	
	/**
	 * Textures to go with animations.
	 */
	private TextureAtlas walkDownTexture;
	private TextureAtlas walkUpTexture;
	private TextureAtlas walkRightTexture;
	private TextureAtlas walkLeftTexture;
	
	/**
	 * Available animations for player object.
	 */
	private Animation <TextureRegion> walkDownAnimation;
	private Animation <TextureRegion> walkUpAnimation;
	private Animation <TextureRegion> walkRightAnimation;
	private Animation <TextureRegion> walkLeftAnimation;
	
	/**
	 * Current animation being used in game.
	 */
	private Animation <TextureRegion> currentAnimation;
	
	/**
	 * Used for animations.
	 */
	private float elapsedTime = 0;
	
	/**
	 * Boolean to check whether player should stop moving upon collisions.
	 */
	public static boolean playerShouldStopMoving = false;
	
	/**
	 * Size of character.
	 */
	protected int characterSize = 1;
	
	/**
	 * Constructor.
	 */
	public Player() {
		this.x               = 5;
		this.y               = 10;
		this.width           = characterSize;
		this.height          = characterSize;
		rectangle.width      = width;
		rectangle.height     = height;
		walkDownTexture      = new TextureAtlas(Gdx.files.internal("PlayerSpriteDown.atlas"));
		walkUpTexture        = new TextureAtlas(Gdx.files.internal("PlayerSpriteUp.atlas"));
		walkRightTexture     = new TextureAtlas(Gdx.files.internal("PlayerSpriteRight.atlas"));
		walkLeftTexture      = new TextureAtlas(Gdx.files.internal("PlayerSpriteLeft.atlas"));
		float animationSpeed = 1/15f;
		walkDownAnimation    = new Animation <TextureRegion> (animationSpeed, walkDownTexture.getRegions());
		walkUpAnimation      = new Animation <TextureRegion> (animationSpeed, walkUpTexture.getRegions());
		walkRightAnimation   = new Animation <TextureRegion> (animationSpeed, walkRightTexture.getRegions());
		walkLeftAnimation    = new Animation <TextureRegion> (animationSpeed, walkLeftTexture.getRegions());
	}
	
	/**
	 * 
	 * @param MyGame    myGame
	 * @param MapEditor mapEditor
	 */
	@Override
	public void updateObject(MyGame myGame, MapEditor mapEditor) {
		x += dx;
		y += dy;
		rectangle.x = x;
		rectangle.y = y;
		CollisionHandler.checkIfPlayerHasCollidedWithASolidTile(myGame, mapEditor);
	}
	
	/**
	 * Returns current animation depending on which direction player is facing.
	 * 
	 * @return Animation <TextureRegion>
	 */
	private Animation <TextureRegion> getCurrentAnimation() {
		currentAnimation = walkDownAnimation;
		switch (direction) {
			case Player.DIRECTION_LEFT:
				currentAnimation = walkLeftAnimation;
				break;
			case Player.DIRECTION_RIGHT:
				currentAnimation = walkRightAnimation;
				break;
			case Player.DIRECTION_UP:
				currentAnimation = walkUpAnimation;
				break;
			case Player.DIRECTION_DOWN:
				currentAnimation = walkDownAnimation;
				break;
			}
		return currentAnimation;
	}
	
	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ShapeRenderer shapeRenderer
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ShapeRenderer shapeRenderer, ImageLoader imageLoader) {
		elapsedTime += Gdx.graphics.getDeltaTime();
		AnimationHandler.renderAnimation(batch, elapsedTime, getCurrentAnimation(), x, y, characterSize);
	}

	/**
	 * Moves object along the x axis.
	 * 
	 * @param float distance
	 */
	@Override
	public void translateX(float distance) {
		x += distance;
	}
	
	/**
	 * Moves object along the y axis.
	 * 
	 * @param float distance
	 */
	@Override
	public void translateY(float distance) {
		y += distance;
	}
	
	/**
	 * Moves player back 1 on the x, y axis depending on which direction player is going, 
	 * then stops it.  This is used when a player interacts with a solid tile.
	 * 
	 * @param int direction
	 */
	public void stopScrolling(int direction) {
		float bounceBackAmountUponPlayerTileCollision = 0.1f;
		switch (direction) {
			case Player.DIRECTION_LEFT:
				x += bounceBackAmountUponPlayerTileCollision;
				break;
			case Player.DIRECTION_RIGHT:
				x -= bounceBackAmountUponPlayerTileCollision;
				break;
			case Player.DIRECTION_UP:
				y += bounceBackAmountUponPlayerTileCollision;
				break;
			case Player.DIRECTION_DOWN:
				y -= bounceBackAmountUponPlayerTileCollision;
				break;
		}
	}
	
}
