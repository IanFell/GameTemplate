package gameobjects.gamecharacters;

import java.util.ArrayList;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
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
		playerOneFollowAndDirectionValueOffset = 30;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		super.updateObject(myGame, mapHandler);

		if (playerOneIsMovingAndNotDead(myGame)) {
			handleWalking(
					myGame, 
					PlayerOne.playerOneXPositions.size(), 
					PlayerOne.playerOneXPositions, 
					PlayerOne.playerOneYPositions
					);
		} else if (
				Player.playerIsMoving && 
				myGame.getGameObject(GameObject.PLAYER_TWO).getHealth() > 0 && 
				myGame.getGameObject(GameObject.PLAYER_ONE).getHealth() <= 0) {
			handleWalking(
					myGame, 
					PlayerTwo.playerTwoXPositions.size(), 
					PlayerTwo.playerTwoXPositions, 
					PlayerTwo.playerTwoXPositions
					);
		}

		removeCurrentPlayerIfDead(myGame.getGameObject(GameObject.PLAYER_TWO), this);
		//simulateDeath(myGame, myGame.getGameObject(GameObject.PLAYER_TWO));
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
