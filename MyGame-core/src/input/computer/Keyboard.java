package input.computer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.mygame.MyGame;

import controllers.GameStateController;
import gameobjects.GameObject;
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
				GameStateController.switchGameStates(myGame, Screens.TITLE_SCREEN);
			}
			break;
			
		case Screens.TITLE_SCREEN:
			if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){ 
				GameStateController.switchGameStates(myGame, Screens.GAME_SCREEN);
			}
			break;

		case Screens.GAME_SCREEN:	
			handleKeyboardDirectionalButtons(myGame, "arrows");
			//handleKeyboardDirectionalButtons(myGame, "wasd");

			// Execute screenshake.
			if (Gdx.input.isKeyPressed(Input.Keys.R)) { 
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
	
	/**
	 * Handles arrows and WASD.
	 * 
	 * @param MyGame myGame
	 * @param String directions
	 */
	private void handleKeyboardDirectionalButtons(MyGame myGame, String directions) {
		System.out.println("Keyboard directional controls: " + directions);
		float cameraScrollingSpeedTierOne = Player.PLAYER_SPEED;
		int up;
		int down;
		int left;
		int right;
		
		if (directions.equalsIgnoreCase("arrows")) {
			up    = Input.Keys.UP;
			down  = Input.Keys.DOWN;
			left  = Input.Keys.LEFT;
			right = Input.Keys.RIGHT;
		} else {
			up    = Input.Keys.W;
			down  = Input.Keys.S;
			left  = Input.Keys.A;
			right = Input.Keys.D;
		}
		
		if (!Player.playerShouldStopMoving) {
			if (Gdx.input.isKeyPressed(left)){
				myGame.getGameObject(GameObject.PLAYER_ONE).setDx(-cameraScrollingSpeedTierOne);
				myGame.getGameObject(GameObject.PLAYER_ONE).setDy(0);
				myGame.getGameObject(GameObject.PLAYER_ONE).setDirection(Player.DIRECTION_LEFT);
				Player.playerIsMoving = true;
				System.out.println("Player is moving LEFT");
			} 
			else  if (Gdx.input.isKeyPressed(right)){ 
				myGame.getGameObject(GameObject.PLAYER_ONE).setDx(cameraScrollingSpeedTierOne);
				myGame.getGameObject(GameObject.PLAYER_ONE).setDy(0);
				myGame.getGameObject(GameObject.PLAYER_ONE).setDirection(Player.DIRECTION_RIGHT);
				Player.playerIsMoving = true;
				System.out.println("Player is moving RIGHT");
			}
			else if (Gdx.input.isKeyPressed(up)){
				myGame.getGameObject(GameObject.PLAYER_ONE).setDy(-cameraScrollingSpeedTierOne); 
				myGame.getGameObject(GameObject.PLAYER_ONE).setDx(0);
				myGame.getGameObject(GameObject.PLAYER_ONE).setDirection(Player.DIRECTION_UP);
				Player.playerIsMoving = true;
				System.out.println("Player is moving UP");
			}
			else if (Gdx.input.isKeyPressed(down)){ 
				myGame.getGameObject(GameObject.PLAYER_ONE).setDy(cameraScrollingSpeedTierOne);
				myGame.getGameObject(GameObject.PLAYER_ONE).setDx(0);
				myGame.getGameObject(GameObject.PLAYER_ONE).setDirection(Player.DIRECTION_DOWN);
				Player.playerIsMoving = true;
				System.out.println("Player is moving DOWN");
			}
			else {
				myGame.getGameObject(GameObject.PLAYER_ONE).stopPlayer();
				Player.playerIsMoving = false;
			}
		} else {
			myGame.getGameObject(GameObject.PLAYER_ONE).stopPlayer();
			myGame.getGameObject(GameObject.PLAYER_ONE).stopScrolling(myGame.getGameObject(GameObject.PLAYER_ONE).getDirection());
			Player.playerShouldStopMoving = false;
			Player.playerIsMoving         = false;
		}
	}
}
