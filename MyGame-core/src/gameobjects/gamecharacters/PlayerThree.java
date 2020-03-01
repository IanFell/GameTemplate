package gameobjects.gamecharacters;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.mygame.MyGame;

import handlers.AnimationHandler;
import loaders.ImageLoader;
import maps.MapHandler;

/**
 * Peg Leg.
 * 
 * @author Fabulous Fellini
 *
 */
public class PlayerThree extends Player {

	/**
	 * Constructor.
	 * 
	 * @param String name
	 * @param MyGame myGame
	 * @param int    playerNumber
	 */
	public PlayerThree(String name, MyGame myGame, int playerNumber) {
		super(name, myGame, playerNumber);
		playerOneFollowAndDirectionValueOffset = 13;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);
		handleWalking(
				myGame, 
				PlayerOne.playerOneXPositions.size(), 
				PlayerOne.playerOneXPositions, 
				PlayerOne.playerOneYPositions
				);

		//simulateDeath(myGame, myGame.getGameObject(GameObject.PLAYER_TWO));
	}

	/**
	 * 
	 * @param SpriteBatch   batch
	 * @param ImageLoader   imageLoader
	 */
	@Override
	public void renderObject(SpriteBatch batch, ImageLoader imageLoader) {
		super.renderObject(batch, imageLoader);

		/**
		 * Only draw player three if we are in life state one.
		 * If we are in life state 2 or 3, player will still be there, but not render.
		 */
		if (lifeState == LIFE_STATE_ONE) {
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
	 * This method is not overridden.
	 * 
	 * @param MyGame           myGame
	 * @param int              size
	 * @param ArrayList<Float> xPosition
	 * @param ArrayList<Float> yPosition
	 */
	protected void handleWalking(MyGame myGame, int size, ArrayList<Float> xPosition, ArrayList<Float> yPosition) {
		int half = 2;
		if (size > playerOneFollowAndDirectionValueOffset - 1) {
			x = PlayerTwo.playerTwoXPositions.get(size - playerOneFollowAndDirectionValueOffset / half);
			y = PlayerTwo.playerTwoYPositions.get(size - playerOneFollowAndDirectionValueOffset / half);
			setDirection(PlayerTwo.playerDirections.get(size - playerOneFollowAndDirectionValueOffset));
		}
	}
}
