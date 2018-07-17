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
					myGame.getPlayer(Player.PLAYER_ONE).setDx(-cameraScrollingSpeedTierOne);
					myGame.getPlayer(Player.PLAYER_ONE).setDy(0);
					myGame.getPlayer(Player.PLAYER_ONE).setDirection(Player.DIRECTION_LEFT);
					Player.playerIsMoving = true;
					System.out.println("Player is moving LEFT");
				} 
				else  if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){ 
					myGame.getPlayer(Player.PLAYER_ONE).setDx(cameraScrollingSpeedTierOne);
					myGame.getPlayer(Player.PLAYER_ONE).setDy(0);
					myGame.getPlayer(Player.PLAYER_ONE).setDirection(Player.DIRECTION_RIGHT);
					Player.playerIsMoving = true;
					System.out.println("Player is moving RIGHT");
				}
				else if (Gdx.input.isKeyPressed(Input.Keys.UP)){
					myGame.getPlayer(Player.PLAYER_ONE).setDy(-cameraScrollingSpeedTierOne); 
					myGame.getPlayer(Player.PLAYER_ONE).setDx(0);
					myGame.getPlayer(Player.PLAYER_ONE).setDirection(Player.DIRECTION_UP);
					Player.playerIsMoving = true;
					System.out.println("Player is moving UP");
				}
				else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){ 
					myGame.getPlayer(Player.PLAYER_ONE).setDy(cameraScrollingSpeedTierOne);
					myGame.getPlayer(Player.PLAYER_ONE).setDx(0);
					myGame.getPlayer(Player.PLAYER_ONE).setDirection(Player.DIRECTION_DOWN);
					Player.playerIsMoving = true;
					System.out.println("Player is moving DOWN");
				}
				else {
					myGame.getPlayer(Player.PLAYER_ONE).stopPlayer();
					Player.playerIsMoving = false;
				}
			} else {
				myGame.getPlayer(Player.PLAYER_ONE).stopPlayer();
				myGame.getPlayer(Player.PLAYER_ONE).stopScrolling(myGame.getPlayer(Player.PLAYER_ONE).getDirection());
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

			float cameraZoomAmount = 1.0f;
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
