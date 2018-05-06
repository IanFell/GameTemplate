package input.computer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.mygame.MyGame;

import controllers.GameStateController;
import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
import physics.Lighting.LightHandler;
import screens.GameScreen;
import screens.Screens;

/**
 * Handles keyboard input.
 * 
 * @author Fabulous Fellini
 *
 */
public class Keyboard extends ComputerInput {
	
	/**
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
				float cameraScrollingSpeedTierOne = Screens.SCREEN_SCROLL_SPEED_TIER_ONE;
				// Get arrow buttons for direction.
				if (!Player.playerShouldStopMoving) {
					if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
						myGame.gameObjectLoader.player.dx = -cameraScrollingSpeedTierOne;
						myGame.gameObjectLoader.player.setDirection(Player.DIRECTION_LEFT);
						System.out.println("Player is moving LEFT");
			        } 
					else  if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){ 
						myGame.gameObjectLoader.player.dx = cameraScrollingSpeedTierOne;
			        	myGame.gameObjectLoader.player.setDirection(Player.DIRECTION_RIGHT);
			        	System.out.println("Player is moving RIGHT");
			        }
					else if (Gdx.input.isKeyPressed(Input.Keys.UP)){
						myGame.gameObjectLoader.player.dy = -cameraScrollingSpeedTierOne;
			        	myGame.gameObjectLoader.player.setDirection(Player.DIRECTION_UP);
			        	System.out.println("Player is moving UP");
			        }
					else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){ 
						myGame.gameObjectLoader.player.dy = cameraScrollingSpeedTierOne;
			        	myGame.gameObjectLoader.player.setDirection(Player.DIRECTION_DOWN);
			        	System.out.println("Player is moving DOWN");
			        }
			        else {
			        	myGame.gameObjectLoader.player.stopPlayer();
					}
				} else {
					myGame.gameObjectLoader.player.stopPlayer();
					myGame.gameObjectLoader.player.stopScrolling(myGame.gameObjectLoader.player.getDirection());
					Player.playerShouldStopMoving = false;
				}
				
		        // Execute screenshake.
		        if (Gdx.input.isKeyPressed(Input.Keys.S)) { 
					GameScreen.screenShake.shake(3, 3);
				}
		        
		        /**
		         * Perform operations on lighting.  
		         * This will make the light texture grow,
		         * then shrink back to normal size when key is released.
		         */
		        if (Gdx.input.isKeyPressed(Input.Keys.L)) { 
					LightHandler.isGrowing = true;
				} else {
					LightHandler.isGrowing = false;
				}
		        
		        float cameraZoomAmount = 0.01f;
		        // Zoom camera out.
		        if (Gdx.input.isKeyPressed(Input.Keys.Z) && Gdx.input.isKeyPressed(Input.Keys.O)) {
		        	GameScreen.camera.zoom += cameraZoomAmount;
		        }
		        
		        // Zoom camera in.
		        if (Gdx.input.isKeyPressed(Input.Keys.Z) && Gdx.input.isKeyPressed(Input.Keys.I)) {
		        	GameScreen.camera.zoom -= cameraZoomAmount;
		        }
			}
	}
}
