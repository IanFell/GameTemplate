package controllers;

import com.mygdx.mygame.MyGame;

import screens.GameScreen;
import screens.InventoryScreen;
import screens.Screens;
import screens.TitleScreen;

/**
 * Handles switching between game states.
 * 
 * @author Fabulous Fellini
 *
 */
public class GameStateController {

	/**
	 * 
	 * @param MyGame myGame
	 * @param int    newGameState
	 */
	public static void switchGameStates(MyGame myGame, int newGameState) {
		switch (newGameState) {
		case Screens.GAME_SCREEN:
			myGame.setScreen(myGame.getGameScreen());
			break;
		case Screens.TITLE_SCREEN:
			myGame.setScreen(new TitleScreen(myGame));
			break;
		case Screens.INVENTORY_SCREEN:
			myGame.setScreen(new InventoryScreen(myGame));
			break;
		}
	}
}
