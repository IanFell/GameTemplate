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
import maps.MapHandler;

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
	
	public final static float PLAYER_SPEED = 0.1f;  
	
	/**
	 * Used to determine whether footsteps sound effect should play.
	 */
	public static boolean playerIsMoving = false;

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

	/**
	 * Character size is the same size as a tile.
	 */
	private int characterSize = 1;

	/**
	 * Constructor.
	 */
	public Player() {
		this.x               = 68 + 68 + 68;
		this.y               = 151;
		this.width           = characterSize;
		this.height          = characterSize;
		rectangle.width      = characterSize;
		rectangle.height     = characterSize;
		walkDownTexture      = new TextureAtlas(Gdx.files.internal("PlayerSpriteDown.atlas"));
		walkUpTexture        = new TextureAtlas(Gdx.files.internal("PlayerSpriteUp.atlas"));
		walkRightTexture     = new TextureAtlas(Gdx.files.internal("PlayerSpriteRight.atlas"));
		walkLeftTexture      = new TextureAtlas(Gdx.files.internal("PlayerSpriteLeft.atlas"));
		float animationSpeed = 7/15f;
		walkDownAnimation    = new Animation <TextureRegion> (animationSpeed, walkDownTexture.getRegions());
		walkUpAnimation      = new Animation <TextureRegion> (animationSpeed, walkUpTexture.getRegions());
		walkRightAnimation   = new Animation <TextureRegion> (animationSpeed, walkRightTexture.getRegions());
		walkLeftAnimation    = new Animation <TextureRegion> (animationSpeed, walkLeftTexture.getRegions());
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	@Override
	public void init(MyGame myGame) {
		int startingDirection = DIRECTION_LEFT;
		int startingPosition  = 1;
		myGame.getGameObject(GameObject.PLAYER_TWO).setDirection(startingDirection);
		myGame.getGameObject(GameObject.PLAYER_THREE).setDirection(startingDirection);

		myGame.getGameObject(GameObject.PLAYER_TWO).setX(myGame.gameObjectLoader.playerOne.getX() + startingPosition);
		myGame.getGameObject(GameObject.PLAYER_TWO).setY(myGame.gameObjectLoader.playerOne.getY());

		myGame.getGameObject(GameObject.PLAYER_THREE).setX(myGame.gameObjectLoader.playerOne.getX() + startingPosition * 2);
		myGame.getGameObject(GameObject.PLAYER_THREE).setY(myGame.gameObjectLoader.playerOne.getY());
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		x += dx;
		y += dy;
		rectangle.x = x;
		rectangle.y = y;

		int playerTwoDirection   = myGame.gameObjectLoader.playerTwo.getDirection();
		int followDistance       = 1;
		// Player two follows player one.
		handleWalking(
				myGame.getGameObject(GameObject.PLAYER_ONE), 
				myGame.getGameObject(GameObject.PLAYER_TWO), 
				followDistance, 
				myGame.getGameObject(GameObject.PLAYER_ONE).getDirection(), 
				playerTwoDirection
				);

		// Player three follows player two.
		handleWalking(
				myGame.getGameObject(GameObject.PLAYER_TWO), 
				myGame.getGameObject(GameObject.PLAYER_THREE), 
				followDistance, 
				playerTwoDirection, 
				myGame.getGameObject(GameObject.PLAYER_THREE).getDirection()
				);
	}

	/**
	 * Sets players walking order heirarchy.  Player one should always be first.
	 * 
	 * @param GameObject leader
	 * @param GameObject follower
	 * @param int        followDistance
	 * @param int        leaderDirection
	 * @param int        followerDirection
	 */
	private void handleWalking(
			GameObject leader, 
			GameObject follower, 
			int followDistance, 
			int leaderDirection, 
			int followerDirection
			) {

		float leaderXPosition = leader.getX();
		float leaderYPosition = leader.getY();

		/**
		 * See if leader has changed directions.  
		 * If so, move follower one space in the direction he was going,
		 * then face him the same way as leader.
		 */
		if (leaderDirection != followerDirection) {
			if (leaderDirection == DIRECTION_UP && followerDirection == DIRECTION_LEFT) {
				if (leaderYPosition < follower.getY() - followDistance) {
					follower.setX(follower.getX() - followDistance);
					follower.setDirection(leaderDirection);
				}
			} 
			else if (leaderDirection == DIRECTION_UP && followerDirection == DIRECTION_RIGHT) {
				if (leaderYPosition < follower.getY() - followDistance) {
					follower.setX(follower.getX() + followDistance);
					follower.setDirection(leaderDirection);
				}
			} 
			else if (leaderDirection == DIRECTION_DOWN && followerDirection == DIRECTION_LEFT) {
				if (leaderYPosition > follower.getY() + followDistance) {
					follower.setX(follower.getX() - followDistance);
					follower.setDirection(leaderDirection);
				}
			}
			else if (leaderDirection == DIRECTION_DOWN && followerDirection == DIRECTION_RIGHT) {
				if (leaderYPosition > follower.getY() + followDistance) {
					follower.setX(follower.getX() + followDistance);
					follower.setDirection(leaderDirection);
				}
			}
			else if (leaderDirection == DIRECTION_LEFT && followerDirection == DIRECTION_UP) {
				if (leaderXPosition < follower.getX() - followDistance) {
					follower.setY(follower.getY() + followDistance);
					follower.setDirection(leaderDirection);
				}
			}
			else if (leaderDirection == DIRECTION_LEFT && followerDirection == DIRECTION_DOWN) {
				if (leaderXPosition < follower.getX() - followDistance) {
					follower.setY(follower.getY() + followDistance);
					follower.setDirection(leaderDirection);
				}
			} 
			else if (leaderDirection == DIRECTION_RIGHT && followerDirection == DIRECTION_DOWN) {
				if (leaderXPosition > follower.getX() + followDistance) {
					follower.setY(follower.getY() + followDistance);
					follower.setDirection(leaderDirection);
				}
			} 
			else if (leaderDirection == DIRECTION_RIGHT && followerDirection == DIRECTION_UP) {
				if (leaderXPosition > follower.getX() + followDistance) {
					follower.setY(follower.getY() - followDistance);
					follower.setDirection(leaderDirection);
				}
			} 
			else if (leaderDirection == DIRECTION_RIGHT && followerDirection == DIRECTION_LEFT) {
				if (leaderXPosition > follower.getX() + followDistance) {
					follower.setDirection(leaderDirection);
				}
			} 
			else if (leaderDirection == DIRECTION_LEFT && followerDirection == DIRECTION_RIGHT) {
				if (leaderXPosition < follower.getX() - followDistance) {
					follower.setDirection(leaderDirection);
				}
			} 
			else if (leaderDirection == DIRECTION_DOWN && followerDirection == DIRECTION_UP) {
				if (leaderYPosition > follower.getY() + followDistance) {
					follower.setDirection(leaderDirection);
				}
			} 
			else if (leaderDirection == DIRECTION_UP && followerDirection == DIRECTION_DOWN) {
				if (leaderYPosition < follower.getY() - followDistance) {
					follower.setDirection(leaderDirection);
				}
			} 
		} else {
			switch(leaderDirection) {
			case DIRECTION_LEFT:
				follower.setX(leaderXPosition + followDistance);
				follower.setY(leaderYPosition);
				break;
			case DIRECTION_RIGHT:
				follower.setX(leaderXPosition - followDistance);
				follower.setY(leaderYPosition);
				break;
			case DIRECTION_UP:
				follower.setX(leaderXPosition);
				follower.setY(leaderYPosition + followDistance);
				break;
			case DIRECTION_DOWN:
				follower.setX(leaderXPosition);
				follower.setY(leaderYPosition - followDistance);
				break;
			}
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
		float bounceBackAmountUponPlayerTileCollision = 0.01f;
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
