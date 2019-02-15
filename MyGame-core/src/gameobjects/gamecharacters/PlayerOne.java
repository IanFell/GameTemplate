package gameobjects.gamecharacters;

import java.util.ArrayList;

import com.mygdx.mygame.MyGame;

import maps.MapHandler;

/**
 * 
 * @author Fabulous Fellini
 *
 */
public class PlayerOne extends Player {
	
	private int playerScore;

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
	 * @param MyGame     myGame
	 * @param MapHandler mapHandler
	 */
	@Override
	public void updateObject(MyGame myGame, MapHandler mapHandler) {
		System.out.println("Player Score: " + playerScore);
		super.updateObject(myGame, mapHandler);
		handleWalking(myGame);
		handleJumping(myGame);
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
		 * This is so player two and three stop with player one.
		 */
		if (playerIsMoving) {
			playerOneXPositions.add(x);
			playerOneYPositions.add(y);
			playerDirections.add(getDirection());
		}
	}
	
	/**
	 * 
	 * @return int
	 */
	public int getPlayerScore() {
		return playerScore;
	}

	/**
	 * 
	 * @param int playerScore
	 */
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
}
