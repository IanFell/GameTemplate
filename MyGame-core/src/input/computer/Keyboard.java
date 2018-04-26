package input.computer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.mygame.MyGame;

import controllers.GameStateController;
import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
import physics.LightHandler;
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
			
			float cameraScrollingSpeedNone    = Screens.SCREEN_SCROLL_SPEED_NONE;
			float cameraScrollingSpeedTierOne = Screens.SCREEN_SCROLL_SPEED_TIER_ONE;
			
			/**
			 * These directions do not seem as they should because we are isometric.
			 * If we switch the screen to normal the directions will be messed up.
			 */
			
			// Get arrow buttons for direction.
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				myGame.gameObjectLoader.player.dx = -cameraScrollingSpeedTierOne;
				Screens.scrollScreen(-cameraScrollingSpeedTierOne, cameraScrollingSpeedNone);
				myGame.gameObjectLoader.player.setDirection(Player.DIRECTION_LEFT);
				System.out.println("Player is moving LEFT");
	        } 
			else  if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){ 
				myGame.gameObjectLoader.player.dx = cameraScrollingSpeedTierOne;
	        	Screens.scrollScreen(cameraScrollingSpeedTierOne, cameraScrollingSpeedNone);
	        	myGame.gameObjectLoader.player.setDirection(Player.DIRECTION_RIGHT);
	        	System.out.println("Player is moving RIGHT");
	        }
			else if (Gdx.input.isKeyPressed(Input.Keys.UP)){
				myGame.gameObjectLoader.player.dy = -cameraScrollingSpeedTierOne;
	        	Screens.scrollScreen(cameraScrollingSpeedTierOne, cameraScrollingSpeedTierOne);
	        	myGame.gameObjectLoader.player.setDirection(Player.DIRECTION_UP);
	        	System.out.println("Player is moving UP");
	        }
			else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){ 
				myGame.gameObjectLoader.player.dy = cameraScrollingSpeedTierOne;
	        	Screens.scrollScreen(-cameraScrollingSpeedTierOne, -cameraScrollingSpeedTierOne);
	        	myGame.gameObjectLoader.player.setDirection(Player.DIRECTION_DOWN);
	        	System.out.println("Player is moving DOWN");
	        }
	        else {
	        	myGame.gameObjectLoader.player.dx = 0;
				myGame.gameObjectLoader.player.dy = 0;
			}
	        
	        // Perform screenshake.
	        if (Gdx.input.isKeyPressed(Input.Keys.S)){ 
				Screens.screenShake.shake(5, 5);
			}
	        
	        /**
	         * Perform operations on lighting.  
	         * This will make the light texture grow,
	         * then shrink back to normal size when key is released.
	         */
	        if (Gdx.input.isKeyPressed(Input.Keys.L)){ 
				LightHandler.isGrowing = true;
			} else {
				LightHandler.isGrowing = false;
			}
		}
	}
}
