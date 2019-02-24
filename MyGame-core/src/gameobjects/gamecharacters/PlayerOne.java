package gameobjects.gamecharacters;

import java.util.ArrayList;

import com.mygdx.mygame.MyGame;

import gameobjects.GameObject;
import loaders.GameObjectLoader;
import maps.MapHandler;

/**
 * Jolly Roger.
 * 
 * @author Fabulous Fellini
 *
 */
public class PlayerOne extends Player {

	/**
	 * Keeps a list of player one's coordinates and direction.  
	 * This is used to determine the paths of player two and player three.
	 */
	public static ArrayList<Float> playerOneXPositions = new ArrayList<Float>();
	public static ArrayList<Float> playerOneYPositions = new ArrayList<Float>();
	public static ArrayList<Integer> playerDirections  = new ArrayList<Integer>();

	/**
	 * Constructor.
	 * 
	 * @param String name
	 */
	public PlayerOne(String name) {
		super(name);
		playerScore = 0;
	}

	/**
	 * 
	 * @param int score
	 */
	public void updatePlayerScore(int score) {
		playerScore += score;
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		System.out.println("Player Score: " + playerScore);
		super.updateObject(myGame, mapHandler);
		handleWalking(myGame);
		handleJumping(myGame);
		if (playerHealth <= 0) {
			GameObjectLoader.gameObjectList.remove(this);
		}
		//simulateDeath(myGame, this);
	}

	/**
	 * 
	 * @param MyGame     myGame
	 * @param GameObject player
	 */
	@Override
	protected void simulateDeath(MyGame myGame, GameObject player) {
		playerHealth--;
	}

	/**
	 * 
	 * @param MyGame myGame
	 */
	@Override
	protected void handleWalking(MyGame myGame) {
		System.out.println("Player One is walking");
		/**
		 * Only save player coordiantes if player is moving.  
		 * This is so player two and three stop and move with player one.
		 */
		savePlayerCurrentPositionAndDirection(x, y, playerOneXPositions, playerOneYPositions, playerDirections);
	}
}
