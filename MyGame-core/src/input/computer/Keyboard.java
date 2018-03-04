package input.computer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.mygame.MyGame;

import controllers.GameStateController;
import helpers.GameAttributeHelper;
import helpers.GamePlayHelper;
import screens.Screens;

/**
 * Handles keyboard input.
 * 
 * @author Fabulous Fellini
 *
 */
public class Keyboard extends ComputerInput {
	
	/**
	 * Handle keyboard input.
	 * 
	 * @param MyGame myGame
	 */
	@Override
	public void handleInput(MyGame myGame) {
		
		switch (GameAttributeHelper.gameState) {
		
		case Screens.SPLASH_SCREEN:
			if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){ 
				GameStateController.switchGameStates(myGame, Screens.GAME_SCREEN);
			}
			break;
			
		case Screens.GAME_SCREEN:
			
			// Get arrow buttons for direction.
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				myGame.gameObjectLoader.player.translateX(-Screens.SCREEN_SCROLL_SPEED_TIER_ONE);
	        } 
	        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){   
	        	myGame.gameObjectLoader.player.translateX(Screens.SCREEN_SCROLL_SPEED_TIER_ONE);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
	        	myGame.gameObjectLoader.player.translateY(Screens.SCREEN_SCROLL_SPEED_TIER_ONE);
	        }
	        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){  
	        	myGame.gameObjectLoader.player.translateY(-Screens.SCREEN_SCROLL_SPEED_TIER_ONE);
	        }
		}
	}
}
