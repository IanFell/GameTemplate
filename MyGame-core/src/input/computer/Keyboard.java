package input.computer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.mygame.MyGame;

import controllers.GameStateController;
import controllers.PlayerController;
import gameobjects.GameObject;
import gameobjects.gamecharacters.Player;
import helpers.GameAttributeHelper;
import inventory.Inventory;
import loaders.GameObjectLoader;
import loaders.bulletloader.BulletLoader;
import screens.GameScreen;
import screens.Screens;
import ui.MapUi;

/**
 * Handles keyboard input.
 * 
 * @author Fabulous Fellini
 *
 */
public class Keyboard extends ComputerInput {

	// Make sure button if held down is not being hit infinite times.
	private int inventoryTimer      = 0;
	private boolean startClickTimer = false;

	/**
	 * 
	 * @param MyGame myGame
	 */
	@Override
	public void handleInput(MyGame myGame) {
		GameObject player = PlayerController.getCurrentPlayer(myGame);
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

		case Screens.INVENTORY_SCREEN:
			// Display all inventory.
			if (Gdx.input.isKeyPressed(Input.Keys.D)) {
				Inventory.allInventoryShouldBeRendered = true;
			} else {
				Inventory.allInventoryShouldBeRendered = false;
			}

			if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
				GameStateController.switchGameStates(myGame, Screens.GAME_SCREEN);
				GameAttributeHelper.gameState = Screens.GAME_SCREEN;
				myGame.gameScreen.resume();
			}
			break;

		case Screens.GAME_SCREEN:	

			if (!Inventory.allInventoryShouldBeRendered && !MapUi.mapShouldBeRendered) {
				//handleKeyboardDirectionalButtons(myGame, "arrows", player);
				handleKeyboardDirectionalButtons(myGame, "wasd", player);
			}

			if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
				Player.isJumping = true;
			}

			// Execute screenshake.
			/*
			if (Gdx.input.isKeyPressed(Input.Keys.Z)) { 
				GameScreen.screenShake.shake(0.3f, 3);
			} */

			/**
			 * Perform operations on lighting.  
			 * This will make the light texture grow,
			 * then shrink back to normal size when key is released.
			 */
			/*
			if (Gdx.input.isKeyPressed(Input.Keys.L)) { 
				LightHandler.isGrowing = true;
			} else {
				LightHandler.isGrowing = false;
			} */

			float cameraZoomAmount = 1.0f;
			// Zoom camera out.
			if (Gdx.input.isKeyPressed(Input.Keys.Z) && Gdx.input.isKeyPressed(Input.Keys.O)) {
				GameScreen.camera.zoom += cameraZoomAmount;
			}

			// Zoom camera in.
			if (Gdx.input.isKeyPressed(Input.Keys.Z) && Gdx.input.isKeyPressed(Input.Keys.I)) {
				GameScreen.camera.zoom -= cameraZoomAmount;
			}

			if (Gdx.input.isKeyPressed(Input.Keys.F)) {
				Player.hasTorch = !Player.hasTorch;
			}

			// Display all inventory.
			if (Gdx.input.isKeyPressed(Input.Keys.I)) {
				if (!startClickTimer) {
					startClickTimer                        = true;
					Inventory.allInventoryShouldBeRendered = !Inventory.allInventoryShouldBeRendered;
					MapUi.mapShouldBeRendered              = false;
				} else {
					// Make sure inventory button is only hit once.
					inventoryTimer++;
					if (inventoryTimer > 1) {
						resetClickTimer();
					}
				}
			} 

			if (Gdx.input.isKeyPressed(Input.Keys.M)) {
				if (!startClickTimer) {
					startClickTimer                        = true;
					MapUi.mapShouldBeRendered              = !MapUi.mapShouldBeRendered;
					Inventory.allInventoryShouldBeRendered = false;
				} else {
					// Make sure inventory button is only hit once.
					inventoryTimer++;
					if (inventoryTimer > 1) {
						resetClickTimer();
					}
				}
			}

			if (Gdx.input.isKeyPressed(Input.Keys.P)) {
				BulletLoader.createBullet(myGame);
			} 

			if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
				System.exit(0);
			}
		}
	}

	private void resetClickTimer() {
		inventoryTimer  = 0;
		startClickTimer = false;
	}

	/**
	 * Handles arrows and WASD.
	 * 
	 * @param GameObject player
	 * @param String     directions
	 */
	private void handleKeyboardDirectionalButtons(MyGame myGame, String directions, GameObject player) {

		// If user presses the T button to use turbo.
		int turboSpeed    = 3;
		float playerSpeed = Player.PLAYER_SPEED;
		if (Gdx.input.isKeyPressed(Input.Keys.T)) {
			playerSpeed = Player.PLAYER_SPEED * turboSpeed;
		}

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

		if(GameObjectLoader.gameObjectList.contains(player)) {
			if (Gdx.input.isKeyPressed(left)) {
				((Player) player).moveLeft(playerSpeed);
			}
			else if (Gdx.input.isKeyPressed(right)) {
				((Player) player).moveRight(playerSpeed);
			}
			else if (Gdx.input.isKeyPressed(up)) {
				((Player) player).moveUp(playerSpeed);
			}
			else if (Gdx.input.isKeyPressed(down)) {
				((Player) player).moveDown(playerSpeed);
			}
			else {
				Player.playerIsMoving = false;
			}
		}
	}
}
