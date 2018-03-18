package controllers;

import com.mygdx.mygame.MyGame;

import screens.GameScreen;
import screens.Screens;

/**
 * Handles switching between game states.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameStateController {
	
	/**
	 * Switches game states.
	 * 
	 * @param MyGame myGame
	 * @param int    newGameState
	 */
	public static void switchGameStates(MyGame myGame, int newGameState) {
		switch (newGameState) {
			case Screens.GAME_SCREEN:
					myGame.setScreen(new GameScreen(myGame));
				break;
			}
	}
}
