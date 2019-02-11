package gameobjects.gamecharacters;

import com.mygdx.mygame.MyGame;

import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlayerThree extends Player {

	/**
	 * Constructor.
	 * 
	 * @param String name
	 */
	public PlayerThree(String name) {
		super(name);
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
		if (Player.playerIsMoving) {
			handleWalking(myGame);
		}
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	@Override
	protected void handleWalking(MyGame myGame) {
		System.out.println("Player Three is walking");
		int playerOneXPositionSize = PlayerOne.playerOneXPositions.size();
		if (playerOneXPositionSize > playerOneFollowAndDirectionValueOffset - 1) {
			x = PlayerOne.playerOneXPositions.get(playerOneXPositionSize - playerOneFollowAndDirectionValueOffset);
			y = PlayerOne.playerOneYPositions.get(playerOneXPositionSize - playerOneFollowAndDirectionValueOffset);
			setDirection(PlayerOne.playerDirections.get(playerOneXPositionSize - playerOneFollowAndDirectionValueOffset));
		}
	}
}
