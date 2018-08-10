package input.computer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.mygame.MyGame;

import controllers.GameStateController;
import helpers.GameAttributeHelper;
import screens.Screens;

/**
 * Handles mouse input.
 * 
 * @author Fabulous Fellini
 *
 */
public class Mouse extends ComputerInput {

	/**
	 * 
	 * @param MyGame myGame
	 */
	@Override
	public void handleInput(MyGame myGame) {

		switch (GameAttributeHelper.gameState) {
		case Screens.SPLASH_SCREEN:
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
				GameStateController.switchGameStates(myGame, Screens.TITLE_SCREEN);
			}
			break;
		case Screens.TITLE_SCREEN:
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
				GameStateController.switchGameStates(myGame, Screens.GAME_SCREEN);
			}
			break;
		}
	}
}
