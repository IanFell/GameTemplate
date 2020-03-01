package gameobjects.gamecharacters;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import handlers.AnimationHandler;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * Blackbeard.
 * 
 * @author Fabulous Fellini
 *
 */
public class PlayerTwo extends Player {

	/**
	 * Keeps a list of player two's coordinates and direction.  
	 * This is used to determine the paths of player three.
	 */
	public static ArrayList<Float> playerTwoXPositions = new ArrayList<Float>();
	public static ArrayList<Float> playerTwoYPositions = new ArrayList<Float>();
	public static ArrayList<Integer> playerDirections  = new ArrayList<Integer>();

	/**
	 * Constructor.
	 * 
	 * @param String name
	 * @param MyGame myGame
	 * @param int    playerNumber
	 */
	public PlayerTwo(String name, MyGame myGame, int playerNumber) {
		super(name, myGame, playerNumber);
		playerOneFollowAndDirectionValueOffset = 6;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		handleWalking(myGame);
		savePlayerCurrentPositionAndDirection(x, y, playerTwoXPositions, playerTwoYPositions, playerDirections);
		simulateDeath(myGame, myGame.getGameObject(GameObject.PLAYER_ONE));

		if (myGame.getGameObject(Player.PLAYER_ONE).getHealth() <= 0) {
			setLifeState(myGame, PLAYER_TWO);
		}
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		super.renderObject(batch, imageLoader);

		if (lifeState == LIFE_STATE_ONE || lifeState == LIFE_STATE_TWO) {
			if (!Player.isInvincible) {
				AnimationHandler.renderAnimation(
						batch, 
						elapsedTime, 
						getCurrentAnimation(), 
						x, 
						y, 
						width,
						height,
						imageLoader, 
						AnimationHandler.OBJECT_TYPE_PLAYER
						);
			} else {
				if (Player.invincibilityTimer % 2 == 0) {
					AnimationHandler.renderAnimation(
							batch, 
							elapsedTime, 
							getCurrentAnimation(), 
							x, 
							y, 
							width,
							height,
							imageLoader, 
							AnimationHandler.OBJECT_TYPE_PLAYER
							);
				}
			}
		}

		//renderHitBox(batch, imageLoader);
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	@Override
	protected void handleWalking(MyGame myGame) {
		int playerOneXPositionSize = PlayerOne.playerOneXPositions.size();
		if (playerOneXPositionSize > playerOneFollowAndDirectionValueOffset - 1) {
			x = PlayerOne.playerOneXPositions.get(playerOneXPositionSize - playerOneFollowAndDirectionValueOffset);
			y = PlayerOne.playerOneYPositions.get(playerOneXPositionSize - playerOneFollowAndDirectionValueOffset);
			setDirection(PlayerOne.playerDirections.get(playerOneXPositionSize - playerOneFollowAndDirectionValueOffset));
		}
	}
}
