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
	 * Used for animation speed.
	 */
	private float elapsedTime = 0;
	
	/**
	 * Boolean to check whether player should stop moving upon collisions.
	 */
	public static boolean playerShouldStopMoving = false;
	
	protected int characterSize = 1;
	
	/**
	 * Constructor.
	 */
	public Player() {
		this.x               = 5;
		this.y               = 10;
		this.width           = characterSize;
		this.height          = characterSize;
		rectangle.width      = characterSize;
		rectangle.height     = characterSize;
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
		setPlayersWalkingOrder(myGame);
	}
	
	/**
	 * Sets players walking order heirarchy.  Player one should always be first.
	 * 
	 * @param MyGame myGame
	 */
	private void setPlayersWalkingOrder(MyGame myGame) {
		int playerOneDirection = myGame.gameObjectLoader.playerOne.getDirection();
		myGame.gameObjectLoader.playerTwo.setDirection(playerOneDirection);
		myGame.gameObjectLoader.playerThree.setDirection(playerOneDirection);
		int playerTwoFollowDistance   = 1;
		int playerThreeFollowDistance = 2;
		// Sets player two follow distance and location.
		setPlayerFollowDistanceAndLocation(
				myGame.gameObjectLoader.playerOne, 
				myGame.gameObjectLoader.playerTwo, 
				playerTwoFollowDistance, 
				playerOneDirection
				);
		// Sets player three follow distance and location.
		setPlayerFollowDistanceAndLocation(
				myGame.gameObjectLoader.playerOne, 
				myGame.gameObjectLoader.playerThree, 
				playerThreeFollowDistance, 
				playerOneDirection
				);
	}
	
	/**
	 * 
	 * @param GameObject playerLeader
	 * @param GameObject playerFollower
	 * @param int        followDistance
	 * @param int        direction
	 */
	private void setPlayerFollowDistanceAndLocation(
			GameObject playerLeader, 
			GameObject playerFollower, 
			int followDistance, 
			int direction
			) {
		switch (direction) {
		case DIRECTION_LEFT:
			playerFollower.setX(playerLeader.getX() + followDistance);
			playerFollower.setY(playerLeader.getY());
			break;
		case DIRECTION_RIGHT:
			playerFollower.setX(playerLeader.getX() - followDistance);
			playerFollower.setY(playerLeader.getY());
			break;
		case DIRECTION_UP:
			playerFollower.setX(playerLeader.getX());
			playerFollower.setY(playerLeader.getY() + followDistance);
			break;
		case DIRECTION_DOWN:
			playerFollower.setX(playerLeader.getX());
			playerFollower.setY(playerLeader.getY() - followDistance);
			break;
		}
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
	 * @param float distance
	 */
	@Override
	public void translateX(float distance) {
		x += distance;
	}
	
	/**
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
	
	public void stopPlayer() {
		dx = 0;
		dy = 0;
	}
}
