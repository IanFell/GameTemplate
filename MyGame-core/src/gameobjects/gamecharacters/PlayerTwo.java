package gameobjects.gamecharacters;

import java.util.ArrayList;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
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
	 */
	public PlayerTwo(String name) {
		super(name);
		playerOneFollowAndDirectionValueOffset = 7;
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
			handleWalking(myGame);
		}
		removeCurrentPlayerIfDead(myGame.getGameObject(GameObject.PLAYER_ONE), this);
		savePlayerCurrentPositionAndDirection(x, y, playerTwoXPositions, playerTwoYPositions, playerDirections);
		simulateDeath(myGame, myGame.getGameObject(GameObject.PLAYER_ONE));
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
