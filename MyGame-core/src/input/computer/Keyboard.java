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
			float cameraScrollingSpeedTierOne = Player.PLAYER_SPEED;
			// Get arrow buttons for direction.
			if (!Player.playerShouldStopMoving) {
				if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
					myGame.gameObjectLoader.playerOne.dx = -cameraScrollingSpeedTierOne;
					myGame.gameObjectLoader.playerOne.setDirection(Player.DIRECTION_LEFT);
					Player.playerIsMoving = true;
					System.out.println("Player is moving LEFT");
				} 
				else  if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){ 
					myGame.gameObjectLoader.playerOne.dx = cameraScrollingSpeedTierOne;
					myGame.gameObjectLoader.playerOne.setDirection(Player.DIRECTION_RIGHT);
					Player.playerIsMoving = true;
					System.out.println("Player is moving RIGHT");
				}
				else if (Gdx.input.isKeyPressed(Input.Keys.UP)){
					myGame.gameObjectLoader.playerOne.dy = -cameraScrollingSpeedTierOne;
					myGame.gameObjectLoader.playerOne.setDirection(Player.DIRECTION_UP);
					Player.playerIsMoving = true;
					System.out.println("Player is moving UP");
				}
				else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){ 
					myGame.gameObjectLoader.playerOne.dy = cameraScrollingSpeedTierOne;
					myGame.gameObjectLoader.playerOne.setDirection(Player.DIRECTION_DOWN);
					Player.playerIsMoving = true;
					System.out.println("Player is moving DOWN");
				}
				else {
					myGame.gameObjectLoader.playerOne.stopPlayer();
					Player.playerIsMoving = false;
				}
			} else {
				myGame.gameObjectLoader.playerOne.stopPlayer();
				myGame.gameObjectLoader.playerOne.stopScrolling(myGame.gameObjectLoader.playerOne.getDirection());
				Player.playerShouldStopMoving = false;
				Player.playerIsMoving         = false;
			}

			// Execute screenshake.
			if (Gdx.input.isKeyPressed(Input.Keys.S)) { 
				GameScreen.screenShake.shake(0.3f, 3);
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
